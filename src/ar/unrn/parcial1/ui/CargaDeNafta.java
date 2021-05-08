package ar.unrn.parcial1.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ar.unrn.parcial1.modelo.Comun;
import ar.unrn.parcial1.modelo.Nafta;
import ar.unrn.parcial1.modelo.RegistroDeVentas;
import ar.unrn.parcial1.modelo.Super;
import ar.unrn.parcial1.modelo.ValidacionException;
import ar.unrn.parcial1.modelo.Venta;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class CargaDeNafta extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField LitrosTextField;
	private JTextField montoTextField;

	public CargaDeNafta(RegistroDeVentas persistencia) {
		getContentPane().setLayout(null);

		setTitle("Carga de Nafta");
		setBounds(100, 100, 275, 285);

		JLabel lblNewLabel = new JLabel("Litros Cargados:");
		lblNewLabel.setBounds(10, 30, 126, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tipo de Nafta: ");
		lblNewLabel_1.setBounds(10, 84, 126, 18);
		getContentPane().add(lblNewLabel_1);

		LitrosTextField = new JTextField();
		LitrosTextField.setBounds(146, 27, 43, 20);
		getContentPane().add(LitrosTextField);
		LitrosTextField.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(146, 80, 75, 22);
		getContentPane().add(comboBox);

		comboBox.addItem("Super");
		comboBox.addItem("Comun");

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String tipo = comboBox.getSelectedItem().toString();
					Nafta nafta = null;

					if (tipo.contentEquals("Super"))
						nafta = new Super();

					else {

						nafta = new Comun();
					}

					Venta venta = new Venta(LocalDateTime.now(), nafta.precio(),
							Integer.parseInt(LitrosTextField.getText()));

					try {
						persistencia.guardarCargaDeNafta(venta, nafta);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}

					JOptionPane.showMessageDialog(null, "Se guardo con exito", "Exito",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (ValidacionException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un numero", "Error", JOptionPane.ERROR_MESSAGE);
				}

				setVisible(false);
			}
		});
		btnNewButton.setBounds(11, 200, 89, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(146, 200, 89, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Consultar Monto");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String tipo = comboBox.getSelectedItem().toString();
					Nafta nafta = null;

					if (tipo.contentEquals("Super"))
						nafta = new Super();

					else {

						nafta = new Comun();
					}

					montoTextField
							.setText(String.valueOf(nafta.aplicarDescuento(Integer.parseInt(LitrosTextField.getText()),
									nafta.precio(), LocalDateTime.now())));

				} catch (ValidacionException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(11, 138, 128, 23);
		getContentPane().add(btnNewButton_2);

		montoTextField = new JTextField();
		montoTextField.setBounds(165, 139, 43, 20);
		getContentPane().add(montoTextField);
		montoTextField.setColumns(10);
	}
}