package com.weelo.automationpractice.exceptions;

public class AssertionsAutomationpractice extends AssertionError {

    private static final long serialVersionUID = 1L;

    public static final String NO_FOUND_ELEMENT = "El elemento a verificar no es visible";
    public static final String MESSAGE_NO_EXPECTED = "El mensaje no es el esperado";
    public static final String QUANTITY_PRODUCT_NO_EXPECTED = "La cantidad de productos no es la esperada";

    public AssertionsAutomationpractice(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionsAutomationpractice(String message) {
        super(message);
    }

}
