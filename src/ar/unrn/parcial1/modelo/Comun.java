package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public class Comun extends Nafta {

	private static final Double PORCENTAJE_DESCUENTO_CINCO = 0.05;
	private static final Integer HORA_OCHO = 8;
	private static final Integer HORA_DIEZ = 10;

	public Comun() throws ValidacionException {
		super("COMUN", 70.0);
		// TODO Auto-generated constructor stub
	}

	public double aplicarDescuento(Integer litros, double precioNafta, LocalDateTime fecha) {

		double naftaComunConDescuento = precioNafta * litros;

		if (entreDosHoras(fecha.getHour()))
			naftaComunConDescuento -= (precioNafta * litros) * PORCENTAJE_DESCUENTO_CINCO;

		return naftaComunConDescuento;
	}

	public boolean entreDosHoras(int hora) {

		if (hora >= HORA_OCHO && hora <= HORA_DIEZ)
			return true;

		return false;
	}
}
