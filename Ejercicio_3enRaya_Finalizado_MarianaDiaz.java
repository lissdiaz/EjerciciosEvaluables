package TareasEvaluables;

import java.util.Scanner;

public class Ejercicio_3enRaya_Finalizado_MarianaDiaz {
	//Variables Globales
	static Scanner in = new Scanner(System.in);
	static char[] tablero=new char [9];
	/*solo puede tener 3 valores: ‘ ‘(vacía, valor inicial),
	‘X’(ficha jugador 1), ‘O’ (ficha del jugador 2).*/

	public static void main(String[] args) {
		//Zona de Declaración de Variables
		int empates=0;
		int gana1=0;
		int gana2=0;
		int partidas=0;
		int opcion=0;
		int pos=0;
		//Rellenar el tablero con espacios vacíos
		for (int i=0; i<=8; i++) {
			tablero[i]=' ';
		}
		//Inicio del programa
		System.out.println("---- BIENVENIDO AL 3 EN RAYA DE MARIANA ----");
		System.out.println(" ");
		mostrarposicion();
		dibujarTablero();
		vaciarTablero();
		System.out.println(" ");
		do {
			System.out.println("Seleccione una opción:\n"
					+ "1. Jugar una partida\n"
					+ "2. Mostrar estadísticas\n"
					+ "3. Salir");
			System.out.println();
			opcion=in.nextInt();
			if (opcion==1) {
				vaciarTablero(); 
				while (quedanCasillasVacias()==true && ganaJugador1()!=true && ganaJugador2()!=true) {
					/*Con ambas condiciones (while e if) se comprueba si el movimiento en sí es válido.
					 * Comprobando tanto las casillas vacías dentro del tablero, así como también si
					 * uno de los dos jugadores ha completado una raya de tres posiciones dentro del tablero*/
					if (quedanCasillasVacias()==true && ganaJugador1()!=true && ganaJugador2()!=true) {
						System.out.println("Elige tu posición, jugador 1 ");
						pos=in.nextInt();
						while (movimientoValido(pos)==false) {
							System.out.println("Movimiento invalido, mueva nuevamente");
							pos=in.nextInt();
						}
						movimientoJugador1(pos);
						dibujarTablero();
					}
					if (quedanCasillasVacias()==true && ganaJugador1()!=true && ganaJugador2()!=true) {
						System.out.println("Elige tu posición, jugador 2 ");
						pos=in.nextInt();
						while (movimientoValido(pos)==false) {
							System.out.println("Movimiento invalido, mueva nuevamente");
							pos=in.nextInt();
						}
						movimientoJugador2(pos);
						dibujarTablero();
					}
				}
				if (ganaJugador1()==true) {
					System.out.println("Ha ganado Jugador 1");
					gana1=gana1+1;
					partidas=partidas+1;
				}
				if (ganaJugador2()==true) {
					System.out.println("Ha ganado Jugador 2");
					gana2=gana2+1;
					partidas=partidas+1;
				}
				if (quedanCasillasVacias()==false && ganaJugador1()==false &&ganaJugador2()==false) {
					System.out.println("Empate!!");
					empates=empates+1;
					partidas=partidas+1;
				}
			}
			if(opcion==2){
				System.out.println();
				System.out.println("Las estadísticas se encuentran de la siguiente manera:");
				System.out.println(" · El jugador 1 ha ganado: "+gana1);
				System.out.println(" · El jugador 2 ha ganado: "+gana2);
				System.out.println(" · Ha habido: "+empates+" empates");
				System.out.println(" · Se han jugado: "+partidas+" partidas");
				System.out.println();
			}
		}while (opcion!=3);
			System.out.println("Espero mi juego te haya parecido divertido!! \n"
					+ "Hasta la próxima!");
}
	
	//FUNCIONES 
	public static void dibujarTablero() {
	//dibuja un tablero de nueve posiciones con el array dentro del tablero.
			System.out.println("-------------");
			for (int posicion=0; posicion<=8; posicion=posicion+3) {
				System.out.println("| "+tablero[posicion+0]+" | "+tablero[posicion+1]+" | "+tablero[posicion+2]+" |");
				System.out.println("-------------");
			}
		}
	
	public static void vaciarTablero() {
	//pone el tablero vacío, con código ASCII.
		char vacio=32;
		for (int i=0; i<=8; i++) {
			tablero[i]=vacio;
		}
	}

	public static void movimientoJugador1(int pos) {
	//Ubica la posición elegida por el jugador en la posición del array.
		tablero[pos-1]='x';
	}
	
	public static void movimientoJugador2(int pos) {
	//Ubica la posición elegida por el jugador en la posición del array.
		tablero[pos-1]='o';
	}
	
	public static boolean movimientoValido(int pos) {
	/*Primero comprueba que la posición elegida por el jugador es válida, es decir
	 *está dentro de 1 al 9, que son las posiciones presentadas al principio del juego.
	 *Además de comprobar que la posición elegida por el jugador contiene un espacio
	 *vacío para poder colocar ahí su posición de tirada.*/
		if (pos<1 || pos>9) {
			return false;
		}
		if (tablero[pos-1]==' ') {
			return true;
		}
		return false;
	}
	
	public static boolean quedanCasillasVacias() {
	/*Comprueba de forma constante si aún hay casillas libres para 
	 * poder seguir desarrollando el juego y permitir a los jugadores elegir 
	 * posiciones.*/
		for (int i=0; i<=8; i++) {
			if (tablero[i]==' ') {
				return true;
			}
		}
		return false;
	}
			
	public static boolean ganaJugador1() {
	/*comprueba si el jugador a realizado una raya, ya sea de forma vertical,
	 * horizontal o en diagonal, por medio de las posiciones del array en el tablero.*/
		//Revisar de forma horizontal:
		if ((tablero[0]=='x') && (tablero[1]=='x') && (tablero[2]=='x')){
			return true;
		}
		if ((tablero[3]=='x') && (tablero[4]=='x') && (tablero[5]=='x')){
			return true;
		}
		if ((tablero[6]=='x') && (tablero[7]=='x') && (tablero[8]=='x')){
			return true;
		//Revisar de forma vertical:
		}
		if ((tablero[0]=='x') && (tablero[3]=='x') && (tablero[6]=='x')){
			return true;
		}
		if ((tablero[1]=='x') && (tablero[4]=='x') && (tablero[7]=='x')){
			return true;
		}
		if ((tablero[2]=='x') && (tablero[5]=='x') && (tablero[8]=='x')){
			return true;
		//REvisar de forma diagonal:
		}
		if ((tablero[0]=='x') && (tablero[4]=='x') && (tablero[8]=='x')){
			return true;
		}
		if ((tablero[2]=='x') && (tablero[4]=='x') && (tablero[6]=='x')){
			return true;
		}
		return false;
	}
		
	public static boolean ganaJugador2() {
	/*comprueba si el jugador a realizado una raya, ya sea de forma vertical,
	 * horizontal o en diagonal, por medio de las posiciones del array en el tablero.*/
		//Revisar de forma horizontal:
		if ((tablero[0]=='o') && (tablero[1]=='o') && (tablero[2]=='o')){
			return true;
		}
		if ((tablero[3]=='o') && (tablero[4]=='o') && (tablero[5]=='o')){
			return true;
		}
		if ((tablero[6]=='o') && (tablero[7]=='o') && (tablero[8]=='o')){
			return true;
		//Revisar de forma vertical:
		}
		if ((tablero[0]=='o') && (tablero[3]=='o') && (tablero[6]=='o')){
			return true;
		}
		if ((tablero[1]=='o') && (tablero[4]=='o') && (tablero[7]=='o')){
			return true;
		}
		if ((tablero[2]=='o') && (tablero[5]=='o') && (tablero[8]=='o')){
			return true;
		}
		//Revisar de forma diagonal:
		if ((tablero[0]=='o') && (tablero[4]=='o') && (tablero[8]=='o')){
			return true;
		}
		if ((tablero[2]=='o') && (tablero[4]=='o') && (tablero[6]=='o')){
			return true;
		}
		return false;
	}
	
	
	//Funciones adicionales
	public static void mostrarposicion () {
		//Función para mostrar las posiciones del tablero del 1 al 9 a los jugadores.
			for (int j=0; j<=8 ; j++) {
			tablero[j]=(char) (j+'1');
			}
			System.out.println("Las posiciones del tablero, están enumeradas de la siguiente manera: ");	
	}
}
