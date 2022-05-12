package asteroidgame;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Portals.
 */
public class Portal implements INeighbour, Steppable {
	/**
	 * This attribute represents the pair of the portal.
	 */
	private Portal pair;
	/**
	 * This represents the asteroid where the portal is placed.
	 */
	private INeighbour parentasteroid;

	/**
	 * This represents the megkergult state of the portal.
	 */
	private Boolean isMegkergult;

	/**
	 * This function deploys the portal on the asteroid
	 */
	public void deploy(Asteroid a) {
		addNeighbour(a);
		parentasteroid.addNeighbour(this);
	}

	@Override
	/**
	 * This function adds a Asteroid for the portal
	 */
	public void addNeighbour(INeighbour n) {

		parentasteroid = n;
	}

	/**
	 * This function removes the parent Asteroid of the portal
	 */
	@Override
	public void removeNeighbour(INeighbour neighbour) {

		parentasteroid = null;

	}

	@Override
	/**
	 * This function makes it possible to move through the portal
	 */
	public void accept(Entity s) {
		if (pair == null || pair.getAsteroid() == null) {
			parentasteroid.accept(s);
			// CmdProcessor.outwriter.println("Can't move!");
		} else
			pair.getAsteroid().accept(s);

	}

	/**
	 * This function returns the parentasteroid
	 * 
	 * @return the parentasteroid
	 */
	public INeighbour getAsteroid() {

		return parentasteroid;
	}

	/**
	 * This function sets the pair of the asteroid
	 * 
	 * @param p the settable pair
	 */
	public void setpair(Portal p) {

		pair = p;
	}

	/**
	 * This function is called when the portal is in a sunstorm.
	 */
	@Override
	public void burn(int n) {
		isMegkergult = true;
	}

	/**
	 * This function is called when something tries to move through the portal.
	 */
	@Override
	public void accept(INeighbour n) {
		if (n != pair)
			pair.getAsteroid().accept(n);
	}

	/**
	 * This funtction returns pair and the parentasteroid of the portal in a
	 * ArrayList.
	 */
	@Override
	public List<INeighbour> getNeighbours() {
		List<INeighbour> neighbours = new ArrayList<INeighbour>();
		neighbours.add(parentasteroid);
		neighbours.add(pair);
		return neighbours;
	}

	/**
	 * This function is called when the portal needs to move somewhere.
	 */
	@Override
	public void step(String command) {
		if (isMegkergult) {
			List<INeighbour> temp = parentasteroid.getNeighbours();
			INeighbour original = parentasteroid;
			for (INeighbour t : temp) {
				if (t != this && t != pair)
					parentasteroid = t;
			}
			if (parentasteroid != original) {
				parentasteroid.accept(this);
				original.removeNeighbour(this);
			}
		}
	}

}
