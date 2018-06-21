package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionPlan;
import modelado.Plan;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class ReportePlanMasUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable tblReportePlanMasUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReportePlanMasUsuarios dialog = new ReportePlanMasUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//tabla
	DefaultTableModel modelo = new DefaultTableModel();
	private JComboBox cboPlan;
	private JLabel lblElegirPlan;
	
	public ReportePlanMasUsuarios() {
		setTitle("Reporte Plan con + Usuarios");
		setBounds(100, 100, 450, 344);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblReportePlan = new JLabel("Reporte Plan + Usuarios");
			lblReportePlan.setBounds(143, 11, 151, 14);
			contentPanel.add(lblReportePlan);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 414, 158);
		contentPanel.add(scrollPane);
		
		tblReportePlanMasUsuarios = new JTable();
		tblReportePlanMasUsuarios.setModel(modelo);
		modelo.addColumn("STANDAR");
		modelo.addColumn("PREMIUN");
		modelo.addColumn("VIP");
		scrollPane.setViewportView(tblReportePlanMasUsuarios);
		
		cboPlan = new JComboBox();
		cboPlan.setBounds(96, 72, 107, 20);
		contentPanel.add(cboPlan);
		
		lblElegirPlan = new JLabel("Elegir Plan");
		lblElegirPlan.setBounds(10, 75, 76, 14);
		contentPanel.add(lblElegirPlan);
		
		//Llenar plan
		llenacombo1();
	}
	
	void llenacombo1(){
		GestionPlan gp = new GestionPlan();
		ArrayList<Plan> lista = gp.listarPlanes();
		cboPlan.addItem("Seleccionar Plan");
		for(Plan p : lista){
			cboPlan.addItem(p.getNombre_plan());
		}
	}
	
}
