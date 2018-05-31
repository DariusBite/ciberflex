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

public class MantenimientoContenido extends JFrame {

	private JPanel contentPane;
	private JTextField txtContenido;
	private JTextField txtTitulo;
	private JTextField txtTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoContenido frame = new MantenimientoContenido();
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
	public MantenimientoContenido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientoDeContenido = new JLabel("MANTENIMIENTO DE CONTENIDO");
		lblMantenimientoDeContenido.setBounds(125, 11, 170, 14);
		contentPane.add(lblMantenimientoDeContenido);
		
		JLabel lblCodigoContenido = new JLabel("Codigo Contenido:");
		lblCodigoContenido.setBounds(23, 51, 116, 14);
		contentPane.add(lblCodigoContenido);
		
		txtContenido = new JTextField();
		txtContenido.setBounds(149, 48, 103, 20);
		contentPane.add(txtContenido);
		txtContenido.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(23, 87, 61, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(149, 84, 103, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblTipoDeContenido = new JLabel("Tipo de Contenido:");
		lblTipoDeContenido.setBounds(23, 128, 116, 14);
		contentPane.add(lblTipoDeContenido);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(149, 125, 103, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(23, 164, 72, 14);
		contentPane.add(lblDescripcion);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(149, 159, 248, 92);
		contentPane.add(textArea);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(309, 47, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(309, 83, 89, 23);
		contentPane.add(btnSalir);
	}

}
