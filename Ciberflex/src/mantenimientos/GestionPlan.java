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
		   
		   rs = pst.executeQuery(); // tipo de ejecuci�n
		   
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

	@Override
	public int registraPlanes(Plan p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "insert into PLANES(NOMBRE_PLAN, PRECIO_PLAN, DESCRIPCION_PLAN) values (?,?,?)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getNombre_plan());
			pst.setDouble(2, p.getPrecio_plan());
			pst.setString(3, p.getDescripcion_plan());
			
			rs = pst.executeUpdate();
			
		} catch(Exception e){
			System.out.println("Error en la Gesti�n Planes" + e.getMessage());;
		}finally{
			try{
				if(pst!=null) pst.close();
				if(pst!=null) con.close();
			}catch(SQLException e){
				System.out.println("Error al cerrar");
			}
		}
		return rs;
	}
	
	public int actualizar(Plan p) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try{
			con=MySQLConexion.getConexion();
			
			//insert into tb_usuarios values (null,'Tito', 'Siber','U001', '10001', curdate(),2,1);
			String sql="update PLANES set NOMBRE_PLAN=?, PRECIO_PLAN=?,DESCRIPCION_PLAN=? where ID_PLAN=?";
			
			pst=con.prepareStatement(sql);
			//parametros
			pst.setString(1,p.getNombre_plan());
			pst.setDouble(2,p.getPrecio_plan());
			pst.setString(3,p.getDescripcion_plan());
			pst.setInt(4,p.getId_plan());
					
			rs=pst.executeUpdate();
		}catch (Exception e){
			System.out.println("Error de sentencia" + e.getMessage());
		}finally {
			try{
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}catch (SQLException e){
				System.out.println("Error al cerrar");
			}
		}
		return rs;
	}

}
