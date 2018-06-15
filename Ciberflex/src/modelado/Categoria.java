package modelado;

public class Categoria {
	private int id_categoria;
	private String titulo_categoria, descripcion_categoria;
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getTitulo_categoria() {
		return titulo_categoria;
	}
	public void setTitulo_categoria(String titulo_categoria) {
		this.titulo_categoria = titulo_categoria;
	}
	public String getDescripcion_categoria() {
		return descripcion_categoria;
	}
	public void setDescripcion_categoria(String descripcion_categoria) {
		this.descripcion_categoria = descripcion_categoria;
	}
}
