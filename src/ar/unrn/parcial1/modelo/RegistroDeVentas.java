package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistroDeVentas {

	public void guardarCargaDeNafta(Venta venta, Nafta nafta) throws Exception;

	public List<Venta> recuperarVentas(LocalDateTime inicio, LocalDateTime fin) throws Exception;
}
