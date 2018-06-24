package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.UsuariosVideosInterface;
import modelado.UsuariosVideos;
import utils.MySQLConexion;

public class GestionUsuariosVideos implements UsuariosVideosInterface{

	@Override
	public int registrar(UsuariosVideos uv) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "insert into USUARIOSCONTENIDOS(ID_USUARIO, ID_CONTENIDO, 1) values (?,?)";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, uv.getId_usuario());
			pst.setInt(2, uv.getId_video());
			
			rs = pst.executeUpdate();
			
		} catch(Exception e){
			System.out.println("Error en la Gestión Usuarios Videos registrar " + e.getMessage());;
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
	public int registrarVeces(UsuariosVideos uv) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "update USUARIOSVIDEOS set VECESVISTO = ? where ID_USUARIO = ? and ID_VIDEO = ?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, uv.getVecesvisto());
			pst.setInt(2, uv.getId_usuario());
			pst.setInt(3, uv.getId_video());
			
			rs = pst.executeUpdate();
			
		} catch(Exception e){
			System.out.println("Error en la Gestión Usuarios Videos registrar veces" + e.getMessage());;
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
	public UsuariosVideos obtener(int id_v, int id_u) {
		UsuariosVideos uv = null;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from USUARIOSVIDEOS where ID_USUARIO = ? and ID_VIDEO = ?"; // sentencia sql

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia		   
		   pst.setInt(1, id_u);	   
		   pst.setInt(2, id_v);		 
		   rs = pst.executeQuery(); // tipo de ejecución
		   while(rs.next()){
			   uv = new UsuariosVideos();
			   uv.setId_usuario(id_u);
			   uv.setId_video(id_v);
			   uv.setVecesvisto(rs.getInt(3));
		   }
		} catch (Exception e) {
		   System.out.println("Error en la Gestión Usuarios videos obtener " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
		
		//--
		return uv;
	}

}
