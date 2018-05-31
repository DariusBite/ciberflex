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

public class MantenimientoCategorias extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoCategorias frame = new MantenimientoCategorias();
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
	public MantenimientoCategorias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientoDeCategorias = new JLabel("MANTENIMIENTO DE CATEGORIAS");
		lblMantenimientoDeCategorias.setBounds(123, 11, 175, 14);
		contentPane.add(lblMantenimientoDeCategorias);
		
		JLabel lblCodigoCategoria = new JLabel("Codigo de Categoria:");
		lblCodigoCategoria.setBounds(22, 53, 112, 14);
		contentPane.add(lblCodigoCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(155, 50, 112, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(22, 88, 46, 14);
		contentPane.add(lblTitulo);
		
		textField = new JTextField();
		textField.setBounds(155, 85, 112, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(22, 128, 63, 14);
		contentPane.add(lblDescripcion);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(155, 128, 256, 107);
		contentPane.add(textArea);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(322, 49, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(322, 84, 89, 23);
		contentPane.add(btnSalir);
	}
}
