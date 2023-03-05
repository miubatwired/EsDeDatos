package practica4u2;

import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// Recuerda que una matriz es un vector de vectores
public class U2Practica4_MultMatrices {

	public static void main(String[] args) {

		String[] opciones = { "1. Generar matriz", "2. Despliega matriz", "3. Suma de elementos",
				"4. Multiplica matrices", "5. Salir" };
		boolean salir = false;
		int[][] m = null; // Inicializamos la matriz

		while (!salir) {

			char respuesta = ((String) JOptionPane.showInputDialog(null, "Que quieres hacer", "Opciones recursividad",
					JOptionPane.QUESTION_MESSAGE, null, opciones, 0)).charAt(0);
			switch (respuesta) {
			// No usar métodos de la clase Arrays
			case '1' -> {
				if (m != null) {
					int op = JOptionPane.showConfirmDialog(null, "Ya ha creado una matriz, ¿desea sobreescribirla?");
					if (op == JOptionPane.YES_OPTION) {
						m = null;
					}
				}
				if (m == null) {
					boolean inListo = false;
					while (!inListo) {
						try {
							JLabel lblPrompt = new JLabel("Ingrese los datos de la matriz a crear");
							JLabel lblNFilas = new JLabel("No. de filas");
							JTextField tfNFilas = new JTextField();
							JLabel lblNColum = new JLabel("No. de columnas");
							JTextField tfNColum = new JTextField();

							Object[] comps = { lblPrompt, lblNFilas, tfNFilas, lblNColum, tfNColum };

							JOptionPane.showMessageDialog(null, comps);

							int nFilas = Integer.parseInt(tfNFilas.getText());
							int nColumnas = Integer.parseInt(tfNColum.getText());
							if (nFilas > 0 && nColumnas > 0) {
								m = new int[nFilas][nColumnas];
								llenaMatriz(m, 0, 0);
								System.out.println(Arrays.deepToString(m));
								inListo = true;
							} else {
								JOptionPane.showMessageDialog(null, "No se aceptan valores negativos!");
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Debe ingresar un número entero!");
						}
					}
				}
			}
			case '2' -> {
				if (m != null) {
					JOptionPane.showMessageDialog(null, imprimeMatriz(m, 0, 0));
				} else {
					JOptionPane.showMessageDialog(null, "No ha creado la matriz!");
				}
			}
			case '3' -> {
				if (m != null) {
					JOptionPane.showMessageDialog(null, sumaMatriz(m, 0, 0));
				} else {
					JOptionPane.showMessageDialog(null, "No ha creado la matriz!");
				}
			}
			case '4' -> {
				try {
					int n = Integer.parseInt(JOptionPane
							.showInputDialog("Ingrese el valor de n para las matrices a y b con dimensiones nxn"));

					int a[][] = new int[n][n];
					int b[][] = new int[n][n];
					int mult[][] = new int[n][n];
					llenaMatriz(a, 0, 0);
					llenaMatriz(b, 0, 0);
					multiplicaMatrices(a, b, mult, 0, 0, 0);
					System.out.println(Arrays.deepToString(a) + "\n\n" + Arrays.deepToString(b) + "\n\n"
							+ Arrays.deepToString(mult));
					JOptionPane.showMessageDialog(null,
							"Matriz a:\n" + imprimeMatriz(a, 0, 0) + "\n\nMatriz b (resultado de la multiplicación): \n"
									+ imprimeMatriz(b, 0, 0) + "\n\nMatriz c: \n" + imprimeMatriz(mult, 0, 0));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Tiene que ingresar valores numéricos!");
				}
			}
			case '5' -> {
				salir = true;
			}
			}
		}

	}

	public static void llenaMatriz(int[][] m, int fila, int columna) {
		if (m.length <= fila || m[fila].length <= columna) {
			return;
		}
		m[fila][columna] = (int) (Math.random() * 10);
		llenaMatriz(m, fila, columna + 1);
		llenaMatriz(m, fila + 1, columna);
	}

	public static String imprimeMatriz(int[][] m, int fila, int columna) {
		if (fila >= m.length) {
			return "";
		}
		if (columna >= m[fila].length) {
			return "\n" + imprimeMatriz(m, fila + 1, 0);
		} else {
			return m[fila][columna] + " " + imprimeMatriz(m, fila, columna + 1);
		}
	}

	public static int sumaMatriz(int[][] m, int fila, int columna) {
		if (fila >= m.length) {
			return 0;
		}
		if (columna >= m[fila].length) {
			return sumaMatriz(m, fila + 1, 0);
		} else {
			return m[fila][columna] + sumaMatriz(m, fila, columna + 1);
		}
	}

	public static void multiplicaMatrices(int a[][], int b[][], int mult[][], int fila, int col, int k) {
		// Las variables fila y col denotan la fila y la col de los elementos de la
		// matriz mult.
		//
		System.out.println(
				"Parámetros:\n" + "n: " + a.length + "\n" + Arrays.deepToString(a) + "\n" + Arrays.deepToString(b)
						+ "\n" + Arrays.deepToString(mult) + "\nFila: " + fila + ", columna: " + col + ", k: " + k);
		if (fila >= a.length) {
			return;
		} else if (col >= b[fila].length) {
			multiplicaMatrices(a, b, mult, fila + 1, 0, 0);
		} else if (k >= a[fila].length) {
			multiplicaMatrices(a, b, mult, fila, col + 1, 0);
		} else {
			mult[fila][col] += a[fila][k] * b[k][col];
			multiplicaMatrices(a, b, mult, fila, col, k + 1);
		}
	}

	/*
	 * public int sumaMatriz(int[][] m, int fila, int columna) {
	 * 
	 * }
	 */

	/*
	 * public static int sumaMatriz(int[][] m, int fila, int columna) {
	 * 
	 * }
	 */

}
