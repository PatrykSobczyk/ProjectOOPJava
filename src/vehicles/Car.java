package vehicles;

import world.Position;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Car extends Vehicle implements Serializable {
    private int mNumberOfSeats;

    public Car(int capacity, int maxSpeed, String registrationNumber, int tankCapacity, Position position, int numberOfSeats) {
        super(capacity, maxSpeed, registrationNumber, tankCapacity, position);
        mNumberOfSeats = numberOfSeats;
    }

    public Car() {
        super();
        setTankCapacity(50000);
        setPetrolLevel(50000);
        mNumberOfSeats = (int) (Math.random() * ((7 - 2) + 1) + 2);
    }

    public int getNumberOfSeats() {
        return mNumberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        mNumberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Car" + super.toString() + ", NumOfSeats:" + mNumberOfSeats;
    }
}
