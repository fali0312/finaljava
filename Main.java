
import java.io.IOException;

import javafx.application.Application; // To connect with the javaFX application to override start function
import javafx.fxml.FXMLLoader; //   This import used to load a new fxml file into the window
import javafx.scene.Parent;
import javafx.scene.Scene;//    To set dimensions of the window
import javafx.scene.image.Image;

import javafx.stage.Stage;  // Import stage every page will create new stage


public class Main extends Application {
    public static Stage primaryStage;
    public  static DBConnect connect;

    @Override
    public void start(Stage pStage) throws IOException {
        primaryStage = pStage;
         connect = new DBConnect();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("STARTING.fxml"));    //To load the start page
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add( new Image( Main.class.getResourceAsStream( "Icon.png" ))); //Load an image for the app logo
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(event -> {
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
