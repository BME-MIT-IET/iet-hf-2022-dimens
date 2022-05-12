package asteroidgame;

/**
 * Robot class that represents a Robot
 */
public class Robot extends Entity {

	private static int number = 0;

	/**
	 * Constructor for initializing the Robot
	 * 
	 * @param a the asteroid that the Robot is on
	 */
	public Robot(Asteroid a) {
		super(a);
		Controller.add("R" + number++, this);
	}

	/**
	 * Settler drills the asteroid it is on
	 */
	public void drill() {
		asteroid.removeLayer();
	}

	@Override
	/**
	 * When the asteroid explodes the robot moves to a neighbouring asteroid or dies
	 * depending on whether the asteroid has neighbour(s) or not
	 */
	public void explode() {
		if (asteroid.getNeighbours().isEmpty())
			this.die();
		else
			this.move(asteroid.getNeighbours().get(0));
	}

	@Override
	/**
	 * A robot k�r�nk�nti l�ptet�s�t v�gzi, a k�l�nb�z� parancsok bead�s�val - amit
	 * param�terk�nt kap (command) - lehet a robotot ir�ny�tani, valamint az �AI� is
	 * meg van emellett val�s�tva, ami random v�lasztja ki, hogy mit csin�ljon a
	 * robot. A parancsok megtal�lhat�ak a bemeneti nyelv le�r�s�n�l. Minden beadott
	 * parancs 1 f�ggv�nyh�v�st jelent. Itt t�rt�nik a f�ggv�nyek felt�telvizsg�lata
	 * is, vagyis az, hogy az adott f�ggv�nyt meg lehet-e h�vni.
	 */
	public void step(String command) {
		Boolean canDrill = asteroid.getNumOfLayers() > 0;
		Boolean hasNeighbour = !asteroid.getNeighbours().isEmpty();

		if (canDrill && hasNeighbour) {
			double rand = Math.random();
			if (rand < 0.5)
				this.move(asteroid.getNeighbours().get(0));
			else
				this.drill();
		} else {
			if (Boolean.TRUE.equals(canDrill))
				this.drill();
			if (Boolean.TRUE.equals(hasNeighbour))
				this.move(asteroid.getNeighbours().get(0));
		}

	}
}
