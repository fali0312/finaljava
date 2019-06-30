import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class controller_placeordersukses {          //controller when you done place order
    public void back() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("USER MENU.fxml"));
    Parent root = loader.load();
    Main.primaryStage.setScene(new Scene(root));
    }
}
