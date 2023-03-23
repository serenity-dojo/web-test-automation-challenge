package com.serenitydojo.webchallenge.cart;

import net.serenitybdd.core.pages.PageComponent;
import org.openqa.selenium.By;

public class ProductOptionsPageComponent extends PageComponent {

    public static By SIZE_ERROR_MESSAGE = By.cssSelector(".size div.mage-error");
    public static By COLOR_ERROR_MESSAGE = By.cssSelector(".size div.mage-error");

    public String getSizeErrorMessage() {
        return find(SIZE_ERROR_MESSAGE).getText();
    }

    public String getColorErrorMessage() {
        return find(COLOR_ERROR_MESSAGE).getText();
    }
}
