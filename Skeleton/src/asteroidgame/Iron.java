package asteroidgame;
/**Represents an iron*/
public class Iron extends Material{
	/**Publikus konstruktor, beállítjukaz ID-t*/
	public Iron() {
		inventoryID = 1;
	}
	
	/**For writing an iron object to standard output
	 * @return a String with the name of the material: Iron
	 **/
	@Override
	public String toString() {
		return "iron";
	}
}
