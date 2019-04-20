package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			System.out.print("room number: ");
			int number = sc.nextInt(); 
			System.out.print("check in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("check out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
			
			System.out.println("enter data to update the reservation: ");
			System.out.print("check in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("check out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
		
			reservation.updatesDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());
		}
		catch(ParseException e){
			System.out.println("Invalid date format");
		}
		catch(DomainException e){
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e){
			System.out.println("unexpected error");
		}
		
		sc.close();
	}

}
