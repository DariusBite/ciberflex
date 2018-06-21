package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionPlan;
import modelado.Plan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAddPlans extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombrePlan;
	private JTextField txtPrecio;
	private JTextArea txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAddPlans frame = new FrmAddPlans();
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
	public FrmAddPlans() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientoDePlanes = new JLabel("A\u00D1ADIR PLANES");
		lblMantenimientoDePlanes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDePlanes.setBounds(10, 11, 400, 14);
		contentPane.add(lblMantenimientoDePlanes);
		
		JLabel lblNombre = new JLabel("Nombre de Plan:");
		lblNombre.setBounds(10, 39, 109, 14);
		contentPane.add(lblNombre);
		
		txtNombrePlan = new JTextField();
		txtNombrePlan.setBounds(118, 36, 97, 20);
		contentPane.add(txtNombrePlan);
		txtNombrePlan.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 67, 49, 14);
		contentPane.add(lblPrecio);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(10, 117, 400, 134);
		contentPane.add(txtDescripcion);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 92, 109, 14);
		contentPane.add(lblDescripcion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setBounds(321, 36, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnSalir.setBounds(321, 63, 89, 23);
		contentPane.add(btnSalir);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(118, 64, 97, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
	}
	
	void guardar(){
		String nombre, descripcion, mensaje = "Los siguientes campos contienen errores";
		double precio = 0;
		int errors = 0;
		GestionPlan gp = new GestionPlan();
		
		nombre = leerNombre();
		descripcion = leerDescripcion();
		
		if(!nombre.matches(".{1,50}")){
			mensaje = mensaje + "\n- Nombre";
			errors++;	
		}
		
		if(!descripcion.matches(".{1,260}")){
			mensaje = mensaje + "\n- Descripcion";
			errors++;	
		}
		
		try {
			precio = leerPrecio();
		} catch (Exception e) {
			mensaje = mensaje + "\n- Precio";
			errors++;
		}
		
		if(errors == 0){
			Plan p = new Plan();
			p.setNombre_plan(nombre);
			p.setPrecio_plan(precio);
			p.setDescripcion_plan(descripcion);
			int ok = gp.registraPlanes(p);
			if(ok == 0) mensaje("Error al registrar plan en la BD");
			else {
				mensaje("Registro exitoso");
				FrmPanelAdministrador fpa = new FrmPanelAdministrador();
				fpa.setVisible(true);
				dispose();
			}
		}
		else mensaje(mensaje);
		
	}
	
	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
	
	String leerNombre(){
		return txtNombrePlan.getText();
	}
	
	double leerPrecio(){
		return Double.parseDouble(txtPrecio.getText());
	}
	
	String leerDescripcion(){
		return txtDescripcion.getText();
	}

	void closeWindow(){
		FrmPanelAdministrador fpa = new FrmPanelAdministrador();
		fpa.setVisible(true);
		dispose();
	}
}
