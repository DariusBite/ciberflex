package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OlvideContraseña extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OlvideContraseña frame = new OlvideContraseña();
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
	public OlvideContraseña() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblolvidasteTuContrasea = new JLabel("\u00BFOlvidaste tu Contrase\u00F1a?");
		lblolvidasteTuContrasea.setBounds(143, 11, 137, 14);
		contentPane.add(lblolvidasteTuContrasea);
		
		JLabel lblCodigoUsuario = new JLabel("Codigo Usuario :");
		lblCodigoUsuario.setBounds(10, 52, 93, 14);
		contentPane.add(lblCodigoUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(143, 49, 103, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPreguntaSecreta = new JLabel("Pregunta Secreta :");
		lblPreguntaSecreta.setBounds(10, 87, 103, 14);
		contentPane.add(lblPreguntaSecreta);
		
		textField = new JTextField();
		textField.setBounds(143, 84, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRespuesta = new JLabel("Respuesta :");
		lblRespuesta.setBounds(10, 125, 93, 14);
		contentPane.add(lblRespuesta);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 122, 165, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(100, 185, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(219, 185, 89, 23);
		contentPane.add(btnCancelar);
	}

}
