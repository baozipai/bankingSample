package marlon.banking.ts.model;

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

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return String.format("transfer '%s' from account '%s' to account '%s' at '%s'", amount, fromAccountId, toAccountId, timestamp);
	}
}
