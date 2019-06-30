import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.sql.Statement;

public class controller_checkstockuser {
    //configure the table
    public TableView<motorcycle> viewTable;
    public TableColumn<motorcycle, String> idColumn;    // call all the table from the database to show up
    public TableColumn<motorcycle, String> brandColumn;
    public TableColumn<motorcycle, String> productColumn;
    public TableColumn<motorcycle, String> colourColumn;

    ObservableList<motorcycle> history = FXCollections.observableArrayList();

    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("USER MENU.fxml"));
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }

    public void initialize() throws Exception {
        String query = "SELECT * FROM motorcycle";
        Connection conn = Main.connect.con;
        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);

        // iterate through the java resultset
        while (rs.next()) {
            String ID = rs.getString("ID");
            String Brand = rs.getString("Brand");
            String Product = rs.getString("Product");
            String Colour = rs.getString("Colour");

            System.out.println(ID);
            System.out.println(Brand);
            System.out.println(Product);
            System.out.println(Colour);
            history.add(new motorcycle(ID,Brand, Product, Colour));
        }

        // giving fx:id
        idColumn.setCellValueFactory(new PropertyValueFactory<motorcycle, String>("ID"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<motorcycle, String>("Brand"));
        productColumn.setCellValueFactory(new PropertyValueFactory<motorcycle, String>("Product"));
        colourColumn.setCellValueFactory(new PropertyValueFactory<motorcycle, String>("Colour"));

        // load dummy data
        viewTable.setItems(history);

    }
}
