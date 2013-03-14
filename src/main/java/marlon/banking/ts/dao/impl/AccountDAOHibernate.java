package marlon.banking.ts.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import marlon.banking.ts.dao.AccountDAO;
import marlon.banking.ts.model.Account;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class AccountDAOHibernate implements AccountDAO {
	private HibernateTemplate hibernateTemplate;
	
	public AccountDAOHibernate(SessionFactory sessionFactory) {
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
