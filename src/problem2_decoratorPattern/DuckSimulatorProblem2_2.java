package problem2_decoratorPattern;

import models.*;
import problem1_adapterPattern.Pigeon;
import problem1_adapterPattern.PigeonAdapter;

public class DuckSimulatorProblem2_2 {
    public static void main(String[] args) {
        DuckSimulatorProblem2_2 simulator = new DuckSimulatorProblem2_2();

        simulator.simulate();
    }

    void simulate() {

        Quackable mallardDuck = new QuackEcho(new MallardDuck());
        Quackable redheadDuck = new QuackEcho(new RedheadDuck());
        Quackable duckCall = new QuackEcho(new DuckCall());
        Quackable rubberDuck = new QuackEcho(new RubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator with QuackEcho");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeon);
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
