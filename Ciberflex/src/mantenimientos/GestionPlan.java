package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.PlanInterface;
import modelado.Plan;
import utils.MySQLConexion;

public class GestionPlan implements PlanInterface{

	@Override
	public ArrayList<Plan> listarPlanes() {
		ArrayList<Plan> lista = new ArrayList<Plan>();
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "SELECT * FROM PLANES"; // sentencia sql
	
		   pst = con.prepareStatement(sql);
		   
		   rs = pst.executeQuery(); // tipo de ejecución
		   
		   // Acciones adicionales en caso de consultas
		   while (rs.next()){
			   Plan p = new Plan();
			   p.setId_plan(rs.getInt(1));
			   p.setNombre_plan(rs.getString(2));
			   p.setPrecio_plan(rs.getDouble(3));
			   p.setDescripcion_plan(rs.getString(4));
			   lista.add(p);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
	
		return lista;
		
	}

}
