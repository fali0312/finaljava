import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class controller_insertstocksukses { // Controller when you successfuly insert the stock
    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMIN MENU.fxml"));
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }
}
