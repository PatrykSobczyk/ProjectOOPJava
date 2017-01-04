package world;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import person.Deliverer;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static main.Main.getPaneChildren;

/**
 * Created by Patryk Sobczyk on 27/12/2016.
 */
public class TollRoad implements Serializable {
    private static int sIndex = 500;
    private Position mPosition;
    private String mName;
    private ImageView mPicture;
    private Deliverer mUsedBy;

    public TollRoad() {
        mName = "TR" + sIndex++;
        mUsedBy = null;
        Position position = new Position();
        mPosition = position;
        Map.get().add(position);
        configPicture();
    }

    public TollRoad(int latitude, int longtitude) {
        mName = "TR" + sIndex++;
        mUsedBy = null;
        Position position = new Position(latitude, longtitude);
        mPosition = position;
        Map.get().add(position);
        configPicture();
    }

    public boolean isUsed() {
        return mUsedBy != null;
    }

    public Deliverer getUsedBy() {
        return mUsedBy;
    }

    public void setUsedBy(Deliverer usedBy) {
        mUsedBy = usedBy;
    }

    public ImageView getPicture() {
        return mPicture;
    }

    public void setPicture(ImageView picture) {
        mPicture = picture;
    }

    public Position getPosition() {
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

    @Override
    public String toString() {
        return "TollRoad Name - " + this.getName() +
                ", " + this.getPosition();
    }

    public void configPicture() {
        setPicture(new ImageView(new Image(getSmallImageURL())));
        getPicture().xProperty().set(getPosition().getLongitude());
        getPicture().yProperty().set(getPosition().getLatitude());
        getPicture().setId(getName());
        getPaneChildren().add(getPicture());
    }


    public String getSmallImageURL() {
        return "/images/stop.png";
    }

    public void tryUseThisTollRoad(Deliverer deliverer) {

        while (!deliverer.equals(getUsedBy())) {
            if (!deliverer.isWorking()) {
                return;
            }
            synchronized (this) {
                if (getUsedBy() == null) {
                    setUsedBy(deliverer);
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TollRoad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TollRoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void releaseThisTollRoad(Deliverer deliverer) {
        synchronized (this) {
            this.mUsedBy = null;
        }

    }
}
