package asteroidgame;

/**
 * Abstract superclass for materials
 */
public abstract class Material {
	/**Unique ID for the inventory*/
	protected int inventoryID;
	

	/**Virtual method for revealing material 
	 * @param asteroid 	The asteroid that contains the material
	 * */
	public void reveal(Asteroid asteroid){}
	
	/**Getter for inventoryID*/
	public int getinventoryID() {return inventoryID;}

	/**Virtual method for writing material objects to standard output
	 * @return a String with the name of the material
	 **/
	@Override
	public abstract String toString();

	/**Check whether two materials are the same kind*/
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Material))
			return false;
		return (inventoryID == ((Material)other).inventoryID);

	}
}
