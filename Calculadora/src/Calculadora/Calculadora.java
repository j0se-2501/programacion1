package Calculadora;

public class Calculadora {

	private Integer pantalla;
	
	public Calculadora() {
		pantalla = 0;
	}
	
	/** Suma al número en pantalla el número indicado por parámetro */
	public void suma(Integer numero) {
		pantalla += numero;
	}

	/** Resta al número en pantalla el número indicado por parámetro */
	public void resta(Integer numero) {
		pantalla -= numero;
	}

	/** Multiplica el número en pantalla por el número indicado por parámetro */
	public void multiplica(Integer numero) {
		pantalla = pantalla * numero;
	}

	/** Divide el número en pantalla por número indicado por parámetro si este es distinto de cero */
	public void divide(Integer numero) {
		if (numero != 0) {
			pantalla = pantalla / numero;
		}
	}

	/** Cambia el número de la pantalla por el tanto por ciento del valor indicado */
	public void porcentaje(Integer numero) {
		pantalla = pantalla * numero / 100;
	}
	
	/** Cambia el numero de la pantalla a cero */
	public void resetea() {
		pantalla = 0;
	}
	
	/** Devuelve el número en pantalla */
	public Integer getPantalla() {
		return pantalla;
	}
	
}
