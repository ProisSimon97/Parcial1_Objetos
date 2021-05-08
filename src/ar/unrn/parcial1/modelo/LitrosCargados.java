package ar.unrn.parcial1.modelo;

public class LitrosCargados {

	private String litrosCargados;

	public LitrosCargados(Integer litros) throws ValidacionException {

		if (litros < 1)
			throw new ValidacionException("Debe introducir una cantidad de litros valida.");

		this.litrosCargados = litros.toString();
	}

	public Integer litrosCargados() {

		Integer litros = Integer.valueOf(this.litrosCargados);

		return litros;
	}

	public String litrosCargadosParaDisco() {

		String litros = this.litrosCargados;

		return litros;
	}
}
