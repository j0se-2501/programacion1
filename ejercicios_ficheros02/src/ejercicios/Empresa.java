package ejercicios;

import java.io.*;

public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//atributos
	
	
	private  String nombre;
	private  int tamanno;
	public  Empleado arrayEmpleados[];
	public  int contadorNumEmpleado;
	public  File ficheroEmpresa;
	
	public static FileInputStream fis = null;
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
	
	public static void despideEmpleado(int numEmpleado, Empresa empresa) {
		empresa.arrayEmpleados[numEmpleado-1]=null;
		try {
			empresa.fos = new FileOutputStream(empresa.ficheroEmpresa, false);
			empresa.oos = new ObjectOutputStream(fos);
			oos.reset();
			empresa.oos.writeObject(empresa.arrayEmpleados);
				
			empresa.fos.close();
			empresa.oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void nuevoEmpleado (String nombre, int sueldo, Empresa empresa) {
		Empleado empleado = new Empleado(nombre, sueldo, empresa);
		empresa.arrayEmpleados[empleado.numEmpleado-1]=empleado;
		try {
			empresa.fos = new FileOutputStream(empresa.ficheroEmpresa, false);
			empresa.oos = new ObjectOutputStream(fos);
			oos.reset();
			
			oos.writeObject(empresa.arrayEmpleados);
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
