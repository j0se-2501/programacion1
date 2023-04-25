package basicos_06_arrays;

import java.util.Scanner;
import java.util.Random;

public class _06_3x3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String casilla[][];
		casilla=new String[3][3];
		int end=0, leer1=0, leer2=0, jugada=0, modo=1;

		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				casilla[i][j]=" ";

			}
		}

		System.out.println("\n   TRES EN RAYA \n\n PULSA 0 PARA JUGAR CONTRA LA CPU \n\n PULSA 1 PARA DOS JUGADORES\n");
		modo=sc.nextInt();
		
		if (modo==1) {
		
		System.out.println("     1.   2.   3.");

		for (int i=0; i<3; i++) {

			System.out.print(i+1+". ");
			for (int j=0; j<3; j++) {
				System.out.print("[ "+casilla[i][j]+" ]");
			}
			System.out.println("");
		}

		while (end==0 & jugada<9) {


			do {

				System.out.print("\n\nJUGADOR 1: \n\nElija fila. ");
				leer1= sc.nextInt();
				System.out.print("\nElija columna. ");
				leer2= sc.nextInt();
				System.out.println("");
				leer1=leer1-1;
				leer2=leer2-1;
				if (casilla[leer1][leer2]!=" ") {
					System.out.println("ERROR. Casilla ocupada.\n\n Pruebe otra vez.");

				}

			} while (casilla[leer1][leer2]!=" ");


			casilla[leer1][leer2]="X";
			jugada++;

			System.out.println("     1.   2.   3.");

			for (int i=0; i<3; i++) {
				System.out.print(i+1+". ");
				for (int j=0; j<3; j++) {
					System.out.print("[ "+casilla[i][j]+" ]");
				}
				System.out.println("");
			}

			if ((casilla[0][0]=="X" & casilla[0][1]=="X" & casilla[0][2]=="X" ) |
					(casilla[1][0]=="X" & casilla[1][1]=="X" & casilla[1][2]=="X" ) |
					(casilla[2][0]=="X" & casilla[2][1]=="X" & casilla[2][2]=="X" ) |
					(casilla[0][0]=="X" & casilla[1][0]=="X" & casilla[2][0]=="X" ) |
					(casilla[0][1]=="X" & casilla[1][1]=="X" & casilla[2][1]=="X" ) |
					(casilla[0][2]=="X" & casilla[1][2]=="X" & casilla[2][2]=="X" ) |
					(casilla[0][0]=="X" & casilla[1][1]=="X" & casilla[2][2]=="X" ) |
					(casilla[0][2]=="X" & casilla[1][1]=="X" & casilla[2][0]=="X" ))
			{
				System.out.println("\n\n  FIN DEL JUEGO  \n GANADOR: JUGADOR 1");
				end++;
			}

			if (jugada==9 & end==0) {

				System.out.println("\n\n FIN DEL JUEGO \n\n EMPATE \n\n\n                 ...vaya perdida de tiempo.");
			}

			if (end==0 &jugada<9) {
				do {

					System.out.print("\n\nJUGADOR 2: \n\nElija fila. ");
					leer1= sc.nextInt();
					System.out.print("\nElija columna. ");
					leer2= sc.nextInt();
					System.out.println("");
					leer1=leer1-1;
					leer2=leer2-1;
					if (casilla[leer1][leer2]!=" ") {
						System.out.println("ERROR. Casilla ocupada.\n\n Pruebe otra vez.");

					}

				} while (casilla[leer1][leer2]!=" ");
				
				
				
				casilla[leer1][leer2]="O";
				jugada++;
				
				System.out.println("     1.   2.   3.");
				for (int i=0; i<3; i++) {
					System.out.print(i+1+". ");
					for (int j=0; j<3; j++) {
						System.out.print("[ "+casilla[i][j]+" ]");
					}
					System.out.println("");
				}
			}

			if (((casilla[0][0]=="O" & casilla[0][1]=="O" & casilla[0][2]=="O" ) |
					(casilla[1][0]=="O" & casilla[1][1]=="O" & casilla[1][2]=="O" ) |
					(casilla[2][0]=="O" & casilla[2][1]=="O" & casilla[2][2]=="O" ) |
					(casilla[0][0]=="O" & casilla[1][0]=="O" & casilla[2][0]=="O" ) |
					(casilla[0][1]=="O" & casilla[1][1]=="O" & casilla[2][1]=="O" ) |
					(casilla[0][2]=="O" & casilla[1][2]=="O" & casilla[2][2]=="O" ) |
					(casilla[0][0]=="O" & casilla[1][1]=="O" & casilla[2][2]=="O" ) |
					(casilla[0][2]=="O" & casilla[1][1]=="O" & casilla[2][0]=="O" )) & (end==0))
			{
				System.out.println("\n\n  FIN DEL JUEGO  \n GANADOR: JUGADOR 2");
				end++;
			}

		}
		
		}
		
		if (modo==0) {
			
			System.out.println("     1.   2.   3.");

			for (int i=0; i<3; i++) {

				System.out.print(i+1+". ");
				for (int j=0; j<3; j++) {
					System.out.print("[ "+casilla[i][j]+" ]");
				}
				System.out.println("");
			}

			while (end==0 & jugada<9) {


				do {

					System.out.print("\n\nJUGADOR 1: \n\nElija fila. ");
					leer1= sc.nextInt();
					System.out.print("\nElija columna. ");
					leer2= sc.nextInt();
					System.out.println("");
					leer1=leer1-1;
					leer2=leer2-1;
					if (casilla[leer1][leer2]!=" ") {
						System.out.println("ERROR. Casilla ocupada.\n\n Pruebe otra vez.");

					}

				} while (casilla[leer1][leer2]!=" ");


				casilla[leer1][leer2]="X";
				jugada++;

				System.out.println("     1.   2.   3.");

				for (int i=0; i<3; i++) {
					System.out.print(i+1+". ");
					for (int j=0; j<3; j++) {
						System.out.print("[ "+casilla[i][j]+" ]");
					}
					System.out.println("");
				}

				if ((casilla[0][0]=="X" & casilla[0][1]=="X" & casilla[0][2]=="X" ) |
						(casilla[1][0]=="X" & casilla[1][1]=="X" & casilla[1][2]=="X" ) |
						(casilla[2][0]=="X" & casilla[2][1]=="X" & casilla[2][2]=="X" ) |
						(casilla[0][0]=="X" & casilla[1][0]=="X" & casilla[2][0]=="X" ) |
						(casilla[0][1]=="X" & casilla[1][1]=="X" & casilla[2][1]=="X" ) |
						(casilla[0][2]=="X" & casilla[1][2]=="X" & casilla[2][2]=="X" ) |
						(casilla[0][0]=="X" & casilla[1][1]=="X" & casilla[2][2]=="X" ) |
						(casilla[0][2]=="X" & casilla[1][1]=="X" & casilla[2][0]=="X" ))
				{
					System.out.println("\n\n  FIN DEL JUEGO  \n\n GANADOR: JUGADOR 1\n\n\n\n                ...Si es que estaba claro.");
					end++;
				}

				if (jugada==9 & end==0) {

					System.out.println("\n\n FIN DEL JUEGO \n\n EMPATE \n\n\n                 ...vaya perdida de tiempo.");
				}

				if (end==0 &jugada<9) {
					do {
						
						Random r1 =  new Random();
						leer1 = r1.nextInt(3);
						Random r2 =  new Random();
						leer2 = r2.nextInt(3);
						

					} while (casilla[leer1][leer2]!=" ");
					
					
					
					casilla[leer1][leer2]="O";
					jugada++;
					
					
					System.out.println("\n\nCPU: \n\n     1.   2.   3.");
					for (int i=0; i<3; i++) {
						System.out.print(i+1+". ");
						for (int j=0; j<3; j++) {
							System.out.print("[ "+casilla[i][j]+" ]");
						}
						System.out.println("");
					}
				}

				if (((casilla[0][0]=="O" & casilla[0][1]=="O" & casilla[0][2]=="O" ) |
						(casilla[1][0]=="O" & casilla[1][1]=="O" & casilla[1][2]=="O" ) |
						(casilla[2][0]=="O" & casilla[2][1]=="O" & casilla[2][2]=="O" ) |
						(casilla[0][0]=="O" & casilla[1][0]=="O" & casilla[2][0]=="O" ) |
						(casilla[0][1]=="O" & casilla[1][1]=="O" & casilla[2][1]=="O" ) |
						(casilla[0][2]=="O" & casilla[1][2]=="O" & casilla[2][2]=="O" ) |
						(casilla[0][0]=="O" & casilla[1][1]=="O" & casilla[2][2]=="O" ) |
						(casilla[0][2]=="O" & casilla[1][1]=="O" & casilla[2][0]=="O" )) & (end==0))
				{
					System.out.println("\n\n  FIN DEL JUEGO  \n GANADOR: CPU");
					end++;
				}

			}
			
			}

	}

}
