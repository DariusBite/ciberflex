package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionUsuario;
import modelado.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JPasswordField txtPassword;
	private JPasswordField txtPassword2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistrar frame = new FrmRegistrar();
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
	public FrmRegistrar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 51, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(136, 51, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(136, 144, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(136, 175, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 82, 77, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblContrasena2 = new JLabel("Repite tu contrase\u00F1a");
		lblContrasena2.setBounds(10, 116, 119, 14);
		contentPane.add(lblContrasena2);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 147, 66, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 178, 46, 14);
		contentPane.add(lblApellido);
		
		JButton btnRegistrarce = new JButton("Registrarce");
		btnRegistrarce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrarce.setBounds(158, 227, 118, 23);
		contentPane.add(btnRegistrarce);
		
		JLabel lblRegistrate = new JLabel("Registrate");
		lblRegistrate.setVerticalAlignment(SwingConstants.TOP);
		lblRegistrate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistrate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrate.setBounds(10, 11, 414, 29);
		contentPane.add(lblRegistrate);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(136, 82, 86, 20);
		contentPane.add(txtPassword);
		
		txtPassword2 = new JPasswordField();
		txtPassword2.setBounds(136, 113, 86, 20);
		contentPane.add(txtPassword2);
	}
	
	void registrar(){
		String email, pass, pass2, nombre, apellido, mensaje = "Los siguientes datos contienen errores";
		int errors = 0;
		
		email = leerEmail();
		pass = leerPass();
		pass2 = leerPass2();
		nombre = leerNombre();
		apellido = leerApellido();
		GestionUsuario gu = new GestionUsuario();
		
		if(!email.matches("[A-Za-z0-9\\-_]{1,}@[A-Za-z0-9\\-_]{1,}\\.[a-z\\.]{2,3}") || email.length() >=50 ){
			mensaje = mensaje + "\n- Email";
			errors++;
		};
		if(!gu.emailExiste(email).isEmpty()){
			mensaje = mensaje + "\n- Email ya existe";
			errors++;		
		}
		if(!pass.matches(".{6,20}")){
			mensaje = mensaje + "\n- Contraseña";
			errors++;			
		};
		if(!pass2.equals(pass)){
			mensaje = mensaje + "\n- Las contraseñas no coinciden";
			errors++;			
		};
		if(!nombre.matches(".{1,50}")){
			mensaje = mensaje + "\n- Nombre";
			errors++;	
		}
		if(!apellido.matches(".{1,50}")){
			mensaje = mensaje + "\n- Apelldio";
			errors++;	
		}
		
		if(errors > 0){
			mensaje(mensaje);
		}
		else {
			Usuario u = new Usuario();
			u.setEmail(email);
			u.setPassword(pass);
			u.setNombre(nombre);
			u.setApellido(apellido);
			int ok = gu.registraUsuario(u);
			if(ok == 0) mensaje("Error al registrar usuario en la BD");
			else {
				mensaje("Registro exitoso");
				FrmLogin v = new FrmLogin();
				v.setVisible(true);
				dispose();
			}
		}
		
	}
	
	String leerEmail(){
		return txtEmail.getText();
	}
	
	String leerPass(){
		return txtPassword.getText();
	}
	
	String leerPass2(){
		return txtPassword2.getText();
	}
	
	String leerNombre(){
		return txtNombre.getText();
	}
	
	String leerApellido(){
		return txtApellido.getText();
	}
	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
}
