package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int number = scan.nextInt();
		System.out.print("Check-in (dd/mm/aaaa): ");
		Date checkIn = sdf.parse(scan.next());
		System.out.print("Check-out (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(scan.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data de saída deve ser posterior à data de entrada!");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Digite os dados de atualização da reserva:");
			System.out.print("Check-in (dd/mm/aaaa): ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(scan.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: As datas para atualização devem ser futuras!");
			}
			else if (!checkOut.after(checkIn)){
				System.out.println("Erro na reserva: A data de saída deve ser posterior à data de entrada!");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reserva: " + reservation);
			}
		}
		
		scan.close();
	}
}
