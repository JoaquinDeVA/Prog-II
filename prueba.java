

import java.util.*;
import java.util.stream.*;

public class prueba{



    public static void main(String[] args){
     
        System.out.println(iterativo(3000000));
        System.out.println(recursivo(3000));
        System.out.println(streams(3000));
    }


	public static double iterativo( long pasos){
		
		double resul = 0.0;

		for (int i = 0; i< pasos; i++){

			double x = Math.random();
			double y = Math.random();

			if(x*x + y*y <= 1){
				resul += 1;
			}
		}

		return resul*4/pasos;
	}

	public static double recursivo(long pasos){


		return auxliarRecursivo(pasos,0,0.0);
	}

	private static double auxliarRecursivo(long pasos, int indice, double resul){

		if (indice == pasos){

			return 4*(resul/indice);
		}

		double x = Math.random();
		double y = Math.random();

		if(x*x + y*y <= 1){
			resul ++;
		}
		return auxliarRecursivo(pasos, indice + 1 , resul);
	}


	public static double streams(long pasos){

		double puntos = Stream.generate(() -> new double[]{Math.random(),Math.random()} ).limit(pasos).filter(w -> w[0]*w[0] + w[1]*w[1] <= 1).count();
		return 4* puntos/ pasos;
	}














/* 
	//EJERCICIO 8 hoja de problemas
	public static String iterativo(String str){

		StringBuilder resul = new StringBuilder();

		while (!str.isEmpty()){

			if(str.charAt(0) % 2 == 0){
				resul.append(str.charAt(0));
			}
			str = str.substring(1);
		}
		return resul.toString();
	}

	public static String recursivo(String str){

		return auxiliarRecursivo(str, new StringBuilder());
	}

	private static String auxiliarRecursivo(String str, StringBuilder resul){

		if(str.isEmpty()){
			return resul.toString();
		}
		if(str.charAt(0) % 2 == 0){
			resul.append(str.charAt(0));
		}
		return auxiliarRecursivo(str.substring(1), resul);
	}


	public static String streams(String str){
		
		return Stream.iterate(0, w -> w+1).limit(str.length())
		.map(w-> str.charAt(w)).filter(w -> w % 2 == 0)
		.map(String::valueOf).collect(Collectors.joining());
	}












	t



/*  //CIFRADO CESAR, EJERCICIO 7
	public static String iterativo (String str, int desplazamiento){

		StringBuilder resul = new StringBuilder();

		while ( !str.isEmpty()){
			int base = (int) 'a';
			int x = (int) str.charAt(0);
			
			if( x < base){
				base = (int) 'A';
			}
			x = (x - base + desplazamiento)%26 + base;
			resul.append((char)x);
			str = str.substring(1);
		}


		return resul.toString();
	}



	public static String recursivo(String str, int desplazamiento){
		
		return auxliarRecursivo(str,desplazamiento, new StringBuilder());
	}

	private static String auxliarRecursivo(String str, int desplazamiento, StringBuilder resul){

		if (str.isEmpty()){
			return resul.toString();
		}
		int base = (int) 'a';
		int x = (int) str.charAt(0);

		if(x < base){

			base = (int) 'A';
		}

		x = (x-base+desplazamiento)%26 + base;
		resul.append((char) x);
		return auxliarRecursivo(str.substring(1), desplazamiento, resul);
	}



	public static String streams(String str, int desplazamiento){

		return Stream
		.iterate(0, w -> w+1)
		.limit(str.length())
		.map( w -> {
			char c = str.charAt(w);
			if(!Character.isLetter(c)){
				return c;
			}
			int base = (int) c >= (int) 'a' ? 'a' : 'A'; 
			return (char)(( c - base + desplazamiento)%26 + base);
			}
		).map(w -> String.valueOf(w))  
		.collect(Collectors.joining());
	}















	EJERCICIO 6 hoja de ejercicios

	public static int iterativo (String str){

		int resul = 0;

		while(!str.isEmpty()){

			resul += (int)str.charAt(0);
			str = str.substring(1);
		}

		return resul;
	}


	public static int recursivo (String str){

		if (str.isEmpty()){
			
			return 0;
		}
		return (int) str.charAt(0) + recursivo(str.substring(1));
	}

	public static int streams(String str){

		return Stream.iterate(0, w -> w+1).limit(str.length()).map(w -> (int)str.charAt(w)).reduce(0,(total,w) -> total + w);
	}













	


/* Ejercicio 4 hoja de ejercicios


	public static double iterativo(double limInf,double limSup,double h){

		double resul = 0.0;

		while ( limInf <= limSup){

			resul += (Math.pow( Math.E , Math.pow(limInf,2)) * h);
			limInf += h;
		}
		return resul;
	}

	public static double recursivo(double limInf,double limSup,double h){

		if (limInf > limSup){
			return 0.0;
		}

		return (Math.pow( Math.E, Math.pow(limInf,2)) * h) + recursivo(limInf + h, limSup, h);
	}

	public static double streams(double limInf,double limSup,double h){

		return Stream.iterate(limInf, w -> w + h).takeWhile( i ->  i <= limSup).reduce(0.0,(total,w) -> total += (Math.pow(Math.E,Math.pow(w,2)) * h));
	}













	POTENCIA DE BASE A LA N

	public static int iterativo(int n,int base){

		int resul = 1;

		for(int i=0;i<n;i++){

			resul *= base;
		}
		return resul;
	}

	public static int recursivo(int n,int base){
		
		if( n==0){
			return 1;
		}
		return base * recursivo(n-1, base);
	}

	public static int streams(int n,int base){
		
		final int aux = base;
		return Stream.generate(() -> aux).limit(n).reduce(1,(total,w) -> total * w);
	}








	FIBONACCI

	public static long iterativo (int n){

		int a = 0,c =0;
		int b =1;
		for(int i =0;i < n; i++){

			c = a + b;
			a = b;
			b = c;
		}
		return a;
	}
	
	public static long recursivo( int n){
		
		return auxliarRecursivo(n,0,0,1);
	}

	private static long auxliarRecursivo(int n, int indice,long actual,long siguiente){

		if (indice == n){
			return actual;
		}
		return auxliarRecursivo(n, indice + 1, siguiente, actual + siguiente);
	}
	
	public static long streams( int n){
		
		return Stream.iterate( new long[]{0,1}, w -> new long[]{w[1], w[0] + w[1]}).limit(n+1).map(w -> w[0]).reduce((total,w)-> w).orElse(null);
	}








	



    public static ArrayList<Integer> iterativo(int n){
	
		ArrayList<Integer> resul = new ArrayList<>();
		for(int i = 2;i <= n; i += 2){
			
			resul.add(i);
		}
		return resul;
    }

    public static ArrayList<Integer> recursivo(int n){
		
		ArrayList<Integer> resul = new ArrayList<>();
        return auxliarRecursivo(n,2,resul);
    }
	private static ArrayList<Integer> auxliarRecursivo(int n, int indice, ArrayList<Integer> resul){
		
		if(indice > n){
				return resul;
		}
		resul.add(indice);
		return auxliarRecursivo(n,indice + 2,resul);
	}

    public static ArrayList<Integer> streams(int n){

       
		return Stream.iterate(2,w-> w+2).limit(n/2).collect(Collectors.toCollection(()-> new ArrayList<>()));
		
    }

	*/

}