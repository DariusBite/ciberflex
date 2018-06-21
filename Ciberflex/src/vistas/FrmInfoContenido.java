package vistas;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionCategoria;
import mantenimientos.GestionContenido;
import mantenimientos.GestionVideo;
import modelado.Categoria;
import modelado.Contenido;
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
		setBounds(100, 100, 460, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(10, 11, 464, 34);
		contentPane.add(lblTitulo);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(10, 46, 464, 58);
		contentPane.add(lblDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 424, 137);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		lblCatgorias = new JLabel("Catgorias");
		lblCatgorias.setForeground(Color.WHITE);
		lblCatgorias.setBounds(10, 115, 424, 14);
		contentPane.add(lblCatgorias);
		
		loadData();
	}
	
	void loadData(){
		String categor = "Categorias: ";
		GestionContenido gc = new GestionContenido();
		GestionCategoria gcat = new GestionCategoria();
		GestionVideo gv = new GestionVideo();
		Contenido c = gc.obtenerContenido(id);
		ArrayList<Categoria> listaCat = gcat.listarCategoriasenContenido(id);
		ArrayList<Video> listaVideo = gv.listarVideosencontenido(id);
		lblTitulo.setText(c.getTitulo_contenido());
		lblDescripcion.setText(c.getDescripcion_contenido());
		int x = 10, w = 170;
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
					openVideo(v.getUrl_video());
				}
			});
			btnContenido.setBounds(x, 10, 150, 100);
			panel.add(btnContenido);
			x = x + 160;
		}
		panel.setPreferredSize(new Dimension(w, 100));
	}
	
	void openVideo(String url){
		FrmReproductor pv = new FrmReproductor(url);
		pv.setVisible(true);
	}
}
