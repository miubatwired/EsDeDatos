package practica4u1;

public class Articulo {

	private String descripcion;
	private int cantidad;
	private float precio;
	private Fecha fechaCaducidad;
	
	public Articulo(String descripcion, int cantidad, float precio, Fecha fechaCaducidad) {
		super();
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Fecha getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Fecha fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	public String toString() {
		return "Articulo [descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", fechaCaducidad=" + fechaCaducidad + "]";
	}
	
	
}
