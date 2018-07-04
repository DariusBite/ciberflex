package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionReporteCategoria;
import mantenimientos.GestionReporteVideoMasVisto;
import modelado.ReporteCategoriasMasVistas;
import modelado.ReporteVideoMasVisto;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmReporteCategorias extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteCategorias frame = new FrmReporteCategorias();
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
	public FrmReporteCategorias() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 563, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategoriasMasVistas = new JLabel("Categorias mas vistas");
		lblCategoriasMasVistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoriasMasVistas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategoriasMasVistas.setBounds(10, 11, 527, 31);
		contentPane.add(lblCategoriasMasVistas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 527, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		modelo.addColumn("Categoria");
		modelo.addColumn("Veces visto");
		
		listar();
	}
	
	void listar(){
		int rowCount = modelo.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    modelo.removeRow(i);
		}
		GestionReporteCategoria gr = new GestionReporteCategoria();
		ArrayList<ReporteCategoriasMasVistas> lista = gr.listar();
		
		for(ReporteCategoriasMasVistas r : lista){
			Object[] fila = {
					r.getTitulo(),
					r.getVisto()
			};
			modelo.addRow(fila);
		}
	}

}
