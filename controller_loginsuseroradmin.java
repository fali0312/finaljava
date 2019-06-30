import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


import java.io.IOException;


public class controller_loginsuseroradmin {     // Choosing whether go to admin or user
    public void login_user() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("USER MENU.fxml")); //load user menu
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }
    public void login_admin() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMIN MENU.fxml")); //load admin menu
        Parent root = loader.load();
//            primaryStage.setTitle("EzBimay v" + version);
        Main.primaryStage.setScene(new Scene(root));
    }
    public void exit(){
        System.exit(0);
    }
}

