package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import mantenimientos.GestionContenido;
import mantenimientos.GestionUsuario;
import mantenimientos.GestionVideo;

import modelado.Contenido;
import modelado.Video;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.naming.directory.SearchResult;
import javax.naming.directory.Attributes;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class FrmListarContenidos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel modelo = new DefaultTableModel();
	private JButton btnSeleccionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListarContenidos frame = new FrmListarContenidos();
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
	public FrmListarContenidos() {
		setTitle("Listado De Contenidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 647, 463);
		contentPane = new JPanel();
		contentPane.setToolTipText("Buscar");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 611, 358);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(modelo);
		modelo.addColumn("ID");
		modelo.addColumn("Titulo");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Tipo");
		modelo.addColumn("Imagen");
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
	    columnModel.getColumn(1).setPreferredWidth(300);
	    columnModel.getColumn(2).setPreferredWidth(100);
	    columnModel.getColumn(3).setPreferredWidth(100);
	    columnModel.getColumn(4).setPreferredWidth(100);
	    
	    scrollPane.setViewportView(table);
	    
	    btnSeleccionar = new JButton("SELECCIONAR");
	    btnSeleccionar.addActionListener(this);
	    btnSeleccionar.setBounds(259, 390, 115, 23);
	    contentPane.add(btnSeleccionar);
		mostrarContenidos();		
	}

	void mostrarContenidos() {
		GestionContenido gc = new GestionContenido(); 
		ArrayList<Contenido> lista = gc.listarContenido();
		if(lista == null){
			JOptionPane.showMessageDialog(null,"Lista Vacía");
		}
		else{
			for(Contenido c : lista){
				Object[] fila={
						c.getId_contenido(),
						c.getTitulo_contenido(),
						c.getDescripcion_contenido(),
						c.getTipo_contenido(),
						c.getUrl_image_contenido()
				};
				modelo.addRow(fila);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSeleccionar) {
			actionPerformedBtnSeleccionar(e);
		}
	}
	protected void actionPerformedBtnSeleccionar(ActionEvent e) {
		enviardatoContenido();
	}
	
	void enviardatoContenido(){
		int fila = table.getSelectedRow();
		FrmEditarContenido.txtID.setText(table.getValueAt(fila, 0).toString());
		FrmEditarContenido.txtTitulo.setText(table.getValueAt(fila, 1).toString());
		FrmEditarContenido.txtDescripcion.setText(table.getValueAt(fila, 2).toString());
		FrmEditarContenido.txtImagen.setText(table.getValueAt(fila, 4).toString());
		FrmEditarContenido.cboTipo.setSelectedItem(table.getValueAt(fila, 3).toString());
		dispose();
	}
}
