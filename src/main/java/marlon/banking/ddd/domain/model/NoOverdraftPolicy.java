package marlon.banking.ddd.domain.model;

import java.math.BigDecimal;

/**
 * 帐户不容许有欠款。
 * 
 * @author marlon
 *
 */
public class NoOverdraftPolicy implements OverdraftPolicy {
	public static final NoOverdraftPolicy INSTANCE = new NoOverdraftPolicy();
	
	public boolean isAllowed(Account account, BigDecimal amount) {
		return account.getBalance().compareTo(amount) >= 0;
	}
	
}
