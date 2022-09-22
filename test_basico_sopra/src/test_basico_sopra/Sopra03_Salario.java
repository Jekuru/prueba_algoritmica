package test_basico_sopra;

import java.util.Scanner;

public class Sopra03_Salario {

	public static void main(String[] args) {
		// Declaración variables
		String horas_trabajadas_string, tarifa_string; // String para evitar errores en el input
		double sueldo, horasTrabajadas, tarifa;
		Scanner userInput = new Scanner(System.in);

		// Se comprueba que el número introducido de horas es correcto
		do {
			System.out.print("Horas trabajadas: ");
			horas_trabajadas_string = userInput.nextLine();
		} while(!isNumeric(horas_trabajadas_string));
		
		horasTrabajadas = Double.parseDouble(horas_trabajadas_string); // Se convierte a Double
		
		// Se comprueba que el número introducido de la tarifa es correcto
		do {
			System.out.print("Tarifa por hora: ");
			tarifa_string = userInput.nextLine();
		} while(!isNumeric(tarifa_string));

		tarifa = Double.parseDouble(tarifa_string); // Se convierte a Double

		// Si el número de horas trabajadas es mayor a 40...
		if (horasTrabajadas > 40) {
			double sueldoBase, sueldoExtra, horasExtra, nuevaTarifa;

			sueldoBase = 40 * tarifa; // Se establece el sueldo a recibir hasta 40 horas trabajadas

			horasExtra = horasTrabajadas - 40; // Se calculan las horas extra

			nuevaTarifa = tarifa * 1.50; // Se aplica la nueva tarifa del 50% sobre la tarifa actual

			sueldoExtra = horasExtra * nuevaTarifa; // Se calcula el sueldo de las horas extra

			sueldo = sueldoBase + sueldoExtra; // Se suma el total del sueldo + horas extra
		} else {
			 // Se calcula el total del sueldo sin horas extra
			sueldo = horasTrabajadas * tarifa;
		}

		System.out.println("Salario: " + sueldo);

		userInput.close();
		System.out.println("\nFin del programa SALARIO");
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