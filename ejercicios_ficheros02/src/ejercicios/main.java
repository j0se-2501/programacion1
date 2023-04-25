package ejercicios;

import java.io.*;

public class main {

	public static FileInputStream fis = null;
	public static ObjectInputStream ois = null;
	public static FileOutputStream fos = null;
	public static ObjectOutputStream oos = null;

	public static void main(String[] args) {

		Empresa empresa1 = new Empresa("Ilerna", 10);
		
		Empleado empleado1 = new Empleado("Pepe", 1500, empresa1);
		Empleado empleado2 = new Empleado("Carlos", 1500, empresa1);
		Empleado empleado3 = new Empleado("Maria", 1700, empresa1);
		Empleado empleado4 = new Empleado("Ana", 1800, empresa1);
		Empleado empleado5 = new Empleado("Juan", 1600, empresa1);
		
		empleado1.aumentarSueldo(100);

		empresa1.arrayEmpleados[0] = empleado1;
		empresa1.arrayEmpleados[1] = empleado2;
		empresa1.arrayEmpleados[2] = empleado3;
		empresa1.arrayEmpleados[3] = empleado4;
		empresa1.arrayEmpleados[4] = empleado5;

		try {
			empresa1.fos = new FileOutputStream(empresa1.ficheroEmpresa, false);
			empresa1.oos = new ObjectOutputStream(empresa1.fos);
			empresa1.oos.reset();
			empresa1.oos.writeObject(empresa1.arrayEmpleados);

			empresa1.fos.close();
			empresa1.oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			if (empresa1.arrayEmpleados[i] != null)
				System.out.println(empresa1.arrayEmpleados[i].toString());
		}

		Empleado empleado6 = empresa1.nuevoEmpleado("Michelle", 2000);
		Empleado empleado7 = empresa1.nuevoEmpleado("Manu", 2000);

		System.out.println("-----------");

		for (int i = 0; i < 10; i++) {
			if (empresa1.arrayEmpleados[i] != null)
				System.out.println(empresa1.arrayEmpleados[i].toString());
		}

		empresa1.despideEmpleado(1);
		empleado7.despedir();
		
		System.out.println("-----------");
		for (int i = 0; i < 10; i++) {
			if (empresa1.arrayEmpleados[i] != null)
				System.out.println(empresa1.arrayEmpleados[i].toString());
		}
		System.out.println("------------");
		System.out.println(empresa1.arrayEmpleados.toString());

		try {

			empresa1.fis = new FileInputStream(empresa1.ficheroEmpresa);
			Empleado[] empresaLeida = null;

			while (empresa1.fis.available() > 0) {
				empresa1.ois = new ObjectInputStream(empresa1.fis);
				empresaLeida = (Empleado[]) empresa1.ois.readObject();

			}
			
			for (Empleado unidad : empresaLeida)
				System.out.println(unidad);

			empresa1.ois.close();
			empresa1.fis.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
