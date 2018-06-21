package mantenimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import interfaces.ReporteMasUsuariosInterface;
import modelado.ReportePlanMasUsuarios;
import utils.MySQLConexion;

public class GestionReportePlanMasUsuarios implements ReporteMasUsuariosInterface{

	@Override
	public int reportePlan(int id_plan) {
		ArrayList<ReportePlanMasUsuarios> lista = new ArrayList<ReportePlanMasUsuarios>();
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try{
			
			con = MySQLConexion.getConexion();
			String sql = "";
			
			
		}catch(Exception e){
			System.out.println("Error al cargar driver " +e.getMessage());
		}finally {
			try{
				if(pst != null){
					pst.close();
				}
				if(con != null){
					con.close();
				}
				
			}catch(SQLException e){
				System.out.println("Error al cerrar");
			}
		}
		
		return rs;
	}

	


}
