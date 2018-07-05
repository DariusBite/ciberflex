package vistas;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionContenido;
import modelado.Contenido;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FrmListaContenidoCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JMenuItem mntmSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListaContenidoCliente frame = new FrmListaContenidoCliente();
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
	public FrmListaContenidoCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 463);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setToolTipText("Buscar");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 120, 21);
		contentPane.add(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		mnUsuario.setForeground(Color.WHITE);
		menuBar.add(mnUsuario);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.setForeground(Color.WHITE);
		mntmPerfil.setBackground(Color.BLACK);
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openEditarPefil();
			}
		});
		mnUsuario.add(mntmPerfil);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setForeground(Color.WHITE);
		mntmSalir.setBackground(Color.BLACK);
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		mnUsuario.add(mntmSalir);
		
		JMenu mnContenido = new JMenu("Contenido");
		mnContenido.setBackground(Color.BLACK);
		mnContenido.setForeground(Color.WHITE);
		menuBar.add(mnContenido);
		
		JMenuItem mntmBuscarTitulos = new JMenuItem("Buscar titulos");
		mntmBuscarTitulos.setForeground(Color.WHITE);
		mntmBuscarTitulos.setBackground(Color.BLACK);
		mntmBuscarTitulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirbuscar();
			}
		});
		mnContenido.add(mntmBuscarTitulos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 19, 585, 405);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		loadContendio();
	}
	
	void openEditarPefil(){
		FrmEditarPerfil v = new FrmEditarPerfil();
		v.setVisible(true);
	}
	
	void loadContendio(){
		GestionContenido gc = new GestionContenido();
		ArrayList<Contenido> lista = gc.listarContenidoActivo();
		int x= 10, y= 10, l=210, i=0;
		
		for(Contenido c : lista){
			i++;
			ImageIcon imageIcon = new ImageIcon(c.getUrl_image_contenido()); // load the image to a imageIcon
			Image image = imageIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(150, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			imageIcon = new ImageIcon(newimg);  // transform it back
			JButton btnContenido = new JButton(c.getTitulo_contenido());
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnContenido.setIcon(imageIcon);
			btnContenido.setBorder(emptyBorder);
			btnContenido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					openInfoContenido(c.getId_contenido());
				}
			});
			if(i == 4){
				x = 10;
				y = y+210;
				l = l+210;
				i = 0;
			}
			btnContenido.setBounds(x, y, 150, 200);
			panel.add(btnContenido);
			x = x + 160;
		}
		panel.setPreferredSize(new Dimension(567, l));
		
	}
	
	void openInfoContenido(int id){
		FrmInfoContenido ic = new FrmInfoContenido(id);
		ic.setVisible(true);
		dispose();
	}
	
	void salir(){
		FrmLogin l = new FrmLogin();
		l.setVisible(true);
		dispose();
	}
	
	void abrirbuscar(){
		FrmBuscarContenido bc = new FrmBuscarContenido();
		bc.setVisible(true);
		dispose();
	}
}
