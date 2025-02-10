package interfaces.segundo.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import interfaces.segundo.model.entities.Contract;
import interfaces.segundo.model.entities.Installment;
import interfaces.segundo.model.service.ContractService;
import interfaces.segundo.model.service.PaypalService;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		sc.nextLine();
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		ContractService service = new ContractService(new PaypalService());
		
		System.out.print("Entre com o numero de parcelas: ");
		int months = sc.nextInt();
		
		service.processContract(contract, months);
		
		System.out.println("PARCELAS: ");
		for(Installment i : contract.getList()) {
			System.out.println(i);
		}
		
		sc.close();
		
	}

}
