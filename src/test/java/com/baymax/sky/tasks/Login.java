package com.baymax.sky.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import org.jetbrains.annotations.NotNull;

public class Login {

    public static final Target INPUT_ID_EMAIL = Target.the("email textbox")
            .locatedBy("//input[@id='Email']");
    public static final Target INPUT_ID_PASSWORD = Target.the("password textbox")
            .locatedBy("//input[@id='Password']");
    public static final Target LOGOUT_BUTTON = Target.the("Logout button")
            .locatedBy("//a[text()='Log out']");
    public static final String BASE_URL = "https://demo.nopcommerce.com/register?returnUrl=%2F";
    public static final Target BUTTON_TEXT_LOG_IN = Target.the("login button")
            .locatedBy("//button[text()='Log in']");

    @NotNull
    public static Performable asNormalUser(String email, String password) {
        return Task.where("{0} login as normal user", actor -> actor.attemptsTo(
                Open.url(BASE_URL),
                Enter.theValue(email).into(INPUT_ID_EMAIL),
                Enter.theValue(password).into(INPUT_ID_PASSWORD),
                Click.on(BUTTON_TEXT_LOG_IN)
        ));
    }
}
