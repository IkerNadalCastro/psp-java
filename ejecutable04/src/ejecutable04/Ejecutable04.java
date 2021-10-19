package ejecutable04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejecutable04 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ProcessBuilder constructor = 
				new ProcessBuilder("bash", "/home/alumno/psp/repos/psp-test/retorno.sh", "1");
		Process bashRetorno = constructor.start(); 
		System.out.println(bashRetorno.exitValue());
		
		int retorno = bashRetorno.waitFor();
		
		ProcessBuilder constructor2 = new ProcessBuilder
				("bash", "/home/alumno/psp/repos/psp-test/retorno.sh", String.valueOf(retorno));
		Process bashRetorno2 = constructor2.start();
		System.out.println(bashRetorno.exitValue());
		
		int retorno2 = bashRetorno.waitFor();

	}
	
}
