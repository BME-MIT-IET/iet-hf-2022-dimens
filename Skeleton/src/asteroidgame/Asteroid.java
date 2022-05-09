package asteroidgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Asteroid class that represents the Asteroid
 */
public class Asteroid implements INeighbour{

	/**
	 * Default value of the numOfLayers attrib
	 * Set to this when default constructor is called
	 */
	private static final int DEFAULTLAYER=10;
	/**
	 * Attribute for the number of remaining layers on the asteroid
	 */
	private int numOfLayers;
	/**
	 * Boolean that represents if the Asteroid is close to the sun.
	 */
	private boolean sunClose;
	/** 
	 * Attribute that represents the Entities on the Asteroid
	 */
	private List<Entity> entities;
	/**
	 * Attribute that represents the neighbouring asteroids and portals
	 */
	private List<INeighbour> neighbours;
	/**
	 * Attribute that represents the material inside the Asteroid core
	 */
	private Material core;
	
	/**
	 * Constructor for the class
	 */
	public Asteroid(){
		Field.addAsteroid(this);
		core=null;
		entities=new ArrayList<Entity>();
		sunClose=false;
		neighbours=new ArrayList<INeighbour>();
		numOfLayers=DEFAULTLAYER;
	}
	
	/**
	 * Function that accepts and adds an Entity on the asteroid
	 * if the entity is part of an Another asteroid it is the callers r4esponsibility to delete it from there
	 * @param e the added Entity
	 */
	@Override
	public void accept(Entity e) {
		e.setAsteroid(this);
		entities.add(e);
	}
	/**
	 * Function that adds an INeighbour Object to the list of neighbours and adds this asteroid to the iNeighbours neighbour
	 * @param i the object connected to the asteroid as a neighbour  
	 */
	@Override
	public void accept(INeighbour i) {
		addNeighbour(i);
		i.addNeighbour(this);
	}
	/**
	 * Function that removes the Entity from the Asteroid
	 * Gives no indication whether the entity was part of the Asteroid's list or not 
	 * @param e the entity which we want removed
	 */
	public void removeEntity(Entity e) {
		entities.remove(e);
	}
	
	/**
	 * Adds a new neighbour to the list of neighbours of this asteroid
	 * The caller's responsibility to add this asteroid to the "i" object
	 * @param i the object to add
	 */
	@Override
	public void addNeighbour(INeighbour i){
		neighbours.add(i);
	}
	
	/** 
	 * Removes a neighbour from the neighnbour list of this Asteroid
	 * Gives no indication whether the INEighbour was part of the Asteroid's list or not
	 * The caller's responsibility to remove this object from the "i" object  
	 * @param i the object to remove
	 */
	@Override
	public void removeNeighbour(INeighbour i) {
		neighbours.remove(i);
	}
	
	/**
	 * Explodes the asteroid exploding every entity on it. The asteroid is removed from any neighbour object
	 */
	public void explode() {
		while(!entities.isEmpty())
			entities.get(0).explode(); 
		
		while(!neighbours.isEmpty()) {
			neighbours.get(0).removeNeighbour(this);
			neighbours.remove(0);
		}
	}

	/**
	 * Lowers the number of layers on the asteroid by 1
	 * @throws Exception when the asteroid has 0 layers
	 */
	public void removeLayer() {
			setNumOfLayers(numOfLayers-1);
			if(numOfLayers==0&&sunClose)
				core.reveal(this);
	}

	/**
	 * Changes the SunClose state
	 * Does all the thing required when getting to sunclose
	 */
	public void changeSunCLose() {
		sunClose = !sunClose;
	}
	
	
	/**
	 * Removes the Material from the core
	 */
	public void removeMaterial() {
	
		core = null;
	
	}
	
	/**
	 * Puts the given material in the Asteroids core
	 * @param m The material to put inside the the asteroid's core
	 * @throws IllegalArgumentException thrown when the core has an another material or Asteroid still has layers
	 */
	public void addMaterial(Material m) {
		core = m;
	}
	@Override
	/**
	 * Recursively burns an asteroid and all its's neighbours
	 * kills all entities on the asteroid makes a portal megkergult 
	 * @param n this deep does the recursion goes in the neighbour connections
	 */
	public void burn(int n){
	
		if(n==0) return;
		else {
			if(numOfLayers!=0||core!=null)
				while(entities.size()>0)
					entities.get(0).die();
			for(int i=0;i<neighbours.size();i++)
				neighbours.get(i).burn(n-1);
		}
	}
	
	/**
	 * Indicates, whether an asteroid is mineable
	 * @return true, if the asteroid is mineable
	 */
	public boolean mineable() {
		return core!=null&&numOfLayers==0;
	}
	
	/**
	 * Checking whether the victroy condition is fullfilled on this asteroid
	 * @return
	 */
	public boolean isVictory() {
		
		//creating a list full of the Materials needed to win 
		List<Material> allm=new ArrayList<Material>();
		for(int i=0;i<3;i++)
			allm.add(new Iron());
		for(int i=0;i<3;i++)
			allm.add(new Coal());
		for(int i=0;i<3;i++)
			allm.add(new WaterIce());
		for(int i=0;i<3;i++)
			allm.add(new Uran());
		
		//putting all Materials of settlers ont the asteroid in a list
		List<Material> current=new ArrayList<Material>();
		for(Entity s: entities) {
			if(s instanceof Settler) {
				current.addAll(((Settler) s).getInventory().materials_list());
			}
		}
		//removing every item from the victory condition that isa present here
		for(Material m:current) {
			allm.remove(m);
		}
		return allm.isEmpty();
	}
	
	
	
	// ------ GETTERS & SETTERS 

	
	/**
	 * returns the material inside the core
	 * @return the material
	 */
	public Material getCore() {
		return core;
	}
	/**
	 * Set the sunClose attrib to the given value
	 * @param SC True if the Asteroid gets close to Sun, false if it gets away from the Sun
	 */
	public void setSunClose(boolean SC) {
		sunClose=SC;
	}
	
	/**
	 * Returns true if the asteroid is close to the sun, else false
	 * @return the sunclose state
	 */
	public boolean getSunClose() {
		return sunClose;
	}
	
	@Override
	/** 
	 * returns the neighbours in an array
	 * @return the array
	 */
	public List<INeighbour> getNeighbours() {
		return neighbours;
	}
	
	/**
	 * returns the number of remaining layers on the asteroid
	 * @return the remaining layers
	 */
	public int getNumOfLayers() {
		return numOfLayers;
	}
	/**
	 * sets the number of layers to the given value
	 * @param n this many layers will the asteroid have 
	 * @throws IllegalArgumentException thrown when n<0
	 */
	public void setNumOfLayers(int n) {
		numOfLayers=n;
	}
	public List<Entity> getEntities(){
		return entities;
	}
	

}
