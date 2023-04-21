package ejercicios_ficheros03;

import java.io.*;

public class Vehiculo implements Serializable {

	// atributos

	private String matricula, marca, modelo;
	private double litrosDeposito;

	// constructor

	public Vehiculo(String matricula, String marca, double litrosDeposito, String modelo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.litrosDeposito = litrosDeposito;
		this.modelo = modelo;
	}

	// getters y setters

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getLitrosDeposito() {
		return litrosDeposito;
	}

	public void setLitrosDeposito(double litrosDeposito) {
		this.litrosDeposito = litrosDeposito;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [Matricula = " + getMatricula() + " Marca = " + getMarca() + ", Litros del Deposito = "
				+ getLitrosDeposito() + "L, Modelo = " + getModelo() + "]";
	}

}
