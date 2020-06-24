/*
 * Cálculo del máximo común divisor (m.c.d.) de dos números mediante el
 * algoritmo de Euclides.
 * 
 * Un ejemplo de este algoritmo en su versión de división euclidiana lo podéis ver en este vídeo de Youtube:
 * https://www.youtube.com/watch?v=x6qFMSRpgpM
 */

package euclides;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int mcd, mcd1,mcd2 = 0;
		int num1,num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Número 1: ");
		while(!sc.hasNextInt()) {
			System.out.print("Número1 no es un entero. Dame número: ");
			sc.next();
		}
		num1 = sc.nextInt();
			
		System.out.print("Número 2: ");
		while(!sc.hasNextInt()) {
			System.out.print("Número2 no es un entero. Dame número: ");
			sc.next();
		}
		num2 = sc.nextInt();
		
		sc.close();
		
		
		// (a) Algoritmo Euclides. Método restas sucesivas
		
		mcd = euclidesRestas(num1,num2);
		
		// (b) Algoritmo Ecuclides. Metodo division euclidiana
		
		// (b.1) Iterativo.
		mcd1 = euclidesDivisiones(num1,num2);
		
		// (b.2) Recursivo
		mcd2 = euclidesDivisionesRec(num1,num2);	

		
		
		// Imprime resultados
		System.out.println("mcd (método restas sucesivas, iterativo) = " + mcd);
		System.out.println("mcd (método división euclidiana, iterativo) = " + mcd1);
		System.out.println("mcd (método división euclidiana, recursivo) = " + mcd2);

	}

	private static int euclidesRestas(int num1, int num2) {
		while(num1 != num2) {
			
			if(num1 > num2) 
				num1 = num1 - num2;
			else 
				num2 = num2 - num1;
			
		}
		return num1;
	}
	
	private static int euclidesDivisiones(int num1, int num2) {
		
		// Dividendo es el mayor de ambos números y divisor el menor
		int dividendo =  num1 >= num2 ? num1 :num2;
		int divisor =  num1 < num2 ? num1 : num2;
				
		while (divisor != 0) {
		
			int divisorTemp = divisor;
			divisor = dividendo % divisor;	
			dividendo = divisorTemp;
		}
		
		return dividendo;
	}
	
	
	// Vesión del método euclidesDivisiones realizado con método recursivo

	private static int euclidesDivisionesRec(int num1, int num2) {
		
		// Dividendo es el mayor de ambos números y divisor el menor

		int dividendo =  num1 >= num2 ? num1 :num2;
		int divisor = num1 < num2 ? num1 : num2;

		if(divisor == 0) return dividendo;
		
		return euclidesDivisionesRec(divisor, dividendo % divisor);
	}
}
