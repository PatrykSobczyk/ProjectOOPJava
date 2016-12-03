package vehicles;

import world.Position;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Vehicle {
    private Double mCapacity;
    private Double mMaxSpeed;
    private String mRegistrationNumber;
    private Double mTankCapacity;
    private Position mPosition;

    public Double getCapacity() {
        return mCapacity;
    }

    public void setCapacity(Double capacity) {
        mCapacity = capacity;
    }

    public Double getMaxSpeed() {
        return mMaxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        mMaxSpeed = maxSpeed;
    }

    public String getRegistrationNumber() {
        return mRegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        mRegistrationNumber = registrationNumber;
    }

    public Double getTankCapacity() {
        return mTankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        mTankCapacity = tankCapacity;
    }

    public Position getPosition() {
        return mPosition;
    }

    public void setPosition(Position position) {
        mPosition = position;
    }
}
