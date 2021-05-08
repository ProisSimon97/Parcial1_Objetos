package ar.unrn.parcial1.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import ar.unrn.parcial1.modelo.Nafta;
import ar.unrn.parcial1.modelo.RegistroDeVentas;
import ar.unrn.parcial1.modelo.Venta;

public class PersistenciaDeVenta implements RegistroDeVentas {

	@Override
	public void guardarCargaDeNafta(Venta venta, Nafta nafta) throws Exception {
		// TODO Auto-generated method stub
		String sqlUpdate = "Insert ventas SET fecha = ? ,monto = ? ,litros = ?";

		double montoFinal = 0;

		montoFinal = nafta.aplicarDescuento(venta.litrosCargadosEnLaVenta(), venta.precioDeNaftaActual(),
				venta.fechaDeVenta());

		try {

			Connection conexion = (Connection) Conexion.conexion();
			PreparedStatement ps = (PreparedStatement) ((java.sql.Connection) conexion).prepareStatement(sqlUpdate);

			ps.setTimestamp(1, Timestamp.valueOf(venta.fechaDeVenta()));
			ps.setDouble(2, montoFinal);
			ps.setInt(3, venta.litrosCargadosEnLaVenta());

			ps.executeUpdate();

			ps.close();
			conexion.close();

		} catch (SQLException e) {
			throw new Exception("Error" + e.getMessage());
		}
	}

	@Override
	public List<Venta> recuperarVentas(LocalDateTime inicio, LocalDateTime fin) throws Exception {
		// TODO Auto-generated method stub

		List<Venta> ventas = new ArrayList<Venta>();

		try {

			Connection conexion = Conexion.conexion();
			Statement sent = conexion.createStatement();

			ResultSet resul = sent.executeQuery("select * from ventas");

			while (resul.next()) {

				LocalDateTime fechaPrincipal = resul.getTimestamp("fecha").toLocalDateTime();

				if (fechaPrincipal.isBefore(fin) && fechaPrincipal.isAfter(inicio)) {
					ventas.add(new Venta(fechaPrincipal, resul.getDouble("monto"), resul.getInt("litros")));
				}
			}

		} catch (SQLException e) {
			throw new Exception("Error" + e.getMessage());
		}

		return ventas;
	}
}
