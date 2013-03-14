package marlon.banking.ts;

import java.math.BigDecimal;

import marlon.banking.ts.exceptions.AccountNotExistedException;
import marlon.banking.ts.exceptions.AccountUnderflowException;
import marlon.banking.ts.facade.TransferFacade;
import marlon.banking.ts.model.Account;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String[] configPaths = {
			"context-datasource.xml",
			"ts/context-persistence-hibernate.xml",
			"ts/context-services.xml",
			"ts/context-facades.xml"
		};
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configPaths);
		
		TransferFacade transferFacade = (TransferFacade) context.getBean("transferFacade", TransferFacade.class);
		Account fromAccount = transferFacade.createAccount("A", new BigDecimal("3250"));
		Account toAccount = transferFacade.createAccount("B", new BigDecimal("55.5"));
		
		try {
			transferFacade.transfer(fromAccount.getAccountId(), toAccount.getAccountId(), new BigDecimal("2000"));
		} catch (AccountNotExistedException e) {
			e.printStackTrace();
		} catch (AccountUnderflowException e) {
			e.printStackTrace();
		}
		
		System.out.println(fromAccount.getAccountId() + " has balance: " + transferFacade.getBalance(fromAccount.getAccountId()));
		System.out.println(toAccount.getAccountId() + " has balance: " + transferFacade.getBalance(toAccount.getAccountId()));
	}
}
