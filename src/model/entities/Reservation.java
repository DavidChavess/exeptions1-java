package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNunber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation(){
		
	}

	public Reservation(Integer roomNunber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)){
			throw new DomainException("error in reservation: check-out date must be after check-in date");
		}
		this.roomNunber = roomNunber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNunber() {
		return roomNunber;
	}

	public void setRoomNunber(Integer roomNunber) {
		this.roomNunber = roomNunber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration(){
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updatesDates(Date checkIn, Date checkOut){
		Date now = new Date();
		if(checkIn.before(now)||checkOut.before(now)){
			throw new DomainException("error in reservation: dates for updates must be future dates");
		}
		if(!checkOut.after(checkIn)){
			throw new DomainException("error in reservation: check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	@Override
	public String toString(){
		return "Room "+
		roomNunber +
		", check-in: "+
		sdf.format(checkIn) +
		", check-out: "+
		sdf.format(checkOut)+
		", "+
		duration() + 
		" nights";
	}
}
