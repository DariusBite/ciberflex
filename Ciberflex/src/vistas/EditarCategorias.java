package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionCategoria;
import modelado.Categoria;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarCategorias extends JFrame {

	private JPanel contentPane;
	private JTextField txtidCategorias;
	private JTextField txtTituloCategoria;
	private JTextField txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarCategorias frame = new EditarCategorias();
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
	public EditarCategorias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActualizarCategorias = new JLabel("ACTUALIZAR CATEGORIAS");
		lblActualizarCategorias.setBounds(148, 24, 141, 14);
		contentPane.add(lblActualizarCategorias);
		
		JLabel lblNumeroCategoria = new JLabel("Numero Categoria:");
		lblNumeroCategoria.setBounds(22, 80, 108, 14);
		contentPane.add(lblNumeroCategoria);
		
		txtidCategorias = new JTextField();
		txtidCategorias.setBounds(159, 77, 86, 20);
		contentPane.add(txtidCategorias);
		txtidCategorias.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(22, 123, 72, 14);
		contentPane.add(lblTitulo);
		
		txtTituloCategoria = new JTextField();
		txtTituloCategoria.setBounds(159, 120, 86, 20);
		contentPane.add(txtTituloCategoria);
		txtTituloCategoria.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(22, 175, 86, 14);
		contentPane.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(159, 172, 86, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar();
			}
		});
		btnActualizar.setBounds(335, 76, 89, 23);
		contentPane.add(btnActualizar);
	}
	void actualizar(){
		// variables
		int id_categoria;
		String titulo_categoria, descripcion_categoria;
		
		// entradas
		id_categoria= Integer.parseInt(txtidCategorias.getText());
		titulo_categoria = txtTituloCategoria.getText();
		descripcion_categoria = txtDescripcion.getText();
		
		// procesos
		Categoria c=new Categoria();
		c.setId_categoria(id_categoria);
		c.setTitulo_categoria(titulo_categoria);
		c.setDescripcion_categoria(descripcion_categoria);

		
		GestionCategoria gc=new GestionCategoria();
		int ok=gc.actualizar(c);
		// salidas
		if (ok==0){
			System.out.println("Error");
		}else{
			System.out.println("Registro Ok");
		}
		
		
	}
}
