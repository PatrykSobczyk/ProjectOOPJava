package vehicles;

import main.Main;
import world.Position;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public abstract class Vehicle implements Serializable {
    private int mCapacity;
    private int mMaxSpeed;
    private String mRegistrationNumber;
    private int mTankCapacity;
    private Position mPosition;
    private int mPetrolLevel;

    public Vehicle(int capacity, int maxSpeed, String registrationNumber, int tankCapacity, Position position) {
        mCapacity = capacity;
        mMaxSpeed = maxSpeed;
        mRegistrationNumber = registrationNumber;
        mTankCapacity = tankCapacity;
        mPosition = position;
        mPetrolLevel = tankCapacity;
    }

    public Vehicle() {
        mCapacity = (int) Math.random() * ((2000 - 100) + 1) + 100;
        mMaxSpeed = (int) Math.random() * ((170 - 50) + 1) + 50;
        mRegistrationNumber = "RES" + String.valueOf((int) Math.random() * ((60000 - 10000) + 1) + 10000);
        mTankCapacity = 0;
        mPosition = new Position(Main.getRestorationAddress().getPosition());
        mPetrolLevel = 0;

    }

    public int getPetrolLevel() {
        return mPetrolLevel;
    }

    public void setPetrolLevel(int petrolLevel) {
        mPetrolLevel = petrolLevel;
    }

    public void refuel() {
        mPetrolLevel = mTankCapacity;
    }

    public void changePetrolLevel(int change) {
        mPetrolLevel += change;
    }

    public int getCapacity() {
        return mCapacity;
    }

    public void setCapacity(int capacity) {
        mCapacity = capacity;
    }

    public int getMaxSpeed() {
        return mMaxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        mMaxSpeed = maxSpeed;
    }

    public String getRegistrationNumber() {
        return mRegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        mRegistrationNumber = registrationNumber;
    }

    public int getTankCapacity() {
        return mTankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        mTankCapacity = tankCapacity;
    }

    public Position getPosition() {
        return mPosition;
    }

    public void setPosition(Position position) {
        mPosition = position;
    }

    @Override
    public String toString() {
        return "Cap:" + mCapacity + ", MaxSpeed" + mMaxSpeed + ", RegNumb" + mRegistrationNumber + ", TankCap" + mTankCapacity + ", " + mPosition;
    }
}
