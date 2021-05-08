package Main;

import ar.unrn.parcial1.persistencia.EnDiscoGuardarVenta;
import ar.unrn.parcial1.ui.MenuPrincipal;

public class MainDisco {

	public static void main(String[] args) {

		MenuPrincipal menu = new MenuPrincipal(
				new EnDiscoGuardarVenta("C:\\Users\\Simón\\Downloads\\UNRN\\Materias 3ro\\OO2\\archivo_examen.txt"));

		menu.setVisible(true);
	}
}
