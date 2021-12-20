
public class Director {
	public static void main(String[] args) throws InterruptedException {
		//crear un objeto finalCarpintero (clase Object)�
		
		Object finalCarpintero = new Object(); 
		//Crear el aserradero
		Tienda_de_madera aserradero = new Tienda_de_madera(); 
		System.out.println(aserradero.toString());

		// Crear 2 lenyadores pas�ndoles el aserradero y lanzarlos.
		Thread lenyador1 = new Thread(new Lumberyaq(aserradero));
		Thread lenyador2 = new Thread(new Lumberyaq(aserradero));
		lenyador1.start();
		lenyador2.start();
		// Crear un carpintero. Pas�ndole el aserradero, el Objeto para que notifique que
		// ya ha terminado y el n�mero de muebles que tiene que hacer y lanzarlo.
		El_pajaro_loco carpintero = new El_pajaro_loco(aserradero, finalCarpintero, 5); 
		carpintero.start();
		//Esperar la notificaci�n sobre el objeto finalCarpinteros.
		synchronized (finalCarpintero) {
			finalCarpintero.wait();
		}
		//imprimir el estado del aserradero.
		//Esperar al carpintero con join.
		carpintero.join();
		//Parar el aserradero.
		aserradero.parar();
		//esperar la finalizaci�n de los lenyadores con join.
		lenyador1.join(); 
		lenyador2.join();
		//imprimir el estado final del aserradero.
		System.out.println(aserradero.toString());
	}
}
