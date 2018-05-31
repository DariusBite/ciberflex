package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MantenimientoVideos extends JFrame {

	private JPanel contentPane;
	private JTextField txtVideo;
	private JTextField txtContenido;
	private JTextField txtTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoVideos frame = new MantenimientoVideos();
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
	public MantenimientoVideos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientosDeVideos = new JLabel("MANTENIMIENTOS DE VIDEOS");
		lblMantenimientosDeVideos.setBounds(130, 11, 159, 14);
		contentPane.add(lblMantenimientosDeVideos);
		
		JLabel lblCodigoVideo = new JLabel("Codigo Video: ");
		lblCodigoVideo.setBounds(25, 51, 78, 14);
		contentPane.add(lblCodigoVideo);
		
		txtVideo = new JTextField();
		txtVideo.setBounds(130, 48, 103, 20);
		contentPane.add(txtVideo);
		txtVideo.setColumns(10);
		
		JLabel lblCodigoContenido = new JLabel("Codigo Contenido:");
		lblCodigoContenido.setBounds(25, 76, 103, 14);
		contentPane.add(lblCodigoContenido);
		
		txtContenido = new JTextField();
		txtContenido.setBounds(130, 73, 103, 20);
		contentPane.add(txtContenido);
		txtContenido.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(25, 101, 46, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(130, 98, 103, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblTemporada = new JLabel("Temporada");
		lblTemporada.setBounds(25, 126, 67, 14);
		contentPane.add(lblTemporada);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 123, 67, 20);
		contentPane.add(comboBox);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(25, 151, 67, 14);
		contentPane.add(lblDescripcion);
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(130, 154, 282, 70);
		contentPane.add(textAreaDescripcion);
		
		JLabel lblurlDelVideo = new JLabel("\"URL del Video\"");
		lblurlDelVideo.setBounds(25, 251, 78, 14);
		contentPane.add(lblurlDelVideo);
		
		JLabel lblurlImagenDel = new JLabel("\"URL Imagen del Video\"");
		lblurlImagenDel.setBounds(133, 251, 121, 14);
		contentPane.add(lblurlImagenDel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(323, 47, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(323, 72, 89, 23);
		contentPane.add(btnSalir);
	}
}
