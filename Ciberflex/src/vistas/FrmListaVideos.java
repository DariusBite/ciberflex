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

public class FrmListaVideos extends JFrame implements ActionListener {

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
					FrmListaVideos frame = new FrmListaVideos();
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
	public FrmListaVideos() {
		setTitle("Listado De Videos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 463);
		contentPane = new JPanel();
		contentPane.setToolTipText("Buscar");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 358);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(modelo);
		modelo.addColumn("ID Video");
		modelo.addColumn("Titulo Video");
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
	    columnModel.getColumn(1).setPreferredWidth(300);
	    scrollPane.setViewportView(table);
	    
	    btnSeleccionar = new JButton("SELECCIONAR");
	    btnSeleccionar.addActionListener(this);
	    btnSeleccionar.setBounds(150, 390, 115, 23);
	    contentPane.add(btnSeleccionar);
		mostrarVideos();		
	}

	void mostrarVideos() {
		GestionVideo gv = new GestionVideo(); 
		ArrayList<Video> lista = gv.listar();
		if(lista == null){
			JOptionPane.showMessageDialog(null,"Lista Vac�a");
		}
		else{
			for(Video v : lista){
				Object[] fila={
						v.getId_video(),
						v.getTitulo_video()
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
		enviardatosvideo();
	}
	
	void enviardatosvideo(){
		int fila = table.getSelectedRow();
		ReporteVideosMasVistos.txtVideo.setText(table.getValueAt(fila, 0).toString());
		ReporteVideosMasVistos.txtTitulo.setText(table.getValueAt(fila, 1).toString());
		dispose();
	}
}