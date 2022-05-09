package asteroidgame;

/** Represents an uran */
public class Uran extends RadioactiveMaterial {
	/**
	 * Number of remaining occasions when the uran won't explode in sunclose,
	 * default=2
	 */
	private int timeToExplode = 2;

	/** Publikus konstruktor, beállítjukaz ID-t */
	public Uran() {
		inventoryID = 3;
	}

	/** Overriden and virtual method for revealing uran */
	@Override
	public void reveal(Asteroid asteroid) {
			if (timeToExplode > 0) {
				timeToExplode--;
			} else {
				asteroid.explode();
			}
	}
	
	/**For writing an uran object to standard output
	 * @return a String with the name of the material: Uran
	 **/
	@Override
	public String toString() {
		return "uran";
	}
}
