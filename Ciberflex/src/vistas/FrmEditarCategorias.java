package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCategoria;
import modelado.Categoria;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmEditarCategorias extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Categoria> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEditarCategorias frame = new FrmEditarCategorias();
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
	public FrmEditarCategorias() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActualizarCategorias = new JLabel("ACTUALIZAR CATEGORIAS");
		lblActualizarCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarCategorias.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblActualizarCategorias.setBounds(10, 11, 414, 20);
		contentPane.add(lblActualizarCategorias);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar();
			}
		});
		btnActualizar.setBounds(10, 227, 107, 23);
		contentPane.add(btnActualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 414, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalir);
		modelo.addColumn("Titulo");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Estado");
		
		listar();
	}
	
	void listar(){
		GestionCategoria gc = new GestionCategoria();
		lista = gc.listarCategorias();
		for(Categoria c:lista){
			String e;
			if(c.getEstado() == 0) e="Inactivo";
			else e="Activo";
			Object[] fila = {c.getTitulo_categoria(), c.getDescripcion_categoria(), e};
			modelo.addRow(fila);
		}
	}
	
	void actualizar(){
		try {
			int id = lista.get(table.getSelectedRow()).getId_categoria();
			FrmEditarCategoria ec = new FrmEditarCategoria(id);
			ec.setVisible(true);
			dispose();
		} catch (Exception e) {
			// TODO: handle exception
		}
	};
	
	void salir(){
		FrmPanelAdministrador pa = new FrmPanelAdministrador();
		pa.setVisible(true);
		dispose();
	}
}
