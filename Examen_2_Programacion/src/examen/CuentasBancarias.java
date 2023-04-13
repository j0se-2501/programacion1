package examen;

public class CuentasBancarias {
	
	//atributos
	
	private float saldoCuenta;
	private int idCuenta;
	private float interes;
	
	//getters y setters
	
	public float getSaldoCuenta() {
		return saldoCuenta;
	}
	public void setSaldoCuenta(float saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	
	public float getInteres() {
		return interes;
	}
	public void setInteres(float interes) {
		this.interes = interes;
	}
	
	//constructores

	public CuentasBancarias(int idCuenta, float interes) {
		super();
		this.saldoCuenta = 0;
		this.idCuenta = idCuenta;
		this.interes = interes;
	}
	
	public CuentasBancarias() {
		
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Cuenta ID = " + getIdCuenta() + ", Saldo = "+getSaldoCuenta() + "Euros, ";
	}
	
	
	

}
