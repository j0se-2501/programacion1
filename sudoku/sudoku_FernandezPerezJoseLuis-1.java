package llamar_sudoku;

import java.util.Scanner;

public class sudoku_FernandezPerezJoseLuis {
	
public static void sudoku() {
		
		Scanner sc= new Scanner (System.in); //el usuario no introduce ningun dato relevante, es solo por estetica 
		int intentos=0; //variable de control para comprobar si un sudoku a medio generar es irresoluble
		
		int[][] plantilla = {
				
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				
		};
		
		int[][] casilla = {
				
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				{0, 0, 0, 0, 0, 0, 0, 0, 0},	
				
		};
		
		//genero ambas para poder mostrar solucion y plantilla simultaneamente;
		//me interesa rellenarlas a 0 para trabajar con ellas;
		//utilizo array para poder almacenar y manipular los datos facilmente;
		
		System.out.println("\n\n\n\n\r\n"
				+ "____ _  _ ___  ____ _  _ _  _    ____ ____ _  _ ____ ____ ____ ___ ____ ____ \r\n"
				+ "[__  |  | |  \\ |  | |_/  |  |    | __ |___ |\\ | |___ |__/ |__|  |  |  | |__/ \r\n"
				+ "___] |__| |__/ |__| | \\_ |__|    |__] |___ | \\| |___ |  \\ |  |  |  |__| |  \\ \r\n"
				+ "                                                                             \r\n"
				+ "");
		System.out.println("\n\n\n\n\n\n...Bienvenido al generador aleatorio de plantillas\n\n...de sudoku y sus soluciones.");
		System.out.println("\n\n\n\n...Las plantillas están generadas completamente al azar.");
		System.out.println("\n...En cada cuadrante se muestran, también al azar, \n\n...de tres a cinco numeros.");
		System.out.println("\n\n\n\n...Pulse 1 para generar una plantilla:\n\n\n\n");
		int tecla= sc.nextInt();
		System.out.println("\n\n");
		
		//inicio de la generacion aleatoria de casillas del sudoku
		
		do { //primer bucle para comprobar que, una vez salido del bucle de comprobacion de casillas, el sudoku se genero al 100%
		
			for (int i=0; i<9; i++) {
			
				for (int j=0; j<9; j++) { //doble for para recorrer el array
				
					do { //segundo bucle para comprobar que cada casilla se genera siguiendo las reglas del sudoku
					
						intentos++; //contador de intentos
				
						casilla[i][j]= (int)(Math.random()*9)+1; //generador aleatorio del 1 al 9 para cada casilla
				
					}while(!comprobaciones(casilla[i][j], i, j, casilla, intentos)); //aqui llamo a las funciones de Numeros.java
				
					if (intentos>700) { //si los intentos superan los 700, reinicio el bucle que recorre los arrays...
					
						j=9;
						i=9;
					
					
						for (int a=0; a<9; a++) { //...y tambien reinicio los valores de cada casilla a 0
						
							for (int b=0; b<9; b++) {
							
								casilla[a][b]=0;
							
							}
					
						}
					
					}
				
				}
	
			}		
		
			if (intentos>700) {
		
				intentos=0; //por ultimo, reinicio el contador de intentos a 0;

			}
		
		}while(casilla[8][8]==0); //hasta que la ultima casilla no obtenga un valor, no salimos del bucle
				
		//fin de la generacion aleatoria de casillas del sudoku
		
		for (int a=0; a<9; a++) { //este bucle es para igual los valores del array de casilla ya asignados al array de plantilla, hasta ahora vacio,
									//al que luego le borrare algunos valores para crear los espacios en blanco de la plantilla
			
			int b=0;
			
			recursiva (casilla, plantilla, b, a); //aqui incluyo la funcion recursiva requerida. Hace del bucle for que recorreria las columnas del array.
			
		}

		//inicio de la asignacion aleatoria de 4 a 6 casillas vacias por cuadrante
		
		//primero genero un numero aleatorio entre 4 y 6
		//y luego recorro cada cuadrante
		
		//se que podria haberme ahorrado repetir cada bucle por cuadrante... pero no encontre la forma facilmente
		//y repitiendolo asi, por cada cuadrante de 3x3, funciona tambien.
		
		int cont_en_blanco=0;//contador para las casillas que van siendo cambiadas a casillas en blanco
		int total_en_blanco= (int)(Math.random()*3)+4; //numero generado al azar de 4 a 6
		
		do {//con el bucle nos aseguramos que se llega al valor generado al azar de casillas vacias
		
			for (int c=0; c<3; c++) {
			
				for (int d=0; d<3; d++) {
				
					if (plantilla[c][d]!=0) {//este if asegura que, de repetirse el bucle
						//no se sobrescribirá una casilla ya vaciada con otro valor vacio;
						//si o si sera una casilla con numero
						
						int en_blanco= (int)(Math.random()*9); //numero generado al azar de 0 a 8
				
						if (en_blanco<4) { //si el numero anterior es menor de cuatro, la casilla ira en blanco
					
							plantilla[c][d]=0;
					
							cont_en_blanco++;
					
							if (cont_en_blanco==total_en_blanco) { //una vez se alcanza el numero generado de casillas en blanco
								//salimos del bucle for que recorre el array
														
								c=3;
								d=3;
						
							}
					
						}
				
					}
				
				}
			
			}
		
		}while(cont_en_blanco<total_en_blanco);
		
		cont_en_blanco=0;
		total_en_blanco= (int)(Math.random()*3)+4;
		
		do {
		
		for (int c=3; c<6; c++) {
			
			for (int d=0; d<3; d++) {
				
				if (plantilla[c][d]!=0) {
				
				int en_blanco= (int)(Math.random()*9);
				
				if (en_blanco<4) {
					
					plantilla[c][d]=0;
					
					cont_en_blanco++;
					
					if (cont_en_blanco==total_en_blanco) {
						
						c=6;
						d=3;
						
					}
					
				}
				
				}
				
			}
			
		}
		
		}while(cont_en_blanco<total_en_blanco);
		

		cont_en_blanco=0;
		total_en_blanco= (int)(Math.random()*3)+4;
		
		do {
		
		for (int c=6; c<9; c++) {
			
			for (int d=0; d<3; d++) {
				
				if (plantilla[c][d]!=0) {
				
				int en_blanco= (int)(Math.random()*9);
				
				if (en_blanco<4) {
					
					plantilla[c][d]=0;
					
					cont_en_blanco++;
					
					if (cont_en_blanco==total_en_blanco) {
						
						c=9;
						d=3;
						
					}
					
				}
				
				}
				
			}
			
		}
		
		}while(cont_en_blanco<total_en_blanco);
		

		cont_en_blanco=0;
		total_en_blanco= (int)(Math.random()*3)+4;
		
		do {
		
		for (int c=0; c<3; c++) {
			
			for (int d=3; d<6; d++) {
				
				if (plantilla[c][d]!=0) {
				
				int en_blanco= (int)(Math.random()*9);
				
				if (en_blanco<4) {
					
					plantilla[c][d]=0;
					
					cont_en_blanco++;
					
					if (cont_en_blanco==total_en_blanco) {
						
						c=3;
						d=6;
						
					}
					
				}
				
				}
				
			}
			
		}
		
		}while(cont_en_blanco<total_en_blanco);
		

		cont_en_blanco=0;
		total_en_blanco= (int)(Math.random()*3)+4;
		
		do {
		
		for (int c=3; c<6; c++) {
			
			for (int d=3; d<6; d++) {
				
				if (plantilla[c][d]!=0) {
				
				int en_blanco= (int)(Math.random()*9);
				
				if (en_blanco<4) {
					
					plantilla[c][d]=0;
					
					cont_en_blanco++;
					
					if (cont_en_blanco==total_en_blanco) {
						
						c=6;
						d=6;
						
					}
					
				}
				
				}
				
			}
			
		}
		
		}while(cont_en_blanco<total_en_blanco);
		

		cont_en_blanco=0;
		total_en_blanco= (int)(Math.random()*3)+4;
		
		do {
		
		for (int c=6; c<9; c++) {
			
			for (int d=3; d<6; d++) {
				
				if (plantilla[c][d]!=0) {
				
				int en_blanco= (int)(Math.random()*9);
				
				if (en_blanco<4) {
					
					plantilla[c][d]=0;
					
					cont_en_blanco++;
					
					if (cont_en_blanco==total_en_blanco) {
						
						c=9;
						d=6;
						
					}
					
				}
				
				}
				
			}
			
		}
		
		}while(cont_en_blanco<total_en_blanco);
		

		cont_en_blanco=0;
		total_en_blanco= (int)(Math.random()*3)+4;
		
		do {
		
		for (int c=0; c<3; c++) {
			
			for (int d=6; d<9; d++) {
				
				if (plantilla[c][d]!=0) {
				
				int en_blanco= (int)(Math.random()*9);
				
				if (en_blanco<4) {
					
					plantilla[c][d]=0;
					
					cont_en_blanco++;
					
					if (cont_en_blanco==total_en_blanco) {
						
						c=3;
						d=9;
						
					}
					
				}
				
				}
				
			}
			
		}
		
		}while(cont_en_blanco<total_en_blanco);
		

		cont_en_blanco=0;
		total_en_blanco= (int)(Math.random()*3)+4;
		
		do {
		
		for (int c=3; c<6; c++) {
			
			for (int d=6; d<9; d++) {
				
				if (plantilla[c][d]!=0) {
				
				int en_blanco= (int)(Math.random()*9);
				
				if (en_blanco<4) {
					
					plantilla[c][d]=0;
					
					cont_en_blanco++;
					
					if (cont_en_blanco==total_en_blanco) {
						
						c=6;
						d=9;
						
					}
					
				}
				
				}
				
			}
			
		}
		
		}while(cont_en_blanco<total_en_blanco);
		

		cont_en_blanco=0;
		total_en_blanco= (int)(Math.random()*3)+4;
		
		do {
		
		for (int c=6; c<9; c++) {
			
			for (int d=6; d<9; d++) {
				
				if (plantilla[c][d]!=0) {
				
				int en_blanco= (int)(Math.random()*9);
				
				if (en_blanco<4) {
					
					plantilla[c][d]=0;
					
					cont_en_blanco++;
					
					if (cont_en_blanco==total_en_blanco) {
						
						c=9;
						d=9;
						
					}
					
				}
				
				}
				
			}
			
		}
		
		}while(cont_en_blanco<total_en_blanco);
		
		
		
		//aqui comienza la impresion de la plantilla
		//se trata de un sencillo bucle doble de for para recorrer el array
		//lo hago dos veces: una para la plantilla y otra para la solucion
		
		System.out.println("—————————————————————————————————————");
		for (int i=0; i<9; i++) {
			
			System.out.print("| ");
			
				for (int j=0; j<9; j++) {
				
					if (plantilla[i][j]==0) {
					
						System.out.print("[ ]");
					
					}else
				
						System.out.print("[" + plantilla[i][j] + "]");
					
					if (j==2 | j==5 | j==8) {
					
						System.out.print(" | ");
					
						if (j==8 & (i==2 | i==5 | i==8)) {
						
							System.out.println("");
							System.out.print("—————————————————————————————————————");
						
						}
					
					}
				
				}
			
				System.out.println("");
			
			}
		
	System.out.println("\n\n\n...Pulse 1 para ver la solucion:\n\n");
		
	tecla= sc.nextInt();
		
	System.out.println("\n\n");
	
	System.out.println("—————————————————————————————————————");
	for (int i=0; i<9; i++) {
			
		System.out.print("| ");
			
		for (int j=0; j<9; j++) {
				
			System.out.print("[" + casilla[i][j] + "]");
					
			if (j==2 | j==5 | j==8) {
					
				System.out.print(" | ");
					
				if (j==8 & (i==2 | i==5 | i==8)) {
						
					System.out.println("");
					System.out.print("————————————————————————————————————");
						
				}
					
			}
				
			}
		
		System.out.println("");
			
	}
		

}

//En esta clase almaceno las funciones de comprobación de cada casilla.//
//En concreto, tengo funciones para comprobar si el numero generado al azar ya se encuentra
//en su misma columna, fila o cuadrante de 3x3.//

private static boolean comprobaciones (int num, int lin, int colum, int[][] casilla, int tries) {
	
	//la idea de agrupar las tres comprobaciones en una sola funcion es de un video de youtube.//
	//link: https://www.youtube.com/watch?v=mcXc8Mva2bA&t //
	//El programa del video RESUELVE sudoku, no los genera; pero me ayudó sobre todo a la comprobacion del cuadrante de 3x3.//
	
	if (tries>700) return true; //Quiero que pasados X intentos de rellenar casillas, deje de intentar el sudoku,//
								//ya que seguramente este es irresoluble. Devolviendo true, salgo del bucle.//
	
	return columna(num, colum, casilla) & fila(num, lin, casilla) & cuadrante(num, lin, colum, casilla);
	
	//Al ser una operacion de AND, necesito que las tres comprobaciones retornen true, para que esta funcion retorne true//
	
}
		

private static boolean fila (int num, int lin, int[][] casilla) {
	
	//Compruebo en una misma fila del array si ya existe ese numero//
	
	int cont=0;
	
	for (int i=0; i<9; i++) {
	
		if (casilla[lin][i]==num){
			
			cont++;
			
		}
		
	}	
	
	if (cont>1) { //al comprobar toda la fila, se incluye la casilla a comprobar,
					//con lo que se espera ya que el contador sea como minimo 1;
					//de ahi el mayor que 1 para retornar que sí que existe otro numero igual
		
		return false;
		
	} else {
	
	return true; //si solo se encuentra la misma casilla que se comprueba, retorna true
		
	}
	
}
	

	


private static boolean columna (int num, int colum, int[][] casilla) {

	//igual que la funcion de comprobacion de fila pero con la columna
	
	int cont=0;
	
	for (int i=0; i<9; i++) {
	
		if (casilla[i][colum]==num){
			
			cont++;
			
		}
		
	}	
	
	if (cont>1) {
		
		return false;
		
	} else {
	
	return true;
		
	}
	
}


	

private static boolean cuadrante (int num, int lin, int colum, int[][] casilla) {

//como mencione, esta sacado del video de youtube arriba enlazado.
//añadi lo del contador y las variables propias
//utiliza MOD 3 para determinar el cuadrante en que se encuentra
//por lo demas, es igual a las otras comprobaciones

int cont=0;
  int localBoxRow = lin - lin % 3;
    int localBoxColumn = colum - colum % 3;
    
    for (int i = localBoxRow; i < localBoxRow + 3; i++) {
      for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
        if (casilla[i][j] == num) {
          cont++;
        }
      }
    }
    if (cont>1) {
		
		return false;
		
	} else {
	
	return true;
		
	}

}

private static void recursiva (int[][] casilla, int[][] plantilla, int b, int a) {
	
	if (b==9) {
		
		return;
	}
	
	plantilla[a][b]=casilla[a][b];
	
	
	recursiva (casilla, plantilla, b+1, a);
	
	
}

}

	
