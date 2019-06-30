import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class controler_adminmenu {
    public void check_stock() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CHECKSTOCKADMIN.fxml")); //load next page
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }
    public void insert_stock() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("INSERTSTOCK.fxml")); //load the insert stock page
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }
    public void check_order() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CUSTOMERORDER.fxml")); //load the check order page
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }
    public void back()throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LOGIN USER OR ADMIN.fxml")); //back
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }
}
