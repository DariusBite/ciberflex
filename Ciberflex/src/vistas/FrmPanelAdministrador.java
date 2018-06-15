package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;

public class FrmPanelAdministrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPanelAdministrador frame = new FrmPanelAdministrador();
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
	public FrmPanelAdministrador() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPanelDeAdministrador = new JLabel("PANEL DE ADMINISTRADOR");
		lblPanelDeAdministrador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPanelDeAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelDeAdministrador.setBounds(10, 11, 704, 14);
		contentPane.add(lblPanelDeAdministrador);
		
		JLabel lblContenido = new JLabel("Contenidos");
		lblContenido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblContenido.setBounds(10, 36, 157, 14);
		contentPane.add(lblContenido);
		
		JButton btnAadirContenido = new JButton("A\u00F1adir contenido");
		btnAadirContenido.setBounds(10, 63, 157, 23);
		contentPane.add(btnAadirContenido);
		
		JButton btnEditarContenido = new JButton("Editar contenido");
		btnEditarContenido.setBounds(10, 97, 157, 23);
		contentPane.add(btnEditarContenido);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(176, 36, 2, 92);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Categorias");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(188, 36, 157, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnAnadirCategoria = new JButton("A\u00F1adir categoria");
		btnAnadirCategoria.setBounds(188, 63, 157, 23);
		contentPane.add(btnAnadirCategoria);
		
		JButton btnEditarCategoria = new JButton("Editar categoria");
		btnEditarCategoria.setBounds(188, 97, 157, 23);
		contentPane.add(btnEditarCategoria);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(355, 36, 2, 92);
		contentPane.add(separator_1);
		
		JLabel label = new JLabel("Planes");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(367, 36, 157, 14);
		contentPane.add(label);
		
		JButton btnAadirPlanes = new JButton("A\u00F1adir planes");
		btnAadirPlanes.setBounds(367, 63, 157, 23);
		contentPane.add(btnAadirPlanes);
		
		JButton btnEditarPlanes = new JButton("Editar planes");
		btnEditarPlanes.setBounds(367, 97, 157, 23);
		contentPane.add(btnEditarPlanes);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(534, 36, 2, 92);
		contentPane.add(separator_2);
		
		JLabel label_1 = new JLabel("Usuarios");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(546, 36, 157, 14);
		contentPane.add(label_1);
		
		JButton btnAadirUsuario = new JButton("A\u00F1adir usuario");
		btnAadirUsuario.setBounds(546, 63, 157, 23);
		contentPane.add(btnAadirUsuario);
		
		JButton btnEditarUsuario = new JButton("Editar Usuario");
		btnEditarUsuario.setBounds(546, 97, 157, 23);
		contentPane.add(btnEditarUsuario);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 128, 694, 2);
		contentPane.add(separator_3);
		
		JLabel label_2 = new JLabel("Reportes");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 139, 694, 14);
		contentPane.add(label_2);
		
		JButton btnNewButton = new JButton("Planes con mas usuarios");
		btnNewButton.setBounds(10, 164, 157, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVideosMasVistos = new JButton("Videos mas vistos");
		btnVideosMasVistos.setBounds(10, 198, 157, 23);
		contentPane.add(btnVideosMasVistos);
		
		JButton btnContenidoMasVisto = new JButton("Contenido mas visto");
		btnContenidoMasVisto.setBounds(10, 232, 157, 23);
		contentPane.add(btnContenidoMasVisto);
		
		JButton btnCategoriasMasVistas = new JButton("Categorias mas vistas");
		btnCategoriasMasVistas.setBounds(10, 266, 157, 23);
		contentPane.add(btnCategoriasMasVistas);
	}
}
