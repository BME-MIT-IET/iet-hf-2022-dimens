package asteroidgame;

/** Abstract superclass for radioactive materials */
public abstract class RadioactiveMaterial extends Material {

	/** Overriden and virtual method for revealing radioactive material */
	@Override
	public void reveal(Asteroid asteroid) {
			asteroid.explode();
	}
	
	/**Virtual method for writing material objects to standard output
	 * @return a String with the name of the material
	 **/
	@Override
	public abstract String toString();
}