package practica4u1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Elegir con enteros, no con strings
 * Opcion 1: 1 departamento
 * Opcion 2: 1 artículo para el cual eliges el departamento
 */
public class U1Practica4 {

	public static void main(String[] args) {

		Departamento[] departamentos = new Departamento[4];
		float[] montosInvDeps = new float[4];

		String[] opcionesSeleccion = { "1.- Registrar departamento", "2.- Registrar artículo en un departamento",
				"3.- Mostrar departamentos", "4.- Inventario por departamentos", "5.- Buscar por artículo",
				"6.- Terminar" };

		int indiceOpcionSeleccionada;

		int departamentosCreados = 0;
		int[] articulosCreados = { 0, 0, 0, 0 };
		boolean isLleno;
		do {

			indiceOpcionSeleccionada = Integer.parseInt(JOptionPane
					.showInputDialog(null, "Qué desea hacer?", "Operaciones departamentos",
							JOptionPane.QUESTION_MESSAGE, null, opcionesSeleccion, "SELECCIONAR")
					.toString().substring(0, 1));

			switch (indiceOpcionSeleccionada) {
			case 1: {
				JLabel labelNombre = new JLabel("Nombre");
				JTextField tfNombre = new JTextField();
				JLabel labelResponsable = new JLabel("Responsable:");
				JTextField tfResponsable = new JTextField();

				Object[] componentesFormularioCreacionDepartamento = { labelNombre, tfNombre, labelResponsable,
						tfResponsable };

				JOptionPane.showMessageDialog(null, componentesFormularioCreacionDepartamento, "Ingresar departamento",
						JOptionPane.QUESTION_MESSAGE, null);

				String nombre = tfNombre.getText();
				String responsable = tfResponsable.getText();

				if (departamentosCreados < departamentos.length && departamentos[departamentosCreados] == null) {
					departamentos[departamentosCreados] = new Departamento(nombre, responsable, new Articulo[10]);
					JOptionPane.showMessageDialog(null, "Departamento creado");
					departamentosCreados++;
				} else {
					JOptionPane.showMessageDialog(null, "DEPARTAMENTO NO PUEDE REGISTRARSE");
				}

				tfNombre.setText("");
				tfResponsable.setText("");
			}
				break;
			case 2: {

				String[] opcionesDepartamentos = new String[4];

				boolean hayDeps = false;
				for (int i = 0; i < departamentos.length; i++) {
					if (departamentos[i] != null) {
						opcionesDepartamentos[i] = i + " - Nombre: " + departamentos[i].getNombre() + " - Responsable: " + departamentos[i].getResponsable();
						hayDeps = true;
					} else {
						opcionesDepartamentos[i] = i + " - NO CREADO";
					}
				}
				if (!hayDeps) {
					JOptionPane.showMessageDialog(null, "Todavía no ha creado departamentos!");
				} else {

					int indiceDepartamentoSeleccionado = Integer.parseInt(
							JOptionPane.showInputDialog(null, "En qué departamento desea registrar un artículo?",
									"Registrar artículo", JOptionPane.QUESTION_MESSAGE, null, opcionesDepartamentos,
									"SELECCIONAR").toString().substring(0, 1));

					if (articulosCreados[indiceDepartamentoSeleccionado] >= departamentos[indiceDepartamentoSeleccionado]
							.getArticulos().length) {
						JOptionPane.showMessageDialog(null, "No se pueden ingresar más artículos al departamento "
								+ indiceDepartamentoSeleccionado + "!!!");
						break;
					}

					JLabel labelQuery = new JLabel("Ingrese los datos para el nuevo artículo del departamento "
							+ indiceDepartamentoSeleccionado);
					JLabel labelDescripcion = new JLabel("Descipción");
					JTextField tfDescripcion = new JTextField();
					JLabel labelCantidad = new JLabel("Cantidad:");
					JTextField tfCantidad = new JTextField();
					JLabel labelPrecio = new JLabel("Precio");
					JTextField tfPrecio = new JTextField();
					JLabel labelFechaCaducidad = new JLabel("Fecha de caducidad:");
					JLabel labelDia = new JLabel("Dia:");
					JLabel labelMes = new JLabel("Mes:");
					JLabel labelAnio = new JLabel("Anio:");
					JTextField tfDia = new JTextField();
					JTextField tfMes = new JTextField();
					JTextField tfAnio = new JTextField();

					Object[] componentesFormularioCreacionArticulo = { labelQuery, labelDescripcion, tfDescripcion, labelCantidad,
							tfCantidad, labelPrecio, tfPrecio, labelFechaCaducidad, labelDia, tfDia, labelMes, tfMes,
							labelAnio, tfAnio };

					JOptionPane.showMessageDialog(null, componentesFormularioCreacionArticulo, "Ingresar artículo",
							JOptionPane.QUESTION_MESSAGE, null);

					String descripcion = tfDescripcion.getText();
					int cantidad = Integer.parseInt(tfCantidad.getText());
					float precio = Float.parseFloat(tfPrecio.getText());
					Fecha fechaCaducidad = new Fecha(Integer.parseInt(tfDia.getText()),
							Integer.parseInt(tfMes.getText()), Integer.parseInt(tfAnio.getText()));

					if (departamentos[indiceDepartamentoSeleccionado]
							.getArticulos()[articulosCreados[indiceDepartamentoSeleccionado]] == null) {
						departamentos[indiceDepartamentoSeleccionado]
								.getArticulos()[articulosCreados[indiceDepartamentoSeleccionado]] = new Articulo(
										descripcion, cantidad, precio, fechaCaducidad);
						JOptionPane.showMessageDialog(null,
								"Artículo creado en el departamento " + (indiceDepartamentoSeleccionado + 1));
						articulosCreados[indiceDepartamentoSeleccionado]++;
					} else {
						JOptionPane.showMessageDialog(null, "ARTÍCULO NO PUEDE REGISTRARSE");
					}

					tfDescripcion.setText("");
					tfCantidad.setText("");
					tfPrecio.setText("");
					tfDia.setText("");
					tfMes.setText("");
					tfAnio.setText("");
				}
			}
				break;
			case 3: {

				String todosDepartamentos = "";
				boolean hayDeps = false;
				for (int i = 0; i < departamentos.length; i++) {
					if (departamentos[i] == null) {
						break;
					} else {
						hayDeps = true;
					}
					todosDepartamentos += ("\nDepartamento " + (i + 1) + ": " + departamentos[i].getNombre())
							+ ("\nEncargado: " + departamentos[i].getResponsable());
					for (int j = 0; j < departamentos[i].getArticulos().length; j++) {
						if (departamentos[i].getArticulos()[j] == null) {
							break;
						}
						if (j == 0) {
							todosDepartamentos += "\nArticulos: {" + "\n\t"
									+ departamentos[i].getArticulos()[j].toString();
						} else if (j == departamentos[i].getArticulos().length - 1) {
							todosDepartamentos += "\n\t" + departamentos[i].getArticulos()[j].toString() + "\n}";
						} else {
							todosDepartamentos += "\n\t" + departamentos[i].getArticulos()[j].toString();
						}
					}
				}

				if (!hayDeps) {
					JOptionPane.showMessageDialog(null, "No ha creado departamentos!");
				} else {

					JTextArea textArea = new JTextArea(6, 25);
					textArea.setText(todosDepartamentos);
					textArea.setEditable(false);
					JScrollPane contenedorScrolleable = new JScrollPane(textArea);
					JOptionPane.showMessageDialog(null, contenedorScrolleable);
				}
			}
				break;
			case 4: {
				String sMontosInvsDeps = "Valor del inventario de cada departamento:";
				boolean hayDeps = false;
				for (int i = 0; i < departamentos.length; i++) {
					if (departamentos[i] == null) {
						break;
					} else {
						hayDeps = true;
					}
					float montoInvDepActual = 0;

					for (int j = 0; j < departamentos[i].getArticulos().length; j++) {
						if (departamentos[i].getArticulos()[j] == null) {
							break;
						}
						montoInvDepActual += (departamentos[i].getArticulos()[j].getPrecio()
								* departamentos[i].getArticulos()[j].getCantidad());
					}

					sMontosInvsDeps += "\n" + (i+1) + ", " + departamentos[i].getNombre() + ": $" + montoInvDepActual
							+ " MXN";

				}

				if (!hayDeps) {
					JOptionPane.showMessageDialog(null, "No ha creado departamentos!");
				} else {
					JTextArea textArea = new JTextArea(6, 25);
					textArea.setText(sMontosInvsDeps);
					textArea.setEditable(false);
					JScrollPane contenedorScrolleable = new JScrollPane(textArea);
					JOptionPane.showMessageDialog(null, contenedorScrolleable);
				}
			}
				break;
			case 5: {
				boolean hayDeps = false;
				for (int i = 0; i < departamentos.length; i++) {
					if (departamentos[i] != null) {
						hayDeps = true;
						break;
					}
				}

				if (!hayDeps) {
					JOptionPane.showMessageDialog(null, "No ha creado departamentos!");
				} else {
					String descArtIn = JOptionPane.showInputDialog("Descripción del artículo a buscar:");
					String artBuscado = "";
					boolean hayArts = false;
					for (int i = 0; i < departamentos.length; i++) {
						if (departamentos[i] == null) {
							break;
						}
						for (int j = 0; j < departamentos[i].getArticulos().length; j++) {
							if (departamentos[i].getArticulos()[j] == null) {
								break;
							}
							if (departamentos[i].getArticulos()[j].getDescripcion().equalsIgnoreCase(descArtIn)) {
								hayArts = true;
								artBuscado += ("\nArticulo " + (j+1) + " del departamento " + (i+1) + " ( "
										+ departamentos[i].getNombre() + ")")
										+ ("\n\t" + departamentos[i].getArticulos()[j].toString());
							}
						}
					}

					// Falta implementar la solución al caso de q hayan 2 o más artículos con la
					// misma descripción
					if (hayArts) {
						JOptionPane.showMessageDialog(null, "Se ha encontrado el siguiente artículo:" + artBuscado);
					} else {
						JOptionPane.showMessageDialog(null, "ARITCULO NO ENCONTRADO");
					}
				}
			}
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Tenga buen día c:");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Se seleccionó una opción no válida");
				break;

			}
		} while ((indiceOpcionSeleccionada <= 5) && (indiceOpcionSeleccionada >= 1));
	}

}
