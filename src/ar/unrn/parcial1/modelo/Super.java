package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public class Super extends Nafta {

	private static final Double PORCENTAJE_DESCUENTO_DIEZ = 0.1;
	private static final Double PORCENTAJE_DESCUENTO_DOCE = 0.12;
	private static final String ES_SABADO = "SATURDAY";
	private static final String ES_DOMINGO = "SUNDAY";

	public Super() throws ValidacionException {
		super("SUPER", 90.0);
		// TODO Auto-generated constructor stub
	}

	public double aplicarDescuento(Integer litros, double precioNafta, LocalDateTime fecha) {

		double naftaSuperConDescuento = precioNafta * litros;

		if (esDomingo(fecha))
			naftaSuperConDescuento -= (precioNafta * litros) * PORCENTAJE_DESCUENTO_DIEZ;

		if (esSabado(fecha) && cantidadDeLitros(litros))
			naftaSuperConDescuento -= (precioNafta * litros) * PORCENTAJE_DESCUENTO_DOCE;

		return naftaSuperConDescuento;
	}

	public boolean esSabado(LocalDateTime hoy) {

		if (hoy.getDayOfWeek().toString().contentEquals(ES_SABADO))
			return true;

		return false;
	}

	public boolean esDomingo(LocalDateTime hoy) {

		if (hoy.getDayOfWeek().toString().contentEquals(ES_DOMINGO))
			return true;

		return false;
	}

	public boolean cantidadDeLitros(Integer litros) {

		if (litros >= 20)
			return true;

		return false;
	}
}