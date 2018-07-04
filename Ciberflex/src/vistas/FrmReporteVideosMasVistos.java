package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionReporteVideoMasVisto;
import modelado.ReporteVideoMasVisto;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmReporteVideosMasVistos extends JFrame {

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
					FrmReporteVideosMasVistos frame = new FrmReporteVideosMasVistos();
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
	public FrmReporteVideosMasVistos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVideosMasVistos = new JLabel("Videos mas vistos");
		lblVideosMasVistos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVideosMasVistos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVideosMasVistos.setBounds(10, 11, 672, 20);
		contentPane.add(lblVideosMasVistos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 672, 385);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		modelo.addColumn("Contenido");
		modelo.addColumn("Video");
		modelo.addColumn("Veces visto");
		
		listar();
	}
	
	void listar(){
		int rowCount = modelo.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    modelo.removeRow(i);
		}
		GestionReporteVideoMasVisto gr = new GestionReporteVideoMasVisto();
		ArrayList<ReporteVideoMasVisto> lista = gr.listar();
		
		for(ReporteVideoMasVisto r : lista){
			Object[] fila = {
					r.getCont(),
					r.getVid(),
					r.getVisto()
			};
			modelo.addRow(fila);
		}
	}
}
