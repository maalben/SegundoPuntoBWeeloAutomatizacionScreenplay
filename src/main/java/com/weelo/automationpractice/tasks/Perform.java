package com.weelo.automationpractice.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static com.weelo.automationpractice.userinterfaces.AutomationpracticeUserInterfaces.BUTTON_SEARCH_PRODUCT;
import static com.weelo.automationpractice.userinterfaces.AutomationpracticeUserInterfaces.TEXTFIELD_SEARCH_PRODUCT;

public class Perform implements Task {

    private String product;

    public Perform(String product) {
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember("product", product);
        actor.attemptsTo(Enter.theValue(product).into(TEXTFIELD_SEARCH_PRODUCT));
        actor.attemptsTo(Click.on(BUTTON_SEARCH_PRODUCT));
    }

    public static Perform theSearch(String product) {
        return Tasks.instrumented(Perform.class, product);
    }
}
