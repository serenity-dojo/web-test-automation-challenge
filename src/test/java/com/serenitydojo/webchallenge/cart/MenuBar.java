package com.serenitydojo.webchallenge.cart;

import net.serenitybdd.core.pages.PageComponent;

import java.time.Duration;

public class MenuBar extends PageComponent {
    public static final String SHOW_CART_BUTTON = ".action.showcart";

    public void showCart() {
        find(MenuBar.SHOW_CART_BUTTON).click();
        withTimeoutOf(Duration.ofSeconds(5)).waitFor("#top-cart-btn-checkout");
    }
}
