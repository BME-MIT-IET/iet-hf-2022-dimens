package asteroidgame;

/**
 * UFO class that represents an UFO
 */
public class Ufo extends Entity {

	static private int NUM = 0;

	/**
	 * Constructor for initializing the UFO
	 * 
	 * @param a the asteroid that the UFO is on
	 */
	public Ufo(Asteroid a) {
		super(a);
		Controller.add("UFO" + NUM++, this);
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
	 * Az UFO körönkénti léptetését végzi, a különbözõ parancsok beadásával - amit
	 * paraméterként kap (command) - lehet az UFO-t irányítani, valamint az “AI” is
	 * meg van emellett valósítva, ami random választja ki, hogy mit csináljon a
	 * robot. A parancsok megtalálhatóak a bemeneti nyelv leírásánál. Minden beadott
	 * parancs 1 függvényhívást jelent. Itt történik a függvények feltételvizsgálata
	 * is, vagyis az, hogy az adott függvényt meg lehet-e hívni.
	 */
	public void step(String command) {
		Boolean canMine = asteroid.mineable();
		Boolean hasNeighbour = asteroid.getNeighbours().size() > 0;

		if (canMine && hasNeighbour) {
			double rand = Math.random();
			if (rand < 0.5)
				this.move(asteroid.getNeighbours().get(0));
			else
				this.mine();
		} else {
			if (canMine)
				this.mine();
			if (hasNeighbour)
				this.move(asteroid.getNeighbours().get(0));
			return;
		}

	}
}
