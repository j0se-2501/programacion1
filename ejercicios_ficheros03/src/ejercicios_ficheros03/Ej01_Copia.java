package ejercicios_ficheros03;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej01_Copia {

	public static File generarArchivoOriginal() {

		Scanner sc = new Scanner(System.in);
		File archivoOriginal = null;
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		Byte Entrada = 0;
		char flag = 1;

		try {

			archivoOriginal = new File("archivos//01_copiaBytes//original.dat");
			fos = new FileOutputStream(archivoOriginal, false);
			dos = new DataOutputStream(fos);

			do {
				try {
					System.out.println(
							"\nIntroduzca bytes en el archivo.\n Un numero desde -128 a 127.\n Pulse una letra para salir. ");
					Entrada = sc.nextByte();
					dos.writeByte(Entrada);
				} catch (InputMismatchException e) {
					flag = 0;
					System.out.println("\nCreacion del archivo finalizada");
				}
			} while (flag != 0);
			fos.close();

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());

		} catch (EOFException e) {

			System.out.println("\nFin del fichero");

		} catch (IOException e) {

			System.out.println(e.getMessage());

		}

		return archivoOriginal;

	}

	public static void copiarArchivos() {

		File archivoOriginal = null;
		File archivoCopia = null;
		String nombreCopia = "";
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		DataInputStream dis = null;
		byte Entrada = 0;
		int numeroArchivo = 0, casillaArray = 0;

		try {

			nombreCopia = "archivos//01_copiaBytes//copias//copia_" + ++numeroArchivo + ".dat";
			archivoCopia = new File(nombreCopia);

			while (archivoCopia.isFile()) {
				nombreCopia = "archivos//01_copiaBytes//copias//copia_" + ++numeroArchivo + ".dat";
				archivoCopia = new File(nombreCopia);
			}

			archivoOriginal = new File("archivos//01_copiaBytes//original.dat");

			if (!archivoOriginal.isFile()) {

				System.out.println("\nNo existe un archivo original que copiar.\nSe procedera a crear uno: ");
				archivoOriginal = generarArchivoOriginal();

			}

			byte[] arrayBytes = new byte[(int) archivoOriginal.length() + 1];

			fos = new FileOutputStream(archivoCopia);
			dos = new DataOutputStream(fos);
			fis = new FileInputStream(archivoOriginal);
			dis = new DataInputStream(fis);

			while (fis.available() >= 1) {

				Entrada = dis.readByte();
				arrayBytes[casillaArray++] = Entrada;

			}

			casillaArray = 0;

			for (int i = 0; i < arrayBytes.length - 1; i = i + 2) {

				dos.writeByte(arrayBytes[i]);
				dos.writeByte(arrayBytes[i + 1]);

			}

			System.out.println("");

		} catch (FileNotFoundException e) {

			System.out.println();
			e.getMessage();

		} catch (IOException e2) {

			System.out.println(e2.getMessage());

		} finally {

			try {

				System.out.println("\nFIN Ejercicio 01)     Copia del archivo de bytes terminada en el archivo "
						+ archivoCopia.getName() + ".\n");

				if (fos != null || fis != null || dis != null || dos != null) {

					fos.close();
					fis.close();
					dis.close();
					dos.close();

				}

			} catch (IOException e) {

				System.out.println(e.getMessage());

			}

		}

	}
}
