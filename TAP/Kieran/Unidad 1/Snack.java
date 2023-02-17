package practica6u1;

public class Snack {

	String nombre;
	float precio;
	char tipo;
	int inv;
	/*
	 * Tipos: a - Chocolates b - Papas y/o fritos c - Chicles
	 */

	public Snack(String nombre, char tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		asignarPrecio();
		this.inv = 5;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public int getInv() {
		return inv;
	}

	public void setInv(int inv) {
		this.inv = inv;
	}

	public void asignarPrecio() {
		switch (tipo) {
		case 'a':
			this.setPrecio(24.00f);
			break;
		case 'b':
			this.setPrecio(15.00f);
			break;
		case 'c':
			this.setPrecio(8.00f);
			break;
		default:
			break;
		}
	}

	// Este método se utilizará en la opción 1. Pedir snack
	public void retirarSnack() {
		setInv(getInv() - 1);
	}

	// Este método se utilizará en la opción 4. Rellenar snacks
	public void rellenarSnacks(int nSnacks) {
		setInv(getInv() + nSnacks);
	}

	// Este método se utilizará en la opción 2. Mostrar golosinas
	@Override
	public String toString() {
		return "nombre=" + nombre + ", precio=" + precio + ", inv=" + inv;
	}

}
