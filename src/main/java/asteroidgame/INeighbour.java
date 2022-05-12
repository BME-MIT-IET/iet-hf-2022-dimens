package asteroidgame;

import java.util.List;

/**
 * This interface is for the portal and the asteroid.
 */
public interface INeighbour {
	/**
	 * Add a neighbor to the object
	 * @param neighbour The object to add
	 */
	public void addNeighbour(INeighbour neighbour);
	/**
	 * Removes a Neighbour from the object
	 * @param neighbour the object to remove
	 */
	public void removeNeighbour(INeighbour neighbour);
	/**
	 * Moves an enitity to or through the object
	 * @param e the entity to move
	 */
	public void accept(Entity e);
	/**
	 * Called when an INeighbour object is hit by a Sunstorm 
	 * @param n recursion is needed to simulate the spreading of the sunstorm and the n param indicates how deep in the connection chain goes
	 */
	public void burn(int n);
	
	/**
	 * Adds the INeighbour object to the appropiate asteroid's neighbours and the asteroid to the object's neighbours  
	 * @param n
	 */
	public void accept(INeighbour n);
	public List<INeighbour> getNeighbours();
}
