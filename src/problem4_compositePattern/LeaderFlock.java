package problem4_compositePattern;

import models.Flock;
import models.Quackable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LeaderFlock extends Flock {
    @Override
    public void add(Quackable quacker) {

        // if we add by LeaderFlock instance, then we need to prevent add it directly
        // because it will be added at "LeaderFlock instance" that have Quackable instances
        // If we iterating our ArrayList, quack() will invoke method of "LeaderFlock"
        // So every member which is a LeaderFlock will be Quack 3 times at first of its member (Wrong purpose)

        // then we need to manually add its member into our arraylist
        if (quacker instanceof LeaderFlock) {
            LeaderFlock leaderFlock = (LeaderFlock) quacker;
            ArrayList<Quackable> secondQuakers = leaderFlock.quackers;

            Iterator iterator = secondQuakers.iterator();
            while (iterator.hasNext()) {
                Quackable member = (Quackable) iterator.next();
                this.quackers.add(member);
            }
        } else {
            this.quackers.add(quacker);
        }
    }

    @Override
    public void quack() {
        Iterator iterator = quackers.iterator();
        Quackable quacker = (Quackable) iterator.next();

        // Leader Duck
        for (int i = 0 ; i < 3 ; i++) {
            System.out.print("LEADER ==> ");
            quacker.quack();
        }

        // Remaining Duck
        while (iterator.hasNext()) {
            quacker = (Quackable) iterator.next();
            quacker.quack();
        }
    }
}
