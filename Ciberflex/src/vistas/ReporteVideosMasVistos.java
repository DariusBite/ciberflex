package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteVideosMasVistos extends JFrame implements ActionListener {

	private JPanel contentPane;
	public static JTextField txtVideo;
	public static JTextField txtTitulo;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteVideosMasVistos frame = new ReporteVideosMasVistos();
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
	public ReporteVideosMasVistos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReporteDeCategorias = new JLabel("REPORTE DE VIDEOS MAS VISTOS");
		lblReporteDeCategorias.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReporteDeCategorias.setBounds(122, 11, 211, 20);
		contentPane.add(lblReporteDeCategorias);
		
		JLabel lblCodigoVideo = new JLabel("Codigo Video:");
		lblCodigoVideo.setBounds(10, 54, 102, 14);
		contentPane.add(lblCodigoVideo);
		
		txtVideo = new JTextField();
		txtVideo.setBounds(122, 51, 94, 20);
		contentPane.add(txtVideo);
		txtVideo.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(ReporteVideosMasVistos.class.getResource("/img/busca.png")));
		btnBuscar.setBounds(248, 42, 34, 31);
		contentPane.add(btnBuscar);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 89, 56, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(122, 86, 160, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JButton btnReportar = new JButton("Reportar");
		btnReportar.setBounds(335, 50, 89, 23);
		contentPane.add(btnReportar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(335, 85, 89, 23);
		contentPane.add(btnSalir);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		mostrarVideos();
	}

	void mostrarVideos() {
		FrmListaVideos vid = new FrmListaVideos();
		vid.setVisible(true);
	}
}
