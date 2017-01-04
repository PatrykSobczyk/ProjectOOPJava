package vehicles;

import world.Position;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Implementuje skuter
 */
public class Scooter extends Vehicle implements Serializable {
    private boolean mHasHelmet;

    /**
     * Konsktuktor skutera
     *
     * @param capacity
     * @param maxSpeed
     * @param registrationNumber
     * @param tankCapacity
     * @param position
     * @param hasHelmet
     */
    public Scooter(int capacity, int maxSpeed, String registrationNumber, int tankCapacity, Position position, boolean hasHelmet) {
        super(capacity, maxSpeed, registrationNumber, tankCapacity, position);
        mHasHelmet = hasHelmet;
    }

    /**
     * Konstruktor losowy skutera
     */
    public Scooter() {
        super();
        setTankCapacity(5000);
        setPetrolLevel(5000);
        mHasHelmet = true;
    }

    /**
     * Zwraca czy ma kask w bagazniku
     * @return czy ma kask
     */
    public boolean isHasHelmet() {
        return mHasHelmet;
    }

    /**
     * Ustawia czy jest kask
     * @param hasHelmet
     */
    public void setHasHelmet(boolean hasHelmet) {
        mHasHelmet = hasHelmet;
    }

    @Override
    public String toString() {
        return "Scooter" + super.toString() + ", HasHelmet:" + mHasHelmet;
    }
}
