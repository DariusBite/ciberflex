package interfaces;

import java.util.ArrayList;

import modelado.Contenido;

public interface ContenidoInterface {
	public int registrarContenido(Contenido c);
	public int ultimoIdContenido();
	public ArrayList<Contenido> listarContenido();
	public Contenido obtenerContenido(int id);
	public ArrayList<Contenido> buscarContenido(String texto);
}
