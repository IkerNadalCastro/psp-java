package ejecutable3;

import java.io.*;

public class Ejecutable3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ProcessBuilder constructor = new ProcessBuilder("firefox");
		Process firefox = constructor.start(); 
		
		System.out.println(firefox.pid());
		
		Thread.sleep(5000);
		
		if (firefox.isAlive()) {
				
			System.out.println("El proceso firefox está vivo y con el pid: " + firefox.pid());
			
		} else {
			
			System.out.println("El proceso está muerto");
			
		}
		
		firefox.destroy();
		
		Thread.sleep(1000);
	
		if (firefox.isAlive()) {
					
			System.out.println("El proceso firefox está vivo y con el pid: " + firefox.pid());
					
		} else {
					
			System.out.println("El proceso está muerto");
					
		}
		
	}

}
