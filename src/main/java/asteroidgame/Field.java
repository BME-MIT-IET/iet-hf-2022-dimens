package asteroidgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Field class that represents the asteroid Field
 *
 */
public abstract class Field {
	/**
	 * Attribute for the remaining rounds until the next sunstorm.
	 */
	private static int timeToSunStorm;
	private static Random rand = new Random();

	/**
	 * The asteroids, which are contained by the field
	 */
	private static List<Asteroid> asteroids = new ArrayList<>();
	static Ufo u1;
	static Ufo u2;


	private Field(){}
	/**
	 * Iterates through all the contained asteroids, end changes their sunClose attribute, if its needed
	 */
	public static void changeSunGroup() {

			for(Asteroid a : asteroids) {

				int n = rand.nextInt(2);
				if(n == 0) {
					a.changeSunCLose();
				}
				if(a.getNumOfLayers() == 0 && a.getCore() != null && a.getSunClose()) {
					a.getCore().reveal(a);
				}
			}
	}

	/**
	 * Represents the sun storm in the game.
	 */
	public static void sunStorm() {

		int n = rand.nextInt(asteroids.size());
		asteroids.get(n).burn(3);
	}

	/**
	 * Function that decreases the timer by one at the end of each turn
	 * If the timer reaches 0 it will launch a sun storm.
	 */
	public static void decreaseTimer() {
		if(timeToSunStorm == 0) {
			sunStorm();
			timeToSunStorm = 5;
		}else {
			timeToSunStorm -= 1;
		}
	}
	
	/**
	 * initialization for the Field
	 * @param allEntities all the entities contained in the game
	 */
	public static void initField(List<Entity> allEntities) {
		if(!asteroids.isEmpty()) {
			asteroids.clear();
		}
		Asteroid a = new Asteroid();
		for(int i = 0; i < 16; i++) {
			Asteroid ab = new Asteroid();

			asteroids.get(i).addNeighbour(asteroids.get(i+1));
			asteroids.get(i+1).addNeighbour(asteroids.get(i));
		}
		asteroids.get(16).addNeighbour(asteroids.get(0));
		asteroids.get(0).addNeighbour(asteroids.get(16));
		Asteroid a17 = new Asteroid();
		Asteroid a18 = new Asteroid();
		Asteroid a19 = new Asteroid();
		asteroids.get(17).addNeighbour(asteroids.get(18));
		asteroids.get(18).addNeighbour(asteroids.get(17));
		asteroids.get(7).addNeighbour(asteroids.get(18));
		asteroids.get(18).addNeighbour(asteroids.get(7));
		asteroids.get(10).addNeighbour(asteroids.get(18));
		asteroids.get(18).addNeighbour(asteroids.get(10));
		asteroids.get(11).addNeighbour(asteroids.get(18));
		asteroids.get(18).addNeighbour(asteroids.get(11));
		asteroids.get(7).addNeighbour(asteroids.get(10));
		asteroids.get(10).addNeighbour(asteroids.get(7));
		asteroids.get(12).addNeighbour(asteroids.get(19));
		asteroids.get(19).addNeighbour(asteroids.get(12));
		asteroids.get(17).addNeighbour(asteroids.get(4));
		asteroids.get(4).addNeighbour(asteroids.get(17));
		asteroids.get(17).addNeighbour(asteroids.get(5));
		asteroids.get(5).addNeighbour(asteroids.get(17));
		asteroids.get(13).addNeighbour(asteroids.get(15));
		asteroids.get(15).addNeighbour(asteroids.get(13));
		for(Asteroid as : asteroids) {
			as.setNumOfLayers(rand.nextInt(5)+1);
		}
		asteroids.get(0).addMaterial(new Iron());
		asteroids.get(1).addMaterial(new Coal());
		asteroids.get(2).addMaterial(new Coal());
		asteroids.get(3).addMaterial(new Uran());
		asteroids.get(4).addMaterial(new Uran());
		asteroids.get(5).addMaterial(new Iron());
		asteroids.get(6).addMaterial(new WaterIce());
		asteroids.get(7).addMaterial(new Iron());
		asteroids.get(8).addMaterial(new WaterIce());
		asteroids.get(9).addMaterial(new Iron());
		asteroids.get(10).addMaterial(new WaterIce());
		asteroids.get(11).addMaterial(new Coal());
		asteroids.get(12).addMaterial(new Coal());
		asteroids.get(13).addMaterial(new Uran());
		asteroids.get(14).addMaterial(new WaterIce());
		asteroids.get(15).addMaterial(new Uran());
		asteroids.get(16).addMaterial(new Coal());
		asteroids.get(17).addMaterial(new WaterIce());
		asteroids.get(18).addMaterial(new Uran());
		asteroids.get(19).addMaterial(new Iron());
		for(Entity e : allEntities) {
			asteroids.get(0).accept(e);
		}
		u1 = new Ufo(a17);
		u2 = new Ufo(a17);
	}
	
	/**
	 * removes one asteroid from the field
	 * @param a the asteroid which has to be removed.
	 */
	public static void removeAsteroid(Asteroid a){
		asteroids.remove(a);
	}
	
	/**
	 * adds an asteroid to the field
	 * @param a the asteroid which is to be added to the field.
	 */
	public static void addAsteroid(Asteroid a) {
		asteroids.add(a);
	}
	
	/**Check for all asteroids whether the game is over*/
	public static boolean checkWin() {
		for(Asteroid a : asteroids) {
			if(a.isVictory()){
				return true;
			}
		}
		return false;
	}
	
	public static int getTimeToSunStorm() {
		return timeToSunStorm;
	}
	
	static public List<Asteroid> getAsteroids(){
		return asteroids;
	}

		
}
