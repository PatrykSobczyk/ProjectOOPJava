package main;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ObservableList<Screen> screenList = Screen.getScreens();
        System.out.println("Screens Count: "+screenList.size());
        for(Screen screen : screenList){
            print(screen);
        }
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    public void print(Screen s){
        System.out.println("DPI: "+s.getDpi());
        System.out.print("System Bounds:");
        Rectangle2D bounds = s.getBounds();
        print(bounds);

        System.out.print("Screen Visual Bounds: ");
        Rectangle2D visualBounds = s.getVisualBounds();
        print(visualBounds);
        System.out.print("--");
    }
    public void print(Rectangle2D r){
        System.out.format("minX=%.2f, minY=%.2f, width=%.2f, height=%.2f%n",
                r.getMinX(), r.getMinY(), r.getWidth(), r.getHeight());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
