package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class BuscarContenido extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTable table;
	DefaultTableModel modelo = new DefaultTableModel();

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
		setBounds(100, 100, 800, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarContenido = new JLabel("BUSCAR CONTENIDO");
		lblBuscarContenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarContenido.setBounds(10, 11, 764, 14);
		contentPane.add(lblBuscarContenido);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 44, 54, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(74, 41, 177, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(586, 40, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(685, 40, 89, 23);
		contentPane.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 764, 269);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		modelo.addColumn("Titulo");
		modelo.addColumn("Descripcion");
		
		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(349, 349, 89, 23);
		contentPane.add(btnVer);
	}
}
