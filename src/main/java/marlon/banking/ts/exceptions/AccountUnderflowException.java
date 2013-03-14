package marlon.banking.ts.exceptions;

import java.math.BigDecimal;

import marlon.banking.ts.model.Account;

/**
 * 当取的金额超过帐户容许的最大金额时，会抛出此异常。
 * 
 * @author marlon
 *
 */
public class AccountUnderflowException extends Exception {
	private static final long serialVersionUID = -6299588017190080876L;
	
	private Account account;
	private BigDecimal amount;
	
	public AccountUnderflowException(Account account, BigDecimal amount) {
		this.account = account;
		this.amount = amount;
	}
	
	public String getMessage() {
		return String.format("Not allowed to debit '%s' from account '%s'", amount, account);
	}
}
