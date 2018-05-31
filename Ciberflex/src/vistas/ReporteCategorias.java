package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ReporteCategorias extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTextField txtTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteCategorias frame = new ReporteCategorias();
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
	public ReporteCategorias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReporteDeCategorias = new JLabel("REPORTE DE CATEGORIAS");
		lblReporteDeCategorias.setBounds(146, 11, 136, 14);
		contentPane.add(lblReporteDeCategorias);
		
		JLabel lblCodigoCategoria = new JLabel("Codigo Categoria:");
		lblCodigoCategoria.setBounds(10, 54, 102, 14);
		contentPane.add(lblCodigoCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(122, 51, 94, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(226, 50, 65, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 89, 56, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(122, 86, 94, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 128, 71, 14);
		contentPane.add(lblDescripcion);
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(122, 123, 211, 128);
		contentPane.add(textAreaDescripcion);
		
		JButton btnReportar = new JButton("Reportar");
		btnReportar.setBounds(335, 66, 89, 23);
		contentPane.add(btnReportar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(335, 100, 89, 23);
		contentPane.add(btnSalir);
	}
}
