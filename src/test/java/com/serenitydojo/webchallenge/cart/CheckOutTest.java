package com.serenitydojo.webchallenge.cart;

import com.serenitydojo.webchallenge.actions.Navigate;
import com.serenitydojo.webchallenge.actions.ProductDetails;
import com.serenitydojo.webchallenge.domain.Shopper;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheckOutTest extends UIInteractionSteps {

    @Steps
    Navigate navigate;

    @Steps
    ProductDetails fromProductDetails;

    @Steps
    MakeAPurchase makeAPurchase;

    MenuBar menuBar;
    ShoppingCart shoppingCart;
    ConfirmationPage confirmationPage;
    ProductOptionsPageComponent productOptions;

    @Nested
    class WhenPurchasingSimpleItems {
        @Test
        void purchaseASingleItem() {

            navigate.openECommerceApplication();

            navigate.toProductPage("Push It Messenger Bag");

            fromProductDetails.addToCart();

            // Show the current cart
            menuBar.showCart();

            // Proceed to checkout
            shoppingCart.proceedToCheckout();

            // Complete user details
            makeAPurchase.enterCustomerDetailsForShopper(Shopper.standardShopper());

            makeAPurchase.placeOrder();

            assertThat(confirmationPage.getThankYouMessage())
                    .isEqualTo("Thank you for your purchase!");

        }
    }

    @Nested
    class WhenPurchasingItemsOfClothing {
        // When adding an item of clothing to the cart

        // The color is mandatory

        @Test
        void colorAndSizeAreMandatory() {
            navigate.openECommerceApplication();

            navigate.toProductPage("Hero Hoodie");

            fromProductDetails.addToCart();

            SoftAssertions softly = new SoftAssertions();
            softly.assertThat(productOptions.getSizeErrorMessage()).isEqualTo("This is a required field.");
            softly.assertThat(productOptions.getColorErrorMessage()).isEqualTo("This is a required field.");
            softly.assertAll();
        }

        @Test
        void weCanPlaceTheItemInTheCartAfterSpecifyingTheSizeAndColor() {
            navigate.openECommerceApplication();

            navigate.toProductPage("Hero Hoodie");

            fromProductDetails.selectSize("M");
            fromProductDetails.selectColor("Black");
            fromProductDetails.addToCart();

            // Show the current cart
            menuBar.showCart();

            // Should see the item in the cart
            assertThat(shoppingCart.getCartItems()).contains("Hero Hoodie");
        }

    }

}
