package marlon.banking.ts.facade;

import java.math.BigDecimal;

import marlon.banking.ts.exceptions.AccountNotExistedException;
import marlon.banking.ts.exceptions.AccountUnderflowException;
import marlon.banking.ts.model.Account;
import marlon.banking.ts.model.TransferTransaction;
import marlon.banking.ts.service.TransferService;

public class TransferFacadeImpl implements TransferFacade {

	private TransferService transferService;
	
	public TransferFacadeImpl(TransferService transferService) {
		this.transferService = transferService;
	}
	
	public Account createAccount(String accountId, BigDecimal balance) {
		return transferService.createAccount(accountId, balance);
	}

	public TransferTransaction transfer(String fromAccountId,
			String toAccountId, BigDecimal amount)
				throws AccountNotExistedException, AccountUnderflowException {
		return transferService.transfer(fromAccountId, toAccountId, amount);
	}
	
	public BigDecimal getBalance(String accountId) {
		return transferService.getBalance(accountId);
	}
}
