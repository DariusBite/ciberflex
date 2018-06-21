package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionUsuario;
import modelado.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarUsuario extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblEditarCampos;
	private JLabel lblId;
	public static JTextField txtIDEditar;
	public static JTextField txtEmailEditar;
	public static JPasswordField pswPasswordEditar;
	public static JTextField txtNombreEditar;
	public static JTextField txtApellidoEditar;
	public static JTextField txtDireccionEditar;
	public static JTextField txtTelefonoEditar;
	public static JTextField txtTipoUsuarioEditar;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblFechaNac;
	private JLabel lblCiudad;
	private JLabel lblProvincia;
	private JLabel lblTelefono;
	private JLabel lblTipoUsuario;
	private JComboBox cboProvinciaEditar;
	private JComboBox cboCiudadEditar;
	private JButton btnGuardar2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditarUsuario dialog = new EditarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditarUsuario() {
		setTitle("Editar Usuario");
		setBounds(100, 100, 400, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblEditarCampos = new JLabel("Editar Campos");
		lblEditarCampos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditarCampos.setBounds(126, 11, 134, 14);
		contentPanel.add(lblEditarCampos);
		
		lblId = new JLabel("ID");
		lblId.setBounds(10, 59, 46, 14);
		contentPanel.add(lblId);
		
		txtIDEditar = new JTextField();
		txtIDEditar.setEditable(false);
		txtIDEditar.setBounds(92, 56, 35, 20);
		contentPanel.add(txtIDEditar);
		txtIDEditar.setColumns(10);
		
		txtEmailEditar = new JTextField();
		txtEmailEditar.setEditable(false);
		txtEmailEditar.setBounds(92, 87, 205, 20);
		contentPanel.add(txtEmailEditar);
		txtEmailEditar.setColumns(10);
		
		txtNombreEditar = new JTextField();
		txtNombreEditar.setBounds(92, 149, 205, 20);
		contentPanel.add(txtNombreEditar);
		txtNombreEditar.setColumns(10);
		
		txtApellidoEditar = new JTextField();
		txtApellidoEditar.setBounds(92, 180, 205, 20);
		contentPanel.add(txtApellidoEditar);
		txtApellidoEditar.setColumns(10);
		
		txtDireccionEditar = new JTextField();
		txtDireccionEditar.setBounds(92, 211, 205, 20);
		contentPanel.add(txtDireccionEditar);
		txtDireccionEditar.setColumns(10);
		
		txtTelefonoEditar = new JTextField();
		txtTelefonoEditar.setBounds(92, 304, 205, 20);
		contentPanel.add(txtTelefonoEditar);
		txtTelefonoEditar.setColumns(10);
		
		txtTipoUsuarioEditar = new JTextField();
		txtTipoUsuarioEditar.setBounds(92, 335, 118, 20);
		contentPanel.add(txtTipoUsuarioEditar);
		txtTipoUsuarioEditar.setColumns(10);
		
		lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(10, 90, 46, 14);
		contentPanel.add(lblEmail);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(10, 121, 72, 14);
		contentPanel.add(lblPassword);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 152, 72, 14);
		contentPanel.add(lblNombre);
		
		lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(10, 183, 72, 14);
		contentPanel.add(lblApellido);
		
		lblFechaNac = new JLabel("DIRECCION");
		lblFechaNac.setBounds(10, 214, 72, 14);
		contentPanel.add(lblFechaNac);
		
		lblCiudad = new JLabel("CIUDAD");
		lblCiudad.setBounds(10, 245, 46, 14);
		contentPanel.add(lblCiudad);
		
		lblProvincia = new JLabel("PROVINCIA");
		lblProvincia.setBounds(10, 276, 72, 14);
		contentPanel.add(lblProvincia);
		
		lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setBounds(10, 307, 72, 14);
		contentPanel.add(lblTelefono);
		
		lblTipoUsuario = new JLabel("TIPO USER");
		lblTipoUsuario.setBounds(10, 338, 86, 14);
		contentPanel.add(lblTipoUsuario);
		
		cboProvinciaEditar = new JComboBox();
		cboProvinciaEditar.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Provincia", "Amazonas", "\u00C1ncash", "Apur\u00EDmac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cusco", "Huancavelica", "Hu\u00E1nuco", "Ica", "Jun\u00EDn", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Mart\u00EDn", "Tacna", "Tumbes", "Ucayali"}));
		cboProvinciaEditar.setBounds(92, 273, 205, 20);
		contentPanel.add(cboProvinciaEditar);
		
		cboCiudadEditar = new JComboBox();
		cboCiudadEditar.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Ciudad"}));
		cboCiudadEditar.setBounds(92, 242, 205, 20);
		contentPanel.add(cboCiudadEditar);
		
		btnGuardar2 = new JButton("Guardar");
		btnGuardar2.addActionListener(this);
		btnGuardar2.setBounds(144, 399, 89, 23);
		contentPanel.add(btnGuardar2);
		
		pswPasswordEditar = new JPasswordField();
		pswPasswordEditar.setBounds(92, 118, 205, 20);
		contentPanel.add(pswPasswordEditar);
	}
	//Abrio así
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGuardar2) {
			actionPerformedBtnGuardar2(arg0);
		}
	}
	protected void actionPerformedBtnGuardar2(ActionEvent arg0) {
		actualizarUsuario();
	}
	//---------------------------
	//Metodo actualziar
	@SuppressWarnings("deprecation")
	void actualizarUsuario(){

		
		//Variables
		int codigo;
		String password, nombre, apellido, direccion, telefono, tipo_user;
		
		//Entrada
		codigo = Integer.parseInt(txtIDEditar.getText());
		password = pswPasswordEditar.getText();
		nombre = txtNombreEditar.getText();
		apellido = txtApellidoEditar.getText();
		direccion = txtDireccionEditar.getText();
		telefono = txtTelefonoEditar.getText();
		tipo_user = txtTipoUsuarioEditar.getText();
		
		//proceso
		Usuario u = new Usuario();
		u.setId(codigo);
		u.setPassword(password);
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setDireccion(direccion);
		u.setTelefono(telefono);
		u.setTipo(tipo_user);
		//
		GestionUsuario gu = new GestionUsuario();
		int ok = gu.actualizarUsuario(u);
		//Salida
		if(ok == 0){
			JOptionPane.showMessageDialog(null,"Error al Actualizar");
		}else{
			JOptionPane.showMessageDialog(null,"Usuario Actualziado");
		}
	}
	
	
	
}
