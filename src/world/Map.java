package world;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Map implements Serializable {
    public static Map sMap;
    private static List<Position> sPositionsList;

    public Map() {
        sPositionsList = new ArrayList<>();
    }

    public static Map get() {
        if (sMap == null) {
            sMap = new Map();
        }
        return sMap;
    }

    public boolean availablePosition(Position position) {
        for (Position x : sPositionsList) {
            if (x.equals(position)) {
                return false;
            }
        }
        return true;
    }

    public void add(Position position) {
        if (availablePosition(position)) {
            sPositionsList.add(position);
        }
    }

    public void remove(Position position) {
        sPositionsList.remove(position);
    }

    public int size() {
        return sPositionsList.size();
    }


}
