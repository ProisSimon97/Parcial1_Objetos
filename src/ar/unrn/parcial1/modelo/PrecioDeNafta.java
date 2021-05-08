package ar.unrn.parcial1.modelo;

public class PrecioDeNafta {

	private Double precioDeNafta;

	public PrecioDeNafta(Double precio) throws ValidacionException {

		if (precio < 1)
			throw new ValidacionException("El precio de la nafta debe ser un valor real");

		this.precioDeNafta = precio;
	}

	public double precioDeLaNafta() {

		double precio = Double.valueOf(this.precioDeNafta);

		return precio;
	}

}
