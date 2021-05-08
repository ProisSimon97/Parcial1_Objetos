package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public abstract class Nafta {

	private TipoDeNafta tipoDeNafta;
	private PrecioDeNafta precioDeNafta;

	public Nafta(String tipoDeNafta, Double precioDeNafta) throws ValidacionException {

		this.tipoDeNafta = new TipoDeNafta(tipoDeNafta);
		this.precioDeNafta = new PrecioDeNafta(precioDeNafta);
	}

	public double precio() {

		return this.precioDeNafta.precioDeLaNafta();
	}

	public abstract double aplicarDescuento(Integer litros, double precioNafta, LocalDateTime fecha);
}
