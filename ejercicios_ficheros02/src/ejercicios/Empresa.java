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
	
	public void despideEmpleado(int numEmpleado) {
		this.arrayEmpleados[numEmpleado-1].empresa=null;
		this.arrayEmpleados[numEmpleado-1]=null;
		try {
			this.fos = new FileOutputStream(this.ficheroEmpresa, false);
			this.oos = new ObjectOutputStream(fos);
			oos.reset();
			this.oos.writeObject(this.arrayEmpleados);
			this.fos.close();
			this.oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Empleado nuevoEmpleado (String nombre, int sueldo) {
		Empleado empleado = new Empleado(nombre, sueldo, this);
		this.arrayEmpleados[empleado.numEmpleado-1]=empleado;
		try {
			this.fos = new FileOutputStream(this.ficheroEmpresa, false);
			this.oos = new ObjectOutputStream(fos);
			oos.reset();
			
			oos.writeObject(this.arrayEmpleados);
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return empleado;
		}
	}
	
	

}
