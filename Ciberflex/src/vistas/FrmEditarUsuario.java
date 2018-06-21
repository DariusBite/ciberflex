package vistas;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionUsuario;
import modelado.Usuario;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEditarUsuario extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblListaDeUsuarios;
	private JScrollPane scrollPane;
	private JButton btnEditar;
	private JTable tblEditarUsuario;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEditarUsuario frame = new FrmEditarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Variable local para el modelo de la tabla
	DefaultTableModel modelo = new DefaultTableModel();

	public FrmEditarUsuario() {
		setTitle("Lista de Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1075, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblListaDeUsuarios = new JLabel("LISTA DE USUARIOS");
		lblListaDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListaDeUsuarios.setForeground(Color.BLACK);
		lblListaDeUsuarios.setBounds(413, 11, 168, 14);
		contentPane.add(lblListaDeUsuarios);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 1039, 271);
		contentPane.add(scrollPane);
		//modelo de la tabla
		tblEditarUsuario = new JTable();
		tblEditarUsuario.setModel(modelo);
		modelo.addColumn("ID");
		modelo.addColumn("EMAIL");
		modelo.addColumn("PASSWORD");
		modelo.addColumn("NAME");
		modelo.addColumn("LAST NAME");
		modelo.addColumn("DATE OF BIRTH");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("CIUDAD");
		modelo.addColumn("PROVINCIA");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("TIPO USUARIO");
		modelo.addColumn("ID PLAN");
		scrollPane.setViewportView(tblEditarUsuario);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(453, 68, 89, 23);
		contentPane.add(btnEditar);
		
		//lLAMAMOS AL METODO LISTAR USUARIOS
		listarUsuarios();
	}
	
	//Metodo listar
	void listarUsuarios(){
		//1.
		GestionUsuario gu = new GestionUsuario();
		//2.
		ArrayList<Usuario> lista = gu.listado();
		//3.
		if(lista.isEmpty()){
			//alerta vacia
		}else{
			for(Usuario u : lista){
				Object datos [] = {
						//3.1
						u.getId(),
						u.getEmail(),
						u.getPassword(),
						u.getNombre(),
						u.getApellido(),
						u.getFechanacimiento(),
						u.getDireccion(),
						u.getCiudad(),
						u.getProvincia(),
						u.getTelefono(),
						u.getTipo(),
						u.getId()
				};
				modelo.addRow(datos);
			}
		}
	}
	
	//Enviar datos
	void enviarDatos(){
		//1.
		int fila = tblEditarUsuario.getSelectedRow();
		//2.
		EditarUsuario.txtIDEditar.setText(tblEditarUsuario.getValueAt(fila, 0).toString());
		EditarUsuario.txtEmailEditar.setText(tblEditarUsuario.getValueAt(fila, 1).toString());
		EditarUsuario.pswPasswordEditar.setText("");
		EditarUsuario.txtNombreEditar.setText(tblEditarUsuario.getValueAt(fila, 3).toString());
		EditarUsuario.txtApellidoEditar.setText(tblEditarUsuario.getValueAt(fila, 4).toString());
		EditarUsuario.txtDireccionEditar.setText(tblEditarUsuario.getValueAt(fila, 6).toString());
		EditarUsuario.txtTelefonoEditar.setText(tblEditarUsuario.getValueAt(fila, 9).toString());
		EditarUsuario.txtTipoUsuarioEditar.setText(tblEditarUsuario.getValueAt(fila, 10).toString());
		EditarUsuario.pswPasswordEditar.requestFocus();
	}		
	
	//Salio así
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEditar) {
			actionPerformedBtnEditar(arg0);
		}
	}
	protected void actionPerformedBtnEditar(ActionEvent arg0) {
		EditarUsuario eu = new EditarUsuario();
		eu.setVisible(true);
		eu.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//enviamos datos para editar
		enviarDatos();
	}
}
