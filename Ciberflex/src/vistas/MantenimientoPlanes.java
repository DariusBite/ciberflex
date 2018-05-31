package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MantenimientoPlanes extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombrePlan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoPlanes frame = new MantenimientoPlanes();
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
	public MantenimientoPlanes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientoDePlanes = new JLabel("MANTENIMIENTO DE PLANES");
		lblMantenimientoDePlanes.setBounds(139, 11, 149, 14);
		contentPane.add(lblMantenimientoDePlanes);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(22, 46, 40, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(130, 43, 97, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre de Plan:");
		lblNombre.setBounds(22, 84, 82, 14);
		contentPane.add(lblNombre);
		
		txtNombrePlan = new JTextField();
		txtNombrePlan.setBounds(130, 81, 97, 20);
		contentPane.add(txtNombrePlan);
		txtNombrePlan.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(22, 119, 49, 14);
		contentPane.add(lblPrecio);
		
		JComboBox cboPrecio = new JComboBox();
		cboPrecio.setBounds(130, 116, 97, 20);
		contentPane.add(cboPrecio);
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(128, 155, 282, 96);
		contentPane.add(textAreaDescripcion);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(22, 160, 59, 14);
		contentPane.add(lblDescripcion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(321, 42, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(321, 80, 89, 23);
		contentPane.add(btnSalir);
	}
}
