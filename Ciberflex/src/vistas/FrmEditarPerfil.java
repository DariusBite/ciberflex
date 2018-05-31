package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class FrmEditarPerfil extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEditarPerfil frame = new FrmEditarPerfil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmEditarPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarPerfil = new JLabel("Editar Perfil");
		lblEditarPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarPerfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditarPerfil.setBounds(10, 11, 414, 20);
		contentPane.add(lblEditarPerfil);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 42, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 67, 98, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblRepiteTuContrasea = new JLabel("Repite tu contrase\u00F1a");
		lblRepiteTuContrasea.setBounds(10, 92, 122, 14);
		contentPane.add(lblRepiteTuContrasea);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 117, 71, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 142, 64, 14);
		contentPane.add(lblApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(10, 167, 122, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 192, 84, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(10, 217, 46, 14);
		contentPane.add(lblCiudad);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 242, 71, 14);
		contentPane.add(lblProvincia);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 267, 71, 14);
		contentPane.add(lblTelefono);
		
		textField = new JTextField();
		textField.setBounds(145, 39, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 64, 160, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(145, 89, 160, 20);
		contentPane.add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 114, 160, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 139, 160, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(145, 189, 160, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(145, 214, 160, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(145, 239, 160, 20);
		contentPane.add(comboBox_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(145, 264, 160, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPlan = new JLabel("Plan");
		lblPlan.setBounds(10, 292, 46, 14);
		contentPane.add(lblPlan);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(145, 289, 160, 20);
		contentPane.add(comboBox_2);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(169, 343, 98, 28);
		contentPane.add(btnGuardar);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(145, 164, 160, 20);
		contentPane.add(dateChooser);
	}
}
