import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.io.Serializable;

public class controller_starting implements Serializable {
    public Button Login;
    public void login() throws IOException {        // Login to choose either user or admin
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LOGIN USER OR ADMIN.fxml"));
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }
    public void exit(){
        System.exit(0);
    }
}
