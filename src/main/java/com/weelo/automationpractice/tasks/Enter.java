package com.weelo.automationpractice.tasks;

import com.weelo.automationpractice.userinterfaces.AutomationpracticeUserInterfaces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Enter implements Task {

    private AutomationpracticeUserInterfaces automationpracticeUserInterfaces;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(automationpracticeUserInterfaces));
    }

    public static Enter toThePageAutomationPractice() {
        return instrumented(Enter.class);
    }
}
