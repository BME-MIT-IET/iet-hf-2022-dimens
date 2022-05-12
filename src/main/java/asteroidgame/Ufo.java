package asteroidgame;

/**
 * UFO class that represents an UFO
 */
public class Ufo extends Entity {

	private static int number = 0;

	/**
	 * Constructor for initializing the UFO
	 * 
	 * @param a the asteroid that the UFO is on
	 */
	public Ufo(Asteroid a) {
		super(a);
		Controller.add("UFO" + number++, this);
	}

	/**
	 * UFO mines the asteroid it is on
	 */
	public void mine() {
		asteroid.removeMaterial();
	}

	@Override
	/**
	 * When the asteroid explodes, the UFO dies
	 */
	public void explode() {
		this.die();
	}

	@Override
	/**
	 * Az UFO k�r�nk�nti l�ptet�s�t v�gzi, a k�l�nb�z� parancsok bead�s�val - amit
	 * param�terk�nt kap (command) - lehet az UFO-t ir�ny�tani, valamint az �AI� is
	 * meg van emellett val�s�tva, ami random v�lasztja ki, hogy mit csin�ljon a
	 * robot. A parancsok megtal�lhat�ak a bemeneti nyelv le�r�s�n�l. Minden beadott
	 * parancs 1 f�ggv�nyh�v�st jelent. Itt t�rt�nik a f�ggv�nyek felt�telvizsg�lata
	 * is, vagyis az, hogy az adott f�ggv�nyt meg lehet-e h�vni.
	 */
	public void step(String command) {
		Boolean canMine = asteroid.mineable();
		Boolean hasNeighbour = !asteroid.getNeighbours().isEmpty();

		if (canMine && hasNeighbour) {
			double rand = Math.random();
			if (rand < 0.5)
				this.move(asteroid.getNeighbours().get(0));
			else
				this.mine();
		} else {
			if (Boolean.TRUE.equals(canMine))
				this.mine();
			if (Boolean.TRUE.equals(hasNeighbour))
				this.move(asteroid.getNeighbours().get(0));
		}

	}
}
