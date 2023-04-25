package ejercicios;

import java.io.*;

public class main {

	public static FileInputStream fis = null;
	public static ObjectInputStream ois = null;
	public static FileOutputStream fos = null;
	public static ObjectOutputStream oos = null;

	public static void main(String[] args) {

		Empresa empresa1 = new Empresa("Ilerna", 10); //creo a mano una empresa
		
		Empleado empleado1 = new Empleado("Pepe", 1500, empresa1);
		Empleado empleado2 = new Empleado("Carlos", 1500, empresa1);
		Empleado empleado3 = new Empleado("Maria", 1700, empresa1);
		Empleado empleado4 = new Empleado("Ana", 1800, empresa1);
		Empleado empleado5 = new Empleado("Juan", 1600, empresa1); //creo 6 empleados como solicita el ejercicio
		
		
		empleado1.aumentarSueldo(100); //pruebo el metodo aumentar sueldo

		empresa1.arrayEmpleados[0] = empleado1;
		empresa1.arrayEmpleados[1] = empleado2;
		empresa1.arrayEmpleados[2] = empleado3;
		empresa1.arrayEmpleados[3] = empleado4;
		empresa1.arrayEmpleados[4] = empleado5; //los introduzco en el array

		try {
			empresa1.fos = new FileOutputStream(empresa1.ficheroEmpresa, false);
			empresa1.oos = new ObjectOutputStream(empresa1.fos);
			empresa1.oos.reset();
			empresa1.oos.writeObject(empresa1.arrayEmpleados); //escribo el archivo con los empleados añadidos a mano mas arriba

			empresa1.fos.close();
			empresa1.oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Primer syso del array de empleados metidos a mano en el main:\n");

		for (int i = 0; i < 10; i++) { //con un for recorro el array; ojo, el array aquí en consola, no estoy leyendo el archivo
			if (empresa1.arrayEmpleados[i] != null)
				System.out.println(empresa1.arrayEmpleados[i].toString()); 
		}

		Empleado empleado6 = empresa1.nuevoEmpleado("Michelle", 2000); //añado dos empleados mediante el metodo nuevoEmpleado como solicita el ejercicio
		Empleado empleado7 = empresa1.nuevoEmpleado("Manu", 2000); //este metodo ya los escribe en el archivo

		System.out.println("-----------");
		System.out.println("Segundo syso, tras annadir con el metodo nuevoEmpleado a dos empleados:\n");

		for (int i = 0; i < 10; i++) {
			if (empresa1.arrayEmpleados[i] != null)
				System.out.println(empresa1.arrayEmpleados[i].toString()); //de nuevo recorro el array para ver si se han añadido bien los empleados
		}

		empresa1.despideEmpleado(1); //pruebo los dos metodos de despedir
		empleado7.despedir();
		
		System.out.println("-----------");
		System.out.println("tercer syso, para comprobar que funcionan los dos metodos de despedir:\n");
		System.out.println();
		for (int i = 0; i < 10; i++) {
			if (empresa1.arrayEmpleados[i] != null)
				System.out.println(empresa1.arrayEmpleados[i].toString()); //de nuevo recorro el array para ver si se han despedido los empleados
		}
		System.out.println("------------");
		System.out.println("cuarto syso, para comprobar que el archivo que se ha ido creando se lee correctamente:\n");

		try {

			empresa1.fis = new FileInputStream(empresa1.ficheroEmpresa);
			Empleado[] empresaLeida = null;

			while (empresa1.fis.available() > 0) {
				empresa1.ois = new ObjectInputStream(empresa1.fis);
				empresaLeida = (Empleado[]) empresa1.ois.readObject(); //ahora leo el archivo; creo un objeto array de empleados al que le paso el archivo con el metodo readObject
			}
			
			for (Empleado unidad : empresaLeida) //hago un for each del array de empleados para mostrar por pantalla que en efecto lee correctamente el archivo
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
