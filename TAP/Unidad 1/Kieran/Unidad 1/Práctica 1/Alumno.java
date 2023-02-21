package practica2unidad1;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Alumno {

	private String nombre;
	private Fecha fechaNacimiento;
	private int edad;
	private int numControl;
	private float[] calif;

	public Alumno() {

	}

	public Alumno(String nombre, Fecha fechaNacimiento, int edad, int numControl, float[] calif) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = this.numControl = numControl;
		this.calif = calif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNumControl() {
		return numControl;
	}

	public void setNumControl(int numControl) {
		this.numControl = numControl;
	}

	public float[] getCalif() {
		return calif;
	}

	public void setCalif(float[] calif) {
		this.calif = calif;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", numControl=" + numControl + ", calif="
				+ Arrays.toString(calif) + "]";
	}

	/*
	 * public float calcularPromedio() { return ; }
	 */

	public float calcularPromedio() {
		float promedio = 0f;
		for (int i = 0; i < calif.length; i++) {
			float sumaPromedio = 0f;
			sumaPromedio += calif[i];
			promedio = sumaPromedio / calif.length;
		}
		return promedio;
	}

	public void calcularEdad() {
		Fecha fechaActual = new Fecha(02, 02, 2023);
		int diasTotalesHastaAhora = fechaActual.getDia() + (fechaActual.getMes() * 30) + (fechaActual.getAnio() * 365);

		int diasTotalesHastaFechaNacimiento = fechaNacimiento.getDia() + (fechaNacimiento.getMes() * 30)
				+ (fechaNacimiento.getAnio() * 365);

		int diferenciaDias = diasTotalesHastaAhora - diasTotalesHastaFechaNacimiento;

		this.setEdad(diferenciaDias / 365);
	}

	// Falta añadir funcionalidad para q se saque de alumnos reprobados si con esos
	// 5 puntos deja
	// de estar reprobado
	public void aumentarPuntos(String nombre) {
		try {
			if (nombre.equals(this.getNombre())) {
				System.out.println("ola babun");
				for (int i = 0; i < this.calif.length; i++) {
					if ((this.calif[i] + 5) > 100) {
						continue;
					} else {
						this.calif[i] = this.calif[i] + 5;
					}
				}
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Nombre ingresado no es válido");
		}

	}

}
