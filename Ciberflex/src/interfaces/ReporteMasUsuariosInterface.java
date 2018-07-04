package interfaces;


import modelado.ReportePlanMasUsuarios;
import java.util.ArrayList;

public interface ReporteMasUsuariosInterface {
	
	//Metodo para el reporte
	public ArrayList<ReportePlanMasUsuarios> reportePlan();
	public ArrayList<ReportePlanMasUsuarios> reportePlan(int id);

}
