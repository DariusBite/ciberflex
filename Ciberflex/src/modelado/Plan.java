package modelado;

public class Plan {
	private int id_plan, estado;
	private double precio_plan; 
	private String nombre_plan, descripcion_plan;
	
	public int getId_plan() {
		return id_plan;
	}
	public void setId_plan(int id_plan) {
		this.id_plan = id_plan;
	}
	public double getPrecio_plan() {
		return precio_plan;
	}
	public void setPrecio_plan(double precio_plan) {
		this.precio_plan = precio_plan;
	}
	public String getNombre_plan() {
		return nombre_plan;
	}
	public void setNombre_plan(String nombre_plan) {
		this.nombre_plan = nombre_plan;
	}
	public String getDescripcion_plan() {
		return descripcion_plan;
	}
	public void setDescripcion_plan(String descripcion_plan) {
		this.descripcion_plan = descripcion_plan;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
