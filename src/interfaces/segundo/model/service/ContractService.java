package interfaces.segundo.model.service;

import java.time.LocalDate;

import interfaces.segundo.model.entities.Contract;
import interfaces.segundo.model.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, Integer months) {
		double basicPayment = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			double interest = onlinePaymentService.interest(basicPayment, i);
			double fee = onlinePaymentService.paymentFee(basicPayment + interest);
			
			double amount = basicPayment + fee + interest;
			contract.getList().add(new Installment(dueDate, amount));
		}
	}
}
