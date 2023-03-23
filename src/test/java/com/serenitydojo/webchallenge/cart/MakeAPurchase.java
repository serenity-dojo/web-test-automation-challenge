package com.serenitydojo.webchallenge.cart;

import com.serenitydojo.webchallenge.domain.Shopper;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.Dropdown;
import net.serenitybdd.screenplay.ui.InputField;
import net.serenitybdd.screenplay.ui.RadioButton;

import java.time.Duration;

public class MakeAPurchase extends UIInteractionSteps {
    public void enterCustomerDetailsForShopper(Shopper shopper) {
        $(InputField.withNameOrId("customer-email")).type(shopper.getEmail());
        $(InputField.withNameOrId("firstname")).type(shopper.getFirstName());
        $(InputField.withNameOrId("lastname")).type(shopper.getLastName());
        $(InputField.withNameOrId("street[0]")).type(shopper.getStreetAddress());
        $(InputField.withNameOrId("city")).type(shopper.getCity());
        $(Dropdown.withNameOrId("country_id")).selectByVisibleText(shopper.getCounty());
        $(InputField.withNameOrId("telephone")).type(shopper.getPhoneNumber());
        $(RadioButton.withValue("flatrate_flatrate")).click();
        withTimeoutOf(Duration.ofSeconds(15)).waitForAbsenceOf(".loader");
    }

    public void placeOrder() {
        $(Button.withText("Next")).click();
        withTimeoutOf(Duration.ofSeconds(15)).waitForAbsenceOf(".loader");

        $(Button.withText("Place Order")).click();
        withTimeoutOf(Duration.ofSeconds(15)).waitForAbsenceOf(".loader");
    }
}
