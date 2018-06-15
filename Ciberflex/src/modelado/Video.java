package modelado;

public class Video {
	private int id_video, id_contenido, temporada_video;
    private String titulo_video, descripcion_video, url_video, url_imagen_video;
	public int getId_video() {
		return id_video;
	}
	public void setId_video(int id_video) {
		this.id_video = id_video;
	}
	public int getId_contenido() {
		return id_contenido;
	}
	public void setId_contenido(int id_contenido) {
		this.id_contenido = id_contenido;
	}
	public int getTemporada_video() {
		return temporada_video;
	}
	public void setTemporada_video(int temporada_video) {
		this.temporada_video = temporada_video;
	}
	public String getTitulo_video() {
		return titulo_video;
	}
	public void setTitulo_video(String titulo_video) {
		this.titulo_video = titulo_video;
	}
	public String getDescripcion_video() {
		return descripcion_video;
	}
	public void setDescripcion_video(String descripcion_video) {
		this.descripcion_video = descripcion_video;
	}
	public String getUrl_video() {
		return url_video;
	}
	public void setUrl_video(String url_video) {
		this.url_video = url_video;
	}
	public String getUrl_imagen_video() {
		return url_imagen_video;
	}
	public void setUrl_imagen_video(String url_imagen_video) {
		this.url_imagen_video = url_imagen_video;
	}
}
