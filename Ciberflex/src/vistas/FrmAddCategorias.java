package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionCategoria;
import modelado.Categoria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAddCategorias extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextArea txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddCategorias frame = new FrmAddCategorias();
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
	public FrmAddCategorias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientoDeCategorias = new JLabel("A\u00D1ADIR CATEGORIAS");
		lblMantenimientoDeCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeCategorias.setBounds(10, 11, 414, 14);
		contentPane.add(lblMantenimientoDeCategorias);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 53, 46, 14);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(66, 50, 112, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 88, 122, 14);
		contentPane.add(lblDescripcion);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(10, 113, 414, 137);
		contentPane.add(txtDescripcion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		btnGuardar.setBounds(335, 36, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnSalir.setBounds(335, 70, 89, 23);
		contentPane.add(btnSalir);
	}
	
	void guardar(){
		String titulo, descripcion, mensaje = "Los siguientes campos contienen errores";
		int errors = 0;
		GestionCategoria gc = new GestionCategoria();
		
		titulo = leerTitulo();
		descripcion = leerDescripcion();
		
		if(!titulo.matches(".{1,50}")){
			mensaje = mensaje + "\n- Titulo";
			errors++;	
		};
		if(!descripcion.matches(".{1,260}")){
			mensaje = mensaje + "\n- Descripcion";
			errors++;	
		};
		
		if(errors == 0){
			Categoria c = new Categoria();
			c.setTitulo_categoria(titulo);
			c.setDescripcion_categoria(descripcion);
			int ok = gc.registarCategoria(c);
			if(ok == 0) mensaje("Error al registrar usuario en la BD");
			else {
				mensaje("Registro exitoso");
				FrmPanelAdministrador fpa = new FrmPanelAdministrador();
				fpa.setVisible(true);
				dispose();
			}
		}
		else mensaje(mensaje);
	}
	
	String leerTitulo(){
		return txtTitulo.getText();
	}
	
	String leerDescripcion(){
		return txtDescripcion.getText();
	}
	
	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
	void closeWindow(){
		FrmPanelAdministrador fpa = new FrmPanelAdministrador();
		fpa.setVisible(true);
		dispose();
	}
}
