package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import interfaces.ContenidoCategoriaInterface;
import modelado.ContenidoCategoria;
import utils.MySQLConexion;

public class GestionContenidoCategoria implements ContenidoCategoriaInterface{

	@Override
	public int registarContenidoCategoria(ContenidoCategoria cc) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "insert into CONTENIDOCATEGORIA(ID_CONTENIDO, ID_CATEGORIA) values (?,?)";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, cc.getId_contenido());
			pst.setInt(2, cc.getId_categoria());
			
			rs = pst.executeUpdate();
			
		} catch(Exception e){
			System.out.println("Error en la Gestión Contenido Categoria " + e.getMessage());;
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
	public int remove(int id) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql = "delete from CONTENIDOCATEGORIA where ID_CONTENIDO = ?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			rs = pst.executeUpdate();
			
		} catch(Exception e){
			System.out.println("Error en la Gestión Contenido Categoria " + e.getMessage());;
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
