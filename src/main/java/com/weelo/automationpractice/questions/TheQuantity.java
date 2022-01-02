package com.weelo.automationpractice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.weelo.automationpractice.userinterfaces.AutomationpracticeUserInterfaces.LIST_PRODUCT_SEARCH;

public class TheQuantity implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {

        return LIST_PRODUCT_SEARCH.resolveAllFor(actor).size();
    }

    public static TheQuantity product() {
        return new TheQuantity();
    }
}
