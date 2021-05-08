package ar.unrn.parcial1.modelo;

public class TipoDeNafta {

	private String tipoDeNafta;

	public TipoDeNafta(String tipoDeNafta) throws ValidacionException {

		if (tipoDeNafta.contentEquals(""))
			throw new ValidacionException("Debe cargar el tipo de nafta.");

		this.tipoDeNafta = tipoDeNafta;
	}

}
