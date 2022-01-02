package com.weelo.automationpractice.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://automationpractice.com/index.php")
public class AutomationpracticeUserInterfaces extends PageObject {

    public static final Target TEXTFIELD_SEARCH_PRODUCT = Target.the("Campo de texto para buscar producto").located(By.id("search_query_top"));

    public static final Target BUTTON_SEARCH_PRODUCT = Target.the("Boton para buscar producto").located(By.name("submit_search"));

    public static final Target LABEL_RESULT_SEARCH = Target.the("Label de producto encontrado").located(By.xpath("//ul[@class='product_list grid row']//h5"));

    public static final Target ALERT_WARNING_RESULT =
            Target.the("Label para mostrar mensajes alternos a los resultados esperados").located(By.xpath("//p[@class='alert alert-warning']"));

    public static final Target LIST_PRODUCT_SEARCH =
            Target.the("Lista de productos encontrados").located(By.xpath("//ul[@class='product_list grid row']/li"));

}
