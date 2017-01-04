package main;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import menu.Order;
import menu.Product;
import person.Customer;
import person.Deliverer;
import vehicles.Vehicle;
import world.Address;
import world.Map;
import world.Position;
import world.TollRoad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Glowne serce aplikacji
 */
public class Main extends Application implements Serializable {
    private final static Address sRestorationAddress = new Address(500, 500, "Centrum Jedzenia");
    private static List<Product> sRestaurantMenu;
    private static List<Customer> sCustomers;
    private static List<TollRoad> sTollRoads;
    private static List<Order> sOrdersList;
    private static List<Vehicle> sVehicles;
    private static List<Deliverer> sDeliverers;
    private static ObservableList<Node> mPaneChildren;

    /**
     * Zwraca menu restauracji
     *
     * @return lista produktow i pokarmow
     */
    public static List<Product> getRestaurantMenu() {
        return sRestaurantMenu;
    }

    /**
     * Zwraca obecnych klientow
     * @return lista klientow
     */
    public static List<Customer> getCustomers() {
        return sCustomers;
    }

    /**
     * Zwraca przejazdy drogowe do implementacji monitorow
     * @return lista przejazdow
     */
    public static List<TollRoad> getTollRoads() {
        return sTollRoads;
    }

    /**
     * Zwraca zamowienia niedostarczone
     * @return lista zamowien
     */
    synchronized public static List<Order> getOrdersList() {
        return sOrdersList;
    }

    /**
     * Zwraca pojazdy
     * @return liste pojazdow
     */

    public static List<Vehicle> getVehicles() {
        return sVehicles;
    }

    /**
     * Zwraca adres restauracji
     * @return adres restauracji
     */
    public static Address getRestorationAddress() {
        return sRestorationAddress;
    }

    /**
     * Zwraca liste doreczycieli
     * @return lista doreczycieli
     */
    public static List<Deliverer> getDeliverers() {
        return sDeliverers;
    }

    /**
     * Zwraca dzieci interfejsu glownego okna
     * @return obserwowana lista dzieci glownego okna
     */
    public static ObservableList<Node> getPaneChildren() {
        return mPaneChildren;
    }

    /**
     * Zwraca przejazd drogowy na danej pozycji
     * @param position
     * @return przejazd drogowy
     */
    public static TollRoad getTollRoad(Position position) {
        for (TollRoad x : getTollRoads()) {
            if (x.getPosition().equals(position)) {
                return x;

            }
        }
        return null;
    }

    /**
     * Glowna funkcja programu
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Metoda rozpoczynajaca dzialanie programu oraz laczaca nasze klasy z plikiem fxml
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mPaneChildren = ((Pane) root.getChildrenUnmodifiable().get(0)).getChildren();
        initializeCollections();
        Map.get().add(new Position(500, 500)); // Position restaurant.
        addTollRoads();
        primaryStage.setTitle("Restaurant");
        primaryStage.setScene(new Scene(root, 1200, 1000));
        primaryStage.show();
    }

    /**
     * Zainicjalizowanie kolekcji
     */
    private void initializeCollections() {
        sRestaurantMenu = new ArrayList<>();
        sCustomers = new ArrayList<>();
        sOrdersList = new ArrayList<>();
        sVehicles = new ArrayList<>();
        sDeliverers = new ArrayList<>();
        sTollRoads = new ArrayList<>();

    }

    /**
     * Funkcja dodajaca przejazdy drogowe.
     */
    private void addTollRoads() {
        for (int i = 0; i < 30; i++) {
            getTollRoads().add(new TollRoad());
        }
    }

}
