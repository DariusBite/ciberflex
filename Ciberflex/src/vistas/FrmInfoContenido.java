package vistas;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionCategoria;
import mantenimientos.GestionContenido;
import mantenimientos.GestionUsuariosContenidos;
import mantenimientos.GestionUsuariosVideos;
import mantenimientos.GestionVideo;
import modelado.Categoria;
import modelado.Contenido;
import modelado.UserSession;
import modelado.UsuariosContenidos;
import modelado.UsuariosVideos;
import modelado.Video;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JComboBox;

public class FrmInfoContenido extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel;
	private int id;
	private JLabel lblTitulo;
	private JLabel lblDescripcion;
	private JScrollPane scrollPane;
	private JLabel lblCatgorias;
	private JComboBox cboPuntuacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInfoContenido frame = new FrmInfoContenido(1);
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
	public FrmInfoContenido(int id) {
		setBackground(Color.BLACK);
		this.id = id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(10, 11, 386, 34);
		contentPane.add(lblTitulo);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(10, 46, 424, 58);
		contentPane.add(lblDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(482, 11, 192, 272);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		lblCatgorias = new JLabel("Catgorias");
		lblCatgorias.setForeground(Color.WHITE);
		lblCatgorias.setBounds(10, 115, 424, 14);
		contentPane.add(lblCatgorias);
		
		cboPuntuacion = new JComboBox();
		cboPuntuacion.setBounds(10, 157, 36, 20);
		contentPane.add(cboPuntuacion);
		cboPuntuacion.addItem(' ');
		cboPuntuacion.addItem('1');
		cboPuntuacion.addItem('2');
		cboPuntuacion.addItem('3');
		cboPuntuacion.addItem('4');
		cboPuntuacion.addItem('5');
		cboPuntuacion.setSelectedItem('5');
		cboPuntuacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				puntua();
			}
		});
		
		JLabel lblPuntua = new JLabel("Puntua");
		lblPuntua.setForeground(Color.WHITE);
		lblPuntua.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntua.setBounds(10, 140, 46, 14);
		contentPane.add(lblPuntua);
		
		JButton button = new JButton("< Regresar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regresar();
			}
		});
		button.setBounds(10, 260, 110, 23);
		contentPane.add(button);
		
		loadData();
		guardar();
	}
	
	void loadData(){
		String categor = "Categorias: ";
		GestionContenido gc = new GestionContenido();
		GestionCategoria gcat = new GestionCategoria();
		GestionVideo gv = new GestionVideo();
		Contenido c = gc.obtenerContenido(id);
		ArrayList<Categoria> listaCat = gcat.listarCategoriasenContenido(id);
		ArrayList<Video> listaVideo = gv.listarVideosencontenidoactivos(id);
		lblTitulo.setText(c.getTitulo_contenido());
		lblDescripcion.setText(c.getDescripcion_contenido());
		int x = 10;
		for (int i = 0; i < listaCat.size(); i++) {
			if(i == 0)
				categor = categor + listaCat.get(i).getTitulo_categoria();
			else
				categor = categor +", "+ listaCat.get(i).getTitulo_categoria();
		}
		lblCatgorias.setText(categor);
		for(Video v : listaVideo){
			ImageIcon imageIcon = new ImageIcon(v.getUrl_imagen_video()); // load the image to a imageIcon
			Image image = imageIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(150, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			imageIcon = new ImageIcon(newimg);  // transform it back
			JButton btnContenido = new JButton(c.getTitulo_contenido());
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnContenido.setBorder(emptyBorder);
			btnContenido.setIcon(imageIcon);
			btnContenido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					openVideo(v.getUrl_video(), v.getId_contenido());
					guardarVideo(v.getId_video());
				}
			});
			btnContenido.setBounds(10, x, 150, 100);
			panel.add(btnContenido);
			x = x + 110;
		}
		panel.setPreferredSize(new Dimension(170, x));
		GestionUsuariosContenidos guc = new GestionUsuariosContenidos();
		UsuariosContenidos uc = guc.obtener(UserSession.getId(), id);
		if(uc != null){
			cboPuntuacion.setSelectedIndex(uc.getPuntuacion());
		}
	}
	
	void openVideo(String url, int id){
		FrmReproductor pv = new FrmReproductor(url, id);
		pv.setVisible(true);
		dispose();
	}
	
	void puntua(){
		int puntuacion = leerPuntuacion();
		GestionUsuariosContenidos guc = new GestionUsuariosContenidos();
		UsuariosContenidos uc = new UsuariosContenidos();
		uc.setId_contenido(id);
		uc.setId_usuario(UserSession.getId());
		uc.setPuntuacion(puntuacion);
		guc.registrarPuntuacion(uc);	
		
	}
	
	void guardar(){
		UsuariosContenidos uc = null;
		GestionUsuariosContenidos guc = new GestionUsuariosContenidos();
		uc = guc.obtener(UserSession.getId(), id);
		if(uc == null){
			uc = new UsuariosContenidos();
			uc.setId_contenido(id);
			uc.setId_usuario(UserSession.getId());
			guc.registrar(uc);
		}
	}
	
	int leerPuntuacion(){
		return cboPuntuacion.getSelectedIndex();
	}
	
	void guardarVideo(int id_v){
		GestionUsuariosVideos guv = new GestionUsuariosVideos();
		UsuariosVideos uv = null;
		uv = guv.obtener(id_v, UserSession.getId());
		if(uv == null){
			uv = new UsuariosVideos();
			uv.setId_usuario(UserSession.getId());
			uv.setId_video(id_v);
			uv.setVecesvisto(1);
			guv.registrar(uv);
		}
		else{
			int newCant = uv.getVecesvisto() + 1;
			uv.setVecesvisto(newCant);
			guv.registrarVeces(uv);
		}
		
	}
	
	void regresar(){
		FrmListaContenidoCliente lc = new FrmListaContenidoCliente();
		lc.setVisible(true);
		dispose();
	}
}
