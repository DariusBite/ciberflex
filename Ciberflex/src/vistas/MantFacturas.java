package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class MantFacturas extends JFrame {

	private JPanel contentPane;
	private JLabel lblMantenimientoDeFacturas;
	private JLabel lblIngreseNmeroDe;
	private JTextField txtNumFac;
	private JButton btnBuscar;
	private JButton btnGrabar;
	private JButton btnSalir;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblPlan;
	private JLabel lblMonto;
	private JTextField txtMonto;
	private JComboBox cboPlanes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantFacturas frame = new MantFacturas();
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
	public MantFacturas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMantenimientoDeFacturas = new JLabel("Mantenimiento de Facturas");
		lblMantenimientoDeFacturas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMantenimientoDeFacturas.setBounds(139, 11, 197, 22);
		contentPane.add(lblMantenimientoDeFacturas);
		
		lblIngreseNmeroDe = new JLabel("Ingrese N\u00FAmero de Factura");
		lblIngreseNmeroDe.setBounds(22, 58, 162, 14);
		contentPane.add(lblIngreseNmeroDe);
		
		txtNumFac = new JTextField();
		txtNumFac.setBounds(22, 79, 138, 20);
		contentPane.add(txtNumFac);
		txtNumFac.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(172, 78, 89, 23);
		contentPane.add(btnBuscar);
		
		btnGrabar = new JButton("GRABAR");
		btnGrabar.setBounds(367, 54, 89, 23);
		contentPane.add(btnGrabar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(367, 101, 89, 23);
		contentPane.add(btnSalir);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(22, 144, 46, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(78, 141, 117, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblPlan = new JLabel("Plan");
		lblPlan.setBounds(22, 185, 46, 14);
		contentPane.add(lblPlan);
		
		lblMonto = new JLabel("Monto");
		lblMonto.setBounds(22, 233, 46, 14);
		contentPane.add(lblMonto);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(78, 230, 86, 20);
		contentPane.add(txtMonto);
		txtMonto.setColumns(10);
		
		cboPlanes = new JComboBox();
		cboPlanes.setBounds(78, 182, 117, 20);
		contentPane.add(cboPlanes);
	}
}
