import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class controller_usermenu {

    public void check_stock() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("CHECKSTOCKUSER.fxml"));  //load check stock for user
    Parent root = loader.load();
    Main.primaryStage.setScene(new Scene(root));
    }
    public void order_product() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PLACE ORDER.fxml")); //load place order for user
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }

    public void exit ()throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LOGIN USER OR ADMIN.fxml")); //back to login
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }
}
