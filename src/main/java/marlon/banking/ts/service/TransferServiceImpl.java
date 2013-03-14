package marlon.banking.ts.service;

import java.math.BigDecimal;

import org.apache.commons.lang.Validate;

import marlon.banking.ts.dao.AccountDAO;
import marlon.banking.ts.dao.TransferTransactionDAO;
import marlon.banking.ts.exceptions.AccountNotExistedException;
import marlon.banking.ts.exceptions.AccountUnderflowException;
import marlon.banking.ts.model.Account;
import marlon.banking.ts.model.TransferTransaction;

public class TransferServiceImpl implements TransferService {
	private AccountDAO accountDAO;
	private TransferTransactionDAO transferTransactionDAO;

	public TransferServiceImpl(AccountDAO accountDAO, 
			TransferTransactionDAO transferTransactionDAO) {
		this.accountDAO = accountDAO;
		this.transferTransactionDAO = transferTransactionDAO;
	}

	public TransferTransaction transfer(String fromAccountId, String toAccountId,
			BigDecimal amount) throws AccountNotExistedException, AccountUnderflowException {
		Validate.isTrue(amount.compareTo(BigDecimal.ZERO) > 0,"转账金额小于0");
		
		Account fromAccount = accountDAO.findAccount(fromAccountId);
		if (fromAccount == null) throw new AccountNotExistedException(fromAccountId);
		if (fromAccount.getBalance().compareTo(amount) < 0) {
			throw new AccountUnderflowException(fromAccount, amount);
		}
		
		Account toAccount = accountDAO.findAccount(toAccountId);
		if (toAccount == null) throw new AccountNotExistedException(toAccountId);
		
		fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
		toAccount.setBalance(toAccount.getBalance().add(amount));
				
		accountDAO.updateAccount(fromAccount);		// 对Hibernate来说这不是必须的
		accountDAO.updateAccount(toAccount);		// 对Hibernate来说这不是必须的
		return transferTransactionDAO.create(fromAccountId, toAccountId, amount);
	}

	public Account createAccount(String accountId, BigDecimal balance) {
		Validate.notEmpty(accountId);
		Validate.isTrue(balance == null || balance.compareTo(BigDecimal.ZERO) >= 0);
		
		return accountDAO.createAccount(accountId, balance == null ? BigDecimal.ZERO : balance);
	}

	public BigDecimal getBalance(String accountId) {
		return accountDAO.findAccount(accountId).getBalance();
	}
}
