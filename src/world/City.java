package world;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class City  {
    private Position mLocation;
    private String mName;

    public Position getLocation() {
        return mLocation;
    }

    public void setLocation(Position location) {
        mLocation = location;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
