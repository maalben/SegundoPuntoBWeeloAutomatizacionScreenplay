package com.weelo.automationpractice.stepdefinitions;

import com.weelo.automationpractice.exceptions.AssertionsAutomationpractice;
import com.weelo.automationpractice.questions.ResultShow;
import com.weelo.automationpractice.questions.TheMessage;
import com.weelo.automationpractice.questions.TheMessageProcess;
import com.weelo.automationpractice.questions.TheQuantity;
import com.weelo.automationpractice.tasks.Enter;
import com.weelo.automationpractice.tasks.Perform;
import com.weelo.automationpractice.tasks.PerformSearch;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import static org.hamcrest.Matchers.is;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.core.IsEqual.equalTo;

public class AutomationpracticeStepdefinitions {

    @Managed(driver ="chrome")
    private WebDriver hisBrowser;
    Actor mario = Actor.named("Mario");

    @Before
    public void setup()
    {
        mario.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^Yo Ingreso a la pagina de automationpractice$")
    public void yoIngresoALaPaginaDeAutomationpractice() {
        mario.wasAbleTo(Enter.toThePageAutomationPractice());
    }


    @When("^Yo realizo la busqueda del producto a buscar \"([^\"]*)\"$")
    public void yoRealizoLaBusquedaDelProductoABuscar(String product) {
        mario.attemptsTo(Perform.theSearch(product));
    }

    @Then("^Yo verifico que se muestre el producto buscado \"([^\"]*)\"$")
    public void yoVerificoQueSeMuestreElProductoBuscado(String product) {
        mario.should(seeThat(ResultShow.product(product), equalTo(true))
                .orComplainWith(AssertionsAutomationpractice.class, AssertionsAutomationpractice.NO_FOUND_ELEMENT));
    }

    @Then("^Yo verifico que se muestre el mensaje \"([^\"]*)\"$")
    public void yoVerificoQueSeMuestreElMensaje(String message) {
        mario.should(seeThat(TheMessageProcess.is(message), equalTo(true))
                .orComplainWith(AssertionsAutomationpractice.class, AssertionsAutomationpractice.MESSAGE_NO_EXPECTED));
    }

    @When("^Yo realizo la busqueda sin algun criterio$")
    public void yoRealizoLaBusquedaSinAlgunCriterio() {
        mario.attemptsTo(PerformSearch.withoutCriterion());
    }


    @Then("^Yo deberia ver el mensaje \"([^\"]*)\"$")
    public void yoDeberiaVerElMensaje(String message) {
        mario.should(seeThat(TheMessage.is(message), equalTo(true))
                .orComplainWith(AssertionsAutomationpractice.class, AssertionsAutomationpractice.MESSAGE_NO_EXPECTED));
    }

    @Then("^Yo deberia ver (\\d+) productos en la lista$")
    public void yoDeberiaVerProductosEnLaLista(int quantity) {
        mario.should(seeThat(TheQuantity.product(), is(quantity))
                .orComplainWith(AssertionsAutomationpractice.class, AssertionsAutomationpractice.QUANTITY_PRODUCT_NO_EXPECTED));
    }

}
