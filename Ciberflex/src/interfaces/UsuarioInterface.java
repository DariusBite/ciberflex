package interfaces;

import java.util.ArrayList;

import modelado.Usuario;

public interface UsuarioInterface {
	
	public int registraUsuario(Usuario u);
	
	public ArrayList<Usuario> emailExiste(String email);
	
	public Usuario validaAcceso(String email, String clave);
	
	public Usuario obtenerUsuario(int id);
	
	public int actualizarUsuario(Usuario u);
	
	public ArrayList<Usuario> listado();

}
