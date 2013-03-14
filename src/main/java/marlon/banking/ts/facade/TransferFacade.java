package marlon.banking.ts.facade;

import java.math.BigDecimal;

import marlon.banking.ts.exceptions.AccountNotExistedException;
import marlon.banking.ts.exceptions.AccountUnderflowException;
import marlon.banking.ts.model.Account;
import marlon.banking.ts.model.TransferTransaction;

public interface TransferFacade {
	TransferTransaction transfer(String fromAccountId, String toAccountId, BigDecimal amount) 
			throws AccountNotExistedException, AccountUnderflowException;
	
	Account createAccount(String accountId, BigDecimal balance);
	
	BigDecimal getBalance(String accountId);
}
