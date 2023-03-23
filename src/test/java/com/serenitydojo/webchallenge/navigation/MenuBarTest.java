package com.serenitydojo.webchallenge.navigation;

import com.serenitydojo.webchallenge.actions.Navigate;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MenuBarTest {

    public static final String TOP_LEVEL_MENU_ENTRIES = ".navigation a.level-top";

    @Steps
    Navigate navigate;

    @Test
    void shouldShowTheTopLevelMenuItems() {
        // Open the application home page
        navigate.openECommerceApplication();

        // Fetch the top level menu items
        List<String> menuItems = navigate.findAll(TOP_LEVEL_MENU_ENTRIES).texts();

        // Check that the items are the expected ones
        assertThat(menuItems).contains("What's New","Women", "Men","Gear","Training","Sale");
    }
}
