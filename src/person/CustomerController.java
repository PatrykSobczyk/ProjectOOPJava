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
 * Implementacja kontrolera dla okna informacji o kliencie
 */
public class CustomerController implements Serializable, Initializable {
    @FXML
    private ImageView ImageCustomer;

    @FXML
    private ListView<String> CustomerInfo;

    /**
     * Inicjalizuje kontroler
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Zwraca obraz klienta
     * @return zwraca obraz klienta
     */
    public ImageView getImageCustomer() {
        return ImageCustomer;
    }

    /**
     * Ustawia obraz klienta
     * @param imageCustomer
     */
    public void setImageCustomer(ImageView imageCustomer) {
        ImageCustomer = imageCustomer;
    }

    /**
     * Zwraca informacje o kliencie
     * @return lista z textview informacji o kliencie
     */
    public ListView<String> getCustomerInfo() {
        return CustomerInfo;
    }

    /**
     * Ustawia informacje o kliencie
     * @param customerInfo
     */
    public void setCustomerInfo(ListView customerInfo) {
        CustomerInfo = customerInfo;
    }

    /**
     * Usuwa klienta
     * @param mouseEvent
     * @return czy operacja sie powiodla
     */
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
