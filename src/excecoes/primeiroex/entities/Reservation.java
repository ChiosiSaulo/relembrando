package excecoes.primeiroex.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import excecoes.primeiroex.entities.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		if(!checkout.after(checkin)){
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void updateDates(Date checkin, Date checkout) throws DomainException{
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Reservation dates for update must be future date");
		}
	    if(!checkout.after(checkin)){
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
		
	}
	
	public long duration() { 
		 long diff = checkout.getTime() - checkin.getTime();
		 return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	@Override
	public String toString() {
		return "Room Number:" + roomNumber 
				+ ", check-in: " 
				+ fmt1.format(checkin) 
				+ ", checkout: "
				+ fmt1.format(checkout) 
				+ ", "
		        + duration() + " nights"
		 ;
	}

}
