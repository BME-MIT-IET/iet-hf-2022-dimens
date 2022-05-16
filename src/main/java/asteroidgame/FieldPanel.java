package asteroidgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * class for containing the views of the asteroids
 *
 */
public class FieldPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * list of asteroidviews
	 */
	transient ArrayList<AsteroidView> asteroidviews = new ArrayList<AsteroidView>();
	/**
	 * layout for the asteroidviews
	 */
	GridLayout asteroidsLayout = new GridLayout(0,5);

	/**
	 * Constructor for the class
	 */
	public FieldPanel() {
		for(int i = 0; i < Field.getAsteroids().size(); i++) {
			asteroidviews.add(new AsteroidView());

		}
		setAsteroids();
		setAsteroidCoordinates();
		for(AsteroidView av : asteroidviews) {
			av.refreshData();
		}

	}

	/**
	 * Updates all the asteroidViews contained by the Field
	 */
	public void updateField() {
		for(AsteroidView a: asteroidviews) {
			a.refreshData();
		}
		this.repaint();
	}

	/**
	 * Cycles through all the asteroids and draws them to the panel
	 */
	@Override
	public void paintComponent(Graphics g) {
		getViewByAsteroid((Graphics2D) g);
		for(AsteroidView i : asteroidviews) {
			i.draw((Graphics2D) g);
		}
	}

	/**
	 * Sets the upper left corner's coordinates of all the asteroidviews
	 */
	private void setAsteroidCoordinates() {
		int index = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++) {
				asteroidviews.get(index).setX(j*200);
				asteroidviews.get(index).setY(i*100);
				index++;
			}
		}
	}

	/**
	 * Sets the corresponding asteroids to its views
	 */
	private void setAsteroids() {
		int i = 0;
		for(Asteroid a : Field.getAsteroids()) {
			asteroidviews.get(i).setAsteroid(a);
			i++;
		}
	}
	
	public void getViewByAsteroid(Graphics2D g) {
		g.setColor(Color.BLUE);
		for(AsteroidView av : asteroidviews) {
			for(INeighbour ii : av.asteroid.getNeighbours()) {
				for(AsteroidView av2 : asteroidviews) {
					if(av2.asteroid == ii) {
						int px = av.x - av2.x;
						int py = av.y - av2.y;
						g.drawLine(av.x+65-px,  av.y+50-py, av2.x+65+px, av2.y+50+py);
					}
				}
			}
		}
	}
}
