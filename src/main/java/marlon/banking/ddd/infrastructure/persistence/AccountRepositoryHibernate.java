package marlon.banking.ddd.infrastructure.persistence;

import java.math.BigDecimal;
import java.util.List;

import marlon.banking.ddd.domain.model.Account;
import marlon.banking.ddd.domain.model.AccountRepository;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class AccountRepositoryHibernate implements AccountRepository {
	private HibernateTemplate hibernateTemplate;
	
	public AccountRepositoryHibernate(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public Account createAccount(String accountId, BigDecimal balance) {
		Account account = new Account(accountId, balance);
		hibernateTemplate.save(account);
		return account;
	}

	@SuppressWarnings("unchecked")
	public Account findAccount(String accountId) {
		List accounts = hibernateTemplate.findByNamedQuery("Account.findByAccountId", accountId);
		return accounts.isEmpty() ? null : (Account) accounts.get(0);
	}

	public void updateAccount(Account account) {
		hibernateTemplate.update(account);
	}
}
