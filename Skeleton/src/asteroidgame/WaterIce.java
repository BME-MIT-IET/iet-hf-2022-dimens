package asteroidgame;

/** Represents a waterice */
public class WaterIce extends Material {
	/** Publikus konstruktor, beállítjuk az ID-t */
	public WaterIce() {
		inventoryID = 2;
	}
	
	/** Overriden method for revealing waterice */
	@Override
	public void reveal(Asteroid asteroid) {
			asteroid.removeMaterial();
	}
	
	/**For writing a waterice object to standard output
	 * @return a String with the name of the material: WaterIce
	 **/
	@Override
	public String toString() {
		return "waterice";
	}
}
