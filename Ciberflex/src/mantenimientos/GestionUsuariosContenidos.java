package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.UsuariosContenidosInterface;
import modelado.UsuariosContenidos;
import utils.MySQLConexion;

public class GestionUsuariosContenidos implements UsuariosContenidosInterface{

	@Override
	public int registrar(UsuariosContenidos uc) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "insert into USUARIOSCONTENIDOS(ID_USUARIO, ID_CONTENIDO) values (?,?)";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, uc.getId_usuario());
			pst.setInt(2, uc.getId_contenido());
			
			rs = pst.executeUpdate();
			
		} catch(Exception e){
			System.out.println("Error en la Gestión Usuarios Contenidos " + e.getMessage());;
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
	public int registrarPuntuacion(UsuariosContenidos uc) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "update USUARIOSCONTENIDOS set PUNTUACION = ? where ID_USUARIO = ? and ID_CONTENIDO = ?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, uc.getPuntuacion());
			pst.setInt(2, uc.getId_usuario());
			pst.setInt(3, uc.getId_contenido());
			
			rs = pst.executeUpdate();
			
		} catch(Exception e){
			System.out.println("Error en la Gestión Usuarios Contenidos registrar Puntuacion" + e.getMessage());;
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
	public UsuariosContenidos obtener(int id_u, int id_c) {
		UsuariosContenidos uc = null;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from USUARIOSCONTENIDOS where ID_USUARIO = ? and ID_CONTENIDO = ?"; // sentencia sql

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia		   
		   pst.setInt(1, id_u);	   
		   pst.setInt(2, id_c);		 
		   rs = pst.executeQuery(); // tipo de ejecución
		   while(rs.next()){
			   uc = new UsuariosContenidos();
			   uc.setId_usuario(id_u);
			   uc.setId_contenido(id_c);
			   uc.setPuntuacion(rs.getInt(3));
		   }
		} catch (Exception e) {
		   System.out.println("Error en la Gestión Usuarios Contenidos obtener " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
		
		//--
		return uc;
	}

}
