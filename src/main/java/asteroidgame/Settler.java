package asteroidgame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Settler class that represents a Settler
 */
public class Settler extends Entity {

    private static int number = 0;
    /**
     * Portals the Settler has
     */
    private List<Portal> portals;
    /**
     * Settler's inventory
     */
    private Inventory inventory;

    /**
     * Constructor for initializing the Settler
     *
     * @param a the asteroid that the Settler is on
     */
    public Settler(Asteroid a) {
        super(a);
        Game.increaseNumberOfSettlers();
        this.inventory = new Inventory();
        this.portals = new ArrayList<>(3);
        Controller.add("S" + number++, this);
    }

    /**
     * Settler mines the asteroid it is on
     */
    public void mine() {
        inventory.addMaterial(asteroid.getCore());
        asteroid.removeMaterial();
    }

    /**
     * Settler drills the asteroid it is on
     */
    public void drill() {
        asteroid.removeLayer();
    }

    /**
     * Settler builds a pair of portals
     */
    public void buildPortal() {
        inventory.removeMaterial(new Iron());
        inventory.removeMaterial(new Iron());
        inventory.removeMaterial(new WaterIce());
        inventory.removeMaterial(new Uran());
        Portal p1 = new Portal();
        Portal p2 = new Portal();
        p1.setpair(p2);
        p2.setpair(p1);
        this.portals.add(p1);
        this.portals.add(p2);
    }

    /**
     * Settler builds a robot
     */
    public void buildRobot() {
        inventory.removeMaterial(new Iron());
        inventory.removeMaterial(new Coal());
        inventory.removeMaterial(new Uran());
        new Robot(asteroid);
    }

    @Override
    /**
     * When the asteroid explodes, the Settler dies
     */
    public void explode() {
        this.die();
    }

    @Override
    /**
     * When the Settler dies, it gets removed from the asteroid,
     * then it gets removed from the game as well
     */
    public void die() {
        asteroid.removeEntity(this);
        Game.removeEntity(this);
        Game.decreaseNumberOfSettlers();
    }

    /**
     * Settler places a portal on the asteroid
     */
    public void deployPortal() {
        portals.remove(0).deploy(asteroid);
    }

    /**
     * Settler places material into the empty asteroid
     *
     * @param m the material, which gets placed into the asteroid
     */
    public void placeMaterial(Material m) {
        asteroid.addMaterial(m);
        inventory.removeMaterial(m);
    }


    @Override
    /**
     * A telepes k�r�nk�nti l�ptet�s�t v�gzi, a k�l�nb�z� parancsok bead�s�val - amit param�terk�nt kap (command) -
     * lehet a telepest ir�ny�tani. A parancsok megtal�lhat�ak a bemeneti nyelv le�r�s�n�l.
     * Minden beadott parancs 1 f�ggv�nyh�v�st jelent. Itt t�rt�nik a f�ggv�nyek felt�telvizsg�lata is,
     * vagyis az, hogy az adott f�ggv�nyt meg lehet-e h�vni.
     */
    public void step(String command) {
        String[] cmd = command.split(" ");
        switch (cmd[0]) {
            case "move":
                tryMove(cmd[1]);
                break;
            case "mine":
                tryMine();
                break;
            case "drill":
                tryDrill();
                break;
            case "build":
                tryBuild(cmd[1]);
                break;
            case "deploy":
                tryDeploy();
                break;
            case "place":
                tryPlace(cmd[1]);
                break;
            case "skip":
                break;
            default:
                JOptionPane.showMessageDialog(null, "wrong command");
                break;
        }
    }

    private void tryPlace(String command) {
        Material m = Controller.createMaterial(command);
        if (asteroid.getNumOfLayers() == 0 && asteroid.getCore() == null && inventory.hasMaterial(m))
            this.placeMaterial(m);
        else JOptionPane.showMessageDialog(null, "Can't place");
    }
    private void tryDeploy() {
        if (!this.portals.isEmpty()) this.deployPortal();
        else JOptionPane.showMessageDialog(null, "Can't deploy");
    }

    private void tryMove(String idX) {
        int idx = Integer.parseInt(idX);
        if (idx >= 0) this.move(asteroid.getNeighbours().get(idx));
        else JOptionPane.showMessageDialog(null, "Can't move");
    }

    private void tryMine() {
        if (Inventory.getMaxNumofMaterials() > inventory.getNumOfMaterials() && asteroid.mineable())
            this.mine();
        else JOptionPane.showMessageDialog(null, "Can't mine");
    }

    private void tryDrill() {
        if (asteroid.getNumOfLayers() > 0) this.drill();
        else JOptionPane.showMessageDialog(null, "Can't drill");
    }
    private void tryBuild(String command) {
        if (command.equals("-r") && inventory.hasMaterial(new Iron()) && inventory.hasMaterial(new Coal())
                && inventory.hasMaterial(new Uran())) {
            this.buildRobot();
        } else if (command.equals("-p") && inventory.hasMaterial(new Iron(), 2) && inventory.hasMaterial(new WaterIce())
                && inventory.hasMaterial(new Uran()) && portals.size() < 2)
            this.buildPortal();
        else JOptionPane.showMessageDialog(null, "Can't build");
    }

    /**
     * Returns how many portals the settler has
     *
     * @return the number of portals the settler has
     */
    public int numOfPortals() {
        return portals.size();
    }

    /**
     * Getter for inventory
     *
     * @return the Settler's inventory
     */
    public Inventory getInventory() {
        return inventory;
    }
}
