package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import menu.Meal;
import menu.Order;
import person.CompanyCustomer;
import person.Customer;
import person.Deliverer;
import person.RegularCustomer;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Serializable, Initializable {
    @FXML
    private ImageView RestaurantImageView;

    @FXML
    private Button MealButton;

    @FXML
    private Button ClientButton;

    @FXML
    private Button DelivererButton;

    @FXML
    private AnchorPane MapsPane;


    public AnchorPane getMapsPane() {
        return MapsPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void newMeal(MouseEvent mouseEvent) {
        Meal meal = new Meal();
        Main.getRestaurantMenu().add(meal);
        System.out.println(meal.toString());
    }

    public void newCustomer(MouseEvent mouseEvent) {
        int random = (int) (Math.random() * ((3 - 1) + 1) + 1);
        Customer customer;
        switch (random) {
            case 1:
                customer = new RegularCustomer();
                break;
            case 2:
                customer = new CompanyCustomer();
                break;
            default:
                customer = new Customer();
                break;
        }
        Thread thread = new Thread(customer);
        thread.setDaemon(true);
        thread.start();
        Main.getCustomers().add(customer);
        System.out.println(customer.toString());
    }

    public void newDeliverer(MouseEvent mouseEvent) {
        Deliverer deliverer = new Deliverer();
        Thread thread = new Thread(deliverer);
        thread.setDaemon(true);
        thread.start();
        Main.getDeliverers().add(deliverer);
    }

    public void newOrder(MouseEvent mouseEvent) {
        if (Main.getCustomers().size() == 0) {
            System.out.println("Unfortunately, no customers to order.");
        } else {
            Order order = new Order();
            Main.getOrdersList().add(order);
            System.out.println(order.toString());
        }
    }

    public void restaurantImageViewListener(MouseEvent mouseEvent) {
        showOrders();
    }

    private void showOrders() {
        for (Order x : Main.getOrdersList()) {
            System.out.println(x.toString());
        }
    }
}
