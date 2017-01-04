package world;

import main.Main;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Address implements Serializable {
    private String[] mNames = {"Poznan", "Warszawa", "Witkowo", "Debiec", "Debina", "Lubon", "Puszczykowo", "Jaroci", "Grzybowo", "Anastazerwo", "Malenin", "Gorzykowo", "Gniezno", "Polanka", "Rybakowka", "Malachowo", "Konin"};
    private Position mPosition;
    private String mName;

    public Address(Position position, String name) {
        mPosition = position;
        mName = name;
    }

    public Address(int longitude, int latitude, String name) {
        mPosition = new Position(longitude, latitude);
        mName = name;
    }

    public Address() {
        Position position = new Position();
        while (!Map.get().availablePosition(position)) {
            position = new Position();
        }

        mPosition = position;
        Map.get().add(position);
        mName = mNames[(int) (Math.random() * (mNames.length - 1))];
    }

    public final Position getPosition() {
        return mPosition;
    }

    public void setPosition(Position position) {
        mPosition = position;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getDistanceToRestaurant() {
        return Math.abs(getPosition().getLatitude() - Main.getRestorationAddress().getPosition().getLatitude()) +
                Math.abs(getPosition().getLongitude() - Main.getRestorationAddress().getPosition().getLongitude());
    }

    @Override
    public String toString() {
        return this.getName() +
                ", " + this.getPosition();
    }
}
