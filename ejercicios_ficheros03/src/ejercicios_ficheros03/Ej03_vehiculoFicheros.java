package ejercicios_ficheros03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej03_vehiculoFicheros {

	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Vehiculo> arrayVehiculos = new ArrayList<Vehiculo>();
	public static File archivoVehiculos = new File("archivos\\03_vehiculos\\listaVehiculos.dat");
	public static FileInputStream fis = null;
	public static ObjectInputStream ois = null;
	public static FileOutputStream fos = null;
	public static ObjectOutputStream oos = null;

	public static void generarVehiculo() {

		Vehiculo vehiculo = null;

		try {

			fos = new FileOutputStream(archivoVehiculos, true);
			oos = new ObjectOutputStream(fos);
			oos.reset();

			vehiculo = obtenerCaracteristicasVehiculo();

			oos.writeObject(vehiculo);

			fos.close();
			oos.close();

			fis = new FileInputStream(archivoVehiculos);
			ois = new ObjectInputStream(fis);

			System.out.println(vehiculo.toString());

			fis.close();
			ois.close();

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());

		} catch (EOFException e) {

			System.out.println("\nFin del fichero");

		} catch (IOException e) {

			System.out.println(e.getMessage());

		} finally {

			try {

				System.out.println("\n\nFIN Ejercicio 3)");

				if (fos != null)
					fos.close();
				if (fis != null)
					fis.close();
				if (ois != null)
					ois.close();
				if (oos != null)
					oos.close();

			} catch (IOException e) {

				System.out.println(e.getMessage());

			}

		}

	}

	public static Vehiculo obtenerCaracteristicasVehiculo() {

		Vehiculo vehiculo = null;
		String matricula = null;
		double litrosDeposito = 0;
		String marca = null;
		String modelo = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("\nNUEVO VEHICULO\n\n Introduzca los datos: \n\n Matricula:");
		matricula = sc.next();
		sc.nextLine();
		System.out.println("Marca: ");
		marca = sc.nextLine();
		sc.nextLine();
		System.out.println("Modelo: ");
		modelo = sc.nextLine();
		sc.nextLine();
		System.out.println("Litros del deposito: ");
		litrosDeposito = sc.nextDouble();

		vehiculo = new Vehiculo(matricula, marca, litrosDeposito, modelo);
		arrayVehiculos.add(vehiculo);

		return vehiculo;
	}

	public static void menuVehiculo() {

		int opcionMenu = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nINICIO Ejercicio 03)\n\n");

		do {
			System.out.println(
					"\nMENU VEHICULO\n1)Introducir nuevo coche \n2)Ver coches \n3)Salir\n\nIntroduzca opcion:");
			opcionMenu = sc.nextInt();
			if (opcionMenu == 1)
				generarVehiculo();
			if (opcionMenu == 2) {

				try {

					fis = new FileInputStream(archivoVehiculos);
					boolean eof = false;

					while (fis.available() > 0 && eof == false) {
						ois = new ObjectInputStream(fis);
						Vehiculo vehiculoLeido = (Vehiculo) ois.readObject();
						if (vehiculoLeido == null)
							eof = true;
						else
							System.out.println(vehiculoLeido);
					}
					fis.close();
					ois.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} while (opcionMenu != 3);
		// opciones: 1, añadir vehiculo
		// 2, ver lista de coches
		// 3, borrar lista?

		// opcion 1: llama a generar Vehiculo, que llama a constructor, que mete el
		// toString en el archivo

	}

}