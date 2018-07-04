package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ReporteVideoMasVistoInterface;
import modelado.ReportePlanMasUsuarios;
import modelado.ReporteVideoMasVisto;
import utils.MySQLConexion;

public class GestionReporteVideoMasVisto implements ReporteVideoMasVistoInterface{

	@Override
	public ArrayList<ReporteVideoMasVisto> listar() {
		ArrayList<ReporteVideoMasVisto> lista = new ArrayList<ReporteVideoMasVisto>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try{
			con = MySQLConexion.getConexion();
			String sql = "call PRC_VIDEOMASVISTO()";
			pst = con.prepareStatement(sql);
			//Parametros para la sentencia
			
			
			rs = pst.executeQuery();
			//Acciones adicionales en caso de conusltas
			while(rs.next()){
				ReporteVideoMasVisto u = new ReporteVideoMasVisto();
				u.setCont(rs.getString(1));
				u.setVid(rs.getString(2));
				u.setVisto(rs.getInt(3));
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
