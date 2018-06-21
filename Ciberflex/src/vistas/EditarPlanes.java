package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionPlan;
import modelado.Plan;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarPlanes extends JFrame {

	private JPanel contentPane;
	private JTextField txtidPlan;
	private JTextField txtNombrePlan;
	private JTextField txtPrecioPlan;
	private JTextField txtDescripcionPlan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarPlanes frame = new EditarPlanes();
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
	public EditarPlanes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActualizarPlanes = new JLabel("Actualizar Planes");
		lblActualizarPlanes.setBounds(28, 23, 115, 14);
		contentPane.add(lblActualizarPlanes);
		
		JLabel lblCodigoPlan = new JLabel("Codigo Plan:");
		lblCodigoPlan.setBounds(10, 62, 76, 14);
		contentPane.add(lblCodigoPlan);
		
		txtidPlan = new JTextField();
		txtidPlan.setBounds(101, 59, 100, 20);
		contentPane.add(txtidPlan);
		txtidPlan.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 102, 61, 14);
		contentPane.add(lblNombre);
		
		txtNombrePlan = new JTextField();
		txtNombrePlan.setBounds(101, 99, 100, 20);
		contentPane.add(txtNombrePlan);
		txtNombrePlan.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 145, 61, 14);
		contentPane.add(lblPrecio);
		
		txtPrecioPlan = new JTextField();
		txtPrecioPlan.setBounds(101, 142, 100, 20);
		contentPane.add(txtPrecioPlan);
		txtPrecioPlan.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 183, 76, 14);
		contentPane.add(lblDescripcion);
		
		txtDescripcionPlan = new JTextField();
		txtDescripcionPlan.setBounds(101, 180, 100, 20);
		contentPane.add(txtDescripcionPlan);
		txtDescripcionPlan.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar();
			}
		});
		btnActualizar.setBounds(299, 58, 100, 23);
		contentPane.add(btnActualizar);
	}
	
	void actualizar(){
		// variables
		int id_plan;
		double precio_plan;
		String nombre_plan, descripcion_plan;
		
		// entradas
		id_plan= Integer.parseInt(txtidPlan.getText());
		nombre_plan = txtNombrePlan.getText();
		precio_plan = Double.parseDouble(txtPrecioPlan.getText());
		descripcion_plan=txtDescripcionPlan.getText();
		
		// procesos
		Plan p=new Plan();
		p.setId_plan(id_plan);;
		p.setNombre_plan(nombre_plan);
		p.setPrecio_plan(precio_plan);
		p.setDescripcion_plan(descripcion_plan);

		
		GestionPlan gp=new GestionPlan();
		int ok=gp.actualizar(p);
		// salidas
		if (ok==0){
			System.out.println("Error");
		}else{
			System.out.println("Registro Ok");
		}
		
		
	}
}
