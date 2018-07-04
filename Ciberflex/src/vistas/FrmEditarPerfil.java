package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionPlan;
import mantenimientos.GestionUsuario;
import modelado.Plan;
import modelado.UserSession;
import modelado.Usuario;
import utils.Lugares;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEditarPerfil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId = UserSession.getId();
	private Usuario u = null;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPass;
	private JPasswordField txtPass2;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDirec;
	private JTextField txtTel;
	private JDateChooser txtFecha;
	private JComboBox cboCiudad;
	private JComboBox cboProvincia;
	private JComboBox cboPlan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEditarPerfil frame = new FrmEditarPerfil();
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
	public FrmEditarPerfil() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarPerfil = new JLabel("Editar Perfil");
		lblEditarPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarPerfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditarPerfil.setBounds(10, 11, 414, 20);
		contentPane.add(lblEditarPerfil);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 42, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 67, 98, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblRepiteTuContrasea = new JLabel("Repite tu contrase\u00F1a");
		lblRepiteTuContrasea.setBounds(10, 92, 122, 14);
		contentPane.add(lblRepiteTuContrasea);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 117, 71, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 142, 64, 14);
		contentPane.add(lblApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(10, 167, 122, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 192, 84, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(10, 242, 46, 14);
		contentPane.add(lblCiudad);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 217, 71, 14);
		contentPane.add(lblProvincia);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 267, 71, 14);
		contentPane.add(lblTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(145, 39, 160, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(145, 64, 160, 20);
		contentPane.add(txtPass);
		
		txtPass2 = new JPasswordField();
		txtPass2.setBounds(145, 89, 160, 20);
		contentPane.add(txtPass2);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(145, 114, 160, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(145, 139, 160, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDirec = new JTextField();
		txtDirec.setBounds(145, 189, 160, 20);
		contentPane.add(txtDirec);
		txtDirec.setColumns(10);
		
		cboCiudad = new JComboBox();
		cboCiudad.setBounds(145, 239, 160, 20);
		cboCiudad.setModel(new DefaultComboBoxModel(Lugares.ciudades[0]));
		contentPane.add(cboCiudad);
		
		cboProvincia = new JComboBox();
		cboProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeCity();
			}
		});
		cboProvincia.setBounds(145, 214, 160, 20);
		cboProvincia.setModel(new DefaultComboBoxModel(Lugares.provincias));
		contentPane.add(cboProvincia);
		
		txtTel = new JTextField();
		txtTel.setBounds(145, 264, 160, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblPlan = new JLabel("Plan");
		lblPlan.setBounds(10, 292, 46, 14);
		contentPane.add(lblPlan);
		
		cboPlan = new JComboBox();
		cboPlan.setBounds(145, 295, 160, 20);
		contentPane.add(cboPlan);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setBounds(169, 343, 98, 28);
		contentPane.add(btnGuardar);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(145, 164, 160, 20);
		contentPane.add(txtFecha);
		setPlans();
		setUser();
	}
	
	void setUser(){
		try {
			GestionUsuario gu = new GestionUsuario();
			u = gu.obtenerUsuario(userId);
			String fecha = u.getFechanacimiento();
			txtEmail.setText(u.getEmail());
			txtPass.setText(u.getPassword());
			txtPass2.setText(u.getPassword());
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
			cboPlan.setSelectedIndex(u.getIdPlan());
			SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = smf.parse(fecha);
			txtFecha.setDate(date);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void changeCity(){
		cboCiudad.setModel(new DefaultComboBoxModel(Lugares.setCiudades(cboProvincia.getSelectedIndex())));
	}
	
	void guardar(){
		String pass, pass2, nombre, apellido, fnacimiento, direc, tel, prov, ciud, mensaje = "Los siguientes datos contienen errores";
		int plan, errors = 0;
		Date actualDate;
		GestionUsuario gu = new GestionUsuario();
		
		pass = leerPass();
		pass2 = leerPass2();
		nombre = leerNombre();
		apellido = leerApellido();
		fnacimiento = leerFecha();
		direc = leerDirec();
		prov = leerProv();
		ciud = leerCiud();
		plan = leerPlan();
		tel = leerTel();
		actualDate = new Date();
		
		if(!pass.matches(".{6,20}")){
			mensaje = mensaje + "\n- Contraseña muy corta o muy larga";
			errors++;			
		};
		if(!pass2.equals(pass)){
			mensaje = mensaje + "\n- Las contraseñas no coinciden";
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
			int ok = gu.actualizarUsuario(u);
			if(ok == 0) mensaje("Error al actualizar usuario en la BD");
			else {
				mensaje("Actualizacion exitosa");
				dispose();
			}
		}
		else {
			mensaje(mensaje);
		}
		
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
	
	String leerPass2(){
		return txtPass2.getText();
	}

	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
}
