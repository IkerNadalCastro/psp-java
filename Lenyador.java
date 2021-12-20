
import java.util.concurrent.ThreadLocalRandom;

public class Lenyador implements Runnable {

	Aserradero aserradero;

	public Lenyador(Aserradero aserradero) {
		super();
		this.aserradero = aserradero;
	}

	@Override
	public void run() {
		// Mientras el aserradero no esté parado,
		while(!aserradero.aserraderoParado()) {
			
			// el carpintero dormirá un tiempo aleatorio entre 1 y 2 segundos:
			
			// y añadirá un número aleatorio entre 1 y 3 unidades de madera al aserradero.
			int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			aserradero.agregarMadera(randomNum);
			synchronized (aserradero) {
				aserradero.notify();
			}
			// después de añadir la madera,
			// notificará sobre el propio objeto aserradero que hay madera disponible.
			// int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			
		}
		
	}

}
