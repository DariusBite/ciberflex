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
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEditarPlan extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private int id;
	private JTextArea txtDescripcion;
	private JComboBox cboEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEditarPlan frame = new FrmEditarPlan(0);
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
	public FrmEditarPlan(int id_p) {
		id = id_p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nombre de Plan:");
		label.setBounds(10, 38, 109, 14);
		contentPane.add(label);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(118, 35, 97, 20);
		contentPane.add(txtNombre);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(118, 63, 97, 20);
		contentPane.add(txtPrecio);
		
		JLabel label_1 = new JLabel("Precio");
		label_1.setBounds(10, 66, 98, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Descripcion:");
		label_2.setBounds(10, 116, 109, 14);
		contentPane.add(label_2);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setBounds(10, 141, 400, 109);
		contentPane.add(txtDescripcion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		btnGuardar.setBounds(321, 35, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(321, 62, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 91, 89, 14);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(118, 88, 97, 20);
		contentPane.add(cboEstado);
		cboEstado.addItem("Inactivo");
		cboEstado.addItem("Activo");
		
		JLabel lblEditarPlan = new JLabel("Editar Plan");
		lblEditarPlan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditarPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarPlan.setBounds(0, 11, 434, 23);
		contentPane.add(lblEditarPlan);
		
		rellenar();
	}
	
	void rellenar(){
		GestionPlan gp = new GestionPlan();
		Plan p = gp.obtener(id);
		txtNombre.setText(p.getNombre_plan());
		txtPrecio.setText(p.getPrecio_plan()+"");
		txtDescripcion.setText(p.getDescripcion_plan());
		cboEstado.setSelectedIndex(p.getEstado());
	}
	
	void guardar(){
		String nombre, descripcion, mensaje = "Los siguientes campos contienen errores";
		double precio = 0;
		int errors = 0, estado;
		GestionPlan gp = new GestionPlan();
		
		nombre = leerNombre();
		descripcion = leerDescripcion();
		estado = leerEstado();
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
			p.setId_plan(id);
			p.setNombre_plan(nombre);
			p.setPrecio_plan(precio);
			p.setDescripcion_plan(descripcion);
			p.setEstado(estado);
			int ok = gp.actualizar(p);
			if(ok == 0) mensaje("Error al registrar plan en la BD");
			else {
				mensaje("Registro exitoso");
				FrmPanelAdministrador fpa = new FrmPanelAdministrador();
				fpa.setVisible(true);
				dispose();
			}
		}
		else mensaje(mensaje);
		
	};
	
	String leerNombre(){
		return txtNombre.getText();
	}
	
	double leerPrecio(){
		return Double.parseDouble(txtPrecio.getText());
	}
	
	int leerEstado(){
		return cboEstado.getSelectedIndex();
	}
	
	String leerDescripcion(){
		return txtDescripcion.getText();
	}
	
	void mensaje(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);

	}
	
	void salir(){
		FrmPanelAdministrador fpa = new FrmPanelAdministrador();
		fpa.setVisible(true);
		dispose();
	}
	
	
}
