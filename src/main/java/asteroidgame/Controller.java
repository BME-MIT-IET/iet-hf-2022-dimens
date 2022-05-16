package asteroidgame;
import java.util.HashMap;
/**The controller of the MVC model**/
public abstract class Controller {
	/**the main window of the game*/
	private static Window window;
	/**Boolean that indicates whether a button was clicked*/
	private static boolean clicked = false;
	/**The string representation of the given command*/
	private static String command;
	public static String getCommand(){
		return command;
	}
	/**All entities*/
	private static HashMap <String, Entity> entities = new HashMap<>();
	/**Adds entity to the game**/
	public static void add(String name, Entity entity) {
		entities.put(name, entity);
	}
	/**Entry point for the game**/
	public static void main(String[] args) {
		Game.initGame();
	}
	/**Initializes windows*/
	public static void initWindows() {
		window = new Window();
	}

	/**Waiting for button click in a new thread.
	 *Loop until 'clicked' will be true
	 *@return The thread which is waiting.
	 * */
	public static Thread buttonClick(Settler settler) {
		window.refreshView(settler);
		clicked = false;
		Thread t = new Thread( () -> {
				while (true) {
					if (clicked)
						break;
					else
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							Thread.currentThread().interrupt();
						}
				}
		});
		t.start();
		return t;
	}
	
	/**Event handler method for commands*/
	public static void performCommand(String command) {
		Controller.command = command;
		clicked = true;
	}
	
	/**Notify the window that the game is over*/
	public static void notifyEndGame() {
		window.endGame();
	}
	
	/**Gets entity by name from hashmap*/
	public static String getEntityNameByValue(Entity e) {
		for (HashMap.Entry<String, Entity> a : entities.entrySet()) {
		    String key = a.getKey();
		    Entity value = a.getValue();
		    if(value == e) {
		    	return key;
		    }
		}
		return "";
	}
	
	/**
	 * Creates a Material by name (iron, coal, watericce, uran), and returns it.
	 * @param type the String that decides what kind of material do we want to create
	 * @return The created material
	 */
	public static Material createMaterial(String type) {
		Material material = null;
		switch (type) {
		case "iron":
			material = new Iron();
			break;
		case "coal":
			material = new Coal();
			break;
		case "waterice":
			material = new WaterIce();
			break;
		case "uran":
			material = new Uran();
			break;
		default:
			throw new UnsupportedOperationException("Unknown material");
		}
		return material;
	}
}
