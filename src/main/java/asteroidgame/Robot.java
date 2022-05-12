package asteroidgame;

/**
 * Robot class that represents a Robot
 */
public class Robot extends Entity {

	static private int NUM = 0;

	/**
	 * Constructor for initializing the Robot
	 * 
	 * @param a the asteroid that the Robot is on
	 */
	public Robot(Asteroid a) {
		super(a);
		Controller.add("R" + NUM++, this);
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
	 * A robot körönkénti léptetését végzi, a különbözõ parancsok beadásával - amit
	 * paraméterként kap (command) - lehet a robotot irányítani, valamint az “AI” is
	 * meg van emellett valósítva, ami random választja ki, hogy mit csináljon a
	 * robot. A parancsok megtalálhatóak a bemeneti nyelv leírásánál. Minden beadott
	 * parancs 1 függvényhívást jelent. Itt történik a függvények feltételvizsgálata
	 * is, vagyis az, hogy az adott függvényt meg lehet-e hívni.
	 */
	public void step(String command) {
		Boolean canDrill = asteroid.getNumOfLayers() > 0;
		Boolean hasNeighbour = asteroid.getNeighbours().size() > 0;

		if (canDrill && hasNeighbour) {
			double rand = Math.random();
			if (rand < 0.5)
				this.move(asteroid.getNeighbours().get(0));
			else
				this.drill();
		} else {
			if (canDrill)
				this.drill();
			if (hasNeighbour)
				this.move(asteroid.getNeighbours().get(0));
			return;
		}

	}
}
