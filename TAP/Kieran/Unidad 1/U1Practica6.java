package practica6u1;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

/*
 * Algo que se puede mejorar en la opción 1 y la opción 4 es usar 3 whiles (que dependan de si el usuario quiere repetir una operación mal hecha) para q se repitan sólo partes de los programas de estas opciones (y no todo el programa de la opción)
 * también se puede mejorar mostrando los snacks en string de matriz
 */
public class U1Practica6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Snack[][] snacksInit = { { new Snack("Crunch", 'a'), new Snack("Doritos", 'b'), new Snack("Bubaloo", 'c') },
				{ new Snack("KitKat", 'a'), new Snack("Cheetos", 'b'), new Snack("Trident", 'c') },
				{ new Snack("Hershey's", 'a'), new Snack("Ruffles queso", 'b'), new Snack("Clorets", 'c') },
				{ new Snack("Snickers", 'a'), new Snack("Fritos", 'b'), new Snack("Orbit", 'c') },
				{ new Snack("Milky Way", 'a'), new Snack("Chip's Jalapeño", 'b'), new Snack("Chiclets", 'c') } };

		MaquinaExpendedora maquina = new MaquinaExpendedora(0.0f, snacksInit);

		String[] menu = { "1. Pedir snack", "2. Mostrar golosinas", "3. Dinero en caja", "4. Rellenar snacks",
				"5. Salir" };

		boolean cicloMenuTerminado = false;

		Snack[][] snacks = maquina.getSnacks();

		while (!cicloMenuTerminado) {

			char opcionInicial = JOptionPane.showInputDialog(null, "¿Qué desea hacer?", "Operaciones snacks",
					JOptionPane.QUESTION_MESSAGE, null, menu, "SELECCIONAR").toString().charAt(0);

			switch (opcionInicial) {
			case '1' -> {

				boolean iIsValido = false;
				boolean esSnackExistente = false;
				boolean esMontoValido = false;
				// while (!iIsValido || !esSnackExistente || !esMontoValido) {
				String posicion = "00";
				int nFila = 0;
				int nColumna = 0;
				boolean inPosicionListo = false;
				while (!inPosicionListo) {
					try {
						// Aquí podríamos, sobre el área de texto para ingresar el snack, mostrar los
						// snacks disponibles arriba del mismo
						posicion = JOptionPane.showInputDialog("¿Cuál snack desea?");
						nFila = Integer.parseInt(posicion.substring(0, 1));
						nColumna = Integer.parseInt(posicion.substring(1, 2));
						inPosicionListo = true;

					} catch (IllegalArgumentException e) {
						JOptionPane.showMessageDialog(null,
								"ERROR: Tiene que ingresar la posición numérica del snack!");
					}
				}
				if ((posicion.length() <= 2) && ((nFila >= 0 && nFila < snacks.length)
						&& (nColumna >= 0 && nColumna < snacks[nFila].length))) {

					iIsValido = true;
					boolean encontrado = false;
					for (int i = 0; i < snacks.length && !encontrado; i++) {
						if (nFila == i) {
							for (int j = 0; j < snacks[i].length && !encontrado; j++) {
								if (nColumna == j) {
									encontrado = true;
									if (snacks[i][j].getInv() >= 1) {
										esSnackExistente = true;
										JLabel lblInfoCompra = new JLabel("Golosina seleccionada: " + snacks[i][j].toString()
												);
										JLabel lblCompra = new JLabel("¿Cuánto dinero va a ingresar?");
										JTextField tfCompra = new JTextField();

										Object[] compsCompra = { lblInfoCompra, lblCompra, tfCompra };

										JOptionPane.showMessageDialog(null, compsCompra);

										if (Float.parseFloat(tfCompra.getText()) >= snacks[i][j].getPrecio()) {
											esMontoValido = true;
											maquina.aumentarCaja(snacks[i][j].getPrecio());
											snacks[i][j].retirarSnack();
											float cambio = Float.parseFloat(tfCompra.getText())
													- snacks[i][j].getPrecio();
											JOptionPane.showMessageDialog(null, "Snack retirado: " + concatInts(i, j) + " - "
													+ snacks[i][j].getNombre() + ", $" + snacks[i][j].getPrecio()
													+ "\nCambio: $" + cambio);
										} else {
											JOptionPane.showMessageDialog(null, "El monto ingresado no es suficiente");
										}

									} else {
										JOptionPane.showMessageDialog(null, "No hay inventario del snack seleccionado");
									}
								}
							}
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "La posición ingresada no es válida");
				}

				// }
			}
			case '2' -> {
				String s = "";
				for (int i = 0; i < snacks.length; i++) {
					for (int j = 0; j < snacks[i].length; j++) {

						s += (((i == 0) && (j == 0)) ? "" : "\n------o------\n") + "Código " + concatInts(i, j) + ", ["
								+ i + "][" + j + "]" + "\n" + snacks[i][j].toString();
					}
				}

				JTextArea aTexto = new JTextArea(6, 25);
				aTexto.setEditable(false);
				aTexto.setText(s);
				JScrollPane areaScroll = new JScrollPane(aTexto);
				JOptionPane.showMessageDialog(null, areaScroll);
			}
			case '3' -> {
				JOptionPane.showMessageDialog(null, "Dinero en caja: $" + maquina.getCaja() + " MXN");
			}
			case '4' -> {
				JLabel lblContrasena = new JLabel("Ingrese la contraseña");
				JPasswordField pfContrasena = new JPasswordField();
				JOptionPane.showMessageDialog(null, new Object[] { lblContrasena, pfContrasena });

				if (String.valueOf(pfContrasena.getPassword()).equals("DeliSnacK")) {
					String posicion = JOptionPane.showInputDialog("¿Qué snack desea rellenar?");

					int nFila = Integer.parseInt(posicion.substring(0, 1));
					int nColumna = Integer.parseInt(posicion.substring(1, 2));

					if ((posicion.length() <= 2) && ((nFila >= 0 && nFila < snacks.length)
							&& (nColumna >= 0 && nColumna < snacks[nFila].length))) {
						boolean encontrado = false;
						for (int i = 0; i < snacks.length && !encontrado; i++) {
							if (nFila == i) {
								for (int j = 0; j < snacks[i].length && !encontrado; j++) {
									if (nColumna == j) {
										encontrado = true;
										int nRellenar = Integer
												.parseInt(JOptionPane.showInputDialog("¿Cuántas unidades del snack "
														+ concatInts(i, j) + " desea ingresar?"));
										snacks[i][j].rellenarSnacks(nRellenar);
										JOptionPane.showMessageDialog(null, "Ha rellenado " + nRellenar + " unidades del snack "
												+ concatInts(i, j));
									}
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "La posición ingresada no es válida");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta, intente de nuevo!");
				}
			}
			case '5' -> {
				cicloMenuTerminado = true;
			}
			}
		}
	}

	public static String concatInts(int i, int j) {
		return Integer.toString(i) + Integer.toString(j);
	}

}
