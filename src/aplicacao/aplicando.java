package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reservas;
import model.exception.ReservasException;

public class aplicando {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do quarto: ");
			int nQuarto = sc.nextInt();
			System.out.print("Check-in data (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservas reservas = new Reservas(nQuarto, checkIn, checkOut);
			System.out.println("Reserva : " + reservas);
	
			System.out.println();
	
			System.out.println("Insira a data atualizada de reserva: ");
	
			System.out.print("Check-in data (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservas.atualizarDatas(checkIn, checkOut);
	
			System.out.println("Reserva : " + reservas);
		}
		catch(ParseException e) {
			System.out.println("Formato da data invalida");
		}
		catch(ReservasException e) {
			System.out.println(e);
		}
		catch(RuntimeException e) {
			System.out.println("Erro desconhecido");
		}

		sc.close();
	}

}
