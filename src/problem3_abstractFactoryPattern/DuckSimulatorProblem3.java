package problem3_abstractFactoryPattern;

import models.*;
import problem1_adapterPattern.Pigeon;
import problem1_adapterPattern.PigeonAdapter;

public class DuckSimulatorProblem3 {
    public static void main(String[] args) {
        DuckSimulatorProblem3 simulator = new DuckSimulatorProblem3();
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory duckFactoryCounter = new DuckFactoryCounter();
        AbstractDuckFactory duckFactoryCounterEcho = new DuckFactoryCounterEcho();

        simulator.simulate(duckFactory);
        simulator.simulate(duckFactoryCounter);
        simulator.simulate(duckFactoryCounterEcho);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedhedDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        System.out.print("\nDuck Simulator : ");
        if (duckFactory instanceof DuckFactory)
            System.out.println("No Decorator");
        else if (duckFactory instanceof DuckFactoryCounter)
            System.out.println("QuackCounter");
        else if (duckFactory instanceof DuckFactoryCounterEcho)
            System.out.println("QuackCounter by QuackEcho");
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
