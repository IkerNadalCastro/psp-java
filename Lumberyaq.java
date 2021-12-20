import java.util.concurrent.ThreadLocalRandom;

public class Lumberyaq implements Runnable {

	Tienda_de_madera aserradero;

	public Lumberyaq(Tienda_de_madera aserradero) {
		super();
		this.aserradero = aserradero;
	}

	@Override
	public void run() {
		// Mientras el aserradero no esté parado,
		while(!aserradero.aserraderoParado()) {
			
			// el carpintero dormirá un tiempo aleatorio entre 1 y 2 segundos:
			int randomNumero = ThreadLocalRandom.current().nextInt(1000, 2000 + 1); 
			try {
				Thread.sleep(randomNumero);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// y añadirá un número aleatorio entre 1 y 3 unidades de madera al aserradero.
			int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			aserradero.agregarMadera(randomNum);
			
			System.out.println("[Lenyador]: He generado " + randomNum + " madera. ");
			
			synchronized (aserradero) {
				aserradero.notify();
			}
			// después de añadir la madera,
			// notificará sobre el propio objeto aserradero que hay madera disponible.
			// int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			
		}
		
	}

}