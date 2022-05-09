package asteroidgame;
/**Represents a coal*/
public class Coal extends Material{
	/**Publikus konstruktor, be�ll�tjuk az ID-t*/
	public Coal() {
		inventoryID = 0;
	}

	/**For writing a coal object to standard output
	 * @return a String with the name of the material: Coal
	 **/
	@Override
	public String toString() {
		return "coal";
	}
}
