package stepdefinitions;

import asteroidgame.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;

public class BuildingStepDefinitions {
    Settler settler;
    Asteroid asteroid;

    @Given("settler has 1 iron, 1 coal, 1 uran to build robot")
    public void settlerWithMaterialToBuildRobot() {
        asteroid = new Asteroid();

        settler = new Settler(asteroid);

        while(asteroid.getNumOfLayers() > 0)
            settler.drill();

        asteroid.addMaterial(new Iron());
        settler.mine();

        asteroid.addMaterial(new Coal());
        settler.mine();

        asteroid.addMaterial(new Uran());
        settler.mine();
    }

    @Then("settler can build robot")
    public void settlerCanBuildRobot() {
        assertEquals(1, asteroid.getEntities().size());

        settler.buildRobot();

        assertEquals(2, asteroid.getEntities().size());
        assertEquals(Robot.class, asteroid.getEntities().get(1).getClass());

    }

    @Given("settler has 2 irons, 1 waterice, 1 uran to build portals")
    public void settlerWithMaterialToBuildPortals() {
        asteroid = new Asteroid();

        settler = new Settler(asteroid);

        while(asteroid.getNumOfLayers() > 0)
            settler.drill();

        asteroid.addMaterial(new Iron());
        settler.mine();

        asteroid.addMaterial(new Iron());
        settler.mine();

        asteroid.addMaterial(new WaterIce());
        settler.mine();

        asteroid.addMaterial(new Uran());
        settler.mine();

    }

    @Then("settler can build portal")
    public void settlerCanBuildPortal() {
        assertEquals(0, settler.numOfPortals());
        settler.buildPortal();

        assertEquals(2, settler.numOfPortals());
    }

    @Given("settler without resources")
    public void settlerWithoutResources() {
        asteroid = new Asteroid();

        settler = new Settler(asteroid);
    }

    @Then("settler can't build")
    public void settlerCanTBuild() {
        assertThrows(java.lang.NullPointerException.class, () -> settler.buildPortal());

        assertThrows(java.lang.NullPointerException.class, () -> settler.buildRobot());
    }
}
