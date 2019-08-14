package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int number = scan.nextInt();
			System.out.print("Check-in (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.print("Check-out (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(scan.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Digite os dados de atualização da reserva:");
			System.out.print("Check-in (dd/mm/aaaa): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(scan.next());
			
			reservation.updateDates(checkIn, checkOut);
			
			System.out.println("Reserva: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválido!");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		
		scan.close();
	}
}
