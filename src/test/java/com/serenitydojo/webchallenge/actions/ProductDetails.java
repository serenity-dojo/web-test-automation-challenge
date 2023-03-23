package com.serenitydojo.webchallenge.actions;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Button;
import net.thucydides.core.annotations.Step;

public class ProductDetails extends UIInteractions {

    public static final String SPINNER = "._block-content-loading";
    public static final SearchableTarget ADD_TO_CART_BUTTON = Button.withText("Add to Cart");
    public static final String OPTION_SELECTOR = "[aria-label='{0}']";

    @Step("Add the product to the cart")
    public void addToCart() {
        find(ADD_TO_CART_BUTTON).click();
        waitForAbsenceOf(SPINNER);
    }

    @Step("Select the color {0}")
    public void selectColor(String color) {
        evaluateJavascript("arguments[0].click();" , $(OPTION_SELECTOR, color));
    }

    @Step("Select the size {0}")
    public void selectSize(String size) {
        // Perform a javascript click on the size option
        evaluateJavascript("arguments[0].click();" , $(OPTION_SELECTOR, size));

    }
}
