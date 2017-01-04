package world;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Position implements Serializable {
    private int mLongitude;
    private int mLatitude;

    public Position(int longitude, int latitude) {
        mLongitude = longitude;
        mLatitude = latitude;
    }

    public Position(Position position) {
        mLongitude = position.getLongitude();
        mLatitude = position.getLatitude();
    }

    public Position() {
        mLongitude = (int) (Math.random() * 20) * 50;
        mLatitude = (int) (Math.random() * 20) * 50;
    }

    public int getLongitude() {
        return mLongitude;
    }

    public void setLongitude(int longitude) {
        mLongitude = longitude;
    }

    public int getLatitude() {
        return mLatitude;
    }

    public void setLatitude(int latitude) {
        mLatitude = latitude;
    }

    public void changeLatitude(int change) {
        mLatitude += change;
    }

    public void changeLongitude(int change) {
        mLongitude += change;
    }

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
