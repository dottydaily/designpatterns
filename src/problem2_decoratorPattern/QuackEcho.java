package problem2_decoratorPattern;

import models.Quackable;

public class QuackEcho implements Quackable {
    private Quackable duck;

    public QuackEcho(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();

        // Echo Quack
        System.out.print("Echo : ");
        duck.quack();
    }
}
