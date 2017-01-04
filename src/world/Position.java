package world;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Implentacja pozycji
 */
public class Position implements Serializable {
    private int mLongitude;
    private int mLatitude;

    /**
     * Konstruktor
     *
     * @param longitude
     * @param latitude
     */
    public Position(int longitude, int latitude) {
        mLongitude = longitude;
        mLatitude = latitude;
    }

    /**
     * Konstruktor kopiujacy
     * @param position
     */
    public Position(Position position) {
        mLongitude = position.getLongitude();
        mLatitude = position.getLatitude();
    }

    /**
     * Losowy konstruktor
     */
    public Position() {
        mLongitude = (int) (Math.random() * 20) * 50;
        mLatitude = (int) (Math.random() * 20) * 50;
    }

    /**
     * Zwrca dlugosc
     * @return dlugosc
     */
    public int getLongitude() {
        return mLongitude;
    }

    /**
     * Ustawia dlugosc
     * @param longitude
     */
    public void setLongitude(int longitude) {
        mLongitude = longitude;
    }

    /**
     * Zwraca szerokosc
     * @return szerokosc
     */
    public int getLatitude() {
        return mLatitude;
    }

    /**
     * Ustawia szerokosc
     * @param latitude
     */
    public void setLatitude(int latitude) {
        mLatitude = latitude;
    }

    /**
     * Zmienia szerokosc
     * @param change
     */
    public void changeLatitude(int change) {
        mLatitude += change;
    }

    /**
     * Zmienia dlugosc
     * @param change
     */
    public void changeLongitude(int change) {
        mLongitude += change;
    }

    /**
     * Zwraca dusyans miedzy dana pozycja, a pozycja ktora prosi o wyliczenie odlegosci
     * @param position
     * @return odleglosc
     */
    public int getDistance(Position position) {
        return Math.abs(getLatitude() - position.getLatitude()) +
                Math.abs(getLongitude() - position.getLongitude());
    }

    @Override
    public String toString() {
        return "Longitude - " + getLongitude() +
                ", Latitude - " + getLatitude();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (mLongitude != position.mLongitude) return false;
        return mLatitude == position.mLatitude;
    }

    @Override
    public int hashCode() {
        int result = mLongitude;
        result = 31 * result + mLatitude;
        return result;
    }
}
