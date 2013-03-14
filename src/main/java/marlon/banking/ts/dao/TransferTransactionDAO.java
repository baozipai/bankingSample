package marlon.banking.ts.dao;

import java.math.BigDecimal;

import marlon.banking.ts.model.TransferTransaction;

public interface TransferTransactionDAO {
	TransferTransaction create(String fromAccountId, String toAccountId, BigDecimal amount);
}
