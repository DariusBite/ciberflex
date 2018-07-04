package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionPlan;
import mantenimientos.GestionUsuario;
import modelado.Plan;
import modelado.Usuario;
import utils.Lugares;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class FrmEditarUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblEditarCampos;
	public static JTextField txtEmail;
	public static JPasswordField txtPass;
	public static JTextField txtNombre;
	public static JTextField txtApellido;
	public static JTextField txtDirec;
	public static JTextField txtTel;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblFechaNac;
	private JLabel lblCiudad;
	private JLabel lblProvincia;
	private JLabel lblTelefono;
	private JLabel lblTipoUsuario;
	private JComboBox cboProvincia;
	private JComboBox cboCiudad;
	private JButton btnGuardar;
	private JComboBox cboTipo;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JLabel lblNatalicio;
	private JComboBox cboPlan;
	private JDateChooser txtFecha;
	private Usuario u = null;
	private int id;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmEditarUsuario dialog = new FrmEditarUsuario(1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmEditarUsuario(int id) {
		this.id = id;
		setTitle("Editar Usuario");
		setBounds(100, 100, 400, 416);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblEditarCampos = new JLabel("Editar Usuario");
		lblEditarCampos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarCampos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditarCampos.setBounds(10, 11, 364, 14);
		contentPanel.add(lblEditarCampos);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(92, 36, 205, 20);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 86, 205, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(92, 111, 205, 20);
		contentPanel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDirec = new JTextField();
		txtDirec.setBounds(92, 161, 205, 20);
		contentPanel.add(txtDirec);
		txtDirec.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setBounds(92, 236, 205, 20);
		contentPanel.add(txtTel);
		txtTel.setColumns(10);
		
		lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(10, 39, 46, 14);
		contentPanel.add(lblEmail);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(10, 64, 72, 14);
		contentPanel.add(lblPassword);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 89, 72, 14);
		contentPanel.add(lblNombre);
		
		lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(10, 114, 72, 14);
		contentPanel.add(lblApellido);
		
		lblFechaNac = new JLabel("DIRECCION");
		lblFechaNac.setBounds(10, 164, 72, 14);
		contentPanel.add(lblFechaNac);
		
		lblCiudad = new JLabel("CIUDAD");
		lblCiudad.setBounds(10, 214, 46, 14);
		contentPanel.add(lblCiudad);
		
		lblProvincia = new JLabel("PROVINCIA");
		lblProvincia.setBounds(10, 189, 72, 14);
		contentPanel.add(lblProvincia);
		
		lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setBounds(10, 239, 72, 14);
		contentPanel.add(lblTelefono);
		
		lblTipoUsuario = new JLabel("TIPO");
		lblTipoUsuario.setBounds(10, 264, 86, 14);
		contentPanel.add(lblTipoUsuario);
		
		cboProvincia = new JComboBox();
		cboProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeCity();
			}
		});
		cboProvincia.setBounds(92, 186, 205, 20);
		cboProvincia.setModel(new DefaultComboBoxModel(Lugares.provincias));
		contentPanel.add(cboProvincia);
		
		cboCiudad = new JComboBox();
		cboCiudad.setBounds(92, 211, 205, 20);
		cboCiudad.setModel(new DefaultComboBoxModel(Lugares.ciudades[0]));
		contentPanel.add(cboCiudad);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		btnGuardar.setBounds(7, 343, 89, 23);
		contentPanel.add(btnGuardar);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(92, 61, 205, 20);
		contentPanel.add(txtPass);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(92, 261, 205, 20);
		contentPanel.add(cboTipo);
		cboTipo.addItem("Cliente");
		cboTipo.addItem("Administrador");
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 289, 72, 14);
		contentPanel.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(92, 286, 205, 20);
		contentPanel.add(cboEstado);
		cboEstado.addItem("Inactivo");
		cboEstado.addItem("Activo");
		
		lblNatalicio = new JLabel("NATALICIO");
		lblNatalicio.setBounds(10, 139, 72, 14);
		contentPanel.add(lblNatalicio);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(92, 135, 205, 20);
		contentPanel.add(txtFecha);
		
		JLabel lblPlan = new JLabel("Plan");
		lblPlan.setBounds(10, 314, 46, 14);
		contentPanel.add(lblPlan);
		
		cboPlan = new JComboBox();
		cboPlan.setBounds(92, 311, 205, 20);
		contentPanel.add(cboPlan);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		btnSalir.setBounds(285, 343, 89, 23);
		contentPanel.add(btnSalir);
		setPlans();
		setUser();
	}

	
	void changeCity(){
		cboCiudad.setModel(new DefaultComboBoxModel(Lugares.setCiudades(cboProvincia.getSelectedIndex())));
	}
	
	void setPlans(){
		GestionPlan gp = new GestionPlan();
		ArrayList<Plan> lista = gp.listarPlanes();
		
		if(!lista.isEmpty()){
			for(Plan p : lista){
				cboPlan.addItem(p.getNombre_plan());
			}
		}
	}
	
	void setUser(){
		try {
			GestionUsuario gu = new GestionUsuario();
			u = gu.obtenerUsuario(id);
			String fecha = u.getFechanacimiento();
			txtEmail.setText(u.getEmail());
			txtPass.setText(u.getPassword());
			txtNombre.setText(u.getNombre());
			txtApellido.setText(u.getApellido());
			txtTel.setText(u.getTelefono());
			txtDirec.setText(u.getDireccion());
			if(u.getProvincia()== null){
				cboProvincia.setSelectedItem(0);
				cboCiudad.setModel(new DefaultComboBoxModel(Lugares.setCiudades(0)));
			}
			else {
				cboProvincia.setSelectedItem(u.getProvincia());
				changeCity();
			}
			if(u.getCiudad() != null){
				cboCiudad.setSelectedItem(u.getCiudad());
			}
			cboTipo.setSelectedItem(u.getTipo());
			cboPlan.setSelectedIndex(u.getIdPlan()-1);
			cboEstado.setSelectedIndex(u.getEstado());
			SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = smf.parse(fecha);
			txtFecha.setDate(date);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void guardar(){
		String pass, nombre, apellido, fnacimiento, direc, tel, prov, ciud, tipo, mensaje = "Los siguientes datos contienen errores";
		int plan, errors = 0, estado;
		Date actualDate;
		GestionUsuario gu = new GestionUsuario();
		
		pass = leerPass();
		nombre = leerNombre();
		apellido = leerApellido();
		fnacimiento = leerFecha();
		direc = leerDirec();
		prov = leerProv();
		ciud = leerCiud();
		plan = leerPlan();
		tel = leerTel();
		estado = leerEstado();
		tipo = leerTipo();
		actualDate = new Date();
		
		if(!pass.matches(".{6,20}")){
			mensaje = mensaje + "\n- Contraseña muy corta o muy larga";
			errors++;			
		};
		if(!nombre.matches(".{1,50}")){
			mensaje = mensaje + "\n- Nombre";
			errors++;	
		};
		if(!apellido.matches(".{1,50}")){
			mensaje = mensaje + "\n- Apelldio";
			errors++;	
		};
		if(leerDate().compareTo(actualDate) >= 0){
			mensaje = mensaje + "\n- Error en fecha";
			errors++;
		};
		if(direc.length() >= 120){
			mensaje = mensaje+ "\n- Direccion muy larga";
			errors++;
		};
		if(!tel.matches("\\d{0,12}")){
			mensaje = mensaje+ "\n- Telefono invalido";
			errors++;
		};
		
		if(errors == 0){
			u.setPassword(pass);
			u.setNombre(nombre);
			u.setApellido(apellido);
			u.setFechanacimiento(fnacimiento);
			u.setCiudad(ciud);
			u.setProvincia(prov);
			u.setIdPlan(plan);
			u.setDireccion(direc);
			u.setTelefono(tel);
			u.setEstado(estado);
			u.setTipo(tipo);
			int ok = gu.actualizarUsuario(u);
			if(ok == 0) mensaje("Error al actualizar usuario en la BD");
			else {
				mensaje("Actualizacion exitosa");
				FrmEditarUsuarios eu = new FrmEditarUsuarios();
				eu.setVisible(true);
				dispose();
			}
		}
		else {
			mensaje(mensaje);
		}
		
	}
	
	void salir(){
		FrmEditarUsuarios eu = new FrmEditarUsuarios();
		eu.setVisible(true);
		dispose();
	}
	
	String leerNombre(){
		return txtNombre.getText();
	}
	
	String leerApellido(){
		return txtApellido.getText();
	}
	
	String leerFecha(){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
		return sdf.format(txtFecha.getDate());
	}
	
	Date leerDate(){
		return txtFecha.getDate();
	}
	
	String leerDirec(){
		return txtDirec.getText();
	}
	
	String leerTel(){
		return txtTel.getText();
	}
	
	String leerProv(){
		return String.valueOf(cboProvincia.getSelectedItem());
	}
	
	String leerCiud(){
		return String.valueOf(cboCiudad.getSelectedItem());
	}
	
	int leerPlan(){
		return cboPlan.getSelectedIndex()+1;
	}
	
	String leerPass(){
		return txtPass.getText();
	}
	
	String leerTipo(){
		return cboTipo.getSelectedItem().toString();
	}
	
	int leerEstado(){
		return cboEstado.getSelectedIndex();
	}

	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
}
