package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdministrador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdministrador frame = new PanelAdministrador();
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
	public PanelAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPanelDeAdministrador = new JLabel("PANEL DE ADMINISTRADOR");
		lblPanelDeAdministrador.setBounds(138, 11, 141, 14);
		contentPane.add(lblPanelDeAdministrador);
		
		JLabel lblBienvenido = new JLabel("Bienvenido Administrador :");
		lblBienvenido.setBounds(10, 40, 133, 14);
		contentPane.add(lblBienvenido);
		
		txtAdministrador = new JTextField();
		txtAdministrador.setBounds(158, 37, 121, 20);
		contentPane.add(txtAdministrador);
		txtAdministrador.setColumns(10);
		
		JButton btnMantenimientoDeUsuarios = new JButton("Mantenimiento de Usuarios");
		btnMantenimientoDeUsuarios.setBounds(10, 79, 177, 23);
		contentPane.add(btnMantenimientoDeUsuarios);
		
		JButton btnMantenimientoDeCategorias = new JButton("Mantenimiento de Categorias");
		btnMantenimientoDeCategorias.setBounds(10, 119, 177, 23);
		contentPane.add(btnMantenimientoDeCategorias);
		
		JButton btnMantenimientoDeContenidos = new JButton("Mantenimiento de Contenidos");
		btnMantenimientoDeContenidos.setBounds(10, 160, 177, 23);
		contentPane.add(btnMantenimientoDeContenidos);
		
		JButton btnReportes = new JButton("Reportes");
		btnReportes.setBounds(335, 79, 89, 23);
		contentPane.add(btnReportes);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(335, 119, 89, 23);
		contentPane.add(btnSalir);
	}
}
