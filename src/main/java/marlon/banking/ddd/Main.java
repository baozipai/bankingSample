package marlon.banking.ddd;

import java.math.BigDecimal;

import marlon.banking.ddd.application.TransferFacade;
import marlon.banking.ddd.domain.model.Account;
import marlon.banking.ddd.domain.model.AccountUnderflowException;
import marlon.banking.ddd.domain.service.AccountNotExistedException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String[] configPaths = {
			"context-datasource.xml",
			"ddd/context-persistence-hibernate.xml",
			"ddd/context-services.xml",
			"ddd/context-facades.xml"
		};
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configPaths);
		
		TransferFacade transferFacade = (TransferFacade) context.getBean("transferFacade", TransferFacade.class);
		Account fromAccount = transferFacade.createAccount("A", new BigDecimal("3250"));
		Account toAccount = transferFacade.createAccount("B", new BigDecimal("55.5"));
		
		try {
			transferFacade.transfer(fromAccount.getAccountId(), toAccount.getAccountId(), new BigDecimal("-50"));
		} catch (AccountNotExistedException e) {
			e.printStackTrace();
		} catch (AccountUnderflowException e) {
			e.printStackTrace();
		}
		
		System.out.println(fromAccount.getAccountId() + " has balance: " + transferFacade.getBalance(fromAccount.getAccountId()));
		System.out.println(toAccount.getAccountId() + " has balance: " + transferFacade.getBalance(toAccount.getAccountId()));
	}
}
