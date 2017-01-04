package main;

import enums.Category;
import enums.Day;
import enums.DrivingLicence;
import enums.Size;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import menu.DinnerSet;
import menu.Meal;
import menu.Order;
import menu.Product;
import person.Customer;
import person.Deliverer;
import vehicles.Car;
import vehicles.Scooter;
import vehicles.Vehicle;
import work.DayAtWork;
import work.WorkSchedule;
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
        addMealsToMenu();
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

    private void addDeliverers() {
        getDeliverers().add(new Deliverer("Adam", "Busik", "90021501010", new WorkSchedule(new DayAtWork(Day.MONDAY, 10)), DrivingLicence.CAR, getVehicles().get(0)));
        getDeliverers().get(0).getWorkSchedule().getDaysAtWorks().add(new DayAtWork(Day.FRIDAY, 8));
        getDeliverers().get(0).addVehicle(getVehicles().get(0));
        getDeliverers().add(new Deliverer());
    }

    private void addVehicles() {
        getVehicles().add(new Car(1000, 120, "PO 94334", 5000, getRestorationAddress().getPosition(), 2));
        getVehicles().add(new Scooter(60, 50, "PZ 99703", 2000, getRestorationAddress().getPosition(), true));
        getVehicles().add(new Car(1500, 140, "PO 990000", 10000, getRestorationAddress().getPosition(), 5));
        getVehicles().add(new Car());
        getVehicles().add(new Scooter());
    }

    private void addOrders() {
        getOrdersList().add(new Order(getRestaurantMenu().get(1), getCustomers().get(1)));
        Order order1 = new Order(getRestaurantMenu().get(3), getCustomers().get(2));
        order1.addMealToOrder(getRestaurantMenu().get(4));
        order1.addMealToOrder(getRestaurantMenu().get(4));
        order1.addMealToOrder(getRestaurantMenu().get(3));
        DinnerSet dinnerSet = new DinnerSet("Kebab z cola", getRestaurantMenu().get(6), getRestaurantMenu().get(3));
        order1.addDinnerSetToOrder(dinnerSet);
        getOrdersList().add(new Order());

    }

    private void addMealsToMenu() {
        getRestaurantMenu().add(new Meal("Pizza Hawajska", 10.0, Category.PIZZA, "Ananas"));
        getRestaurantMenu().add(new Meal("Pizza Kebab", 12.0, Category.PIZZA, Size.MEDIUM, "Kurczak"));
        getRestaurantMenu().add(new Meal("Spagetti Carbonara", 10.0, Category.PASTA, Size.STANDARD, "Smietana"));
        getRestaurantMenu().add(new Meal("Kebab w bulce", 16.0, Category.FASTFOOD, Size.XBIG, "Kurczak"));
        getRestaurantMenu().add(new Meal("Zupa rybna", 8.0, Category.SOUP, Size.STANDARD, "Okon"));
        getRestaurantMenu().add(new Meal("Nalesniki z nutella", 10.0, Category.OMLETTES, "Czekolada"));
        getRestaurantMenu().add(new Meal("Cola", 5.0, Category.DRINK, Size.XBIG, "Cukier"));
        for (int i = 0; i < 15; i++) {
            getRestaurantMenu().add(new Meal());
        }

    }

    private void addClients() {
        getCustomers().add(new Customer("Adam", "Bak", 196, "722-000-555", 100, 500, "Witkowo", "pp@gmail.com"));
        //getCustomers().add(new Customer("Zygmunt", "Zwyklyzjadacz", 197,"723-000-555",500,100,"Puszczykowko","ppp@gmail.com"));
        //getCustomers().add(new RegularCustomer());
        //getCustomers().add(new CompanyCustomer());

    }
}
