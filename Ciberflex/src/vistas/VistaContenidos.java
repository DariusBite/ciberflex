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
import javax.swing.JScrollBar;
import javax.naming.directory.SearchResult;
import javax.naming.directory.Attributes;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VistaContenidos extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblBienvenido;
	private JLabel lblNomUsuario;
	private JLabel labelNomUsuario;
	private JTextField textABuscar;
	private JButton btnBuscar;
	private JScrollBar scrollBar;
	private JLabel lblCerrarSesin;
	private JComboBox cboSeleccionar;
	private JLabel lblSeleccione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaContenidos frame = new VistaContenidos();
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
	public VistaContenidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 463);
		contentPane = new JPanel();
		contentPane.setToolTipText("Buscar");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Lista de Pel\u00EDculas y Series");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setBounds(207, 11, 186, 19);
		contentPane.add(lblTitulo);
		
		lblBienvenido = new JLabel("Bienvenido:");
		lblBienvenido.setBounds(29, 54, 72, 14);
		contentPane.add(lblBienvenido);
		
		lblNomUsuario = new JLabel("Usuario");
		lblNomUsuario.setBounds(121, 54, 46, 14);
		contentPane.add(lblNomUsuario);
		
		labelNomUsuario = new JLabel("Usuario");
		labelNomUsuario.setBounds(529, 54, 46, 14);
		contentPane.add(labelNomUsuario);
		
		textABuscar = new JTextField();
		textABuscar.setToolTipText("Buscar");
		textABuscar.setBounds(199, 52, 121, 17);
		contentPane.add(textABuscar);
		textABuscar.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.setBounds(319, 50, 20, 18);
		contentPane.add(btnBuscar);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(568, 120, 17, 293);
		contentPane.add(scrollBar);
		
		lblCerrarSesin = new JLabel("Cerrar Sesi\u00F3n");
		lblCerrarSesin.setBounds(503, 79, 72, 14);
		contentPane.add(lblCerrarSesin);
		
		cboSeleccionar = new JComboBox();
		cboSeleccionar.setModel(new DefaultComboBoxModel(new String[] {"---- SERIES  ---------", "---- FAVORITOS  ----", "---- RECIENTES  ----"}));
		cboSeleccionar.setToolTipText("");
		cboSeleccionar.setBounds(121, 100, 136, 20);
		contentPane.add(cboSeleccionar);
		
		lblSeleccione = new JLabel("Seleccione :");
		lblSeleccione.setBounds(29, 103, 72, 14);
		contentPane.add(lblSeleccione);
	}
}
