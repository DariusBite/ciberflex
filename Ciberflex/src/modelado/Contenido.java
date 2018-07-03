package modelado;

public class Contenido {
	int id_contenido, estado;
    public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	String titulo_contenido, descripcion_contenido, tipo_contenido, url_image_contenido;
	public int getId_contenido() {
		return id_contenido;
	}
	public void setId_contenido(int id_contenido) {
		this.id_contenido = id_contenido;
	}
	public String getTitulo_contenido() {
		return titulo_contenido;
	}
	public void setTitulo_contenido(String titulo_contenido) {
		this.titulo_contenido = titulo_contenido;
	}
	public String getDescripcion_contenido() {
		return descripcion_contenido;
	}
	public void setDescripcion_contenido(String descripcion_contenido) {
		this.descripcion_contenido = descripcion_contenido;
	}
	public String getTipo_contenido() {
		return tipo_contenido;
	}
	public void setTipo_contenido(String tipo_contenido) {
		this.tipo_contenido = tipo_contenido;
	}
	public String getUrl_image_contenido() {
		return url_image_contenido;
	}
	public void setUrl_image_contenido(String url_image_contenido) {
		this.url_image_contenido = url_image_contenido;
	}
}
