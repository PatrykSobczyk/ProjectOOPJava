package world;

import main.Main;

import java.io.Serializable;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Implementuje adres w naszym swiecie
 */
public class Address implements Serializable {
    private String[] mNames = {"Poznan", "Warszawa", "Witkowo", "Debiec", "Debina", "Lubon", "Puszczykowo", "Jaroci", "Grzybowo", "Anastazerwo", "Malenin", "Gorzykowo", "Gniezno", "Polanka", "Rybakowka", "Malachowo", "Konin"};
    private Position mPosition;
    private String mName;

    /**
     * Konstruktor adresu
     *
     * @param position
     * @param name
     */
    public Address(Position position, String name) {
        mPosition = position;
        mName = name;
    }

    /**
     * Konstruktor adresu
     * @param longitude
     * @param latitude
     * @param name
     */
    public Address(int longitude, int latitude, String name) {
        mPosition = new Position(longitude, latitude);
        mName = name;
    }

    /**
     * Losowy konstruktor adresu
     */
    public Address() {
        Position position = new Position();
        while (!Map.get().availablePosition(position)) {
            position = new Position();
        }
        mPosition = position;
        Map.get().add(position);
        mName = mNames[(int) (Math.random() * (mNames.length - 1))];
    }

    /**
     * Zwraca pozycje
     * @return pozycja
     */
    public final Position getPosition() {
        return mPosition;
    }

    /**
     * Ustawia pozycje
     * @param position
     */
    public void setPosition(Position position) {
        mPosition = position;
    }

    /**
     * Zwraca nazwe miejscowosci
     * @return nazwa
     */
    public String getName() {
        return mName;
    }

    /**
     * Ustawia nazwe miejscowosci
     * @param name
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Liczy dystans do restauracji
     * @return liczba okreslajaca dystans do resutauracji
     */
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
