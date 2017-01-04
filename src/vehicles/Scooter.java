package vehicles;

import world.Position;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Scooter extends Vehicle implements Serializable {
    private boolean mHasHelmet;

    public Scooter(int capacity, int maxSpeed, String registrationNumber, int tankCapacity, Position position, boolean hasHelmet) {
        super(capacity, maxSpeed, registrationNumber, tankCapacity, position);
        mHasHelmet = hasHelmet;
    }

    public Scooter() {
        super();
        setTankCapacity(5000);
        setPetrolLevel(5000);
        mHasHelmet = true;
    }

    public boolean isHasHelmet() {
        return mHasHelmet;
    }

    public void setHasHelmet(boolean hasHelmet) {
        mHasHelmet = hasHelmet;
    }

    @Override
    public String toString() {
        return "Scooter" + super.toString() + ", HasHelmet:" + mHasHelmet;
    }
}
