package com.serenitydojo.webchallenge.cart;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.screenplay.ui.Button;

import java.time.Duration;
import java.util.List;

public class ShoppingCart extends PageComponent {

    public void proceedToCheckout() {
        $(Button.withText("Proceed to Checkout")).click();
        withTimeoutOf(Duration.ofSeconds(15)).waitForAbsenceOf(".loader");
    }

    public List<String> getCartItems() {
        return findAll("#mini-cart .product-item-name").texts();
    }
}
