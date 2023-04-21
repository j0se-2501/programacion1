package ejercicios_ficheros03;

import java.io.*;
import java.util.Scanner;

public class Ej02_Random {

	public static int generarNumerosAleatorios() {

		int random = (int) (Math.random() * 101);

		return random;
	}

	public static int pedirCantidadAleatorios() {

		Scanner sc = new Scanner(System.in);
		int cantidad = 0;

		System.out.println("Cuantos numeros random quieres generar?");
		cantidad = sc.nextInt();

		return cantidad;

	}

	public static String pedirRutaArchivo() {

		Scanner sc = new Scanner(System.in);
		String ruta = "";

		System.out.println("\nINICIO Ejercicio 02)\n");
		System.out.println("\nIntroduzca el nombre del archivo (se guardara en archivos\\02_random):\n");
		ruta = sc.nextLine();

		return ruta;
	}

	public static void generarArchivoConRandom() {

		Scanner sc = new Scanner(System.in);
		String rutaArchivo = pedirRutaArchivo();
		int cantidadRandom = pedirCantidadAleatorios();
		File archivoConRandom = null;
		FileInputStream fis = null;
		DataInputStream dis = null;
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {

			archivoConRandom = new File("archivos\\02_random\\", rutaArchivo);
			fos = new FileOutputStream(archivoConRandom, true);
			dos = new DataOutputStream(fos);
			fis = new FileInputStream(archivoConRandom);
			dis = new DataInputStream(fis);

			System.out.print("\nNumeros aleatorios generados: ");
			for (int i = 0; i < cantidadRandom; i++) {

				int random = generarNumerosAleatorios();
				dos.writeInt(random);
				System.out.print(random + ", "); // mostrar por pantalla

			}

			fis.close();
			dis.close();
			fis = new FileInputStream(archivoConRandom);
			dis = new DataInputStream(fis);
			System.out.print("\n\nSe mostraran todos los numeros del archivo, incluidos los generados anteriormente: ");

			while (dis.available() > 0)
				System.out.print(dis.readInt() + ", ");

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());

		} catch (EOFException e) {

			System.out.println("\nFin del fichero");

		} catch (IOException e) {

			System.out.println(e.getMessage());

		} finally {

			try {

				System.out.println("\n\nFIN Ejercicio 02)     Numeros randoms generados en el archivo "
						+ archivoConRandom.getName() + ".");

				if (fos != null)
					fos.close();
				if (fis != null)
					fis.close();
				if (dis != null)
					dis.close();
				if (dos != null)
					dos.close();

			} catch (IOException e) {

				System.out.println(e.getMessage());

			}

		}

	}

}
