package com.baymax.sky.features.authentication;

import com.baymax.sky.tasks.Login;
import com.baymax.sky.ui.HomePage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenProvidingAnUsernameAndPasswordStory {
    Actor jacob = Actor.named("Jacob");
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        jacob.can(BrowseTheWeb.with(herBrowser));
    }

    @WithTag("testcase:01")
    @Test
    public void verify_login_successfully() {

        jacob.wasAbleTo(
                Login.asNormalUser("rong@gmail.com", "12345@"),
                Ensure.that(Login.LOGOUT_BUTTON).attribute("href").contains("/logout"),
                Ensure.that(Login.LOGOUT_BUTTON).attribute("class").isEqualTo("ico-logout"),
                Ensure.thatTheCurrentPage().currentUrl().isEqualTo("https://demo.nopcommerce.com/"),
                Ensure.thatTheCurrentPage().title().isEqualTo("nopCommerce demo store")
        );
    }
    @WithTag("testcase:02")
    @Test
    public void verify_login_with_invalid_email() {
        jacob.wasAbleTo(
                Login.asNormalUser("rong", "12345@"),
                Ensure.that(HomePage.WRONG_EMAIL_ERROR).text().isEqualTo("Wrong email"),
                Ensure.that(HomePage.WRONG_EMAIL_ERROR).hasTextContent("Wrong email")
        );
    }

    @WithTag("testcase:03")
    @Test
    public void verify_login_with_wrong_email(){

        //jacob.remember("count", SelectOptions.of(BUTTON_TEXT_LOG_IN).asString());

        jacob.wasAbleTo(
                Login.asNormalUser("rongcon@gmail.com", "12345@"),
                Ensure.that(HomePage.VALIDATION_EMAIL_ERROR).text().contains("com.baymax.sky.tasks.Login was unsuccessful. Please correct the errors and try again.")
        );
    }
    @WithTag("testcase:04")
    @Test
    public void verify_login_with_wrong_password(){
        jacob.wasAbleTo(
                Login.asNormalUser("rong@gmail.com", "123"),
                Ensure.that(HomePage.VALIDATION_EMAIL_ERROR).text().contains("The credentials provided are incorrect")
        );
    }
    @WithTag("testcase:05")
    @Test
    public void verify_login_when_user_input_nothing(){
        jacob.wasAbleTo(
                Login.asNormalUser("", ""),
                Ensure.that(HomePage.WRONG_EMAIL_ERROR).text().isEqualTo("Please enter your email")
        );
    }
}