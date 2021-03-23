package model.exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	private Integer nQuarto;
	private Date checkIn;
	private Date checkOut;

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservas(Integer nQuarto, Date checkIn, Date checkOut) {
		this.nQuarto = nQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getnQuarto() {
		return nQuarto;
	}

	public void setnQuarto(Integer nQuarto) {
		this.nQuarto = nQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - getCheckIn().getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String atualizarDatas(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Erro nas reservar: As reservas atualizadas devem ser futuras datas";
		}
		if (!checkOut.after(checkIn)) {
			return "A data de check-in deve ser primeiro que a de check-out";
		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room " + nQuarto + ", Check-in: " + sdf.format(checkIn) + ", Check-out: " + sdf.format(checkOut) + ","
				+ duracao() + " noites";
	}

}
