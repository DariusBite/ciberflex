package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioInterface;
import modelado.Usuario;
import utils.MySQLConexion;

public class GestionUsuario implements UsuarioInterface{

	@Override
	public int registraUsuario(Usuario u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "insert into USUARIOS(EMAIL_USUARIO, PASSWORD_USUARIO, NOMBRE_USUARIO, APELLIDO_USUARIO) values (?,?,?,?)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getNombre());
			pst.setString(4, u.getApellido());
			
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
	public ArrayList<Usuario> emailExiste(String email) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select EMAIL_USUARIO from USUARIOS where EMAIL_USUARIO = ?"; // sentencia sql
	
		   pst = con.prepareStatement(sql);
		   
		   // parámetros según la sentencia	}	 	   
		   pst.setString(1, email);	  
		   
		   rs = pst.executeQuery(); // tipo de ejecución
		   
		   // Acciones adicionales en caso de consultas
		   while (rs.next()){
			   Usuario u = new Usuario();
			   lista.add(u);
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
	public Usuario validaAcceso(String email, String clave) {
		Usuario u = null;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from USUARIOS where EMAIL_USUARIO = ? and PASSWORD_USUARIO = ?"; // sentencia sql

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia		   
		   pst.setString(1, email);		   
		   pst.setString(2, clave);
		   rs = pst.executeQuery(); // tipo de ejecución
		   while(rs.next()){
			   u = new Usuario();
			   u.setId(rs.getInt(1));
			   u.setEmail(rs.getString(2));
			   u.setPassword(rs.getString(3));
			   u.setNombre(rs.getString(4));
			   u.setApellido(rs.getString(5));
			   u.setFechanacimiento(rs.getString(6));
			   u.setDireccion(rs.getString(7));
			   u.setCiudad(rs.getString(8));
			   u.setProvincia(rs.getString(9));
			   u.setTelefono(rs.getString(10));
			   u.setTipo(rs.getString(11));
			   u.setIdPlan(rs.getInt(12));
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
		return u;
	}

	@Override
	public Usuario obtenerUsuario(int id) {
		Usuario u = null;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from USUARIOS where ID_USUARIO = ?"; // sentencia sql

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia		   
		   pst.setInt(1, id);		 
		   rs = pst.executeQuery(); // tipo de ejecución
		   while(rs.next()){
			   u = new Usuario();
			   u.setId(rs.getInt(1));
			   u.setEmail(rs.getString(2));
			   u.setPassword(rs.getString(3));
			   u.setNombre(rs.getString(4));
			   u.setApellido(rs.getString(5));
			   u.setFechanacimiento(rs.getString(6));
			   u.setDireccion(rs.getString(7));
			   u.setCiudad(rs.getString(8));
			   u.setProvincia(rs.getString(9));
			   u.setTelefono(rs.getString(10));
			   u.setTipo(rs.getString(11));
			   u.setIdPlan(rs.getInt(12));
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
		return u;
	}

	@Override
	public int actualizarUsuario(Usuario u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "update USUARIOS set PASSWORD_USUARIO=?, NOMBRE_USUARIO=?, APELLIDO_USUARIO=?, FECHANACIMIENTO_USUARIO=?, DIRECCION_USUARIO=?, CIUDAD_USUARIO=?, PROVINCIA_USUARIO=?, TELEFONO_USUARIO=?, ID_PLAN=? where ID_USUARIO=?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getPassword());
			pst.setString(2, u.getNombre());
			pst.setString(3, u.getApellido());
			pst.setString(4, u.getFechanacimiento());
			pst.setString(5, u.getDireccion());
			pst.setString(6, u.getCiudad());
			pst.setString(7, u.getProvincia());
			pst.setString(8, u.getTelefono());
			pst.setInt(9, u.getIdPlan());
			pst.setInt(10, u.getId());
			
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

}
