package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ReporteUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTipo;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteUsuarios frame = new ReporteUsuarios();
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
	public ReporteUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReporteDeUsuarios = new JLabel("REPORTE DE USUARIOS");
		lblReporteDeUsuarios.setBounds(151, 11, 125, 14);
		contentPane.add(lblReporteDeUsuarios);
		
		JLabel lblCodigoUsuario = new JLabel("Codigo Usuario:");
		lblCodigoUsuario.setBounds(10, 39, 108, 14);
		contentPane.add(lblCodigoUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(128, 36, 110, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setBounds(10, 64, 61, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(128, 61, 110, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 89, 61, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(128, 86, 110, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario:");
		lblTipoDeUsuario.setBounds(10, 114, 108, 14);
		contentPane.add(lblTipoDeUsuario);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(128, 111, 110, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblCodigoDePlan = new JLabel("Codigo de Plan:");
		lblCodigoDePlan.setBounds(10, 139, 108, 14);
		contentPane.add(lblCodigoDePlan);
		
		textField = new JTextField();
		textField.setBounds(128, 136, 110, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 168, 414, 83);
		contentPane.add(textArea);
		
		JButton btnReportar = new JButton("Reportar");
		btnReportar.setBounds(335, 35, 89, 23);
		contentPane.add(btnReportar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(335, 64, 89, 23);
		contentPane.add(btnSalir);
	}
}
