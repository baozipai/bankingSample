package marlon.banking.ddd.application;

import java.math.BigDecimal;

import marlon.banking.ddd.domain.model.Account;
import marlon.banking.ddd.domain.model.AccountRepository;
import marlon.banking.ddd.domain.model.AccountUnderflowException;
import marlon.banking.ddd.domain.model.TransferTransaction;
import marlon.banking.ddd.domain.service.AccountNotExistedException;
import marlon.banking.ddd.domain.service.TransferService;

public class TransferFacadeImpl implements TransferFacade {

	private AccountRepository accountRepository;
	private TransferService transferService;
	
	public TransferFacadeImpl(AccountRepository accountRepository,
			TransferService transferService) {
		this.accountRepository = accountRepository;
		this.transferService = transferService;
	}
	
	public Account createAccount(String accountId, BigDecimal balance) {
		return accountRepository.createAccount(accountId, balance);
	}

	public TransferTransaction transfer(String fromAccountId,
			String toAccountId, BigDecimal amount)
				throws AccountNotExistedException, AccountUnderflowException {
		return transferService.transfer(fromAccountId, toAccountId, amount);
	}

	public BigDecimal getBalance(String accountId) {
		return accountRepository.findAccount(accountId).getBalance();
	}
	
}
