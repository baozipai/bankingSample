package marlon.banking.ts.dao.impl;

import java.math.BigDecimal;
import java.util.Date;

import marlon.banking.ts.dao.TransferTransactionDAO;
import marlon.banking.ts.model.TransferTransaction;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class TransferTransactionDAOHibernate implements TransferTransactionDAO {

	private HibernateTemplate hibernateTemplate;
	
	public TransferTransactionDAOHibernate(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	public TransferTransaction create(String fromAccountId, String toAccountId,
			BigDecimal amount) {
		Date timestamp = new Date();
		TransferTransaction transferTransaction = new TransferTransaction(
				fromAccountId, toAccountId, amount, timestamp);
		hibernateTemplate.save(transferTransaction);
		return transferTransaction;
	}

}
