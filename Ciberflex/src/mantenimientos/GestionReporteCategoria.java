package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ReporteCategoriasMasVistasInterface;
import modelado.ReporteCategoriasMasVistas;
import modelado.ReporteVideoMasVisto;
import utils.MySQLConexion;

public class GestionReporteCategoria implements ReporteCategoriasMasVistasInterface{

	@Override
	public ArrayList<ReporteCategoriasMasVistas> listar() {
		ArrayList<ReporteCategoriasMasVistas> lista = new ArrayList<ReporteCategoriasMasVistas>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		
		try{
			con = MySQLConexion.getConexion();
			String sql = "call PRC_CATEGOMASVISTO()";
			pst = con.prepareStatement(sql);
			//Parametros para la sentencia
			
			
			rs = pst.executeQuery();
			//Acciones adicionales en caso de conusltas
			while(rs.next()){
				ReporteCategoriasMasVistas u = new ReporteCategoriasMasVistas();
				u.setTitulo(rs.getString(1));
				u.setVisto(rs.getInt(2));
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
