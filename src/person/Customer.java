package person;

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
import world.Address;
import world.Map;
import world.Position;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import static main.Main.getPaneChildren;

/**
 * Created by Patryk Sobczyk on 17/11/2016.
 */
public class Customer extends Person implements Serializable, Runnable {
    private static int mStaticID = 200;
    private int mID;
    private String mPhoneNumber;
    private Address mAddress;
    private String mEmail;
    private boolean mToDelete;
    private Stage mStage;

    public Customer() {
        super();
        mID = mStaticID++;
        mPhoneNumber = String.valueOf("609-999-" + String.valueOf((int) (Math.random() * ((999 - 100) + 1) + 100)));
        mAddress = new Address();
        mEmail = String.valueOf(getName() + "." + getSurname() + "@gmail.com");
        configPicture(getAddress().getPosition(), getID());

    }

    public Customer(String name, String surname, int ID, String phoneNumber, Address address, String email) {
        super(name, surname);
        mID = ID;
        mPhoneNumber = phoneNumber;
        mAddress = address;
        mEmail = email;
        configPicture(address.getPosition(), ID);
    }

    public Customer(String name, String surname, int ID, String phoneNumber, int longitude, int latitude, String cityName, String email) {
        this(name, surname, ID, phoneNumber, new Address(longitude, latitude, cityName), email);
    }

    public Customer(String name, String surname, int ID, String phoneNumber, Address address) {
        this(name, surname, ID, phoneNumber, address, "");
    }

    public Customer(String name, String surname, int ID, String phoneNumber, int longitude, int latitude, String cityName) {
        this(name, surname, ID, phoneNumber, new Address(longitude, latitude, cityName), "");
    }

    public boolean isToDelete() {
        return mToDelete;
    }

    public void setToDelete(boolean toDelete) {
        mToDelete = toDelete;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address address) {
        mAddress = address;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public void payToOrder(Order order) {
        order.getTotalPrice(); //Paying for orders it is very primitive. Our customers are prosperously. :)
    }

    public void configPicture(Position position, int id) {
        setPicture(new ImageView(new Image(getSmallImageURL())));
        getPicture().xProperty().set(position.getLongitude());
        getPicture().yProperty().set(position.getLatitude());
        getPicture().setId("" + id);
        getPicture().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    customerInfo(event);
                } catch (Exception e) {
                    Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
                }
                event.consume();
            }
        });
        Map.get().add(position);
        getPaneChildren().add(getPicture());


    }

    @Override
    public String toString() {
        return super.toString() + " I'm " + this.getClass().toString() +
                ", my ID - " + this.getID() +
                ", my PhoneNumber - " + this.getPhoneNumber() +
                ", my Address - " + this.getAddress() +
                ", my E-Mail - " + this.getEmail();
    }

    public void customerInfo(MouseEvent mouseEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customer.fxml"));
        Parent root = loader.load();
        CustomerController controller = loader.getController();
        Scene scene = new Scene(root);
        mStage = new Stage();
        mStage.setScene(scene);
        mStage.setTitle("Customer Info");
        mStage.show();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        controller.getImageCustomer().setImage(new Image(getBigImageURL()));
                        controller.getCustomerInfo().setItems(customerDetailsList());
                        if (mToDelete) {
                            Thread.currentThread().interrupt();
                        }
                    } catch (Exception e) {
                        Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (mToDelete) {
                                Platform.setImplicitExit(false);
                                mStage.close();
                            }

                        }
                    });
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public ObservableList<String> customerDetailsList() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Name:" + getName());
        list.add("Surname:" + getSurname());
        list.add("ID:" + String.valueOf(getID()));
        list.add("Phone Number:" + getPhoneNumber());
        list.add("Address:" + getAddress().toString());
        list.add("Email:" + getEmail());
        return list;
    }

    public String getBigImageURL() {
        return "/images/customerbig.png";
    }

    public String getSmallImageURL() {
        return "/images/customer.png";
    }

    @Override
    public void run() {
        int frequency = new Random().nextInt(55000) + 5000; // The Customer creates order <5sek;60sek>
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (!mToDelete) {
                    int whichProduct = new Random().nextInt(Main.getRestaurantMenu().size());
                    Main.getOrdersList().add(new Order(Main.getRestaurantMenu().get(whichProduct), this));
                    Thread.sleep(frequency);
                } else {
                    Thread.currentThread().interrupt();
                }
            } catch (InterruptedException e) {
                Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}


