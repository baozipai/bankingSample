package marlon.banking.ddd.application;

import java.math.BigDecimal;

import marlon.banking.ddd.domain.model.Account;
import marlon.banking.ddd.domain.model.AccountUnderflowException;
import marlon.banking.ddd.domain.model.TransferTransaction;
import marlon.banking.ddd.domain.service.AccountNotExistedException;

public interface TransferFacade {
	TransferTransaction transfer(String fromAccountId, String toAccountId, BigDecimal amount) 
			throws AccountNotExistedException, AccountUnderflowException;
	
	Account createAccount(String accountId, BigDecimal balance);
	
	BigDecimal getBalance(String accountId);
}
