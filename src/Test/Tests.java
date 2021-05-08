package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.Test;

import ar.unrn.parcial1.modelo.Comun;
import ar.unrn.parcial1.modelo.Nafta;
import ar.unrn.parcial1.modelo.RegistroDeVentas;
import ar.unrn.parcial1.modelo.Super;
import ar.unrn.parcial1.modelo.ValidacionException;
import ar.unrn.parcial1.modelo.Venta;
import ar.unrn.parcial1.persistencia.EnMemoriaGuardarVenta;

public class Tests {

	@Test

	public void calcularMontoDeNaftaSuperEnUnDomingoTest() throws ValidacionException {

		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 8, 22, 20);

		Nafta nafta = new Super();

		Integer litros = 20;

		assertEquals(1584.0, nafta.aplicarDescuento(litros, nafta.precio(), date), 0.1);
	}

	@Test

	public void calcularMontoDeNaftaSuperEnUnSabadoTest() throws ValidacionException {

		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 9, 22, 20);

		Nafta nafta = new Super();

		Integer litros = 20;

		assertEquals(1620.0, nafta.aplicarDescuento(litros, nafta.precio(), date), 0.1);
	}

	@Test

	public void calcularMontoDeNaftaComunTest() throws ValidacionException {

		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 9, 9, 9);

		Nafta nafta = new Comun();

		Integer litros = 20;

		assertEquals(1330.0, nafta.aplicarDescuento(litros, nafta.precio(), date), 0.1);
	}

	@Test

	public void calcularMontoDeNaftaComunSinDescuentoTest() throws ValidacionException {

		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 9, 11, 9);

		Nafta nafta = new Comun();

		Integer litros = 20;

		assertEquals(1400.0, nafta.aplicarDescuento(litros, nafta.precio(), date), 0.1);
	}

	@Test

	public void calcularMontoDeNaftaSuperSinDescuentoTest() throws ValidacionException {

		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 10, 22, 20);

		Nafta nafta = new Super();

		Integer litros = 20;

		assertEquals(1800, nafta.aplicarDescuento(litros, nafta.precio(), date), 0.1);
	}

	@Test

	public void verificarRegistroDeVentaTest() throws Exception {

		RegistroDeVentas registro = new EnMemoriaGuardarVenta();

		Nafta nafta = new Super();

		Venta venta = new Venta(LocalDateTime.now(), nafta.precio(), 20);

		registro.guardarCargaDeNafta(venta, nafta);

		List<Venta> lista = registro.recuperarVentas(LocalDateTime.of(2021, Month.MAY, 7, 9, 9),
				LocalDateTime.of(2021, Month.MAY, 10, 9, 9));

		assertNotNull(lista);
	}

	@Test

	public void verificarValidacionesFuncionandoEnVentaTest() {

		assertThrows(ValidacionException.class, () -> {
			new Venta(LocalDateTime.now(), 0, 20);
		});
	}
}
