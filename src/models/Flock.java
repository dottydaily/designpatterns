package models;

import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
    protected ArrayList<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {

        // Iterator Pattern : This flock is quackable so it can work with quack()
        // Like a command that make the whole flock of duck use quack()
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
        }
    }
}
