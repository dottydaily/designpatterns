package models;

// use this class at counter of quack numbers : Decorator Pattern
public class QuackCounter implements Quackable {
    private Quackable duck;
    private static int numberOfQuack;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuack++;
    }

    public static int getNumberOfQuack() {
        return numberOfQuack;
    }
}
