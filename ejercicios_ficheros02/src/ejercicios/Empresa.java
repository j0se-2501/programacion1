package ejercicios;

import java.io.*;

public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//atributos
	
	
	private String nombre;
	private int tamanno;
	public  Empleado arrayEmpleados[];
	public  int contadorNumEmpleado;
	public  File ficheroEmpresa;
	
	public static FileInputStream fis = null; //   IMPORTANTE que todas las variables de lectura y escritura sean public static, si no, no es serializable
	public static ObjectInputStream ois = null;
	public static FileOutputStream fos = null;
	public static ObjectOutputStream oos = null;

	
	//constructor
	
	public Empresa(String nombre, int tamanno) {
		super();
		this.nombre = nombre;
		this.tamanno = tamanno;
		this.arrayEmpleados = new Empleado[tamanno];
		this.ficheroEmpresa = new File ("archivos//fichero empresa "+nombre);
		
	}
	
	//getters y setters

	public String getNombre() {
		return nombre;
	}

	public int getTamanno() {
		return tamanno;
	}
	
	//metodos
	
	public Empleado getEmpleado(int numEmpleado) {
		return arrayEmpleados[numEmpleado];
	}
	
	public void despideEmpleado(int numEmpleado) {
		this.arrayEmpleados[numEmpleado-1].empresa=null; //asigno la empresa del empleado a null puesto que ya no pertenece a esa empresa
		this.arrayEmpleados[numEmpleado-1]=null; //asigno null a la casilla del array que ocupaba ese empleado
		try {
			this.fos = new FileOutputStream(this.ficheroEmpresa, false);
			this.oos = new ObjectOutputStream(fos);
			oos.reset();
			this.oos.writeObject(this.arrayEmpleados); //reescribo en el archivo el array de empleados en su totalidad
			this.fos.close();
			this.oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Empleado nuevoEmpleado (String nombre, int sueldo) {
		Empleado empleado = new Empleado(nombre, sueldo, this); //llamo al constructor de empleado con los datos que se han pasado al metodo
		this.arrayEmpleados[empleado.numEmpleado-1]=empleado; //le asigno su posicion en el array de empleados
		try {
			this.fos = new FileOutputStream(this.ficheroEmpresa, false);
			this.oos = new ObjectOutputStream(fos);
			oos.reset();
			oos.writeObject(this.arrayEmpleados); //reescribo en el archivo el array de empleados en su totalidad
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return empleado; //retorno un empleado para que en el main despues tenga un nombre el objeto empleado que creo aqui
		}
	}
	
	

}
