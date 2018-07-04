package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionPlan;
import mantenimientos.GestionReportePlanMasUsuarios;
import modelado.Plan;
import modelado.ReportePlanMasUsuarios;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmReportePlanesUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReportePlanesUsuarios frame = new FrmReportePlanesUsuarios();
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
	public FrmReportePlanesUsuarios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlanesConMas = new JLabel("Planes con mas usuarios");
		lblPlanesConMas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlanesConMas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanesConMas.setBounds(10, 11, 764, 20);
		contentPane.add(lblPlanesConMas);
		
		comboBox = new JComboBox();
		comboBox.setBounds(589, 42, 185, 20);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
		comboBox.addItem("Selecciona un plan");
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 764, 377);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		modelo.addColumn("Plan");
		modelo.addColumn("Usuarios");
		go();
		setPlans();
	}
	
	void setPlans(){
		GestionPlan gp = new GestionPlan();
		ArrayList<Plan> lista = gp.listarPlanes();
		
		if(!lista.isEmpty()){
			for(Plan p : lista){
				comboBox.addItem(p.getNombre_plan());
			}
		}
	}
	
	void go(){
		int rowCount = modelo.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    modelo.removeRow(i);
		}
		int i = comboBox.getSelectedIndex();
		GestionReportePlanMasUsuarios grpu = new GestionReportePlanMasUsuarios();
		if(i==0){
			ArrayList<ReportePlanMasUsuarios> lista = grpu.reportePlan();
			for(ReportePlanMasUsuarios u : lista){
				Object[] fila = {
						u.getNombre_plan(),
						u.getTotal() + ""
				};
				modelo.addRow(fila);
			}
		}
		else{
			ArrayList<ReportePlanMasUsuarios> lista = grpu.reportePlan(i);
			for(ReportePlanMasUsuarios u : lista){
				Object[] fila = {
						u.getNombre_plan(),
						u.getTotal() + ""
				};
				modelo.addRow(fila);
			}
		}
	}
}
