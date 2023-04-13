package examen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	
	//atributos
	
	
	public static ArrayList<CuentasBancarias> Cuentas = new ArrayList<CuentasBancarias>(); //declaracion del arraylist del banco
	public static int contadorID=1; //contador para los ID de las cuentas
	
	//metodo como tal del menu
	
	public static void menu() {
	
		
	int opcionMenu=7; //opcion por defecto fuera del rango 0-6 que se pide
	Scanner sc = new Scanner (System.in);
		
		
	//do while del menu
		
		
		
		do {
		System.out.println("\n-------------------------------------------------" //ascii art en el titulo del menu para que quede chulo
				+"\n_  _ ____ _  _ _  _    ___  ____ _  _ ____ ____ \r\n"
				+ "|\\/| |___ |\\ | |  |    |__] |__| |\\ | |    |  | \r\n"
				+ "|  | |___ | \\| |__|    |__] |  | | \\| |___ |__| \r\n"
				+ "                                               "
				+"\n-------------------------------------------------"
				+"\n\nElija una opcion: "
				+ "\n\n 1) Crear Cuenta"
				+ "\n 2) Ingresar Dinero"
				+ "\n 3) Retirar Dinero"
				+ "\n 4) Traspasar Dinero"
				+ "\n 5) Pagar Intereses a Cuentas"
				+ "\n 6) Mostrar Informe del Banco"
				+ "\n\n 0)Salir"
				+ "\n\n-------------------------------------------------");
		try { //try catch para el input mismatch exception al introducir una letra cuando se pide un numero; saldra por pantalla el mensaje default del case
		opcionMenu = sc.nextInt(); //recojo el input del usuario para navegar por el menu de opciones
		}
		catch(InputMismatchException a) {
			opcionMenu = 7;
			sc.nextLine();
		}
		try { //mismo try catch pero para las acciones una vez dentro del menu
			
			
		//switch del menu
		
			
		switch (opcionMenu) {
		
			case 1:
				float interes=0; 
				System.out.println("\nIntroduzca el tipo de cuenta: 'ahorro' o 'corriente': "); //pido datos al usuario
				String tipoCuenta = sc.next();
				if (tipoCuenta.equals("ahorro")) { //solo si la cuenta es de ahorro me interesa el tipo de interes, abajo en las de tipo corriente devuelvo la constante
				System.out.println("\nIntroduzca el tipo de interes: ");
				interes = sc.nextFloat();
				if (interes<0) {
					System.out.println("ERROR: el interes no puede ser negativo."); //uso un if para el error porque para el caso al poder poner un break en el case es lo mismo
					break;
				}
				}else if (tipoCuenta.equals("corriente")) {
					System.out.println("\nEl interes predeterminado de las cuentas corrientes es del: " +CuentasCorrientes.getINTERES_CORRIENTES());
				}else {
					System.out.println("\nERROR: introduzca un tipo de cuenta valido." //con el else obligo a que me de "corriente" o "ahorro", es otra forma de controlarlo
							+ "\nRecuerde respetar las minusculas tal como se le pide.");
					sc.nextLine(); //reseteo el scanner
					break;
				}
				crearCuenta(tipoCuenta, interes); //llamo al metodo que a su vez llamara al constructor con estos datos que pedi al usuario
				sc.nextLine();
				break;
			case 2:
				System.out.println("\nIntroduzca el ID de la cuenta que recibira el ingreso: ");
				int id = sc.nextInt();
				System.out.println("\nIntroduzca la cantidad de dinero a ingresar: ");
				float ingreso = sc.nextFloat();
			try { //try catch del throw que lanza este metodo
				ingresar(id, ingreso);
			} catch (ExcepcionesBanco e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMensaje());;
			}
				break;
			case 3:
				System.out.println("\nIntroduzca el ID de la cuenta que retirara el dinero: ");
				id = sc.nextInt();
				System.out.println("\nIntroduzca la cantidad de dinero a retirar: ");
				float retiro = sc.nextFloat();
			try {
				retirar(id, retiro);
			} catch (ExcepcionesBanco e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMensaje());
			}
				break;
			case 4:
				System.out.println("\nIntroduzca el ID de la cuenta que retirara el dinero: ");
				id = sc.nextInt();
				System.out.println("\nIntroduzca el ID de la cuenta que recibira el ingreso: ");
				int id2 = sc.nextInt();
				System.out.println("\nIntroduzca la cantidad de dinero a traspasar: ");
				float traspaso = sc.nextFloat();
			try {
				traspasar(id, id2, traspaso);
			} catch (ExcepcionesBanco e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMensaje());
			}
				break;
			case 5:
				System.out.println("\nSe pagara todos los intereses a los clientes: \n");
				pagarInteresesACuentas();
				break;
			case 6:
				System.out.println("\nSe mostraran todas las cuentas: \n");
				mostrarInforme();
				break;
			case 0:
				System.out.println("\n Cerrando la aplicacion.");
				break;
			default:
				System.out.println("\nERROR: Introduzca una opcion valida de entre las que aparecen en el menu.");
			}
		}catch(InputMismatchException a) {
			System.out.println("\nERROR: Introduzca un valor correcto. Use numeros y no letras cuando se le solicite dinero o numeros de cuenta, "
					+ "\nasi como comas (,) en vez de puntos (.) para los decimales.");
			sc.nextLine();
		}
		
		}while(opcionMenu!=0); //clasico 'mientras distinto de 0' que nos permitira seguir en el menu hasta que el usuario decida salir
	}

	
	
	
	//metodos 
	
	
	
	public static void crearCuenta(String tipoCuenta, float interes) {
		if (tipoCuenta.equals("ahorro")) Cuentas.add(new CuentasAhorro(contadorID++, interes)); //segun el atributo tipoCuenta creo una cuenta de un tipo o de otro
		if (tipoCuenta.equals("corriente")) Cuentas.add(new CuentasCorrientes(contadorID++)); //esta no necesita el atributo interes en su constructor, pues es una constante
	}

	
	public static void ingresar(int id, float cantidad) throws ExcepcionesBanco {
		if (cantidad<0) throw new ExcepcionesBanco("\nERROR: la cantidad a ingresar debe ser positiva"); //para controlar que la cantidad del ingreso sea positiva
		boolean flag=false; //booleano de control para controlar que existe una cuenta con el id que nos pasa el usuario
		for (CuentasBancarias unidad : Cuentas) {//for each para recorrer el arraylist
			if (unidad.getIdCuenta()==id) {
				unidad.setSaldoCuenta(unidad.getSaldoCuenta()+ cantidad);//sumo la cantidad que nos da el usuario
				flag=true;//activo la variable de control
			}
		}
		if(!flag) throw new ExcepcionesBanco("\nERROR: la cuenta solicitada no existe"); //si la variable de control no fue activada se devuelve este error
	}

	
	public static void retirar(int id, float cantidad) throws ExcepcionesBanco { //similar al metodo de ingresar pero con la retirada de dinero
		if (cantidad<0) throw new ExcepcionesBanco("\nERROR: la cantidad a retirar debe ser positiva");
		boolean flag=false;
		for (CuentasBancarias unidad : Cuentas) {
			if (unidad.getIdCuenta()==id) {
				if (unidad.getSaldoCuenta()-cantidad<0) throw new ExcepcionesBanco("\nERROR: El saldo restante en la cuenta no puede ser inferior a 0"); //para controlar que el saldo restante sea mayor que 0
				unidad.setSaldoCuenta(unidad.getSaldoCuenta()- cantidad);
				flag=true;
			}
		}
		if(!flag) throw new ExcepcionesBanco("\nERROR: la cuenta solicitada no existe");
	}

	
	public static void traspasar(int idEmisor, int idReceptor, float cantidad) throws ExcepcionesBanco { //simplemente reutilizo los dos metodos anteriores
		retirar(idEmisor, cantidad);
		ingresar(idReceptor, cantidad);
	}


	public static void pagarInteresesACuentas() {
		for (CuentasBancarias unidad : Cuentas) { //simple for each para recorrer el arrayList
			unidad.setSaldoCuenta(unidad.getSaldoCuenta()+((unidad.getSaldoCuenta()/100)*unidad.getInteres())); //calculo para sumar el porcentaje de interes que tiene cada cuenta
		}
		
	}


	public static void mostrarInforme() {
		for (CuentasBancarias unidad : Cuentas) System.out.println( unidad.toString()); //for each + toString de cada elemento del arrayList
		
	}

	
	
	
	

}
