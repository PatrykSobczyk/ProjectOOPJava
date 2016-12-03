package vehicles;

import javafx.scene.layout.VBox;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Car extends Vehicle {
    private int mNumberOfSeats;

    public int getNumberOfSeats() {
        return mNumberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        mNumberOfSeats = numberOfSeats;
    }
}
