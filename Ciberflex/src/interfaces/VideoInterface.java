package interfaces;

import java.util.ArrayList;

import modelado.Video;

public interface VideoInterface {
	
	public int registrarVideo (Video v);
	
	public ArrayList<Video> listarVideosencontenido(int id);
	
	public ArrayList<Video> listarVideosencontenidoactivos(int id);
	
	public ArrayList<Video> listar();

}
