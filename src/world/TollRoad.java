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
 * Implementacja przejazdow drogowych, do zastosowanie wielowatkowosci
 */
public class TollRoad implements Serializable {
    private static int sIndex = 500;
    private Position mPosition;
    private String mName;
    private ImageView mPicture;
    private Deliverer mUsedBy;

    /**
     * Konsktruktor losowy
     */
    public TollRoad() {
        mName = "TR" + sIndex++;
        mUsedBy = null;
        boolean ok = false;
        while (!ok) {
            Position position = new Position();
            if (Map.get().availablePosition(position)) {
                mPosition = position;
                Map.get().add(position);
                ok = true;
            }
        }
        configPicture();
    }

    /**
     * Konsktruktor ustawiajacy przejazd w danej pozycji
     *
     * @param latitude
     * @param longtitude
     */
    public TollRoad(int latitude, int longtitude) {
        mName = "TR" + sIndex++;
        mUsedBy = null;
        Position position = new Position(latitude, longtitude);
        mPosition = position;
        Map.get().add(position);
        configPicture();
    }

    /**
     * SPrawdza czy przejazd jest uzywany
     * @return czy uzywany
     */
    public boolean isUsed() {
        return mUsedBy != null;
    }

    /**
     * Zwraca przez kogo jest uzywany
     * @return przez kogo uzywany
     */
    public Deliverer getUsedBy() {
        return mUsedBy;
    }

    /**
     * Ustawia przez kogo jest obecnie uzywany
     * @param usedBy
     */
    public void setUsedBy(Deliverer usedBy) {
        mUsedBy = usedBy;
    }

    /**
     * Zwraca obrazek przejazdu
     * @return obrazek
     */
    public ImageView getPicture() {
        return mPicture;
    }

    /**
     * Ustawia obrazek
     * @param picture
     */
    public void setPicture(ImageView picture) {
        mPicture = picture;
    }

    /**
     * Zwraca pozycje w ktorej sie znajduej przejazd
     * @return
     */
    public Position getPosition() {
        return mPosition;
    }

    /**
     * Ustawia w ktorej pozycji znajduje sie przejazd
     * @param position
     */
    public void setPosition(Position position) {
        mPosition = position;
    }

    /**
     * Zwraca nazwe przejazdu
     * @return
     */
    public String getName() {
        return mName;
    }

    /**
     * Ustawia nazwe przejazdu
     * @param name
     */
    public void setName(String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return "TollRoad Name - " + this.getName() +
                ", " + this.getPosition();
    }

    /**
     * Konfiguruje obrazek w glownym oknie aplikacji
     */
    public void configPicture() {
        setPicture(new ImageView(new Image(getSmallImageURL())));
        getPicture().xProperty().set(getPosition().getLongitude());
        getPicture().yProperty().set(getPosition().getLatitude());
        getPicture().setId(getName());
        getPaneChildren().add(getPicture());
    }

    /**
     * Zwraca adres do malego obrazka
     * @return maly obrazek
     */
    public String getSmallImageURL() {
        return "/images/stop.png";
    }

    /**
     * Funkcja umozliwajaca watkowi probe uzycia tego przejazdu
     * @param deliverer
     */
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

    /**
     * Funcja zwalniajaca przejazd
     * @param deliverer
     */
    public void releaseThisTollRoad(Deliverer deliverer) {
        synchronized (this) {
            this.mUsedBy = null;
        }

    }
}
