package com.weelo.automationpractice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.assertj.core.api.SoftAssertions;

import static com.weelo.automationpractice.userinterfaces.AutomationpracticeUserInterfaces.ALERT_WARNING_RESULT;

public class TheMessageProcess implements Question<Boolean> {

    private final SoftAssertions validateSendValues = new SoftAssertions();
    private final String message;

    public TheMessageProcess(String message) {
        this.message = message;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean flag = false;

        if (ALERT_WARNING_RESULT.resolveFor(actor).isPresent()) {
            flag = true;
            validateSendValues.assertThat(Text.of(ALERT_WARNING_RESULT).viewedBy(actor).asString()).isEqualTo(message + " \"" + actor.recall("product") + "\"");

        validateSendValues.assertAll();
    }

        return flag;
    }

    public static TheMessageProcess is(String message) {
        return new TheMessageProcess(message);
    }
}
