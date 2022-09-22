package test_basico_sopra;

import java.io.*;
import java.util.ArrayList;

public class Sopra02_Personas {

	public static void main(String[] args) throws Exception {
		// Declaración de la lista donde se almacenarán las personas
		ArrayList<Persona> personas = new ArrayList<>();
		// Archivo a leer con los datos separados por ,
		System.out.println("Se carga fichero Personas.txt\n");
		BufferedReader leerPersonas = new BufferedReader(
				new InputStreamReader(Sopra02_Personas.class.getResourceAsStream("Personas.txt"), "UTF-8"));

		// Separa los datos sexo y edad que se encuentran separados por , en cada línea y crea el objeto Persona almacenando su valor con un constructor
		String fila;
		while ((fila = leerPersonas.readLine()) != null) {
			String[] pair = fila.split(",");
			Persona persona = new Persona(pair[0], Integer.valueOf(pair[1]));
			personas.add(persona);
		}

		// Cantidad de personas mayores de edad (>=18 años)
		int personasMayores = 0;
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).edad >= 18)
				personasMayores++;
		}
		System.out.println("Personas mayores de edad: " + personasMayores);

		// Cantidad de personas menores de edad (<18 años)
		System.out.println("Personas menores de edad: " + (personas.size() - personasMayores));

		// Cantidad de personas masculinas mayores de edad
		int mayoresHombre = 0;
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).edad >= 18 && personas.get(i).sexo.equals("Hombre"))
				mayoresHombre++;
		}
		System.out.println("Personas masculinas mayores de edad: " + mayoresHombre);

		// Cantidad de personas femeninas menores de edad
		int menoresMujer = 0;
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).edad < 18 && personas.get(i).sexo.equals("Mujer"))
				menoresMujer++;
		}
		System.out.println("Personas femeninas menores de edad: " + menoresMujer);

		// Porcentaje de peronas mayores de edad respecto al total de personas
		double porcentajeMayores = ((double) personasMayores / personas.size()) * 100;
		System.out.println("Porcentaje de personas mayores de edad respecto al total de personas: "
				+ Math.round(porcentajeMayores) + "%");

		// Porcentaje que representan las mujeres respecto al total de personas
		int cantidadMujeres = 0;
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).sexo.equals("Mujer"))
				cantidadMujeres++;
		}
		double porcentajeMujeres = ((double) cantidadMujeres / personas.size()) * 100;
		System.out
				.println("Porcentaje de mujeres respecto al total de personas: " + Math.round(porcentajeMujeres) + "%");

		System.out.println("\nFin del programa PERSONAS");
	}
}