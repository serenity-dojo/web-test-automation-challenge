package com.serenitydojo.webchallenge.cart;

import net.serenitybdd.core.pages.PageComponent;

public class ConfirmationPage extends PageComponent {
    public String getThankYouMessage() {
        return $(".page-title").getText();
    }
}
