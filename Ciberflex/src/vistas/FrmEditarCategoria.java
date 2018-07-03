package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionCategoria;
import modelado.Categoria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEditarCategoria extends JFrame {

	private JPanel contentPane;
	private int id;
	private JTextField txtTitulo;
	private JComboBox cboEstado;
	private JTextPane txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEditarCategoria frame = new FrmEditarCategoria(1);
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
	public FrmEditarCategoria(int id) {
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActualizarCategoria = new JLabel("Actualizar Categoria");
		lblActualizarCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblActualizarCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarCategoria.setBounds(10, 11, 414, 20);
		contentPane.add(lblActualizarCategoria);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 42, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 67, 46, 14);
		contentPane.add(lblEstado);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 92, 67, 14);
		contentPane.add(lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 414, 133);
		contentPane.add(scrollPane);
		
		txtDescripcion = new JTextPane();
		scrollPane.setViewportView(txtDescripcion);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(80, 39, 120, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		btnGuardar.setBounds(335, 38, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(335, 63, 89, 23);
		contentPane.add(btnSalir);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(80, 64, 120, 20);
		contentPane.add(cboEstado);
		cboEstado.addItem("Inactivo");
		cboEstado.addItem("Activo");
		
		rellenar();
	}
	
	void rellenar(){
		GestionCategoria gc = new GestionCategoria();
		Categoria c = gc.obtener(id);
		txtTitulo.setText(c.getTitulo_categoria());
		txtDescripcion.setText(c.getDescripcion_categoria());
		cboEstado.setSelectedIndex(c.getEstado());
	}
	
	String leerTitulo(){
		return txtTitulo.getText();
	}
	
	String leerDescripcion(){
		return txtDescripcion.getText();
	}
	
	int leerEstado(){
		return cboEstado.getSelectedIndex();
	}
	
	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
	
	void guardar(){
		String titulo, descripcion, mensaje = "Los siguientes campos contienen errores";
		int errors = 0, estado;
		GestionCategoria gc = new GestionCategoria();
		
		titulo = leerTitulo();
		descripcion = leerDescripcion();
		estado = leerEstado();
		
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
			c.setId_categoria(id);
			c.setTitulo_categoria(titulo);
			c.setDescripcion_categoria(descripcion);
			c.setEstado(estado);
			int ok = gc.actualizar(c);
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
	
}
