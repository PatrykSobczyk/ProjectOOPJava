package world;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Implementacja klasy przechowujacej wszystkie pozycje na mapie
 */
public class Map implements Serializable {
    public static Map sMap;
    private static List<Position> sPositionsList;

    /**
     * Konsktrukor
     */
    public Map() {
        sPositionsList = new ArrayList<>();
    }

    /**
     * Sprawdza czy klasa istnieje, jesli nie to ja tworzy
     *
     * @return klasa z pozycjami
     */
    public static Map get() {
        if (sMap == null) {
            sMap = new Map();
        }
        return sMap;
    }

    /**
     * Sprawdza czy dana jest dostepna
     * @param position
     * @return czy dostepna
     */
    public boolean availablePosition(Position position) {
        for (Position x : sPositionsList) {
            if (x.equals(position)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Dodaje pozycje do listy
     * @param position
     */
    public void add(Position position) {
        if (availablePosition(position)) {
            sPositionsList.add(position);
        }
    }

    /**
     * Usuwa pozycje z listy
     * @param position
     */
    public void remove(Position position) {
        sPositionsList.remove(position);
    }

    /**
     * Okresla ile ma pozycji nasza lista
     * @return rozmiar
     */
    public int size() {
        return sPositionsList.size();
    }


}
