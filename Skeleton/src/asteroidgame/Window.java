package asteroidgame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * class for the Game Window
 *
 */
public class Window extends JFrame{
	/**
	 * Default serialVersionUID needed for JFrame
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The FieldPanel which shows the asteroidfield
	 */
	FieldPanel fp;
	/**
	 * controlview field this contol
	 */
	ControlView cv; 
	
	/**
	 * Function that responsible for refreshing everything on the window
	 * @param settler The settler whose data is shown in the right panel of the window
	 */
	public void refreshView(Settler settler) {
		cv.refreshButtons(settler);
		fp.updateField();
		this.repaint();
	}
	
	/**
	 * Function that ends the game
	 */
	public void endGame() {
		if(Field.checkWin())
			JOptionPane.showMessageDialog(this, "Victory");
		else
			JOptionPane.showMessageDialog(this, "Defeat");
		
		this.dispose();
	}
	
	/**
	 * Constructor
	 * Creates the two panels and adds them to the window
	 */
	public Window() {
		super("Asteroid Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1000,538));
		setResizable(false);
		setVisible(true);
		this.setLayout(new BorderLayout());
		fp = new FieldPanel();
		cv = new ControlView();
		
		this.add(fp, BorderLayout.CENTER);
		this.add(cv, BorderLayout.EAST);
		
		this.pack();
		this.repaint();
	}
	
}
