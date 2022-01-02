package com.weelo.automationpractice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.assertj.core.api.SoftAssertions;
import static com.weelo.automationpractice.userinterfaces.AutomationpracticeUserInterfaces.LABEL_RESULT_SEARCH;

public class ResultShow implements Question<Boolean> {

    private final SoftAssertions validateSendValues = new SoftAssertions();
    private String product;

    public ResultShow(String product) {
        this.product = product;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean flag = false;

        if (LABEL_RESULT_SEARCH.resolveFor(actor).isPresent()) {
            flag = true;
            validateSendValues.assertThat(Text.of(LABEL_RESULT_SEARCH).viewedBy(actor).asString()).isEqualTo(product);
        }

        return flag;
    }

    public static ResultShow product(String product) {
        return new ResultShow(product);
    }
}
