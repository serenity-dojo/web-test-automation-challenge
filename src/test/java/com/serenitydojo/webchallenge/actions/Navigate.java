package com.serenitydojo.webchallenge.actions;

import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.By;

public class Navigate extends UIInteractions {

    public void openECommerceApplication() {
        // Open the application home page
        openUrl("https://magento.softwaretestingboard.com/");
    }

    public void toProductPage(String productName) {
        // Open the product details page
        find(By.linkText(productName)).click();
    }
}
