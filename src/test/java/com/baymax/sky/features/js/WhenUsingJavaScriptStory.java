package com.baymax.sky.features.js;

import com.baymax.sky.interactions.HighLigth;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.baymax.sky.tasks.Login.BASE_URL;

@RunWith(SerenityRunner.class)
public class WhenUsingJavaScriptStory {

    Actor jacob = Actor.named("Jacob");
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        jacob.can(BrowseTheWeb.with(herBrowser));
    }

    @WithTag("browserstack:remote")
    @Test
    public void verify_login_with_wrong_password(){

        Target FIRST_NAME = Target.the("first name field")
                .located(By.id("FirstName"));

        jacob.wasAbleTo(
                Open.url(BASE_URL),
                HighLigth.element(FIRST_NAME),
                Wait.aBit(3)
        );
    }



}




