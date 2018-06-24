package interfaces;

import modelado.UsuariosVideos;

public interface UsuariosVideosInterface {
	
	public int registrar(UsuariosVideos uv);
	
	public int registrarVeces(UsuariosVideos uv);
	
	public UsuariosVideos obtener(int id_v, int id_u);

}
