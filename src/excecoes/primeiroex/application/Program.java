package excecoes.primeiroex.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import excecoes.primeiroex.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		
		SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkin =  fmt1.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy): ");
		Date checkout = fmt1.parse(sc.next());
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation r = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + r);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy): ");
		    checkin =  fmt1.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkout = fmt1.parse(sc.next());
			
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future date");
			}
			else if(!checkout.after(checkin)){
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
				r.updateDates(checkin, checkout);
				System.out.println("Reservation: " + r);
			}
			
			
		}
		
		
		
		
		sc.close();
	}

}
