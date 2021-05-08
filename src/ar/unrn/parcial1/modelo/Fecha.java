package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public class Fecha {

	private LocalDateTime fecha;

	public Fecha(LocalDateTime fecha) throws ValidacionException {

		if (fecha.toString().contentEquals(""))
			throw new ValidacionException("La fecha es incorrecta");

		this.fecha = fecha;
	}

	public LocalDateTime fechaActual() {

		LocalDateTime fecha = this.fecha;

		return fecha;
	}
}
