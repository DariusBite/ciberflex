package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VideoInterface;
import modelado.Video;
import utils.MySQLConexion;

public class GestionVideo implements VideoInterface{

	@Override
	public int registrarVideo(Video v) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "insert into VIDEOS(ID_CONTENIDO, TITULO_VIDEO, TEMPORADA_VIDEO, DESCRIPCION_VIDEO, URL_VIDEO, URL_IMAGEN_VIDEO) values (?,?,?,?,?,?)";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, v.getId_contenido());
			pst.setString(2, v.getTitulo_video());
			if(v.getTemporada_video() == 0) pst.setString(3, null);
			else pst.setInt(3, v.getTemporada_video());
			pst.setString(4, v.getDescripcion_video());
			pst.setString(5, v.getUrl_video());
			pst.setString(6, v.getUrl_imagen_video());
			
			rs = pst.executeUpdate();
			
		} catch(Exception e){
			System.out.println("Error en la Gestión Contenido videos " + e.getMessage());;
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
	public ArrayList<Video> listarVideosencontenido(int id) {
		ArrayList<Video> lista = new ArrayList<Video>();
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from VIDEOS where ID_CONTENIDO = ?"; // sentencia sql
	
		   pst = con.prepareStatement(sql);
		   
		   // parámetros según la sentencia	}	 	   
		   pst.setInt(1, id);	  
		   
		   rs = pst.executeQuery(); // tipo de ejecución
		   
		   // Acciones adicionales en caso de consultas
		   while (rs.next()){
			   Video v = new Video();
			   v.setId_video(rs.getInt(1));
			   v.setId_contenido(id);
			   v.setTitulo_video(rs.getString(3));
			   v.setTemporada_video(rs.getInt(4));
			   v.setDescripcion_video(rs.getString(5));
			   v.setUrl_video(rs.getString(6));
			   v.setUrl_imagen_video(rs.getString(7));
			   lista.add(v);
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
	
	public ArrayList<Video> listar(){
		ArrayList<Video> lista = new ArrayList<Video>();
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from videos"; // sentencia sql

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia		   
		   
		   rs = pst.executeQuery(); // tipo de ejecución
		   
		   // Acciones adicionales en caso de consultas
		   while (rs.next()){
			   Video v = new Video();
			   v.setId_video(rs.getInt(1));
			   v.setTitulo_video(rs.getString(3));
			   lista.add(v);
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
