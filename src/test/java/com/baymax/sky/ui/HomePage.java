package com.baymax.sky.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target WRONG_EMAIL_ERROR = Target.the("Wrong email error")
            .locatedBy("//span[@id='Email-error']");
    public static final Target VALIDATION_EMAIL_ERROR = Target.the("Validation email eror")
            .locatedBy("//div[@class='message-error validation-summary-errors']");
}
