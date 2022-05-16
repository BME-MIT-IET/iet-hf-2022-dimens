package stepdefinitions;

import asteroidgame.Asteroid;
import asteroidgame.Coal;
import asteroidgame.Settler;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MiningStepDefinitions {
    public Asteroid asteroid;
    public Settler settler;
    @Given("asteroid has resource and layercount is {int}")
    public void asteroidHasResourceAndLayercountIs(int layerCount) {
        asteroid = new Asteroid();
        settler = new Settler(asteroid);
        asteroid.setNumOfLayers(layerCount);
        asteroid.addMaterial(new Coal());
    }

    @Then("settler can mine it")
    public void settlerCanMineIt() {
        int invBefore = settler.getInventory().getNumOfMaterials();
        settler.mine();
        assertEquals(invBefore + 1, settler.getInventory().getNumOfMaterials());
    }

    @Given("asteroid is empty and layerCount is {int}")
    public void asteroidIsEmptyAndLayerCountIs(int layerCount) {
        asteroid = new Asteroid();
        settler = new Settler(asteroid);
        asteroid.setNumOfLayers(layerCount);
    }

    @Then("settler can't mine")
    public void settlerCanTMine() {
        int invBefore = settler.getInventory().getNumOfMaterials();
        assertThrows(java.lang.NullPointerException.class, () -> settler.mine());
    }

    @Given("asteroid layerCount is {int}")
    public void asteroidLayerCountIsNot(int layerCount) {
        asteroid = new Asteroid();
        settler = new Settler(asteroid);
        asteroid.setNumOfLayers(layerCount);
    }
}
