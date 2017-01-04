package person;

import com.sun.istack.internal.Nullable;
import enums.DrivingLicence;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Main;
import menu.Order;
import vehicles.Car;
import vehicles.Scooter;
import vehicles.Vehicle;
import work.WorkSchedule;
import world.Position;
import world.TollRoad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static main.Main.getPaneChildren;
import static main.Main.getTollRoad;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Deliverer extends Person implements Serializable, Runnable {
    private String mPESEL;
    private WorkSchedule mWorkSchedule;
    private DrivingLicence mDrivingLicence;
    private Position mPosition;
    private int mDistance;
    @Nullable
    private Vehicle mVehicle;
    private boolean mWorking;
    private List<Order> mOrders = new ArrayList<>();
    private Position mCurrentTarget;
    private boolean mComingBack;
    private boolean mToDelete;
    private DelivererController mDelivererController;
    private Stage mStage;

    /**
     * Konstruktor dostawcy
     *
     * @param name
     * @param surname
     * @param PESEL
     * @param workSchedule
     * @param drivingLicence
     * @param vehicle
     */
    public Deliverer(String name, String surname, String PESEL, WorkSchedule workSchedule, DrivingLicence drivingLicence, Vehicle vehicle) {
        super(name, surname);
        mPESEL = PESEL;
        mWorkSchedule = workSchedule;
        mDrivingLicence = drivingLicence;
        mVehicle = vehicle;
        mPosition = Main.getRestorationAddress().getPosition();
        configPicture();
    }

    /**
     * Konstruktor dostawcy
     * @param name
     * @param surname
     * @param PESEL
     * @param workSchedule
     * @param drivingLicence
     */
    public Deliverer(String name, String surname, String PESEL, WorkSchedule workSchedule, DrivingLicence drivingLicence) {
        this(name, surname, PESEL, workSchedule, drivingLicence, null);
    }

    /**
     * Konstruktor losowy dostawcy
     */
    public Deliverer() {
        super();
        mPESEL = String.valueOf(String.valueOf((int) (Math.random() * ((99 - 10) + 1) + 10)) + String.valueOf((int) (Math.random() * ((12 - 1) + 1) + 1)) +
                String.valueOf((int) (Math.random() * ((31 - 1) + 1) + 1)) + "94021");
        mWorkSchedule = new WorkSchedule();
        if ((int) (Math.random() * ((2 - 1) + 1) + 1) == 1) {
            mDrivingLicence = DrivingLicence.CAR;
            Car car = new Car();
            mVehicle = car;
            Main.getVehicles().add(car);
        } else {
            mDrivingLicence = DrivingLicence.SCOOTER;
            Scooter scooter = new Scooter();
            mVehicle = scooter;
            Main.getVehicles().add(scooter);
        }
        mPosition = new Position(Main.getRestorationAddress().getPosition());
        configPicture();

    }

    /**
     * Zwraca czy dostawca jest do usunecia
     * @return czy do usunecia
     */
    public boolean isToDelete() {
        return mToDelete;
    }

    /**
     * Ustawia do usunecia
     * @param toDelete
     */
    public void setToDelete(boolean toDelete) {
        mToDelete = toDelete;
    }

    /**
     * Zwraca czy dostawca wraca do restauracji
     * @return czy wraca do restauracji
     */
    public boolean isComingBack() {
        return mComingBack;
    }

    /**
     * UStawia czy ma wracac do restauracji
     * @param comingBack
     */
    public void setComingBack(boolean comingBack) {
        mComingBack = comingBack;
    }

    /**
     * Zwraca czy pracuje
     * @return czy pracuje
     */
    public boolean isWorking() {
        return mWorking;
    }

    /**
     * Ustawia aby pracowal
     * @param working
     */
    public void setWorking(boolean working) {
        mWorking = working;
    }

    /**
     * Zwraca pesel
     * @return pesel
     */
    public String getPESEL() {
        return mPESEL;
    }

    /**
     * Ustawia pesel
     * @param PESEL
     */
    public void setPESEL(String PESEL) {
        mPESEL = PESEL;
    }

    /**
     * Zwraca grafik pracy
     * @return
     */
    public WorkSchedule getWorkSchedule() {
        return mWorkSchedule;
    }

    /**
     * UStawia grafik pracy
     * @param workSchedule
     */
    public void setWorkSchedule(WorkSchedule workSchedule) {
        mWorkSchedule = workSchedule;
    }

    /**
     * Zwraca pojazd
     * @return pojazd
     */
    public Vehicle getVehicle() {
        return mVehicle;
    }

    /**
     * Ustawia pojazd
     * @param vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        mVehicle = vehicle;
    }

    /**
     * Zwraca pozycje
     * @return pozycja
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

    /**
     * Dodaje pojazd zgodny z licencja
     * @param vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        System.out.println(vehicle);
        this.setPosition(Main.getRestorationAddress().getPosition());
        switch (mDrivingLicence) {
            case CAR:
                if (vehicle instanceof Car) {
                    mVehicle = vehicle;
                } else {
                    System.out.println("Unfortunately, you don't have licence to drive this vehicle");
                }
                break;
            case SCOOTER:
                if (vehicle instanceof Scooter) {
                    mVehicle = vehicle;
                } else {
                    System.out.println("Unfortunately, you don't have licence to drive this vehicle");
                }
                break;
            default:
                break;
        }
    }

    /**
     * Zwraca czy dostawca ma przypisany pojazd
     * @return czy ma pojazd
     */
    public boolean hasVehicle() {
        return mVehicle != null;
    }

    /**
     * Zwraca licencje prawajazda
     * @return enum z licencja
     */
    public DrivingLicence getDrivingLicence() {
        return mDrivingLicence;
    }

    /**
     * Ustawia licencje prawa jazdy
     * @param drivingLicence
     */
    public void setDrivingLicence(DrivingLicence drivingLicence) {
        mDrivingLicence = drivingLicence;
    }

    @Override
    public String toString() {
        return super.toString() + " My PESEL - " + this.getPESEL() +
                ", my Work Schedule - " + this.getWorkSchedule() +
                ", my Vehicle - " + this.getVehicle() +
                ", my Driving Licence - " + this.getDrivingLicence();
    }

    /**
     * Metoda odpowiedzialna za utworzenie okna szczegolowego o dostawcy
     * @param mouseEvent
     * @throws Exception
     */
    public void delivererInfo(MouseEvent mouseEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("deliverer.fxml"));
        Parent root = loader.load();
        mDelivererController = loader.getController();
        Scene scene = new Scene(root);
        mStage = new Stage();
        mStage.setScene(scene);
        mStage.setTitle("Deliverer Info");
        mStage.show();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mDelivererController.getDelivererInfo().setItems(getCustomerDetailsList());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Zwraca liste szczegolow dla dostawcy
     * @return obserwowana lista szczegolow
     */
    public ObservableList<String> getCustomerDetailsList() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Name:" + getName());
        list.add("Surname:" + getSurname());
        list.add("PESEL:" + getPESEL());
        list.add("Work Schedule:" + getWorkSchedule().toString());
        list.add("Driving Licence:" + getDrivingLicence().toString());
        list.add("Vehicle:" + getVehicle().toString());
        String orders;
        if (getOrders().size() == 0) {
            orders = "No order";
        } else {
            orders = getOrders().get(0).toString();
        }
        list.add("Current order:" + orders
        );
        return list;
    }

    /**
     * Konfiguruje obrazek dostawcy
     */
    public void configPicture() {
        setPicture(new ImageView(new Image(getSmallImageURL())));
        mPosition = getPosition();
        getPicture().xProperty().set(Main.getRestorationAddress().getPosition().getLongitude());
        getPicture().yProperty().set(Main.getRestorationAddress().getPosition().getLatitude());
        getPicture().setId(getPESEL());
        getPicture().setVisible(false);
        getPicture().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    delivererInfo(event);
                } catch (Exception e) {
                    Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
                }
                event.consume();
            }
        });
        getPaneChildren().add(getPicture());
    }

    /**
     * Zwraca dystans do celu
     * @return dystans
     */
    public int getDistance() {
        return mDistance;
    }

    /**
     * Ustawia dystans
     * @param distance
     */
    public void setDistance(int distance) {
        mDistance = distance;
    }

    /**
     * Zwraca zamowienia ktore obsluguje dostawca
     * @return lista zamowien
     */
    public List<Order> getOrders() {
        return mOrders;
    }

    /**
     * Ustawia zamowienia
     * @param orders
     */
    public void setOrders(List<Order> orders) {
        mOrders = orders;
    }

    /**
     * Zwraca obecny cel
     * @return pozycja obecnego celu
     */
    public Position getCurrentTarget() {
        return mCurrentTarget;
    }

    /**
     * UStawia obecny cel
     * @param currentTarget
     */
    public void setCurrentTarget(Position currentTarget) {
        mCurrentTarget = currentTarget;
    }

    /**
     * Kontroler dla doreczyciela
     * @return klasa kontrolera
     */
    public DelivererController getDelivererController() {
        return mDelivererController;
    }

    /**
     * Ustawia klase kontrolera
     * @param delivererController
     */
    public void setDelivererController(DelivererController delivererController) {
        mDelivererController = delivererController;
    }

    /**
     * Stage na ktorej jest wyswietlona informacja o doreczycielu
     * @return stage
     */
    public Stage getStage() {
        return mStage;
    }

    /**
     * Ustawia stage
     * @param stage
     */
    public void setStage(Stage stage) {
        mStage = stage;
    }

    /**
     * Zwraca adres do malego obrazka
     * @return adres do malego obraka
     */
    public String getSmallImageURL() {
        return "/images/bus.png";
    }

    /**
     * Implementue prace dostawcy. Sprawdza czy zakonczyl prace, czy zostal usunety czy sa zamowienia do rozwiezienia.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (hasVehicle()) {
                if (!isWorking()) {
                    mOrders.addAll(Main.getOrdersList());
                    Main.getOrdersList().removeAll(mOrders);
                    System.out.println("I have orders:" + mOrders.size());
                }
                if (mOrders.size() > 0 && !isToDelete()) {
                    startDelivery();
                    drawDelivererMotion();
                }
                if (isComingBack() && isWorking()) {
                    comeBack();
                }
                if (isToDelete()) {
                    Thread.currentThread().interrupt();

                }
                if (!isWorking() && !isComingBack() && !isToDelete()) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {

                    }
                }
            } else {
                System.out.println("Delvierer hasn't a vehicle.");
            }
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Platform.setImplicitExit(false);
                mStage.close();
            }
        });


    }

    /**
     * Funkcje umozliwiajaca powrot do restauracji
     */
    private void comeBack() {
        mCurrentTarget = new Position(Main.getRestorationAddress().getPosition());
        mDistance = mCurrentTarget.getDistance(getPosition());
        while (this.mDistance > 10) {
            try {
                this.motionAndPetrol();
            } catch (InterruptedException ex) {
                Logger.getLogger(Deliverer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.mDistance <= 10) {
            getPicture().setVisible(false);
            getPicture().setX(mCurrentTarget.getLongitude());
            getPicture().setY(mCurrentTarget.getLatitude());
            mPosition = mCurrentTarget;
            getVehicle().refuel();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (mDelivererController != null) {
                        mDelivererController.changePetrolLevel();
                    }
                }
            });
            this.mWorking = false;
            this.mComingBack = false;
            if (mOrders.size() > 0) {
                Main.getOrdersList().addAll(mOrders);
            }
        }

    }

    /**
     * Funkcje rozpoczynajaca rozwozenie zamowienia
     */
    private void startDelivery() {
        this.mWorking = true;
        mCurrentTarget = mOrders.get(0).getCustomer().getAddress().getPosition();
        mDistance = mCurrentTarget.getDistance(this.getPosition());
        if (mDistance > 20) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    getPosition().setLongitude(getPosition().getLongitude());
                    getPosition().setLatitude(getPosition().getLatitude());
                    getPicture().setX(getPosition().getLongitude());
                    getPicture().setY(getPosition().getLatitude());
                    getPicture().setVisible(true);
                    mDistance = mCurrentTarget.getDistance(getPosition());
                }
            });

        }
    }

    /**
     * Funkcja odslugujaca rysowanie pracy doreczyciela
     */
    private void drawDelivererMotion() {
        while (this.mDistance > 10 && !this.isComingBack()) {
            try {
                this.motionAndPetrol();
            } catch (InterruptedException ex) {
                Logger.getLogger(Deliverer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.mDistance <= 10) {
            delivered();
        }
    }

    /**
     * Funkcja obslugujaca zamowienia gdy zostalo zakonczone jedno z nich
     */
    private void delivered() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        mOrders.remove(0);
        if (mOrders.size() > 0) {
            mCurrentTarget = mOrders.get(0).getCustomer().getAddress().getPosition();
            mDistance = mCurrentTarget.getDistance(getPosition());
        } else {
            mComingBack = true;
        }
    }

    /**
     * Funkcja rysujaca zamowienie zgodnie z lokalizacjia, a takze zmieniajaca wartosc paliwa
     *
     * @throws InterruptedException
     */
    private void motionAndPetrol() throws InterruptedException {
        Position position = mCurrentTarget;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (mDelivererController != null) {
                    mDelivererController.changePetrolLevel();
                }
            }
        });

        if (position.getLatitude() != getPosition().getLatitude()) {
            if (position.getLatitude() > getPosition().getLatitude()) {
                Position next = new Position(mPosition.getLongitude(), mPosition.getLatitude() + 10);
                if (checkIfTollRoad(next)) {
                    TollRoad x = getTollRoad(next);
                    x.tryUseThisTollRoad(this);
                    x.releaseThisTollRoad(this);

                }
                getPicture().setY(next.getLatitude());
                getPosition().changeLatitude(10);
            } else {
                Position next = new Position(mPosition.getLongitude(), mPosition.getLatitude() - 10);
                if (checkIfTollRoad(next)) {
                    TollRoad x = getTollRoad(next);
                    x.tryUseThisTollRoad(this);
                    x.releaseThisTollRoad(this);
                }

                getPicture().setY(next.getLatitude());
                getPosition().changeLatitude(-10);
            }
        } else {
            if ((position.getLongitude() != getPosition().getLongitude())) {
                if (position.getLongitude() > getPosition().getLongitude()) {
                    Position next = new Position(mPosition.getLongitude() + 10, mPosition.getLatitude());
                    if (checkIfTollRoad(next)) {
                        TollRoad x = getTollRoad(next);
                        x.tryUseThisTollRoad(this);
                        x.releaseThisTollRoad(this);
                    }
                    getPicture().setX(next.getLongitude());
                    getPosition().changeLongitude(10);
                } else {
                    Position next = new Position(mPosition.getLongitude() - 10, mPosition.getLatitude());
                    if (checkIfTollRoad(next)) {
                        TollRoad x = getTollRoad(next);
                        x.tryUseThisTollRoad(this);
                        x.releaseThisTollRoad(this);

                    }
                    getPicture().setX(next.getLongitude());
                    getPosition().changeLongitude(-10);
                }
            }
        }
        mDistance = mCurrentTarget.getDistance(getPosition());
        getVehicle().changePetrolLevel(-1);
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(Deliverer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sprawdza czy na danym polu wystepuje przejazd drogowy
     * @param position
     * @return
     */
    public boolean checkIfTollRoad(Position position) {
        for (TollRoad x : Main.getTollRoads()) {
            if (x.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }


}
