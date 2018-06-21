package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import mantenimientos.GestionCategoria;
import modelado.Categoria;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmListaCategorias extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListaCategorias frame = new FrmListaCategorias();
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
	public FrmListaCategorias() {
		setTitle("Listado de Categorias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(modelo);
		modelo.addColumn("ID Categoria");
		modelo.addColumn("Titulo Categoria");
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
	    columnModel.getColumn(1).setPreferredWidth(300);
		scrollPane.setViewportView(table);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviardatosCategoria();
			}
		});
		btnSeleccionar.setBounds(167, 261, 89, 23);
		contentPane.add(btnSeleccionar);
		mostrarCategorias();
	}
	void mostrarCategorias(){
		GestionCategoria gt=new GestionCategoria();
		ArrayList<Categoria> lista=gt.listarCategorias();
		if(lista == null){
			JOptionPane.showMessageDialog(null,"Lista Vacía");
		}
		else{
			for (Categoria c : lista){
				Object[] fila={
					c.getId_categoria(),
					c.getTitulo_categoria()
				};
				modelo.addRow(fila);			
			}
		}
	}
	void enviardatosCategoria(){
		int fila = table.getSelectedRow();
		ReporteCategoriasMasVistas.txtCategoria.setText(table.getValueAt(fila, 0).toString());
		ReporteCategoriasMasVistas.txtTitulo.setText(table.getValueAt(fila, 1).toString());
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
