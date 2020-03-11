
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
		final File file = new File(dir + bar + "cards_desc.txt");
		if (!file.exists()) {
			throw new FileNotFoundException("No se encontro el archivo, ver lineas comentadas");
		}
		FileReader fr;
		fr = new FileReader(file);
		final BufferedReader br = new BufferedReader(fr);
		String[] lineList = null;
		String line = "";
		while ((line = br.readLine()) != null) {
			lineList = line.split(" ");
		}

		br.close();
		return lineList;
	}

	public static void main(final String[] args) throws Exception {
		/**
		 * Menú de elección de tipo de Map a utilizar.
		 */
        System.out.println("Eliga el tipo de Map que quiere utlizar:");
        System.out.println("1. HashMap\n2. TreeMap\n3. LinkedHashMap");
        Scanner scan = new Scanner(System.in);
        int mapType = scan.nextInt();
        scan.nextLine();
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
		/**
		 * Comienza la lectura de los elementos del archivo en la lista para ingresarlos al Map.
		 */
		String[] keyAndValue = new String[2];
		for (String cardInList : list) {
			keyAndValue = cardInList.split("|");
			map.put(keyAndValue[0], keyAndValue[1]);
		}
		/**
		 * Teniendo todas las cartas guardadas en el Map, se muestra al usuario
         * el menu de opciones que puede realizar
		 */
        int userOption = 0;
        while(userOption != 7) {
            System.out.println("------CAAAAAARTAAAAAAAAAAAAAASSSSSSSS--------");
            System.out.println("1. Agregar una carta a la colección. Debe ingresar el nombre de la carta que desea agregar.");
            System.out.println("2. Mostrar el tipo de una carta específica. Debe ingresar el nombre de la carta");
            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta en su colección.");
            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta en su colección, ordenadas por tipo.");
            System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes.");
            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo.");
            userOption = scan.nextInt();
            scan.nextLine();
            /**
             * Se realizan las opciones segun la eleccion del usuario.
             */
            try {
                switch (userOption) {
                    case 1:
                        System.out.println("Pendiente opcion 1");
                    break;
                    case 2:
                        System.out.println("Pendiente opcion 2");
                    break;
                    case 3:
                        System.out.println("Pendiente opcion 3");
                    break;
                    case 4:
                        System.out.println("Pendiente opcion 4");
                    break;
                    case 5:
                        System.out.println("Pendiente opcion 5");
                    break;
                    case 6:
                        System.out.println("Pendiente opcion 6");
                    break;
                    default:
                        System.out.println("Eliga una opción válida!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Algo salio mal :("); // TODO: Cachar un error general o especifico 
            }
        }
		scan.close();
	}
}