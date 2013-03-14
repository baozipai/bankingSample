package marlon.banking.ddd.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransferTransaction {
	@SuppressWarnings("unused")
	private long id;		/* for hibernate */
	
	private Date timestamp;
	private String fromAccountId;
	private String toAccountId;
	private BigDecimal amount;
	
	public TransferTransaction() {}
	
	public TransferTransaction(String fromAccountId, String toAccountId, BigDecimal amount, Date timestamp) {
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.timestamp = timestamp;
	}
	

	public Date getTimestamp() {
		return timestamp;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	public String toString() {
		return String.format("transfer '%s' from account '%s' to account '%s' at '%s'", amount, fromAccountId, toAccountId, timestamp);
	}
}
