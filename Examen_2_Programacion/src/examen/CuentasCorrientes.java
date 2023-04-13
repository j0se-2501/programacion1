package examen;

public class CuentasCorrientes extends CuentasBancarias {
	
	//atributos

	private static final float INTERES_CORRIENTES = 5; //lo pongo como constante porque dice el enunciado que no va a cambiar
	
	//constructor
	
	public CuentasCorrientes(int idCuenta) {
		super(idCuenta, INTERES_CORRIENTES);
		// TODO Auto-generated constructor stub
	}
	
	//getter

	public static float getINTERES_CORRIENTES() {
		return INTERES_CORRIENTES;
	}
	
	//toString
	
	@Override
	public String toString() {
		return super.toString()+ " Tipo = Corriente,  Interes = " + getINTERES_CORRIENTES(); //amplia el toString de la clase padre
	}

}
