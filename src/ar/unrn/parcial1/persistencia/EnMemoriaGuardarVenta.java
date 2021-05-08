package ar.unrn.parcial1.persistencia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ar.unrn.parcial1.modelo.Nafta;
import ar.unrn.parcial1.modelo.RegistroDeVentas;
import ar.unrn.parcial1.modelo.Venta;

public class EnMemoriaGuardarVenta implements RegistroDeVentas {

	private List<String> registroVentas = new ArrayList<String>();

	@Override
	public void guardarCargaDeNafta(Venta venta, Nafta nafta) throws Exception {
		// TODO Auto-generated method stub
		double monto = nafta.aplicarDescuento(venta.litrosCargadosEnLaVenta(), nafta.precio(), venta.fechaDeVenta());

		DateTimeFormatter largo = DateTimeFormatter.ofPattern("dd-MM-YYYY h:mm").withLocale(new Locale("es", "ES"));
		String fechaDeVenta = largo.format(venta.fechaDeVenta());

		String carga = fechaDeVenta + "," + monto + "," + venta.litrosCargadosEnLaVenta().toString() + "\n";

		registroVentas.add(carga);
	}

	@Override
	public List<Venta> recuperarVentas(LocalDateTime inicio, LocalDateTime fin) throws Exception {
		// TODO Auto-generated method stub
		List<Venta> ventas = new ArrayList<Venta>();

		for (String venta : registroVentas) {

			Venta a;
			try {
				String[] split = venta.split(",");
				String fecha = split[0];
				String[] splitFecha = fecha.split("-");

				LocalDateTime fechaPrincipal = LocalDateTime.of(Integer.parseInt(splitFecha[0]),
						Integer.parseInt(splitFecha[1]), Integer.parseInt(splitFecha[2]), 0, 0);

				if (fechaPrincipal.isBefore(fin) && fechaPrincipal.isAfter(inicio)) {
					a = new Venta(fechaPrincipal, Double.valueOf(split[1]), Integer.valueOf(split[2]));
					ventas.add(a);
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return ventas;
	}

}
