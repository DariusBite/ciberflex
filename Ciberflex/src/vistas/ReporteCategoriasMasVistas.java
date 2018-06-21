package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteCategoriasMasVistas extends JFrame {

	private JPanel contentPane;
	public static JTextField txtCategoria;
	public static JTextField txtTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteCategoriasMasVistas frame = new ReporteCategoriasMasVistas();
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
	public ReporteCategoriasMasVistas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategoriaMasVistas = new JLabel("CATEGORIA MAS VISTAS");
		lblCategoriaMasVistas.setBounds(150, 23, 129, 14);
		contentPane.add(lblCategoriaMasVistas);
		
		JLabel lblCodigoCategoria = new JLabel("Codigo Categoria:");
		lblCodigoCategoria.setBounds(10, 63, 109, 14);
		contentPane.add(lblCodigoCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(129, 60, 100, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCategorias();
			}
		});
		btnBuscar.setBounds(239, 59, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 115, 61, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(129, 112, 100, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JButton btnReportar = new JButton("Reportar");
		btnReportar.setBounds(361, 59, 89, 23);
		contentPane.add(btnReportar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(361, 111, 89, 23);
		contentPane.add(btnSalir);
	}
	void mostrarCategorias(){
		FrmListaCategorias cat=new FrmListaCategorias();
		cat.setVisible(true);
		
		
	}

}
