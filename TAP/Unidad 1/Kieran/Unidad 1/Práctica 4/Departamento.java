package practica4u1;

import java.util.Arrays;

public class Departamento {

	private String nombre;
	private String responsable;
	private Articulo[] articulos;
	
	public Departamento(String nombre, String responsable, Articulo[] articulos) {
		super();
		this.nombre = nombre;
		this.responsable = responsable;
		this.articulos = articulos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Articulo[] getArticulos() {
		return articulos;
	}

	public void setArticulos(Articulo[] articulos) {
		this.articulos = articulos;
	}

	@Override
	public String toString() {
		return "Departamento [nombre=" + nombre + ", responsable=" + responsable + ", articulos="
				+ Arrays.toString(articulos) + "]";
	}
}
