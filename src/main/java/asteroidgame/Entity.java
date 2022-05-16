package asteroidgame;

/**
* Entity parent class
*/
public abstract class Entity implements Steppable {
	
	/**
	* The asteroid that the Entity is on
	*/
	protected Asteroid asteroid;
	
	/**
	* Constructor for initializing the Entity
	* 
	* @param a the asteroid that the Entity is on
	*/
	protected Entity(Asteroid a) {
		this.asteroid = a;
		if (a != null) this.asteroid.accept(this);
		Game.addSteppable(this);
	}
	
	/**
	* When the Entity dies, it gets removed from the asteroid,
	* then it gets removed from the game as well
	*/
	public void die() {
		asteroid.removeEntity(this);
		Game.removeEntity(this);
	}
	
	/**
	* The Entity moves to an asteroid or a portal.
	* 
	* @param n the asteroid/portal where the Entity will move
	*/
	public void move(INeighbour n) {
		asteroid.removeEntity(this);
		n.accept(this);
	}
	
	/**
	* After the asteroid explodes, all the Entities on it also explode
	*/
	public abstract void explode();
	
	@Override
	/**
	* Entity steps
	*/
	public abstract void step(String command);
	
	/*-----getters and setters-----*/
	
	/**
	* Getter for the asteroid
	* 
	* @return the asteroid that the Entity is on
	*/
	public Asteroid getAsteroid() {
		return asteroid;
	}

	/**
	* Setter for the asteroid
	* 
	* @param a the asteroid that the Entity is on
	*/
	public void setAsteroid(Asteroid a) {
		this.asteroid = a;
	}
}
