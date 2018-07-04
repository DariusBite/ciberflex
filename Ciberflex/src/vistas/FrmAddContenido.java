package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCategoria;
import mantenimientos.GestionContenido;
import mantenimientos.GestionContenidoCategoria;
import mantenimientos.GestionVideo;
import modelado.Categoria;
import modelado.Contenido;
import modelado.ContenidoCategoria;
import modelado.Plan;
import modelado.Video;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class FrmAddContenido extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	public static JTable tblVideos;
	private JScrollPane scrollPane;
	public static JComboBox cboTipo;
	public static DefaultTableModel modelo;
	private JTextArea txtDescripcion;
	private JComboBox cboCategoria;
	private JTextField txtImagen;
	private JTable tblCategorias;
	private DefaultTableModel modeloCat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddContenido frame = new FrmAddContenido();
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
	public FrmAddContenido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientoDeContenido = new JLabel("A\u00D1ADIR CONTENIDO");
		lblMantenimientoDeContenido.setBounds(10, 11, 764, 14);
		lblMantenimientoDeContenido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMantenimientoDeContenido.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMantenimientoDeContenido);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 53, 61, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(81, 50, 131, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblTipoDeContenido = new JLabel("Tipo de Contenido:");
		lblTipoDeContenido.setBounds(262, 53, 116, 14);
		contentPane.add(lblTipoDeContenido);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 103, 72, 14);
		contentPane.add(lblDescripcion);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setBounds(10, 128, 504, 160);
		contentPane.add(txtDescripcion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setBounds(586, 7, 89, 23);
		contentPane.add(btnGuardar);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(383, 50, 131, 20);
		contentPane.add(cboTipo);
		cboTipo.addItem("Pelicula");
		cboTipo.addItem("Serie");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 330, 663, 280);
		contentPane.add(scrollPane);
		
		tblVideos = new JTable();
		tblVideos.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tblVideos);
		modelo = (DefaultTableModel)tblVideos.getModel();
		modelo.addColumn("Titulo");
		modelo.addColumn("Temporada");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Url");
		modelo.addColumn("Imagen");
		
		JLabel lblVideos = new JLabel("Videos");
		lblVideos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVideos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVideos.setBounds(10, 299, 764, 14);
		contentPane.add(lblVideos);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openVideo();
			}
		});
		btnAadir.setBounds(685, 327, 89, 23);
		contentPane.add(btnAadir);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarVideo();
			}
		});
		btnEliminar.setBounds(685, 361, 89, 23);
		contentPane.add(btnEliminar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 305, 350, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(424, 305, 350, 2);
		contentPane.add(separator_1);
		
		JLabel label = new JLabel("Categorias");
		label.setBounds(537, 53, 116, 14);
		contentPane.add(label);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(643, 50, 131, 20);
		contentPane.add(cboCategoria);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(10, 78, 46, 14);
		contentPane.add(lblImagen);
		
		txtImagen = new JTextField();
		txtImagen.setBounds(81, 78, 131, 20);
		contentPane.add(txtImagen);
		txtImagen.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(525, 53, 2, 237);
		contentPane.add(separator_2);
		
		JButton btnAnadirCat = new JButton("A\u00F1adir");
		btnAnadirCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCategory();
			}
		});
		btnAnadirCat.setBounds(537, 74, 95, 23);
		contentPane.add(btnAnadirCat);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(537, 103, 237, 185);
		contentPane.add(scrollPane_1);
		
		tblCategorias = new JTable();
		scrollPane_1.setViewportView(tblCategorias);
		modeloCat = (DefaultTableModel)tblCategorias.getModel();
		modeloCat.addColumn("Categoria");
		
		JButton btnEliminarCat = new JButton("Eliminar");
		btnEliminarCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCat();
			}
		});
		btnEliminarCat.setBounds(679, 74, 95, 23);
		contentPane.add(btnEliminarCat);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeWindow();
			}
		});
		btnCancelar.setBounds(685, 7, 89, 23);
		contentPane.add(btnCancelar);
		
		setCategorias();
	}
	
	void openVideo(){
		cboTipo.setEditable(false);
		cboTipo.setEnabled(false);
		FrmAddVideo v = new FrmAddVideo();
		v.setVisible(true);
	}
	
	public static void actualizarListaVideos(Object[] fila){
		modelo.addRow(fila);
	}
	
	void eliminarVideo(){
		if(leerVideos().isEmpty()){
			cboTipo.setEditable(true);
			cboTipo.setEnabled(true);
		}
		else {
			modelo.removeRow(tblVideos.getSelectedRow());
		}
	}
	
	String leerTipo(){
		return String.valueOf(cboTipo.getSelectedItem());
	}
	
	void guardar(){
		String titulo, tipo, descripcion, imagen, mensaje = "Los siguientes campos contienen errores";
		ArrayList<String[]> videos;
		ArrayList<String> categorias;
		int errors = 0;
		GestionContenido gc = new GestionContenido();
		GestionCategoria gcat = new GestionCategoria();
		GestionContenidoCategoria gcc = new GestionContenidoCategoria();
		GestionVideo gv = new GestionVideo();
		
		titulo = leerTitulo();
		categorias = leerTblCategorias();
		descripcion = leerDescripcion();
		videos = leerVideos();
		imagen = leerImagen();
		tipo = leerTipo();
		
		if(!titulo.matches(".{1,80}")){
			mensaje = mensaje + "\n- Titulo";
			errors++;	
		};
		if(!descripcion.matches(".{1,80}")){
			mensaje = mensaje + "\n- Descripcion";
			errors++;	
		};
		if(!imagen.matches(".{1,260}")){
			mensaje = mensaje + "\n- Imagen";
			errors++;
		};
		if(videos.isEmpty()){
			mensaje = mensaje + "\n- Añadir video(s)";
			errors++;
		};
		if(categorias.isEmpty()){
			mensaje = mensaje + "\n- Añadir categoria(s)";
			errors++;
		}
		
		if(errors == 0){
			int er2 = 0;
			Contenido c = new Contenido();
			c.setTitulo_contenido(titulo);
			c.setDescripcion_contenido(descripcion);
			c.setTipo_contenido(tipo);
			c.setUrl_image_contenido(imagen);
			gc.registrarContenido(c);
			
			for(String[] s: videos){
				Video v = new Video();
				v.setId_contenido(gc.ultimoIdContenido());
				v.setTitulo_video(s[0]);
				v.setTemporada_video(Integer.parseInt(s[1]));
				v.setDescripcion_video(s[2]);
				v.setUrl_video(s[3]);
				v.setUrl_imagen_video(s[4]);
				gv.registrarVideo(v);
			}
			
			for(String s: categorias){
				ContenidoCategoria cc = new ContenidoCategoria();
				cc.setId_contenido(gc.ultimoIdContenido());
				cc.setId_categoria(gcat.obtenerCategoriaXTitulo(s).getId_categoria());
				gcc.registarContenidoCategoria(cc);
			}
			mensaje("Registro exitoso");
			FrmPanelAdministrador fpa = new FrmPanelAdministrador();
			fpa.setVisible(true);
			dispose();

		}
		else{
			mensaje(mensaje);
		}
		
	}
	
	void setCategorias(){
		GestionCategoria gc = new GestionCategoria();
		ArrayList<Categoria> lista = gc.listarCategorias();
		
		if(!lista.isEmpty()){
			for(Categoria c : lista){
				cboCategoria.addItem(c.getTitulo_categoria());
			}
		}
	}
	
	void addCategory(){
		String cat = leerCategoria();
		ArrayList<String> catss = leerTblCategorias();
		int ex = 0;
		for(String c : catss){
			if(cat.equals(c)) ex++;
		};
		if(ex == 0){
			Object[] fila = {cat};
			modeloCat.addRow(fila);
		};
	}
	
	void eliminarCat(){
		if(!leerTblCategorias().isEmpty()) modeloCat.removeRow(tblCategorias.getSelectedRow());
	}
	
	String leerTitulo(){
		return txtTitulo.getText();
	}
	
	String leerDescripcion(){
		return txtDescripcion.getText();
	}
	
	String leerCategoria(){
		return String.valueOf(cboCategoria.getSelectedItem());
	}
	
	String leerImagen(){
		return txtImagen.getText();
	}
	
	ArrayList<String[]> leerVideos(){
		ArrayList<String[]> lista = new ArrayList<String[]>();
		int rows = tblVideos.getRowCount();
		for(int i = 0; i<rows; i++){
			String temp;
			try {
				temp = tblVideos.getValueAt(i, 1).toString();
			} catch (Exception e) {
				temp = "0";
			}
			String[] s =  {
					tblVideos.getValueAt(i, 0).toString(),
					temp,
					tblVideos.getValueAt(i, 2).toString(),
					tblVideos.getValueAt(i, 3).toString(),
					tblVideos.getValueAt(i, 4).toString()
				};
			lista.add(s);
		}
		return lista;
	}
	
	ArrayList<String> leerTblCategorias(){
		ArrayList<String> lista = new ArrayList<String>();
		int rows = tblCategorias.getRowCount();
		for(int i = 0; i<rows; i++){
			String s =  tblCategorias.getValueAt(i, 0).toString();
			lista.add(s);
		}
		return lista;
	}
	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
	void closeWindow(){
		FrmPanelAdministrador fpa = new FrmPanelAdministrador();
		fpa.setVisible(true);
		dispose();
	}
}
