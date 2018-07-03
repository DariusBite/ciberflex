package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionPlan;
import modelado.Plan;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmEditarPlanes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Plan> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEditarPlanes frame = new FrmEditarPlanes();
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
	public FrmEditarPlanes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActualizarPlanes = new JLabel("Actualizar Planes");
		lblActualizarPlanes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblActualizarPlanes.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarPlanes.setBounds(10, 11, 414, 20);
		contentPane.add(lblActualizarPlanes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 414, 174);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btnEditar.setBounds(174, 227, 89, 23);
		contentPane.add(btnEditar);
		modelo.addColumn("Plan");
		modelo.addColumn("Precio");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Estado");
		
		listar();
	}
	
	void listar(){
		GestionPlan gp = new GestionPlan();
		lista = gp.listarPlanes();
		for(Plan p:lista){
			String e;
			if (p.getEstado() == 0) e = "Inactivo";
			else e = "Activo";
			Object[] fila = {p.getNombre_plan(), p.getPrecio_plan(), p.getDescripcion_plan(),e};
			modelo.addRow(fila);
		}
	}
	
	void editar(){
		try {
			int id = lista.get(table.getSelectedRow()).getId_plan();
			FrmEditarPlan ep = new FrmEditarPlan(id);
			ep.setVisible(true);
			dispose();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
