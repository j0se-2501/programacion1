package ejercicios;

public class Vehiculo {
	
	//atributos
	
	protected int ID_Vehiculo, Anyo, Potencia, Plazas;
	protected String Matricula, Marca, Modelo, Observaciones;
	protected double Deposito, Consumo;
	protected boolean L_correcto;
	
	public Vehiculo(int iD_Vehiculo, int anyo, int potencia, int plazas, String matricula, String marca, String modelo,
			String observaciones, double deposito, double consumo, boolean l_correcto) {
		super();
		ID_Vehiculo = iD_Vehiculo;
		Anyo = anyo;
		Potencia = potencia;
		Plazas = plazas;
		Matricula = matricula;
		Marca = marca;
		Modelo = modelo;
		Observaciones = observaciones;
		Deposito = deposito;
		Consumo = consumo;
		L_correcto = l_correcto;
	}

	@Override
	public String toString() {
		return "Vehiculo [ID_Vehiculo=" + ID_Vehiculo + ", Anyo=" + Anyo + ", Potencia=" + Potencia + ", Plazas="
				+ Plazas + ", Matricula=" + Matricula + ", Marca=" + Marca + ", Modelo=" + Modelo + ", Observaciones="
				+ Observaciones + ", Deposito=" + Deposito + ", Consumo=" + Consumo + ", L_correcto=" + L_correcto
				+ "]";
	}
	
	
	
	
}
