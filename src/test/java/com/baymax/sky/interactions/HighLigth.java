package com.baymax.sky.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.targets.Target;

public class HighLigth {
    public static Performable element(Target target) {
        return Task.where("{0} high ligth element ", actor -> {
            actor.attemptsTo(
                Evaluate.javascript("arguments[0].style.backgroundColor = 'red'", new Object[]{
                    target.resolveFor(actor)})
            );
        });
    }
}
