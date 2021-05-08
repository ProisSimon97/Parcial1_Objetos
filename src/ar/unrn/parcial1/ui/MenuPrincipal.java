package ar.unrn.parcial1.ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import ar.unrn.parcial1.modelo.RegistroDeVentas;

public class MenuPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuPrincipal(RegistroDeVentas persistencia) {

		getContentPane().setLayout(null);
		setBounds(100, 100, 301, 242);
		setTitle("Menu Principal");
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CargaDeNafta vista = new CargaDeNafta(persistencia);

				vista.setVisible(true);
			}
		});
		btnNewButton.setBounds(170, 24, 89, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Abrir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ConsultaDeVentas vista = new ConsultaDeVentas(persistencia);

				vista.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(170, 91, 89, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cerrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(170, 163, 89, 23);
		getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("Carga de Combustible:");
		lblNewLabel.setBounds(10, 28, 150, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Consulta de Ventas:");
		lblNewLabel_1.setBounds(10, 95, 150, 14);
		getContentPane().add(lblNewLabel_1);
	}
}
