package practica2unidad1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class U1Practica1 {

	private Alumno[] alumnosTotal = new Alumno[10];
	private Alumno[] alumnosMenores = new Alumno[10];
	private Alumno[] alumnosReprobados = new Alumno[10];
	private Alumno[] alumnosFeb2002 = new Alumno[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		U1Practica1 app = new U1Practica1();

		String[] opcionesSeleccion = { "Dar de alta alumno", "Mostrar alumnos", "Mostrar alumnos menores de edad",
				"Mostrar alumnos reprobados", "Aumentar puntos", "Alumnos que nacieron en FEB/2002", "Salir" };

		String opcionSeleccionada = "SELECCIONAR";

		while (opcionSeleccionada != opcionesSeleccion[opcionesSeleccion.length - 1]) {

			opcionSeleccionada = JOptionPane.showInputDialog(null, "Qué desea hacer?", "Operaciones alumnos",
					JOptionPane.QUESTION_MESSAGE, null, opcionesSeleccion, "SELECCIONAR").toString();

			switch (opcionSeleccionada) {
			case "Dar de alta alumno":
				try {
					int posicionElegida = Integer
							.parseInt(JOptionPane.showInputDialog("En qué posición desea ingresar el alumno?"));
					if ((posicionElegida > app.alumnosTotal.length - 1) || (posicionElegida < 0)) {
						throw new IndexOutOfBoundsException();
					}

					if (app.alumnosTotal[posicionElegida] == null) {
						Alumno nuevoAlumno = app.altaAlumno();
						app.alumnosTotal[posicionElegida] = nuevoAlumno;
						if (app.alumnosTotal[posicionElegida].getEdad() < 18) {
							app.alumnosMenores[posicionElegida] = nuevoAlumno;
						}
						if (app.alumnosTotal[posicionElegida].calcularPromedio() < 70.0f) {
							app.alumnosReprobados[posicionElegida] = nuevoAlumno;
						}
						if ((app.alumnosTotal[posicionElegida].getFechaNacimiento().getAnio() == 2003)
								&& (app.alumnosTotal[posicionElegida].getFechaNacimiento().getMes() == 2)) {
							app.alumnosFeb2002[posicionElegida] = nuevoAlumno;
						}
					} else {
						throw new ExcepcionPosicionOcupada("La posición que eligió está ocupada");
					}
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null,
							"La posición que usted ingreso no es válida (índice no válido), ingrese otra posición.");
				} catch (ExcepcionPosicionOcupada e) {
					JOptionPane.showMessageDialog(null, "Esta posición ya está ocupada, ingrese otra posición");
				}
				break;
			case "Mostrar alumnos":
				app.mostrarAlumnos();
				break;
			case "Mostrar alumnos menores de edad":
				app.mostrarAlumnosMenores();
				break;
			case "Mostrar alumnos reprobados":
				app.mostrarAlumnosReprobados();
				break;
			case "Aumentar puntos":
				String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno:");
				app.aumentarPuntos(nombre);
				break;
			case "Alumnos que nacieron en FEB/2002":
				app.mostrarAlumnosFeb2002();
				break;
			case "Salir":
				break;
			default:
				break;
			}
		}

	}

	private Alumno altaAlumno() {

		Alumno nuevoAlumno = new Alumno();

		JLabel labelNombre = new JLabel("Nombre:");
		JLabel labelNumeroControl = new JLabel("Número de control:");
		JLabel labelCalificaciones = new JLabel("Calificaciones:");
		JTextField tfNombre = new JTextField();
		JTextField tfNumeroControl = new JTextField();
		JTextField tfCalificacion1 = new JTextField();
		JTextField tfCalificacion2 = new JTextField();
		JTextField tfCalificacion3 = new JTextField();

		Object[] componentesFormularioDatosPersonales = { labelNombre, tfNombre, labelNumeroControl, tfNumeroControl,
				labelCalificaciones, tfCalificacion1, tfCalificacion2, tfCalificacion3 };

		JOptionPane.showMessageDialog(null, componentesFormularioDatosPersonales, "Datos personales",
				JOptionPane.QUESTION_MESSAGE, null);

		float[] calificacionesNAlumno = { Float.parseFloat(tfCalificacion1.getText()),
				Float.parseFloat(tfCalificacion1.getText()), Float.parseFloat(tfCalificacion1.getText()) };

		JLabel labelDia = new JLabel("Dia:");
		JLabel labelMes = new JLabel("Mes:");
		JLabel labelAnio = new JLabel("Anio:");
		JTextField tfDia = new JTextField();
		JTextField tfMes = new JTextField();
		JTextField tfAnio = new JTextField();

		Object[] componentesFormularioFechaNac = { labelDia, tfDia, labelMes, tfMes, labelAnio, tfAnio };

		JOptionPane.showMessageDialog(null, componentesFormularioFechaNac, "Fecha de nacimiento",
				JOptionPane.QUESTION_MESSAGE, null);

		int alumnoDiaN = Integer.parseInt(tfDia.getText());
		int alumnoMesN = Integer.parseInt(tfMes.getText());
		int alumnoAnioN = Integer.parseInt(tfAnio.getText());
		Fecha fechaNacimientoNuevoAlumno = new Fecha(alumnoDiaN, alumnoMesN, alumnoAnioN);

		nuevoAlumno.setNombre(tfNombre.getText());
		nuevoAlumno.setNumControl(Integer.parseInt(tfNumeroControl.getText()));
		nuevoAlumno.setCalif(calificacionesNAlumno);
		nuevoAlumno.setFechaNacimiento(fechaNacimientoNuevoAlumno);
		nuevoAlumno.calcularEdad();
		nuevoAlumno.setEdad(nuevoAlumno.getEdad());

		tfNombre.setText("");
		tfNumeroControl.setText("");
		tfCalificacion1.setText("");
		tfCalificacion2.setText("");
		tfCalificacion3.setText("");
		tfDia.setText("");
		tfMes.setText("");
		tfAnio.setText("");

		return nuevoAlumno;

	}

	private void mostrarAlumnos() {

		String stringTodosAlumnos = "";
		int contadorAlumPasados = 0;
		for (int i = 0; i < alumnosTotal.length; i++) {
			if (alumnosTotal[i] != null) {
				String nombreAlumnoActual = alumnosTotal[i].getNombre();
				int numControlAlumnoActual = alumnosTotal[i].getNumControl();
				float[] califAlumnoActual = alumnosTotal[i].getCalif();
				int edadAlumnoActual = alumnosTotal[i].getEdad();
				String stringCalifAlumnoActual = califAlumnoActual[0] + ", " + califAlumnoActual[1] + ", "
						+ califAlumnoActual[2];
				String stringFechaAlumnoActual = alumnosTotal[i].getFechaNacimiento().toString();

				stringTodosAlumnos += "\nNombre: " + nombreAlumnoActual + ", No. control: "
						+ Integer.toString(numControlAlumnoActual) + ", Calificaciones: [" + stringCalifAlumnoActual
						+ "], " + "Edad: " + edadAlumnoActual + "\nFecha de nacimiento: " + stringFechaAlumnoActual;
			} else {
				contadorAlumPasados++;
				continue;
			}
		}

		if (contadorAlumPasados >= alumnosTotal.length) {
			JOptionPane.showMessageDialog(null, "No ha dado de alta ningún alumno");
		} else {
			JOptionPane.showMessageDialog(null, stringTodosAlumnos, "Todos los alumnos",
					JOptionPane.INFORMATION_MESSAGE, null);
		}
	}

	// *
	private void mostrarAlumnosMenores() {
		String stringTodosAlumnos = "";

		int contadorAlumPasados = 0;
		for (int i = 0; i < alumnosMenores.length; i++) {

			if (alumnosMenores[i] != null) {
				String nombreAlumnoMActual = alumnosMenores[i].getNombre();
				int numControlAlumnoMActual = alumnosMenores[i].getNumControl();
				float[] califAlumnoMActual = alumnosMenores[i].getCalif();
				int edadAlumnoMActual = alumnosMenores[i].getEdad();
				String stringCalifAlumnoMActual = califAlumnoMActual[0] + ", " + califAlumnoMActual[1] + ", "
						+ califAlumnoMActual[2];
				String stringFechaAlumnoMActual = alumnosMenores[i].getFechaNacimiento().toString();

				stringTodosAlumnos += "\nNombre: " + nombreAlumnoMActual + ", No. control: " + numControlAlumnoMActual
						+ ", Calificaciones: [" + stringCalifAlumnoMActual + "], " + "Edad: " + edadAlumnoMActual
						+ "\nFecha de nacimiento: " + stringFechaAlumnoMActual;
			} else {
				contadorAlumPasados++;
				continue;
			}

		}

		if (contadorAlumPasados >= alumnosTotal.length) {
			JOptionPane.showMessageDialog(null, "No ha dado de alta ningún alumno");
		} else {
			JOptionPane.showMessageDialog(null, stringTodosAlumnos, "Todos los alumnos",
					JOptionPane.INFORMATION_MESSAGE, null);
		}
	}

	// *
	private void mostrarAlumnosReprobados() {
		String stringAlumnosReprobados = "";

		int contadorAlumPasados = 0;
		for (int i = 0; i < alumnosReprobados.length; i++) {

			if (alumnosReprobados[i] != null) {
				String nombreAlumnoRActual = alumnosReprobados[i].getNombre();
				int numControlAlumnoRActual = alumnosReprobados[i].getNumControl();
				float[] califAlumnoRActual = alumnosReprobados[i].getCalif();
				int edadAlumnoRActual = alumnosReprobados[i].getEdad();
				String stringCalifAlumnoRActual = califAlumnoRActual[0] + ", " + califAlumnoRActual[1] + ", "
						+ califAlumnoRActual[2];
				String stringFechaAlumnoRActual = alumnosReprobados[i].getFechaNacimiento().toString();

				stringAlumnosReprobados += "\nNombre: " + nombreAlumnoRActual + ", No. control: "
						+ Integer.toString(numControlAlumnoRActual) + ", Calificaciones: [" + stringCalifAlumnoRActual
						+ "], " + "Edad: " + Integer.toString(edadAlumnoRActual) + "\nFecha de nacimiento: "
						+ stringFechaAlumnoRActual;
			} else {
				contadorAlumPasados++;
				continue;
			}

		}

		if (contadorAlumPasados >= alumnosTotal.length) {
			JOptionPane.showMessageDialog(null, "No ha dado de alta ningún alumno");

		} else {
			JOptionPane.showMessageDialog(null, stringAlumnosReprobados, "Todos los alumnos",
					JOptionPane.INFORMATION_MESSAGE, null);
		}
	}

	public void aumentarPuntos(String nombre) {
		// System.out.println(nombre);
			for (int i = 0; i < alumnosTotal.length; i++) {
				// System.out.println(nombre);
				alumnosTotal[i].aumentarPuntos(nombre);
			}
	}

	public void mostrarAlumnosFeb2002() {
		String stringAlumnosFeb2002 = "";

		int contadorAlumPasados = 0;
		for (int i = 0; i < alumnosFeb2002.length; i++) {

			if (alumnosFeb2002[i] != null) {
				String nombreAlumnoRActual = alumnosFeb2002[i].getNombre();
				int numControlAlumnoRActual = alumnosFeb2002[i].getNumControl();
				float[] califAlumnoRActual = alumnosFeb2002[i].getCalif();
				int edadAlumnoRActual = alumnosFeb2002[i].getEdad();
				String stringCalifAlumnoRActual = califAlumnoRActual[0] + ", " + califAlumnoRActual[1] + ", "
						+ califAlumnoRActual[2];
				String stringFechaAlumnoRActual = alumnosFeb2002[i].getFechaNacimiento().toString();

				stringAlumnosFeb2002 += "\nNombre: " + nombreAlumnoRActual + ", No. control: "
						+ Integer.toString(numControlAlumnoRActual) + ", Calificaciones: [" + stringCalifAlumnoRActual
						+ "], " + "Edad: " + Integer.toString(edadAlumnoRActual) + "\nFecha de nacimiento: "
						+ stringFechaAlumnoRActual;
			} else {
				contadorAlumPasados++;
				continue;
			}

		}

		if (contadorAlumPasados >= alumnosTotal.length) {
			JOptionPane.showMessageDialog(null, "No ha dado de alta ningún alumno");

		} else {
			JOptionPane.showMessageDialog(null, stringAlumnosFeb2002, "Todos los alumnos",
					JOptionPane.INFORMATION_MESSAGE, null);
		}
	}

}
