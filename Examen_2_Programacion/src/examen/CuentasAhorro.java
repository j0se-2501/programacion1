package examen;

public class CuentasAhorro extends CuentasBancarias {
	
	//atributos

	private float interesAhorro;
	
	//constructor
	
	public CuentasAhorro(int idCuenta, float interesAhorro) {
		super(idCuenta, interesAhorro);
		this.interesAhorro=interesAhorro;
	}
	
	//getters y setters

	public float getInteresAhorro() {
		return interesAhorro;
	}

	public void setInteresAhorro(float interesAhorro) {
		this.interesAhorro = interesAhorro;
	}

	//toString
	
	@Override
	public String toString() {
		return super.toString()+ " Tipo = Ahorro,  Interes = " + getInteresAhorro(); //amplia el toString de la clase padre
	}

}
