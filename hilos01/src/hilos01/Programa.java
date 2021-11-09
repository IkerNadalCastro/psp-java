package hilos01;

public class Programa {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Soy el hilo principal, voy a lanzar la tarea");
		
		Tarea t1 = new Tarea();
		t1.start(); //hay que lanzar con el start, aunque se haya implementado el run
		
		Thread t2 = new Thread(new TareaRunnable());
		t2.start();
		
		t2.join();
		t1.join();
			
		System.out.println("Fin del hilo principal.");

		
	}

}
