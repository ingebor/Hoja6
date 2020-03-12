
/**
 * 
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Hoja de trabajo 6
 * 11/03/2020
 * 
 * Lector de archivos reutilizado de Hoja de Trabajo 4
 * 
 * @author Julio Herrera 19402
 * @author Ingebor Rubio 19
 * @version 1.0
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.LinkedHashMap;

import static java.util.stream.Collectors.*;

public class Main {

	/**
	 * 
	 * Este método es utilizado para leer el archivo datos.txt.
	 * La lectura se realiza para todas las líneas del archivo y separa cada
	 * caracter que tenga el archivo para agregarlo a la lista de Strings
	 * que devolverá.
	 * 
	 * @return una lista de todos los elementos del archivo separados
	 * @throws Exception excepción general para la lectura del archivo
	 */
	public static String[] textReader() throws Exception{
		Scanner scan = new Scanner(System.in);
		final String bar = File.separator;
		final String dir = System.getProperty("user.dir");
		/**
		 * AQUI SE LEE EL ARCHIVO TXT
		 * si no corre se debe de reemplazar en el parentesis (dir + barra +"NOMBRE DEL
		 * FOLDER EN DONDE ESTA EL PROYECTO" +barra+ "datos.txt")
		 * El error del archivo de texto puede pasar si se corre el programa en eclipse
		 * y no en consola
		 * o tambien sucede al trabajar con paquetes
		 */
		System.out.println("Escribe el nombre del archivo de texto a utilizar");
		System.out.println("O presiona enter para utilizar el predeterminado (cards_desc.txt)");
		String filetxt = scan.nextLine();
		if (filetxt.equals("")) {
			filetxt = "cards_desc.txt";
		}
		final File file = new File(dir + bar + filetxt);
		if (!file.exists()) {
			throw new FileNotFoundException("No se encontro el archivo, ver lineas comentadas");
		}
		FileReader fr;
		fr = new FileReader(file);
		final BufferedReader br = new BufferedReader(fr);
		String[] lineList = new String[8861];
		String line = "";
		int cont = 0;
		while ((line = br.readLine()) != null) {
			lineList[cont] = line;
			cont++;
		}

		br.close();
		return lineList;
	}
	static int countMon = 0;
	static int countTram = 0;
	static int countHech = 0;

	@SuppressWarnings("unchecked")
	public static void main(final String[] args) throws Exception {
		/**
		 * Menu de eleccion de tipo de Map a utilizar.
		 */
		Scanner scan = new Scanner(System.in);
		boolean hasAType = false;
		int mapType = 0;
		while(!hasAType) {
			System.out.println("Eliga el tipo de Map que quiere utlizar:");
			System.out.println("1. HashMap\n2. TreeMap\n3. LinkedHashMap");
			mapType = scan.nextInt();
			scan.nextLine();
			if (mapType > 0 && mapType < 4) {
				hasAType = true;
			}
		}
		/**
		 * Se lee el archivo de texto
		 */
		final String[] list = textReader();
		/**
		 * Se implementa el patron Factory, creando una instancia de la clase
		 * MapFactory y llamando al metodo que devuelve una Map<K, V>,
         * segun los parametros escogidos por el usuario.
		 */
		
		MapFactory<String, String> mapFactory = new MapFactory<String, String>();
		Map<String, String> map = mapFactory.getMap(mapType);
		Map<String, String> userMap = mapFactory.getMap(mapType);
		
		/**
		 * Comienza la lectura de los elementos del archivo en la lista para ingresarlos al Map.
		 */
		String[] keyAndValue = new String[2];
		for (String cardInList : list) {
			keyAndValue[0] = cardInList.split("\\|")[0];
			keyAndValue[1] = cardInList.split("\\|")[1];
			map.put(keyAndValue[0], keyAndValue[1]);
		}
		/**
		 * Teniendo todas las cartas guardadas en el Map, se muestra al usuario
         * el menu de opciones que puede realizar
		 */
        int userOption = 0;
        while(userOption != 7) {
            System.out.println("------Bienvenido--------\n Debe esoger la opcion que desee utilizar: ");
            System.out.println("1. Agregar una carta a la coleccion. Debe ingresar el nombre de la carta que desea agregar.");
            System.out.println("2. Mostrar el tipo de una carta especifica. Debe ingresar el nombre de la carta");
            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta en su coleccion.");
            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta en su coleccion, ordenadas por tipo.");
            System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes.");
            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.");
			System.out.println("7. Salir");
			userOption = scan.nextInt();
			scan.nextLine();
			/**
			 * Se realizan las opciones segun la eleccion del usuario.
			 */
			String key = "";
			String value = "";
			java.util.Map<String, String> sorted = new LinkedHashMap<String, String>();
			try {
				switch (userOption) {
					case 1:
						System.out.println("Ingrese el nombre de la carta:");
						key = scan.nextLine();
						if (map.containsKey(key)) {
							value = map.get(key);
							userMap.put(key, value);
							System.out.println("Se ha ingresado la carta: " + key);
						} else {
							System.out.println("Esta carta no existe!");
						}
					break;
					case 2:
						System.out.println("Ingrese el nombre de la carta:");
						key = scan.nextLine();
						if (map.containsKey(key)) {
							value = map.get(key);
							System.out.println("Esta carta es de tipo " + value);
						} else {
							System.out.println("Esta carta no existe!");
						}
					break;
					case 3:
						countMon = 0;
						countTram = 0;
						countHech = 0;
						userMap.forEach((k, v) -> {
							if (v.equals("Monstruo")) {
								countMon++;
							} else if (v.equals("Trampa")) {
								countTram++;

							} else if (v.equals("Hechizo")) {
								countHech++;
							}
							System.out.println(k + " - " + v);
						});
						System.out.println("Cantidad de cartas tipo Monstruo: " + countMon);
						System.out.println("Cantidad de cartas tipo Trampa: " + countTram);
						System.out.println("Cantidad de cartas tipo Hechizo: " + countHech);
					break;
					case 4:
						countMon = 0;
						countTram = 0;
						countHech = 0;
						sorted = userMap.entrySet().stream().sorted(java.util.Map.Entry.comparingByValue())
								.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
						sorted.forEach((k, v) -> {
							if (v.equals("Monstruo")) {
								countMon++;
							} else if (v.equals("Trampa")) {
								countTram++;

							} else if (v.equals("Hechizo")) {
								countHech++;
							}
							System.out.println(k + " - " + v);
						});
						System.out.println("Cantidad de cartas tipo Monstruo: " + countMon);
						System.out.println("Cantidad de cartas tipo Trampa: " + countTram);
						System.out.println("Cantidad de cartas tipo Hechizo: " + countHech);
					break;
					case 5:
						map.forEach((k, v) -> {
							System.out.println(k + " - " + v);
						});
					break;
					case 6:
						sorted = map.entrySet().stream().sorted(java.util.Map.Entry.comparingByValue())
								.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
						
						sorted.forEach((k, v) -> {
							System.out.println(k + " - " + v);
						});
					break;
					default:
						System.out.println("Eliga una opcion valida!");
					break;
					}
				} 
				catch (Exception e) {
					System.out.println(e);
					System.out.println("Algo salio mal :("); // TODO: Cachar un error general o especifico 
				}
        	}
			scan.close();
				
				
			
				
        }
	}
