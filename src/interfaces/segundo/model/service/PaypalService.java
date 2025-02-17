package interfaces.segundo.model.service;

public class PaypalService implements OnlinePaymentService{

	private static final double FEE_PERCENTAGE = 0.02;
	private static final double INTEREST_MONTH = 0.01;
	@Override
	public double paymentFee(double amount) {
		return amount * FEE_PERCENTAGE;
	}

	@Override
	public double interest(double amount, int months) {
		return amount * INTEREST_MONTH * months;
	}
	
}
