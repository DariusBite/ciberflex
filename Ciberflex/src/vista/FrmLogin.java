package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtPassword;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		txtPassword = new JTextField();
		txtPassword.setBounds(81, 74, 86, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(46, 105, 89, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblRegistrar = new JLabel("Registrar");
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
	}
}
