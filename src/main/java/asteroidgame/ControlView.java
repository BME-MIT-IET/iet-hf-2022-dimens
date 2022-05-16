package asteroidgame;

import java.awt.*;
import javax.swing.*;

/**
 * Displays the right control panel
 */
@SuppressWarnings("serial")
public class ControlView extends JPanel {
	/**
	 * Buttons for controlling the settler
	 */
	private JButton drillButton, mineButton, buildRobotButton, buildPortalButton, placePortalButton, skipButton;
	/**
	 * Drop-down lists
	 * The moveMenu lists the neighbouring asteroids
	 * The placeMaterialMenu lists the materials the settler can put into the empty asteroid
	 */
	private JComboBox<String> moveMenu, placeMaterialMenu;
	/**
	 * Labels for displaying the asteroid's name the settler is currently on,
	 * the settler's inentory, the time till sunstorm hits, and the settler's name
	 */
	private JLabel asteroidOfSettler, settlerInventory, timeToSunstorm, sLabel;
	
	/**
	 * Constructor for constructing the panel
	 */
	public ControlView() {
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();		
		setLayout(gb);
		
		//mine button
		mineButton = new JButton("mine");
		gbc.gridx = 0; gbc.gridy = 6;
		gbc.gridwidth = 1; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(mineButton, gbc);
		mineButton.addActionListener(e -> Controller.performCommand("mine"));
		add(mineButton);
		
		//drill button
		drillButton = new JButton("drill");
		gbc.gridx = 0; gbc.gridy = 8;
		gbc.gridwidth = 1; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(drillButton, gbc);
		drillButton.addActionListener(e -> Controller.performCommand("drill"));
		add(drillButton);
		
		//skip button
		skipButton = new JButton("skip");
		gbc.gridx = 0; gbc.gridy = 10;
		gbc.gridwidth = 1; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(skipButton, gbc);
		skipButton.addActionListener(e -> Controller.performCommand("skip"));
		add(skipButton);
		
		//build robot button
		buildRobotButton = new JButton("build robot");
		gbc.gridx = 2; gbc.gridy = 6;
		gbc.gridwidth = 1; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(buildRobotButton, gbc);
		buildRobotButton.addActionListener(e -> Controller.performCommand("build -r"));
		add(buildRobotButton);		
		
		//build portal button
		buildPortalButton = new JButton("build portals");
		gbc.gridx = 2; gbc.gridy = 8;
		gbc.gridwidth = 1; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(buildPortalButton, gbc);
		buildPortalButton.addActionListener(e -> Controller.performCommand("build -p"));
		add(buildPortalButton);
		
		//place portal button
		placePortalButton = new JButton("place portal");
		gbc.gridx = 2; gbc.gridy = 10;
		gbc.gridwidth = 1; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(placePortalButton, gbc);
		placePortalButton.addActionListener(e -> Controller.performCommand("deploy"));
		add(placePortalButton);
		
		//settler's name
		sLabel = new JLabel();
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.gridwidth = 1; gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(sLabel, gbc);
		add(sLabel);
		
		//settler's asteroid
		asteroidOfSettler = new JLabel();
		gbc.gridx = 2; gbc.gridy = 0;
		gbc.gridwidth = 1; gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(asteroidOfSettler, gbc);
		add(asteroidOfSettler);
		
		//settler's inventory label
		JLabel invLabel = new JLabel("Inventory:");
		gbc.gridx = 0; gbc.gridy = 2;
		gbc.gridwidth = 1; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(invLabel, gbc);
		add(invLabel);
		
		//lists the materials the settler's inventory has
		settlerInventory = new JLabel();
		gbc.gridx = 1; gbc.gridy = 2;
		gbc.gridwidth = 2; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(settlerInventory, gbc);
		add(settlerInventory);
		
		//time till sunstorm hits
		timeToSunstorm = new JLabel();
		gbc.gridx = 0; gbc.gridy = 18;
		gbc.gridwidth = 2; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 2; gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gb.setConstraints(timeToSunstorm, gbc);
		add(timeToSunstorm);
		
		//list of the asteroid's neighbour
		moveMenu = new JComboBox<String>();
		gbc.gridx = 0; gbc.gridy = 12;
		gbc.gridwidth = 1; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(moveMenu, gbc);
		moveMenu.addActionListener(e -> {
				int idx = moveMenu.getSelectedIndex();
				Controller.performCommand("move " + idx);
		});
		add(moveMenu);
		
		//lists the materials the settler can place into the empty asteroid
		placeMaterialMenu = new JComboBox<String>();
		gbc.gridx = 2; gbc.gridy = 12;
		gbc.gridwidth = 1; gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1; gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gb.setConstraints(placeMaterialMenu, gbc);
		placeMaterialMenu.addActionListener(e ->
			Controller.performCommand("place " + placeMaterialMenu.getSelectedItem()));
		add(placeMaterialMenu);
		
		setVisible(true);
	}
	
	/**
	 * In every round refreshes the buttons with the given settler
	 * @param settler The settler that we are displaying informaton about
	 */
	public void refreshButtons(Settler settler) {
		
		//setting the text of labels based of the given settler
		timeToSunstorm.setText("Time to sunstorm: " + String.valueOf(Field.getTimeToSunStorm()));
		settlerInventory.setText(settler.getInventory().list());
		sLabel.setText("Settler: " + Controller.getEntityNameByValue(settler));
		
		moveMenu.removeAllItems();
		//updating the moveMenu combobox with the neighbouring asteroids of the asteroid
		//the settler is on
		for(INeighbour n : settler.getAsteroid().getNeighbours()) {
            String name="hiba";
            
            if (n.getClass() == Asteroid.class) {
                for(int i=0;i<Field.getAsteroids().size();i++)
                    if (Field.getAsteroids().get(i).equals((Asteroid)n)) {
                        name="a"+(i+1);
                        break;
                    }
            }
            
            else if(n.getClass()==Portal.class) {
                Portal p=(Portal)n;
                Portal pair=(Portal)(p.getNeighbours().get(1));
                Asteroid a=(Asteroid)pair.getAsteroid();
                for(int k=0;k<Field.getAsteroids().size(); k++)
                    if (Field.getAsteroids().get(k).equals(a)){
                        name = "a" + (k+1);
                        break;
                    }
            }
            moveMenu.addItem(name);
        }
		
		//setting the text of the asteroid the settler is on
        for(int i=0;i<Field.getAsteroids().size();i++)
            if (Field.getAsteroids().get(i).equals(settler.getAsteroid()))
                asteroidOfSettler.setText("Asteroid: a"+(i+1));
		
		
		placeMaterialMenu.removeAllItems();
		//updating the combobox with the materials the settler can place in the asteroid
		for (Material m : settler.getInventory().materialsList())
			placeMaterialMenu.addItem(m.toString());
	}
}
