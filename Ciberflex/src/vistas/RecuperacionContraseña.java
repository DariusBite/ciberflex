package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RecuperacionContraseña extends JFrame {

	private JPanel contentPane;
	private JTextField txtNuevaContraseña;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperacionContraseña frame = new RecuperacionContraseña();
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
	public RecuperacionContraseña() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecuperarContrasea = new JLabel("RECUPERAR CONTRASE\u00D1A");
		lblRecuperarContrasea.setBounds(145, 25, 139, 14);
		contentPane.add(lblRecuperarContrasea);
		
		JLabel lblCodigoUsuario = new JLabel("Codigo Usuario :");
		lblCodigoUsuario.setBounds(29, 74, 97, 14);
		contentPane.add(lblCodigoUsuario);
		
		JLabel lblAutogenerado = new JLabel("Autogenerado");
		lblAutogenerado.setBounds(169, 74, 84, 14);
		contentPane.add(lblAutogenerado);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva Contrase\u00F1a :");
		lblNuevaContrasea.setBounds(29, 108, 115, 14);
		contentPane.add(lblNuevaContrasea);
		
		txtNuevaContraseña = new JTextField();
		txtNuevaContraseña.setBounds(169, 105, 115, 20);
		contentPane.add(txtNuevaContraseña);
		txtNuevaContraseña.setColumns(10);
		
		JLabel lblRepitaNuevaContrasea = new JLabel("Repita Nueva Contrase\u00F1a :");
		lblRepitaNuevaContrasea.setBounds(29, 142, 139, 14);
		contentPane.add(lblRepitaNuevaContrasea);
		
		textField = new JTextField();
		textField.setBounds(169, 139, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(97, 201, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(246, 201, 89, 23);
		contentPane.add(btnCancelar);
	}

}
