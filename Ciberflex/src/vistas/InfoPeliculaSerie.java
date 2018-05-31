package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class InfoPeliculaSerie extends JFrame {

	private JPanel contentPane;
	private JTextField txtPelicula;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoPeliculaSerie frame = new InfoPeliculaSerie();
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
	public InfoPeliculaSerie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformacionPeliculaO = new JLabel("INFORMACION PELICULA O SERIE");
		lblInformacionPeliculaO.setBounds(126, 11, 166, 14);
		contentPane.add(lblInformacionPeliculaO);
		
		JLabel lblCodigoPeliculaserie = new JLabel("Codigo Pelicula/Serie:");
		lblCodigoPeliculaserie.setBounds(10, 56, 120, 14);
		contentPane.add(lblCodigoPeliculaserie);
		
		txtPelicula = new JTextField();
		txtPelicula.setBounds(126, 53, 143, 20);
		contentPane.add(txtPelicula);
		txtPelicula.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(324, 52, 73, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 91, 73, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(126, 88, 143, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTemporada = new JLabel("Temporada:");
		lblTemporada.setBounds(10, 124, 73, 14);
		contentPane.add(lblTemporada);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 119, 84, 20);
		contentPane.add(comboBox);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 159, 73, 14);
		contentPane.add(lblDescripcion);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(126, 154, 271, 97);
		contentPane.add(textArea);
	}
}
