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

public class BuscarContenido extends JFrame {

	private JPanel contentPane;
	private JTextField txtContenido;
	private JTextField txtTitulo;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarContenido frame = new BuscarContenido();
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
	public BuscarContenido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarContenido = new JLabel("BUSCAR CONTENIDO");
		lblBuscarContenido.setBounds(162, 11, 114, 14);
		contentPane.add(lblBuscarContenido);
		
		JLabel lblCodigoContenido = new JLabel("Codigo Contenido:");
		lblCodigoContenido.setBounds(30, 62, 120, 14);
		contentPane.add(lblCodigoContenido);
		
		txtContenido = new JTextField();
		txtContenido.setBounds(135, 59, 114, 20);
		contentPane.add(txtContenido);
		txtContenido.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(30, 95, 54, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(135, 92, 114, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(30, 130, 46, 14);
		contentPane.add(lblTipo);
		
		textField = new JTextField();
		textField.setBounds(135, 127, 114, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion :");
		lblDescripcion.setBounds(30, 168, 87, 14);
		contentPane.add(lblDescripcion);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(135, 168, 265, 71);
		contentPane.add(textArea);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(311, 58, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(311, 91, 89, 23);
		contentPane.add(btnSalir);
	}

}
