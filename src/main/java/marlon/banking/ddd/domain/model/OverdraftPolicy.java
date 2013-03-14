package marlon.banking.ddd.domain.model;

import java.math.BigDecimal;

public interface OverdraftPolicy {
	boolean isAllowed(Account account, BigDecimal amount);
}
