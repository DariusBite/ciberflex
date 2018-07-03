package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionContenido;
import modelado.Contenido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class FrmBuscarContenido extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTable table;
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Contenido> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBuscarContenido frame = new FrmBuscarContenido();
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
	public FrmBuscarContenido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				buscar();
			}
		});
		btnBuscar.setBounds(586, 40, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
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
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ver();
			}
		});
		btnVer.setBounds(349, 349, 89, 23);
		contentPane.add(btnVer);
	}
	
	void buscar(){
		String titulo;
		titulo = leerTitulo();
		if(titulo.matches(".{1,80}")){
			GestionContenido gc = new GestionContenido();
			lista = gc.buscarContenido(titulo);
			if(!lista.isEmpty()){
				int rowCount = modelo.getRowCount();
				//Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					modelo.removeRow(i);
				}
				for(Contenido c:lista){
					Object[] fila = {c.getTitulo_contenido(), c.getDescripcion_contenido()};
					modelo.addRow(fila);
				}
			}
			else mensaje("No se encontro ningun resultado");
		}
		else mensaje("Ingresa un titulo valido");
	}
	
	void ver(){
		int i = table.getSelectedRow();
		int id = lista.get(i).getId_contenido();
		FrmInfoContenido ic = new FrmInfoContenido(id);
		ic.setVisible(true);
		dispose();
	}
	
	void salir(){
		FrmListaContenido flc = new FrmListaContenido();
		flc.setVisible(true);
		dispose();
	}
	
	String leerTitulo(){
		return txtTitulo.getText();
	}
	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
}
