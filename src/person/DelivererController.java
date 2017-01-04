package person;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Patryk Sobczyk on 31/12/2016.
 */
public class DelivererController implements Serializable, Initializable {
    @FXML
    private ImageView ImageDeliverer;

    @FXML
    private ListView<String> DelivererInfo;

    @FXML
    private Label petrolLevel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public ImageView getImageDeliverer() {
        return ImageDeliverer;
    }

    public void setImageDeliverer(ImageView imageDeliverer) {
        ImageDeliverer = imageDeliverer;
    }

    public ListView<String> getDelivererInfo() {
        return DelivererInfo;
    }

    public void setDelivererInfo(ListView delivererInfo) {
        DelivererInfo = delivererInfo;
    }

    public void returnDeliver(MouseEvent mouseEvent) {
        String pesel = getDelivererInfo().getItems().get(2).substring(6);
        for (Deliverer x : Main.getDeliverers()) {
            if (x.getPESEL().equals(pesel)) {
                x.setComingBack(true);
                break;
            }
        }
    }

    public void deleteDeliver(MouseEvent mouseEvent) {
        String pesel = getDelivererInfo().getItems().get(2).substring(6);
        System.out.print(pesel);
        for (Deliverer x : Main.getDeliverers()) {
            if (x.getPESEL().equals(pesel)) {
                x.setComingBack(true);
                x.setToDelete(true);
                break;
            }
        }
    }

    public void changePetrolLevel() {
        String pesel = getDelivererInfo().getItems().get(2).substring(6);
        System.out.print(pesel);
        for (Deliverer x : Main.getDeliverers()) {
            if (x.getPESEL().equals(pesel)) {
                petrolLevel.textProperty().bind(new SimpleIntegerProperty(x.getVehicle().getPetrolLevel()).asString());
                break;
            }
        }
    }

    public void updateInfo(MouseEvent mouseEvent) {
        String pesel = getDelivererInfo().getItems().get(2).substring(6);
        System.out.print(pesel);
        for (Deliverer x : Main.getDeliverers()) {
            if (x.getPESEL().equals(pesel)) {
                System.out.print("wyszuk");
                getDelivererInfo().setItems(x.getCustomerDetailsList());
                break;
            }
        }
    }
}