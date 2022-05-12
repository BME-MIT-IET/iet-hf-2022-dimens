package asteroidgame;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * The class responsible for displaying the asteroid object set in the asteroid field.
 */
public class AsteroidView{
	/**
	 * The x coordinate of the asteroid on the fieldpanel
	 */
	int x;
	/**
	 * The y coordinate of the asteroid on the fieldpanel
	 */
	int y;
	/**
	 * The first letter of the material in the asteroid, empty string if the asteroid is empty.
	 */
	String material;
	/**
	 * The name of the entities on the asteroid separated by a column.
	 */
	String entities;
	/**
	 * The name of the asteroid.
	 */
	String name;
	/**
	 * The number of layers remaining of the asteroid.
	 */
	String layer;
	/**
	 * The asteroid object which the class displays.
	 */
	Asteroid asteroid;
	/**
	 * Default constructor of the class
	 */
	AsteroidView(){
		material = "";
		entities = "";
		name = "";
		layer = "";

	}
	/**
	 * Responsible for drawing on the fieldpanel.
	 * @param g the graphics object which it is drawing on.
	 */
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillOval(x + 50, y + 35, 30, 30);
		g.fillRect(x + 18, y + 24, 12, 12);
		g.fillRect(x + 58, y + 74, 24, 12);
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(1));
		g.drawRect(x + 18, y + 24, 12, 12);
		g.drawString(layer,x + 20, y + 35 );
		g.drawString(entities,x + 80, y + 35);
		g.drawString(material, x + 62, y + 55);
		g.drawRect(x + 58, y + 74, 24, 12);
		g.drawString(name, x + 60, y + 85);
		g.setStroke(new BasicStroke(3));
		if(asteroid.getSunClose()) g.setColor(Color.RED);
		g.drawOval(x + 50, y + 35, 30, 30);
		g.setColor(Color.BLACK);
	}

	/**
	 * Get the current data and sets the strings accordingly.
	 */
	public void refreshData() {
		material = "";
		entities = "";
		name = "";
		layer = "";
		if(asteroid.getCore() != null) {
			material = asteroid.getCore().toString();
			material = material.substring(0,1);
			material = material.toUpperCase();
		}
		for(int i = 0; i < asteroid.getEntities().size(); i++) {
			entities = entities + Controller.getEntityNameByValue(asteroid.getEntities().get(i)) +", ";

		}
		if(entities != "") {
			entities = entities.substring(0, entities.length() - 2);
		}
		/*for (HashMap.Entry<String, Asteroid> a : CmdProcessor.asteroids.entrySet()) {
			String key = a.getKey();
			Asteroid value = a.getValue();
			if(value == asteroid) {
				name = key;
			}
		}*/
		for(int i=0;i<Field.getAsteroids().size();i++) {
			if(asteroid.equals(Field.getAsteroids().get(i))) {
				name="a"+(i+1);
				break;
			}
				
		}
		Integer l = asteroid.getNumOfLayers();
		layer = l.toString();
	}

	/**
	 * Sets the x field.
	 * @param value to set
	 */
	public void setX(int value) {
		x = value;
	}

	/**
	 * Sets the y field.
	 * @param value to set
	 */
	public void setY(int value) {
		y = value;
	}
	/**
	 * Sets the asteroid field.
	 * @param a asteroid to set
	 */
	public void setAsteroid(Asteroid a) {
		asteroid = a;
	}
}
