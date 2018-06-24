package interfaces;

import modelado.UsuariosContenidos;

public interface UsuariosContenidosInterface {
	
	public int registrar(UsuariosContenidos uc);
	
	public int registrarPuntuacion(UsuariosContenidos uc);
	
	public UsuariosContenidos obtener(int id_u, int id_c);


}
