package interfaces;

import java.util.ArrayList;

import modelado.Categoria;

public interface CategoriaInterface {
	
	public int registarCategoria(Categoria c);
	
	public ArrayList<Categoria> listarCategorias();
	
	public Categoria obtenerCategoriaXTitulo(String titulo);
	
	public ArrayList<Categoria> listarCategoriasenContenido(int id);
	
	public int actualizar (Categoria c);

}
