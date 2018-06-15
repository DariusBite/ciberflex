package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionUsuario;
import modelado.UserSession;
import modelado.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 202, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 52, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(81, 49, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 77, 70, 14);
		contentPane.add(lblPassword);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarAcceso();
			}
		});
		btnEntrar.setBounds(46, 105, 89, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblRegistrar = new JLabel("Registrate");
		lblRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				registrate();
			}
		});
		lblRegistrar.setForeground(Color.BLUE);
		lblRegistrar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegistrar.setBounds(90, 139, 86, 14);
		contentPane.add(lblRegistrar);
		
		JLabel lblOlvidarContrasea = new JLabel("Olvidar Contrase\u00F1a");
		lblOlvidarContrasea.setForeground(Color.BLUE);
		lblOlvidarContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOlvidarContrasea.setBounds(28, 153, 148, 14);
		contentPane.add(lblOlvidarContrasea);
		
		JLabel lblIniciarSession = new JLabel("Iniciar Session");
		lblIniciarSession.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIniciarSession.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSession.setBounds(10, 11, 166, 14);
		contentPane.add(lblIniciarSession);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(81, 74, 86, 20);
		contentPane.add(txtPassword);
	}
	
	void registrate(){
		FrmRegistrar v = new FrmRegistrar();
		v.setVisible(true);
		dispose();
	}
	
	void validarAcceso(){
		String email, clave;
		try {
			email = leerEmail();
			clave = leerPass();
			GestionUsuario gu = new GestionUsuario();
			
			Usuario u = gu.validaAcceso(email, clave);
			
			if(u != null) {
				UserSession.setId(u.getId());
				if (u.getTipo().equals("Cliente")){
					FrmListaContenido v = new FrmListaContenido();
					v.setVisible(true);
					dispose();
				};
				if(u.getTipo().equals("Administrador")){
					PanelAdministrador v = new PanelAdministrador();
					v.setVisible(true);
					dispose();
				};
			}
			else mensaje("Usuario o clave incorrecto");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	String leerEmail(){
		return txtEmail.getText();
	}
	
	String leerPass(){
		return txtPassword.getText();
	}
	
	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
	
}
