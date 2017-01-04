package person;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import world.Map;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Patryk Sobczyk on 31/12/2016.
 */
public class CustomerController implements Serializable, Initializable {
    @FXML
    private ImageView ImageCustomer;

    @FXML
    private ListView<String> CustomerInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public ImageView getImageCustomer() {
        return ImageCustomer;
    }

    public void setImageCustomer(ImageView imageCustomer) {
        ImageCustomer = imageCustomer;
    }

    public ListView<String> getCustomerInfo() {
        return CustomerInfo;
    }

    public void setCustomerInfo(ListView customerInfo) {
        CustomerInfo = customerInfo;
    }


    public boolean removeClients(MouseEvent mouseEvent) {
        String idAll = getCustomerInfo().getItems().get(2);
        int id = Integer.valueOf(idAll.substring(3, idAll.length()));
        for (Customer x : Main.getCustomers()) {
            if (x.getID() == id) {
                Map.get().remove(x.getAddress().getPosition());
                Main.getPaneChildren().remove(x.getPicture());
                Main.getCustomers().remove(x);
                x.setToDelete(true);
                return true;
            }
        }
        return false;
    }


}
