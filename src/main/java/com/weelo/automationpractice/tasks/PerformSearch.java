package com.weelo.automationpractice.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static com.weelo.automationpractice.userinterfaces.AutomationpracticeUserInterfaces.BUTTON_SEARCH_PRODUCT;

public class PerformSearch implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BUTTON_SEARCH_PRODUCT));
    }

    public static PerformSearch withoutCriterion() {
        return Tasks.instrumented(PerformSearch.class);
    }
}
