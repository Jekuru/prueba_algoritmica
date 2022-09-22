package test_basico_sopra;

import java.util.Scanner;

public class Sopra01_Numero {

	public static void main(String[] args) {
		// Declaración de variables
		Scanner leerNumero = new Scanner(System.in);
		String numero; // Se utiliza string para evitar errores en el input

		// Se comprueba que el número introducido es correcto
		do {
			System.out.print("Introduce un numero: ");
			numero = leerNumero.nextLine();
		} while (!isNumeric(numero));

		// Se quitan decimales, en caso de haber introducido un número decimal y se convierte a tipo Integer
		String numeroSplit[] = numero.split("\\.");
		int numeroParsed = Integer.parseInt(numeroSplit[0]);

		// Se imprime por consola si el número es par o impar.
		if (numeroParsed % 2 == 0) {
			System.out.println("El numero introducido es par.");
		} else {
			System.out.println("El numero introducido es impar.");
		}

		System.out.println(numeroParsed); // Se realiza una primera impresión del número por consola

		// Se imprimen los números pares o impares hasta llegar a 0 o 1 restando dos al número original
		for (int i = numeroParsed; i > 0; i = i - 2) {
			numeroParsed = numeroParsed - 2;
			if (numeroParsed < 0) {
				numeroParsed = 0;
			} else {
				System.out.println(numeroParsed);
			}
		}

		System.out.print("\nFin del programa LEER NUMERO");
		leerNumero.close();
	}

	/**
	 * Comprueba si la cadena de texto introducida es un número
	 * 
	 * @param string
	 * @return bool Devuelve "true" si el parametro introducido es un valor númerico, "false" más un mensaje de error por consola si no lo es.
	 */
	public static boolean isNumeric(String string) {
		if (string == null || string.isEmpty()) {
			System.err.println("Introduzca un número válido (1: No se ha introducido número)");
			return false;
		} else {
			try {
				Double.parseDouble(string);
			} catch (NumberFormatException e) {
				System.err.println("Introduzca un número válido (2: No se ha introducido un número válido)");
				return false;
			}
		}

		return true;
	}
}