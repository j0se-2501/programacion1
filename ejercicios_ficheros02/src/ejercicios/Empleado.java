package ejercicios;

import java.io.Serializable;

public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//atributos
	
	protected String nombre;
	protected int numEmpleado, sueldo;
	protected Empresa empresa;
	
	//constructor
	
	public Empleado(String nombre, int sueldo, Empresa empresa) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.empresa = empresa;
		this.numEmpleado = ++empresa.contadorNumEmpleado; //de esta forma el numero de empleado es autoincremental
	}
	
	protected Empleado(String nombre, int sueldo, Empresa empresa, int numEmpleado) { //constructor para asignarle un numero de empleado concreto; lo pide pero no se usa en el ejercicio
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.empresa = empresa;
		this.numEmpleado = numEmpleado;
	}
	
	//getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getNumEmpleado() {
		return numEmpleado;
	}

	//toString
	
	@Override
	public String toString() {
		return "Empleado [Num. empleado = " + getNumEmpleado() + ", Nombre = " + getNombre() + ", Sueldo = " + getSueldo() + "]";
	}
	
	//metodos propios
	
	public void aumentarSueldo(int porcentajeAumento) { //metodo para aumentar el sueldo, simple calculo y ya
		this.sueldo*=(1+(porcentajeAumento/100));
	}
	
	public void despedir() {
		empresa.despideEmpleado(this.numEmpleado); //llamo al metodo de la clase Empresa y le paso el numero de this Empleado
	}
	
	
	
	
	

}
