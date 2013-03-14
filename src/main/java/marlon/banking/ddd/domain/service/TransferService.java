package marlon.banking.ddd.domain.service;

import java.math.BigDecimal;

import marlon.banking.ddd.domain.model.AccountUnderflowException;
import marlon.banking.ddd.domain.model.TransferTransaction;

public interface TransferService {
	TransferTransaction transfer(String fromAccountId, String toAccountId, BigDecimal amount) 
			throws AccountNotExistedException, AccountUnderflowException;
}
