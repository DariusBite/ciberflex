package vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionVideo;
import modelado.Video;

import javax.swing.JComboBox;

public class FrmEditVideo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtTemporada;
	private JTextField txtUrl;
	private JTextField txtImagen;
	String tipo;
	private JTextArea txtDescripcion;
	int id, id_c;
	private JComboBox cboEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEditVideo frame = new FrmEditVideo(1, 1);
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
	public FrmEditVideo(int id, int id_c) {
		this.id = id;
		this.id_c = id_c;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientosDeVideos = new JLabel("Editar Videos");
		lblMantenimientosDeVideos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientosDeVideos.setBounds(10, 11, 414, 14);
		contentPane.add(lblMantenimientosDeVideos);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 39, 46, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(115, 36, 210, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblTemporada = new JLabel("Temporada");
		lblTemporada.setBounds(10, 64, 67, 14);
		contentPane.add(lblTemporada);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 164, 67, 14);
		contentPane.add(lblDescripcion);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setBounds(115, 164, 309, 101);
		contentPane.add(txtDescripcion);
		
		JLabel lblUrl = new JLabel("URL del Video");
		lblUrl.setBounds(10, 89, 78, 14);
		contentPane.add(lblUrl);
		
		JLabel lblImagen = new JLabel("URL Imagen");
		lblImagen.setBounds(10, 114, 121, 14);
		contentPane.add(lblImagen);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setBounds(335, 36, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(335, 135, 89, 23);
		contentPane.add(btnSalir);
		
		txtTemporada = new JTextField();
		txtTemporada.setEnabled(false);
		txtTemporada.setEditable(false);
		txtTemporada.setBounds(115, 61, 210, 20);
		contentPane.add(txtTemporada);
		txtTemporada.setColumns(10);
		
		txtUrl = new JTextField();
		txtUrl.setBounds(115, 86, 210, 20);
		contentPane.add(txtUrl);
		txtUrl.setColumns(10);
		
		txtImagen = new JTextField();
		txtImagen.setBounds(115, 111, 210, 20);
		contentPane.add(txtImagen);
		txtImagen.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 139, 46, 14);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(115, 136, 210, 20);
		cboEstado.addItem("Inactivo");
		cboEstado.addItem("Activo");
		contentPane.add(cboEstado);
		
		peliculaovideo();
		setData();
	}
	
	void peliculaovideo(){
		tipo = String.valueOf(FrmEditarContenido.cboTipo.getSelectedItem());
		if(tipo.equals("Pelicula")){
			txtTemporada.setEnabled(false);
			txtTemporada.setEditable(false);
		}
		else{
			txtTemporada.setEnabled(true);
			txtTemporada.setEditable(true);
		}
	}
	
	void setData(){
		GestionVideo gv = new GestionVideo();
		Video v = gv.obtener(id);
		txtTitulo.setText(v.getTitulo_video());
		if(v.getTemporada_video() != 0){
			txtTemporada.setText(v.getTemporada_video()+"");
		}
		txtUrl.setText(v.getUrl_video());
		txtImagen.setText(v.getUrl_imagen_video());
		txtDescripcion.setText(v.getDescripcion_video());
		cboEstado.setSelectedIndex(v.getEstado());
		
	};
	
	void guardar(){
		String titulo, temporada, url, imagen, descripcion, mensaje = "Los siguientes campos contienen errores";
		int errors = 0, estado;
		
		titulo = leerTitulo();
		temporada = leerTemporada();
		url = leerUrl();
		imagen = leerImagen();
		descripcion = leerDescripcion();
		estado = leerEstado();
		
		if(!titulo.matches(".{1,80}")){
			mensaje = mensaje + "\n- Titulo";
			errors++;	
		}
		if(tipo.equals("Serie")){
			try {
				int t = Integer.parseInt(temporada);
			} catch (Exception e) {
				mensaje = mensaje + "\n- Temporada no es un numero";
				errors++;	
			}
		}
		else temporada = null;
		if(!url.matches(".{1,300}")){
			mensaje = mensaje + "\n- Url";
			errors++;	
		}
		if(!imagen.matches(".{1,300}")){
			mensaje = mensaje + "\n- Imagen";
			errors++;	
		}
		if(!descripcion.matches(".{1,260}")){
			mensaje = mensaje + "\n- Descripcion";
			errors++;	
		}
		
		if(errors == 0){
			Video v = new Video();
			v.setId_video(id);
			v.setTitulo_video(titulo);
			if(temporada != null)v.setTemporada_video(Integer.parseInt(temporada));			
			v.setDescripcion_video(descripcion);
			v.setUrl_video(url);
			v.setUrl_imagen_video(imagen);
			v.setEstado(estado);
			GestionVideo gv = new GestionVideo();
			int rs = gv.editar(v);
			if(rs == 0){
				mensaje("error al aztualizar");
			}
			else {
				FrmEditarContenido.listarVideos(id_c);
				dispose();
			}
		}
		else mensaje(mensaje);
	}
	
	String leerTitulo(){
		return txtTitulo.getText();
	}
	
	String leerTemporada(){
		return txtTemporada.getText();
	}
	
	String leerUrl(){
		return txtUrl.getText();
	}
	
	String leerImagen(){
		return txtImagen.getText();
	}
	
	String leerDescripcion(){
		return txtDescripcion.getText();
	}
	int leerEstado(){
		return cboEstado.getSelectedIndex();
	}

	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}

}
