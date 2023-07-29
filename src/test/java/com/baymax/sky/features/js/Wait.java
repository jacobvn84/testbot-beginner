package com.baymax.sky.features.js;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class Wait {
    public static Performable aBit(int second) {
        return Task.where("{0} wait a bit in "+second + "second", actor -> {
            try {
                Thread.sleep(1000*second);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
