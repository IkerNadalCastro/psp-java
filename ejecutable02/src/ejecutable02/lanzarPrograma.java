package ejecutable02;

import java.io.*;
public class lanzarPrograma {

	public static void main(String[] args) throws Exception {
		
		Process proceso = Runtime.getRuntime().exec("ls");
		
		//conectamos un reader a la salida del proceso
		
		BufferedReader salida = new BufferedReader
				(new InputStreamReader(proceso.getInputStream()));
		String linea; 
		
		//mientras haya datos a la salida, léelos de línea en línea
		//e imprimelos por la salida estándar. 
		
		while (salida.ready()) {
			
			System.out.println(salida.readLine());
			
		}
		

	}

}
