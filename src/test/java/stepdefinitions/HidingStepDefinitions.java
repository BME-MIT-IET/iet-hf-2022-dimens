package stepdefinitions;

import asteroidgame.Asteroid;
import asteroidgame.Settler;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HidingStepDefinitions {
    Settler settler;
    Asteroid asteroid;

    @Given("asteroid is empty and layercount is {int}")
    public void asteroidIsEmptyAndLayercountIs(int arg0) {
        asteroid = new Asteroid();
        asteroid.setNumOfLayers(arg0);

        settler = new Settler(asteroid);
    }

    @When("asteroid has been mined and asteroid is in sunstorm")
    public void asteroidHasBeenMinedAndAsteroidIsInSunstorm() {
        asteroid.burn(1);
    }

    @Then("settler can hide")
    public void settlerCanHide() {
        assertEquals(1, asteroid.getEntities().size());
    }

    @Given("asteroid is empty but layerCount is not {int}")
    public void asteroidIsEmptyButLayerCountIsNot(int arg0) {
        asteroid = new Asteroid();
        asteroid.setNumOfLayers(arg0+1);

        settler = new Settler(asteroid);
    }

    @When("asteroid is in sunstorm")
    public void asteroidIsInSunstorm() {
        asteroid.burn(1);
    }

    @Then("settler dies")
    public void settlerDies() {
        assertEquals(0, asteroid.getEntities().size());
    }
}
