package marlon.banking.ddd.domain.model;

import java.math.BigDecimal;

import org.apache.commons.lang.Validate;

/**
 * 帐户容许欠款，但有限制。
 * 
 * @author marlon
 *
 */
public class LimitedOverdraftPolicy implements OverdraftPolicy {
	private BigDecimal limit;
	
	public LimitedOverdraftPolicy(BigDecimal limit) {
		Validate.isTrue(limit.compareTo(BigDecimal.ZERO) > 0, "limit must be greater than zero");
		this.limit = limit;
	}
	
	public boolean isAllowed(Account account, BigDecimal amount) {
		return account.getBalance().add(limit).compareTo(amount) > 0;
	}
	
}
