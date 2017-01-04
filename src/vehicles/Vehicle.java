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

    /**
     * Konsktruktor pojazdu
     *
     * @param capacity
     * @param maxSpeed
     * @param registrationNumber
     * @param tankCapacity
     * @param position
     */
    public Vehicle(int capacity, int maxSpeed, String registrationNumber, int tankCapacity, Position position) {
        mCapacity = capacity;
        mMaxSpeed = maxSpeed;
        mRegistrationNumber = registrationNumber;
        mTankCapacity = tankCapacity;
        mPosition = position;
        mPetrolLevel = tankCapacity;
    }

    /**
     * Konstruktor losowy pojazdu
     */
    public Vehicle() {
        mCapacity = (int) Math.random() * ((2000 - 100) + 1) + 100;
        mMaxSpeed = (int) Math.random() * ((170 - 50) + 1) + 50;
        mRegistrationNumber = "RES" + String.valueOf((int) Math.random() * ((60000 - 10000) + 1) + 10000);
        mTankCapacity = 0;
        mPosition = new Position(Main.getRestorationAddress().getPosition());
        mPetrolLevel = 0;

    }

    /**
     * Zwraca poziom benzyny
     * @return
     */
    public int getPetrolLevel() {
        return mPetrolLevel;
    }

    /**
     * UStawia poziom benzyny
     * @param petrolLevel
     */
    public void setPetrolLevel(int petrolLevel) {
        mPetrolLevel = petrolLevel;
    }

    /**
     * Tankuje do pelna
     */
    public void refuel() {
        mPetrolLevel = mTankCapacity;
    }

    /**
     * Zmiena poziom benzyny
     * @param change
     */
    public void changePetrolLevel(int change) {
        mPetrolLevel += change;
    }

    /**
     * Zwraca pojemnosc
     * @return pojemnosc
     */
    public int getCapacity() {
        return mCapacity;
    }

    /**
     * UStawia pojemnosc
     * @param capacity
     */
    public void setCapacity(int capacity) {
        mCapacity = capacity;
    }

    /**
     * Zwraca predkosc maksymalna
     * @return predkosc maksymalna
     */
    public int getMaxSpeed() {
        return mMaxSpeed;
    }

    /**
     * Ustawia predkosc maksymalna
     * @param maxSpeed
     */
    public void setMaxSpeed(int maxSpeed) {
        mMaxSpeed = maxSpeed;
    }

    /**
     * Zwraca numer rejestracyjny
     * @return numer rejestracyjny
     */
    public String getRegistrationNumber() {
        return mRegistrationNumber;
    }

    /**
     * Ustawia numer rejestracyjny
     * @param registrationNumber
     */
    public void setRegistrationNumber(String registrationNumber) {
        mRegistrationNumber = registrationNumber;
    }

    /**
     * Zwraca pojemnosc baku
     * @return pojemnosc baku
     */
    public int getTankCapacity() {
        return mTankCapacity;
    }

    /**
     * Ustawa pojemnosc baku
     * @param tankCapacity
     */
    public void setTankCapacity(int tankCapacity) {
        mTankCapacity = tankCapacity;
    }

    /**
     * Zwraca pozycje pojazdu
     * @return pozycja pojazdu
     */
    public Position getPosition() {
        return mPosition;
    }

    /**
     * Ustawia pozycje
     * @param position
     */
    public void setPosition(Position position) {
        mPosition = position;
    }

    @Override
    public String toString() {
        return "Cap:" + mCapacity + ", MaxSpeed" + mMaxSpeed + ", RegNumb" + mRegistrationNumber + ", TankCap" + mTankCapacity + ", " + mPosition;
    }
}
