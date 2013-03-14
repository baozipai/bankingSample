package marlon.banking.ddd.domain.model;

import java.math.BigDecimal;

public interface TransferTransactionRepository {
	TransferTransaction create(String fromAccountId, String toAccountId, BigDecimal amount);
}
