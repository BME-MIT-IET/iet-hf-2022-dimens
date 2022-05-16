package asteroidgame;

import java.util.ArrayList;

/** Singleton class for controlling the game */
public abstract class Game {
	/** Number of living settlers */
	private static int numberOfSettlers = 0;
	/** All steppable objects of the game */
	private static ArrayList<Steppable> steppables = new ArrayList<>();
	/** Indicates whether the game is over or not */
	private static boolean endGame = false;

	/**
	 * Adds steppable to game
	 * 
	 * @param steppable The steppable object to add
	 **/
	public static void addSteppable(Steppable steppable) {
		steppables.add(steppable);
	}

	/**
	 * Removes entity from game
	 * 
	 * @param entity The entity to remove
	 **/
	public static void removeEntity(Entity entity) {
		steppables.remove(entity);
	}

	/** Decreases the numbers of the settlers alive */
	public static void decreaseNumberOfSettlers() {
		numberOfSettlers--;
		if (numberOfSettlers == 0) {
			endGame = true;
		}
	}

	/** Decreases the numbers of settlers alive */
	public static void increaseNumberOfSettlers() {
		numberOfSettlers++;
	}

	/**
	 * Plays the game. Iterates on each steppable, and if it is a settler, ask the
	 * player what to step. Then steps all other steppables. 
	 * Runs until the end(victory or defeat) of the game, and after it warnings the player that the game is over.
	 */
	private static void game() {
		Controller.initWindows();

		while (!endGame) {
			int steppedSettlers = 0;
			for (Steppable each : steppables) {
				if (steppedSettlers < numberOfSettlers) {
					Settler settler = (Settler) each;
					Thread t = Controller.buttonClick(settler);
					try {
						t.join();
					}
					catch(Exception e) {}
					settler.step(Controller.getCommand());
					steppedSettlers++;
				} else {
					each.step("");
				}
			}
			Field.decreaseTimer();
			Field.changeSunGroup();
			
			if(Field.checkWin()) {
				System.out.println("VICTORY");
				endGame = true;
			}
		}
		Controller.notifyEndGame();
		

	}

	/**
	 * Initializes the game.
	 * 
	 * Creates 4 settlers, adds them to the game. Initialzes the asteroid field by
	 * calling Field.initField(). Starts the game.
	 */
	public static void initGame() {
		ArrayList<Entity> entitiesList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			Settler settler = new Settler(null);
			entitiesList.add(settler);
		}
		Field.initField(entitiesList);
		game();
	}
}
