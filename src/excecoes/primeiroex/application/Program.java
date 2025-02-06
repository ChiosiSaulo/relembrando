package excecoes.primeiroex.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import excecoes.primeiroex.entities.Reservation;
import excecoes.primeiroex.entities.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkin =  fmt1.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkout = fmt1.parse(sc.next());
			
			Reservation r = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + r);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy): ");
		    checkin =  fmt1.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			checkout = fmt1.parse(sc.next());
			
		
			r.updateDates(checkin, checkout);
			System.out.println("Reservation: " + r);
		}
		catch (ParseException e){
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in resevation" + e.getMessage());
		}
		
		
			
			
			
			
		
		
		
		
		
		sc.close();
	}

}
