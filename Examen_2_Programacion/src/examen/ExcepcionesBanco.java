package examen;

public class ExcepcionesBanco extends Exception {
	
	protected String mensaje, idCuenta;

	public ExcepcionesBanco(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	

}
