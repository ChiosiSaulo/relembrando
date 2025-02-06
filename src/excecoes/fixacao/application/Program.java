package excecoes.fixacao.application;

import java.util.Scanner;

import excecoes.fixacao.model.entities.Account;
import excecoes.primeiroex.entities.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account data");
		System.out.println("Number: ");
		int number = sc.nextInt();
		System.out.println("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.println("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.println("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		try {
			acc.withdraw(amount);
			System.out.println("New Balance: " + acc.getBalance());
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		
		
		
		sc.close();
	}

}
