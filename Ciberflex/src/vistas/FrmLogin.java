package vistas;

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
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		setBounds(100, 100, 300, 217);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(10, 52, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(81, 49, 193, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(10, 77, 70, 14);
		contentPane.add(lblPassword);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarAcceso();
			}
		});
		btnEntrar.setBounds(105, 105, 90, 23);
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
		lblRegistrar.setBounds(188, 140, 86, 14);
		contentPane.add(lblRegistrar);
		
		JLabel lblIniciarSession = new JLabel("Iniciar Session");
		lblIniciarSession.setForeground(Color.WHITE);
		lblIniciarSession.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIniciarSession.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSession.setBounds(10, 11, 264, 14);
		contentPane.add(lblIniciarSession);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(81, 74, 193, 20);
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
					FrmPanelAdministrador v = new FrmPanelAdministrador();
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
	
	@SuppressWarnings("deprecation")
	String leerPass(){
		return txtPassword.getText();
	}
	
	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
	
}
