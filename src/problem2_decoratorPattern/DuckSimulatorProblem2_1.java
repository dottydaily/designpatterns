package problem2_decoratorPattern;

import models.*;
import problem1_adapterPattern.Pigeon;
import problem1_adapterPattern.PigeonAdapter;

public class DuckSimulatorProblem2_1 {
    public static void main(String[] args) {
        DuckSimulatorProblem2_1 simulator = new DuckSimulatorProblem2_1();

        simulator.simulate();
    }

    void simulate() {

        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator with QuackCounter");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeon);

        System.out.println("The ducks quacked " +
                QuackCounter.getNumberOfQuack() +  " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
