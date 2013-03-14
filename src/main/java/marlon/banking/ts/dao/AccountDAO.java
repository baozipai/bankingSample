package marlon.banking.ts.dao;

import java.math.BigDecimal;

import marlon.banking.ts.model.Account;


public interface AccountDAO {
	Account findAccount(String accountId);
	
	Account createAccount(String accountId, BigDecimal balance);
	
	void updateAccount(Account account);
}
