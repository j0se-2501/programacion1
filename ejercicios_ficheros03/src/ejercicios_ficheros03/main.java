package ejercicios_ficheros03;

public class main {

	public static void main(String[] args) {

		Ej01_Copia.copiarArchivos(); // a veces genera el texto del archivo original en chino; segun stack overflow,
										// es porque el metodo readUTF
										// solo esta pensado para readUTF. Sea como sea, me parece mas interesante crear
										// un archivo asi
										// que crear un archivo de int, y si creo un archivo dat con texto, no me lo
										// pilla el metodo readUTF

		Ej02_Random.generarArchivoConRandom();

		Ej03_vehiculoFicheros.menuVehiculo();
	}

}
