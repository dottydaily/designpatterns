package problem1_adapterPattern;

import models.Quackable;

public class PigeonAdapter implements Quackable {
    private Pigeon pigeon;
    public static int cooCount;

    public PigeonAdapter(Pigeon pigeon) {
        this.pigeon = pigeon;
        this.cooCount = 0;
    }

    @Override
    public void quack() {
        pigeon.coo();
        pigeon.coo();
    }


}
