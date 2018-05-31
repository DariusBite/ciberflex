package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ReporteFacturacion extends JFrame {

	private JPanel contentPane;
	private JTextField txtFactura;
	private JTextField txtUsuario;
	private JTextField txtPlan;
	private JTextField txtMonto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteFacturacion frame = new ReporteFacturacion();
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
	public ReporteFacturacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReporteDeFacturacion = new JLabel("REPORTE DE FACTURACION");
		lblReporteDeFacturacion.setBounds(143, 11, 146, 14);
		contentPane.add(lblReporteDeFacturacion);
		
		JLabel lblFactura = new JLabel("Factura N\u00BA:");
		lblFactura.setBounds(26, 53, 64, 14);
		contentPane.add(lblFactura);
		
		txtFactura = new JTextField();
		txtFactura.setBounds(137, 50, 93, 20);
		contentPane.add(txtFactura);
		txtFactura.setColumns(10);
		
		JLabel lblCodigoDeUsuario = new JLabel("Codigo de Usuario:");
		lblCodigoDeUsuario.setBounds(26, 92, 99, 14);
		contentPane.add(lblCodigoDeUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(137, 89, 93, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblCodigoDePlan = new JLabel("Codigo de Plan:");
		lblCodigoDePlan.setBounds(26, 132, 83, 14);
		contentPane.add(lblCodigoDePlan);
		
		txtPlan = new JTextField();
		txtPlan.setBounds(137, 129, 93, 20);
		contentPane.add(txtPlan);
		txtPlan.setColumns(10);
		
		JLabel lblMonto = new JLabel("Monto :");
		lblMonto.setBounds(26, 170, 46, 14);
		contentPane.add(lblMonto);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(137, 167, 93, 20);
		contentPane.add(txtMonto);
		txtMonto.setColumns(10);
		
		JButton btnEmitir = new JButton("Emitir");
		btnEmitir.setBounds(323, 49, 89, 23);
		contentPane.add(btnEmitir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(323, 88, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(323, 128, 89, 23);
		contentPane.add(btnSalir);
	}

}
