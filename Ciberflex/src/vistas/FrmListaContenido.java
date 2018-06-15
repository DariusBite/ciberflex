package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionContenido;
import modelado.Contenido;

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
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class FrmListaContenido extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListaContenido frame = new FrmListaContenido();
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
	public FrmListaContenido() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 463);
		contentPane = new JPanel();
		contentPane.setToolTipText("Buscar");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		contentPane.add(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openEditarPefil();
			}
		});
		mnUsuario.add(mntmPerfil);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 19, 585, 405);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
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
		ArrayList<Contenido> lista = gc.listarContenido();
		int x= 10, y= 10;
		
		for(Contenido c : lista){
			ImageIcon imageIcon = new ImageIcon(c.getUrl_image_contenido()); // load the image to a imageIcon
			Image image = imageIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(150, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			imageIcon = new ImageIcon(newimg);  // transform it back
			JButton btnContenido = new JButton(c.getTitulo_contenido());
			btnContenido.setIcon(imageIcon);
			btnContenido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					openInfoContenido(c.getId_contenido());
				}
			});
			btnContenido.setBounds(x, y, 150, 200);
			panel.add(btnContenido);
			x = x + 160;
			if(x > 400){
				x = 10;
				y = y+210;
			}
		}
		
	}
	
	void openInfoContenido(int id){
		FrmInfoContenido ic = new FrmInfoContenido(id);
		ic.setVisible(true);
		dispose();
	}
}
