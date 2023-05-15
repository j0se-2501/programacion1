package ejercicios;

import java.sql.*;

public class main {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/vehiculos";
	private static final String USUARIO = "vehiculosJL";
	private static final String PASSWORD = "1234abc";

	public static void main(String[] args) {
		
		main m = new main();
		m.insertData(); //inserto 10 registros
		m.getData(); //consulto todos los registros
		m.getData2019(); //consultos vehiculos del 2019
		m.eliminar2Registros(); //elimino los registros 1 y 2
		m.getData();	

	}
	
	public Connection conexionBBDD() {
		Connection conexion = null;
		
		try {
			
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(BBDD, USUARIO, PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	public void cerrarConexion(Connection conexion) {
		try {
			
			conexion.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getData() {

		Connection conec = conexionBBDD(); 
		
		if (conec != null)

		try {

		//Datos a consultar

		String consultaSeleccion = "SELECT * FROM vehiculos;"; 
		System.out.println(consultaSeleccion);

		// Creación del Statement para poder realizar las consultas.

		Statement consulta = conec.createStatement();

		//Ejecución de la consulta 
		
		if (consulta.execute(consultaSeleccion)) {

		ResultSet resultset = consulta.getResultSet();
		
		/*(int iD_Vehiculo, int anyo, int potencia, int plazas, String matricula, String marca, String modelo,
				String observaciones, double deposito, double consumo, boolean l_correcto)*/

		while (resultset.next()) {

		Vehiculo vehiculoConsulta = new Vehiculo (resultset.getInt ("ID_Vehiculo"), 
				resultset.getInt("Anyo"),
				resultset.getInt("Potencia"),
				resultset.getInt("Plazas"),
				resultset.getString("Matricula"),
				resultset.getString("Marca"),
				resultset.getString("Modelo"),
				resultset.getString("Observaciones"),
				resultset.getDouble("Deposito"),
				resultset.getDouble("Consumo"),
				resultset.getBoolean("L_correcto")
				);

		System.out.println(vehiculoConsulta.toString());
		
		}
		
		}

		System.out.println("Datos recuperados correctamente");

		consulta.close();

		} catch (SQLException e) {

		System.err.println("Se ha producido un error al insertar la base de datos.\n" + e);

		} finally {

		cerrarConexion (conec);
		
		}
	
	}
	
	public void getData2019() {

		Connection conec = conexionBBDD(); 
		
		if (conec != null)

		try {

		//Datos a consultar

		String consultaSeleccion = "SELECT * FROM vehiculos where Anyo = 2019;"; 
		System.out.println(consultaSeleccion);

		// Creación del Statement para poder realizar las consultas.

		Statement consulta = conec.createStatement();

		//Ejecución de la consulta 
		
		if (consulta.execute(consultaSeleccion)) {

		ResultSet resultset = consulta.getResultSet();
		
		/*(int iD_Vehiculo, int anyo, int potencia, int plazas, String matricula, String marca, String modelo,
				String observaciones, double deposito, double consumo, boolean l_correcto)*/

		while (resultset.next()) {

		Vehiculo vehiculoConsulta = new Vehiculo (resultset.getInt ("ID_Vehiculo"), 
				resultset.getInt("Anyo"),
				resultset.getInt("Potencia"),
				resultset.getInt("Plazas"),
				resultset.getString("Matricula"),
				resultset.getString("Marca"),
				resultset.getString("Modelo"),
				resultset.getString("Observaciones"),
				resultset.getDouble("Deposito"),
				resultset.getDouble("Consumo"),
				resultset.getBoolean("L_correcto")
				);

		System.out.println(vehiculoConsulta.toString());
		
		}
		
		}

		System.out.println("Vehiculos del 2019 recuperados correctamente");

		consulta.close();

		} catch (SQLException e) {

		System.err.println("Se ha producido un error al insertar la base de datos.\n" + e);

		} finally {

		cerrarConexion (conec);
		
		}
	
	}
	
	public void insertData() {

	Connection conec = conexionBBDD();

	if (conec != null)

	try { //Datos a Insertar

	String consultaInsercion = "INSERT INTO vehiculos (Matricula, Marca, Modelo, Anyo, Potencia, Plazas, Deposito, Consumo, L_correcto, Observaciones)"
	+"VALUES ('ABC123', 'Marca1', 'Modelo1', 2020, 150, 5, 60.5, 8.5, true, 'Sin observaciones'),"
	+ "('DEF456', 'Marca2', 'Modelo2', 2018, 120, 5, 55.2, 7.2, true, 'Sin observaciones'),"
	+ "('GHI789', 'Marca3', 'Modelo3', 2019, 140, 7, 65.3, 9.1, true, 'Sin observaciones'),"
	+ "('JKL012', 'Marca4', 'Modelo4', 2022, 180, 5, 70.2, 10.2, true, 'Sin observaciones'),"
	+ "('MNO345', 'Marca5', 'Modelo5', 2021, 130, 5, 58.7, 7.8, true, 'Sin observaciones'),"
	+ "('PQR678', 'Marca6', 'Modelo6', 2019, 110, 7, 62.1, 8.9, true, 'Sin observaciones'),"
	+ "('STU901', 'Marca7', 'Modelo7', 2020, 160, 5, 67.4, 9.5, true, 'Sin observaciones'),"
	+ "('VWX234', 'Marca8', 'Modelo8', 2022, 170, 5, 75.2, 10.6, true, 'Sin observaciones'),"
	+ "('YZA567', 'Marca9', 'Modelo9', 2021, 140, 7, 63.9, 9.2, true, 'Sin observaciones'),"
	+ "('BCD890', 'Marca10', 'Modelo10', 2023, 190, 5, 80.0, 11.0, true, 'Sin observaciones');";
	
	System.out.println(consultaInsercion);

	// Creación del statement para poder realizar las consultas.

	Statement consulta = conec.createStatement ();

	// Ejecución de la conilta

	consulta.executeUpdate(consultaInsercion);

	System.out.println("Datos insertados correctamente");

	// Cierre del state

	consulta.close();

	} catch (SQLException e) {
		
		e.printStackTrace();

	} finally {
		
		cerrarConexion(conec); //cierre de la conexion. cerrarConexion (conec);
		
	}

	
	}
	
	public void eliminar2Registros() {

		Connection conec = conexionBBDD(); 
		
		if (conec != null)

		try {

		//Datos a consultar

		String consultaSeleccion = "DELETE FROM vehiculos where ID_Vehiculo = 1 OR ID_Vehiculo = 2"; 
		System.out.println(consultaSeleccion);

		// Creación del Statement para poder realizar las consultas.

		Statement consulta = conec.createStatement();

		//Ejecución de la consulta 
		
		if (consulta.execute(consultaSeleccion)) {

		ResultSet resultset = consulta.getResultSet();
		
		/*(int iD_Vehiculo, int anyo, int potencia, int plazas, String matricula, String marca, String modelo,
				String observaciones, double deposito, double consumo, boolean l_correcto)*/
		
		}

		System.out.println("Registros 1 y 2 borrados correctamente");

		consulta.close();

		} catch (SQLException e) {

		System.err.println("Se ha producido un error al insertar la base de datos.\n" + e);

		} finally {

		cerrarConexion (conec);
		
		}
	
	}

}
