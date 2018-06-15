package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ContenidoInterface;
import modelado.Contenido;
import utils.MySQLConexion;

public class GestionContenido implements ContenidoInterface{

	@Override
	public int registrarContenido(Contenido c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "insert into CONTENIDOS(TITULO_CONTENIDO, DESCRIPCION_CONTENIDO, TIPO_CONTENIDO, URLIMAGE_CONTENIDO) values (?,?,?,?)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, c.getTitulo_contenido());
			pst.setString(2, c.getDescripcion_contenido());
			pst.setString(3, c.getTipo_contenido());
			pst.setString(4, c.getUrl_image_contenido());
			
			rs = pst.executeUpdate();
			
		} catch(Exception e){
			System.out.println("Error en la Gestión Usuario" + e.getMessage());;
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

	@Override
	public int ultimoIdContenido() {
		int id =  0;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "SELECT ID_CONTENIDO FROM CONTENIDOS ORDER BY ID_CONTENIDO DESC LIMIT 1"; // sentencia sql
	
		   pst = con.prepareStatement(sql);	 
		   rs = pst.executeQuery(); // tipo de ejecución
		   while(rs.next()){
			   id = rs.getInt(1);
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
		
		//--
		return id;
	}
	
	public ArrayList<Contenido> listarContenido(){
		ArrayList<Contenido> lista = new ArrayList<Contenido>();
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from 	CONTENIDOS"; // sentencia sql

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia		   
		   
		   rs = pst.executeQuery(); // tipo de ejecución
		   
		   // Acciones adicionales en caso de consultas
		   while (rs.next()){
			   Contenido c = new Contenido();
			   c.setId_contenido(rs.getInt(1));
			   c.setTitulo_contenido(rs.getString(2));
			   c.setDescripcion_contenido(rs.getString(3));
			   c.setTipo_contenido(rs.getString(4));
			   c.setUrl_image_contenido(rs.getString(5));
			   lista.add(c);
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
	public Contenido obtenerContenido(int id) {
		Contenido c = null;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from 	CONTENIDOS where ID_CONTENIDO = ?"; // sentencia sql

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia	
		   pst.setInt(1, id);	   
		   
		   rs = pst.executeQuery(); // tipo de ejecución
		   
		   // Acciones adicionales en caso de consultas
		   while (rs.next()){
			   c = new Contenido();
			   c.setId_contenido(rs.getInt(1));
			   c.setTitulo_contenido(rs.getString(2));
			   c.setDescripcion_contenido(rs.getString(3));
			   c.setTipo_contenido(rs.getString(4));
			   c.setUrl_image_contenido(rs.getString(5));
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

		return c;
	}

}
