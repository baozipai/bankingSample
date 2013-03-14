package marlon.banking.ts.exceptions;

public class AccountNotExistedException extends Exception {
	private static final long serialVersionUID = -7541389775817139018L;
	
	private String accountId;
	
	public AccountNotExistedException(String accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountId() {
		return accountId;
	}
	
	public String getMessage() {
		return String.format("Cannot found account with id '%s'", accountId);
	}
}
