package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.CategoriaInterface;
import modelado.Categoria;
import utils.MySQLConexion;

public class GestionCategoria implements CategoriaInterface{

	@Override
	public int registarCategoria(Categoria c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "insert into CATEGORIAS(TITULO_CATEGORIA, DESCRIPCION_CATEGORIA) values (?,?)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, c.getTitulo_categoria());
			pst.setString(2, c.getDescripcion_categoria());
			
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
	public ArrayList<Categoria> listarCategorias() {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from CATEGORIAS"; // sentencia sql
	
		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia		   
		   
		   rs = pst.executeQuery(); // tipo de ejecución
		   
		   // Acciones adicionales en caso de consultas
		   while (rs.next()){
			   Categoria c = new Categoria();
			   c.setId_categoria(rs.getInt(1));
			   c.setTitulo_categoria(rs.getString(2));
			   c.setDescripcion_categoria(rs.getString(3));
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
	public Categoria obtenerCategoriaXTitulo(String titulo) {
		Categoria c = null;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "select * from CATEGORIAS where TITULO_CATEGORIA = ?"; // sentencia sql

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia		   
		   pst.setString(1, titulo);		 
		   rs = pst.executeQuery(); // tipo de ejecución
		   while(rs.next()){
			   c = new Categoria();
			   c.setId_categoria(rs.getInt(1));
			   c.setTitulo_categoria(titulo);
			   c.setDescripcion_categoria(rs.getString(3));
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
		return c;
	}

	@Override
	public ArrayList<Categoria> listarCategoriasenContenido(int id) {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "call PRC_CATEGORIASENCONTENIDO(?)"; // sentencia sql

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia		   
		   pst.setInt(1, id);		 
		   rs = pst.executeQuery(); // tipo de ejecución
		   while(rs.next()){
			   Categoria c = new Categoria();
			   c.setId_categoria(rs.getInt(1));
			   c.setTitulo_categoria(rs.getString(2));
			   c.setDescripcion_categoria(rs.getString(3));
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
		
		//--
		return lista;
	}
	
	public int actualizar(Categoria c) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		try{
			con=MySQLConexion.getConexion();
			
			//insert into tb_usuarios values (null,'Tito', 'Siber','U001', '10001', curdate(),2,1);
			String sql="update CATEGORIAS set TITULO_CATEGORIA=?, DESCRIPCION_CATEGORIA=? where ID_CATEGORIA=?";
			
			pst=con.prepareStatement(sql);
			//parametros
			pst.setString(1,c.getTitulo_categoria());
			pst.setString(2,c.getDescripcion_categoria());
			pst.setInt(3,c.getId_categoria());
					
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
