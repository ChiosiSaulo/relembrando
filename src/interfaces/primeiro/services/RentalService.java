package interfaces.primeiro.services;

import java.time.Duration;

import interfaces.primeiro.entities.CarRental;
import interfaces.primeiro.entities.Invoice;

public class RentalService {
	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;
	
	
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}


	public void provessInvoice(CarRental cr) {
		double minutes = Duration.between(cr.getStart(), cr.getFinish()).toMinutes();
		double hours = minutes / 60;
		
		double basicPayment;
		
		if (hours <= 12) {
			basicPayment = pricePerHour * Math.ceil(hours);
		}else {
			basicPayment = pricePerDay * Math.ceil(hours/24);
		}
		
		double tax = taxService.tax(basicPayment);

		cr.setInvoice(new Invoice(basicPayment, tax));
	}
}
