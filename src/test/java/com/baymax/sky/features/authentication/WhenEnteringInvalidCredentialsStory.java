package com.baymax.sky.features.authentication;

import com.baymax.sky.tasks.Login;
import com.baymax.sky.ui.HomePage;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "datatest/invalid-users.csv")
public class WhenEnteringInvalidCredentialsStory {

    private String email;
    private String password;

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    Actor jacob = Actor.named("Jacob");
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        jacob.can(BrowseTheWeb.with(herBrowser));
    }

    @WithTag("testcase:04")
    @Test
    public void verify_login_with_wrong_password(){

        jacob.wasAbleTo(
                Login.asNormalUser(email, password),
                Ensure.that(HomePage.VALIDATION_EMAIL_ERROR).text().contains("Login was unsuccessful")
        );
    }
}