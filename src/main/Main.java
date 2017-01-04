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

public class Main extends Application implements Serializable {
    private final static Address sRestorationAddress = new Address(500, 500, "Centrum Jedzenia");
    private static List<Product> sRestaurantMenu;
    private static List<Customer> sCustomers;
    private static List<TollRoad> sTollRoads;
    private static List<Order> sOrdersList;
    private static List<Vehicle> sVehicles;
    private static List<Deliverer> sDeliverers;
    private static ObservableList<Node> mPaneChildren;


    public static List<Product> getRestaurantMenu() {
        return sRestaurantMenu;
    }

    public static List<Customer> getCustomers() {
        return sCustomers;
    }

    public static List<TollRoad> getTollRoads() {
        return sTollRoads;
    }

    synchronized public static List<Order> getOrdersList() {
        return sOrdersList;
    }

    public static List<Vehicle> getVehicles() {
        return sVehicles;
    }

    public static Address getRestorationAddress() {
        return sRestorationAddress;
    }

    public static List<Deliverer> getDeliverers() {
        return sDeliverers;
    }

    public static ObservableList<Node> getPaneChildren() {
        return mPaneChildren;
    }

    public static TollRoad getTollRoad(Position position) {
        for (TollRoad x : getTollRoads()) {
            if (x.getPosition().equals(position)) {
                return x;

            }
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }

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

    private void initializeCollections() {
        sRestaurantMenu = new ArrayList<>();
        sCustomers = new ArrayList<>();
        sOrdersList = new ArrayList<>();
        sVehicles = new ArrayList<>();
        sDeliverers = new ArrayList<>();
        sTollRoads = new ArrayList<>();

    }

    private void addTollRoads() {
        for (int i = 0; i < 30; i++) {
            getTollRoads().add(new TollRoad());
        }
    }

}
