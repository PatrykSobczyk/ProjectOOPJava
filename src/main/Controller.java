package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import menu.Meal;
import menu.Order;
import menu.Product;
import person.CompanyCustomer;
import person.Customer;
import person.Deliverer;
import person.RegularCustomer;

import java.io.Serializable;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 * Kontroler do glownego okna
 */
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

    /**
     * Wykonuje czynności startowe glownego okna aplikacji.
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * Obsluga klikniecia na przycisk Meal
     * @param mouseEvent
     */
    public void newMeal(MouseEvent mouseEvent) {
        Product product;
        if (new Random().nextBoolean()) {
            product = new Meal();
        } else {
            product = new Product();
        }
        Main.getRestaurantMenu().add(product);
        System.out.println(product.toString());
    }

    /**
     * Obsluga klikniecia na przycisk Customer
     * @param mouseEvent
     */
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

    /**
     * Obsluga klikniecia na przycisk Deliverer
     * @param mouseEvent
     */
    public void newDeliverer(MouseEvent mouseEvent) {
        Deliverer deliverer = new Deliverer();
        Thread thread = new Thread(deliverer);
        thread.setDaemon(true);
        thread.start();
        Main.getDeliverers().add(deliverer);
    }

    /**
     * Obsluga klikniecia na przycisk Order
     * @param mouseEvent
     */
    public void newOrder(MouseEvent mouseEvent) {
        if (Main.getCustomers().size() == 0) {
            System.out.println("Unfortunately, no customers to order.");
        } else {
            Order order = new Order();
            Main.getOrdersList().add(order);
            System.out.println(order.toString());
        }
    }

    /**
     * Obsluga klikniecia na ikone restauracji, w konsoli pokazuje zamowienia
     * @param mouseEvent
     */
    public void restaurantImageViewListener(MouseEvent mouseEvent) {
        showOrders();
    }

    /**
     * Pokazuje zamowienia w konsoli
     */
    private void showOrders() {
        if (Main.getOrdersList().size() > 0) {
            for (Order x : Main.getOrdersList()) {
                System.out.println(x.toString());
            }
        } else {
            System.out.println("No Orders");
        }
    }
}
