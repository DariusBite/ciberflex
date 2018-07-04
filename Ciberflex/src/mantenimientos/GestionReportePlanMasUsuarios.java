package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ReporteMasUsuariosInterface;
import modelado.ReportePlanMasUsuarios;
import utils.MySQLConexion;

public class GestionReportePlanMasUsuarios implements ReporteMasUsuariosInterface{

	@Override
	public ArrayList<ReportePlanMasUsuarios> reportePlan() {
		ArrayList<ReportePlanMasUsuarios> lista = new ArrayList<ReportePlanMasUsuarios>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try{
			con = MySQLConexion.getConexion();
			String sql = "call PRC_COMPRARPLANES()";
			pst = con.prepareStatement(sql);
			//Parametros para la sentencia
			
			
			rs = pst.executeQuery();
			//Acciones adicionales en caso de conusltas
			while(rs.next()){
				ReportePlanMasUsuarios u = new ReportePlanMasUsuarios();
				u.setNOMBRE_PLAN(rs.getString(1));
				u.setTotal(rs.getInt(2));
				lista.add(u);
			}
		}catch(Exception e){
			System.out.println("Error al cargar el driver " + e.getMessage());
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
		return lista;
	}

	@Override
	public ArrayList<ReportePlanMasUsuarios> reportePlan(int id) {
		ArrayList<ReportePlanMasUsuarios> lista = new ArrayList<ReportePlanMasUsuarios>();ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try{
			con = MySQLConexion.getConexion();
			String sql = "call PRC_COMPRARPLANES_PLAN(?)";
			pst = con.prepareStatement(sql);
			//Parametros para la sentencia
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			//Acciones adicionales en caso de conusltas
			while(rs.next()){
				ReportePlanMasUsuarios u = new ReportePlanMasUsuarios();
				u.setNOMBRE_PLAN(rs.getString(1));
				u.setTotal(rs.getInt(2));
				lista.add(u);
			}
		}catch(Exception e){
			System.out.println("Error al cargar el driver " + e.getMessage());
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
		return lista;
	}

	


}
