package Main;

import ar.unrn.parcial1.persistencia.PersistenciaDeVenta;
import ar.unrn.parcial1.ui.MenuPrincipal;

public class MainPersistencia {
	public static void main(String[] args) {

		MenuPrincipal menu = new MenuPrincipal(new PersistenciaDeVenta());

		menu.setVisible(true);
	}
}
