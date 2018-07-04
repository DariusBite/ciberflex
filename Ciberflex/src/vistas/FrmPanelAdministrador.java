package vistas;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;

public class FrmPanelAdministrador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setBounds(100, 100, 730, 250);
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
		btnAadirContenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openAddContent();
			}
		});
		btnAadirContenido.setBounds(10, 63, 157, 23);
		contentPane.add(btnAadirContenido);
		
		JButton btnEditarContenido = new JButton("Editar contenidos");
		btnEditarContenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openEditarContenido();
			}
		});
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
		btnAnadirCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAddCategoria();
			}
		});
		btnAnadirCategoria.setBounds(188, 63, 157, 23);
		contentPane.add(btnAnadirCategoria);
		
		JButton btnEditarCategoria = new JButton("Editar categorias");
		btnEditarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEditarCats();
			}
		});
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
		btnAadirPlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAddPlanes();
			}
		});
		btnAadirPlanes.setBounds(367, 63, 157, 23);
		contentPane.add(btnAadirPlanes);
		
		JButton btnEditarPlanes = new JButton("Editar planes");
		btnEditarPlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEditarPlanes();
			}
		});
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
		btnAadirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrate();
			}
		});
		btnAadirUsuario.setBounds(546, 63, 157, 23);
		contentPane.add(btnAadirUsuario);
		
		JButton btnEditarUsuario = new JButton("Editar Usuarios");
		btnEditarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEditarUsuario();
			}
		});
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openR1();
			}
		});
		btnNewButton.setBounds(10, 164, 187, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVideosMasVistos = new JButton("Videos mas vistos");
		btnVideosMasVistos.setBounds(281, 164, 157, 23);
		contentPane.add(btnVideosMasVistos);
		
		JButton btnCategoriasMasVistas = new JButton("Categorias mas vistas");
		btnCategoriasMasVistas.setBounds(506, 164, 197, 23);
		contentPane.add(btnCategoriasMasVistas);
	}
	
	void openAddContent(){
		FrmAddContenido v = new FrmAddContenido();
		v.setVisible(true);
		dispose();
	}
	
	void openAddCategoria(){
		FrmAddCategorias c = new FrmAddCategorias();
		c.setVisible(true);
		dispose();
	}
	
	void openAddPlanes(){
		FrmAddPlans p = new FrmAddPlans();
		p.setVisible(true);
		dispose();
	}
	
	void openEditarContenido(){
		FrmEditarContenido c = new FrmEditarContenido();
		c.setVisible(true);
		dispose();
	}
	
	void openEditarUsuario(){
		FrmEditarUsuarios u = new FrmEditarUsuarios();
		u.setVisible(true);
		dispose();
	}
	
	void registrate(){
		FrmRegistrar v = new FrmRegistrar();
		v.setVisible(true);
	}
	
	void openEditarCats(){
		FrmEditarCategorias ec = new FrmEditarCategorias();
		ec.setVisible(true);
		dispose();
	}
	
	void openEditarPlanes(){
		FrmEditarPlanes ep = new FrmEditarPlanes();
		ep.setVisible(true);
		dispose();
	}
	
	void openR1(){
		FrmReportePlanesUsuarios pu = new FrmReportePlanesUsuarios();
		pu.setVisible(true);
	}
	
	void openR2(){
		FrmReporteVideosMasVistos pu = new FrmReporteVideosMasVistos();
		pu.setVisible(true);
	}
	
	void openR3(){
		FrmReporteCategorias pu = new FrmReporteCategorias();
		pu.setVisible(true);
	}
}
