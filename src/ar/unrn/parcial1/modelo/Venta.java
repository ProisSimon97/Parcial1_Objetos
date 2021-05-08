package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public class Venta {

	private PrecioDeNafta precioDeNafta;
	private Fecha fecha;
	private LitrosCargados litros;

	public Venta(LocalDateTime fecha, double precio, Integer litros) throws ValidacionException {

		this.fecha = new Fecha(fecha);
		this.precioDeNafta = new PrecioDeNafta(precio);
		this.litros = new LitrosCargados(litros);
	}

	public double precioDeNaftaActual() {

		double precio = this.precioDeNafta.precioDeLaNafta();

		return precio;
	}

	public LocalDateTime fechaDeVenta() {

		LocalDateTime fecha = this.fecha.fechaActual();

		return fecha;
	}

	public Integer litrosCargadosEnLaVenta() {

		Integer litros = this.litros.litrosCargados();

		return litros;
	}
}
