package marlon.banking.ddd.domain.model;

import java.math.BigDecimal;


import org.apache.commons.lang.Validate;

public class Account {
	@SuppressWarnings("unused")
	private long id;			/* for hibernate */
	
	private String accountId;
	private BigDecimal balance;
	
	private OverdraftPolicy overdraftPolicy = NoOverdraftPolicy.INSTANCE;
	
	public Account() {}
	
	public Account(String accountId, BigDecimal balance) {
		Validate.notEmpty(accountId);
		Validate.isTrue(balance == null || balance.compareTo(BigDecimal.ZERO) >= 0);
		
		this.accountId = accountId;
		this.balance = balance == null ? BigDecimal.ZERO : balance;
	}
	
	public String getAccountId() {
		return accountId;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
	public void debit(BigDecimal amount) throws AccountUnderflowException {
		Validate.isTrue(amount.compareTo(BigDecimal.ZERO) > 0,"转账金额小于0");
		
		if (!overdraftPolicy.isAllowed(this, amount)) {
			throw new AccountUnderflowException(this, amount);
		}
		balance = balance.subtract(amount);
	}
	
	public void credit(BigDecimal amount) {
		Validate.isTrue(amount.compareTo(BigDecimal.ZERO) > 0);
		
		balance = balance.add(amount);
	}
	
	public String toString() {
		return accountId;
	}
}
