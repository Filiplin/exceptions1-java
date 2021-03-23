package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.exception.Reservas;

public class aplicando {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int nQuarto = sc.nextInt();
		System.out.print("Check-in data (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out data (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("A data de check-in deve ser primeiro que a de check-out");
		} else {
			Reservas reservas = new Reservas(nQuarto, checkIn, checkOut);
			System.out.println("Reserva : " + reservas);

			System.out.println();

			System.out.println("Insira a data atualizada de reserva: ");

			System.out.print("Check-in data (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String erro = reservas.atualizarDatas(checkIn, checkOut);
			if (erro != null) {
				System.out.println(erro);
			} 
			else {
				System.out.println("Reserva : " + reservas);

			}

		}
		sc.close();
	}

}
