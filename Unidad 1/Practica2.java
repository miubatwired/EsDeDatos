package unidad1;

<<<<<<< HEAD
import java.util.Scanner;

public class Practica2 {

=======
public class Practica2 {
/* /*
>>>>>>> ca83ab7 (tercer commit)
	public static void main(String[] args) {
		float lado1, lado2, lado3;
		Scanner sc = new Scanner(System.in);
		/* a) Declarar y crear un vector de 10 triángulos */
<<<<<<< HEAD
		Triangulo tri[] = new Triangulo[10];
		
		/* b) Crear el triángulo de la última casilla con el primer constructor */
		tri[9] = new Triangulo();
		
		/* c) Los triángulos de las primeras 4 casillas se construyen 
		 * con datos leídos del teclado (obviamente, usaremos el 2do. constructor). */
=======
		/*Triangulo tri[] = new Triangulo[10];
		
		/* b) Crear el triángulo de la última casilla con el primer constructor */ /*
		tri[9] = new Triangulo();
		*/
	/* c) Los triángulos de las primeras 4 casillas se construyen
	 * con datos leídos del teclado (obviamente, usaremos el 2do. constructor). */ /*
>>>>>>> ca83ab7 (tercer commit)
		for(int i=0; i<4; i++) {
			System.out.println("Triángulo: " + i);
			System.out.print("Inserte el primer lado del triángulo: ");
			lado1 = sc.nextFloat();
			System.out.print("Inserte el segundo lado del triángulo: ");
			lado2 = sc.nextFloat();
			System.out.print("Inserte el tercer lado del triángulo: ");
			lado3 = sc.nextFloat();
			tri[i] = new Triangulo(lado1,lado2,lado3);
<<<<<<< HEAD
		}
		
		/*d) Para el triángulo de la penúltima casilla se crea un NUEVO OBJETO, pero con
		LOS MISMOS DATOS del primer triángulo (índice [0]) */
		lado1 = tri[0].getLado1();
		lado2 = tri[0].getLado2();
		lado3 = tri[0].getLado3();
		tri[8] = new Triangulo(lado1,lado2,lado3);
		
		/* e) Desplegar en pantalla de cada triángulo que hay actualmente en el vector: */
=======
		} /*
		
		/*d) Para el triángulo de la penúltima casilla se crea un NUEVO OBJETO, pero con
		LOS MISMOS DATOS del primer triángulo (índice [0]) */

	/*lado1 =tri[0].

	getLado1();

	lado2 =tri[0].

	getLado2();

	lado3 =tri[0].

	getLado3();

	tri[8]=new

	Triangulo(lado1, lado2, lado3);

	/* e) Desplegar en pantalla de cada triángulo que hay actualmente en el vector: */
		/*
>>>>>>> ca83ab7 (tercer commit)
		for(int i=0; i<tri.length; i++) {
			if(tri[i]!=null){
				System.out.println("------------");
				System.out.println("Casilla = " + i);
				System.out.println(tri[i].toString());
				System.out.println("Area: " + tri[i].calcularArea());
				System.out.println("Perímetro: " + tri[i].calcularPerimetro());
				System.out.println("Tipo de Triángulo: " + tri[i].tipoDeTriangulo());
			}
		}
		sc.close();
	}

}
<<<<<<< HEAD
=======
		 */
}
>>>>>>> ca83ab7 (tercer commit)
