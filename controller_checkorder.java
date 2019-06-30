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

public class controller_checkorder {

    public TableView<customer_order> viewTable;                 //call the table in the database to show up
    public TableColumn<customer_order, String> idColumn;
    public TableColumn<customer_order, String> customerColumn;
    public TableColumn<customer_order, String> brandColumn;
    public TableColumn<customer_order, String> productColumn;
    public TableColumn<customer_order, String> colourColumn;

    ObservableList<customer_order> history = FXCollections.observableArrayList();


    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMIN MENU.fxml"));
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }
    public void initialize() throws Exception {
        String query = "SELECT * FROM customer_order";  // took from the database customer_order
        Connection conn = Main.connect.con;
        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);

        // iterate through the java resultset
        while (rs.next()) {
            String ID = rs.getString("ID");
            String Customer = rs.getString("Customer");
            String Brand = rs.getString("Brand");
            String Product = rs.getString("Product");
            String Colour = rs.getString("Colour");

            System.out.println(ID);                             //print all the data
            System.out.println(Customer);
            System.out.println(Brand);
            System.out.println(Product);
            System.out.println(Colour);
            history.add(new customer_order(ID,Customer,Brand,Product,Colour));
        }
        idColumn.setCellValueFactory(new PropertyValueFactory<customer_order, String>("ID"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<customer_order, String>("Customer"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<customer_order, String>("Brand"));
        productColumn.setCellValueFactory(new PropertyValueFactory<customer_order, String>("Product"));
        colourColumn.setCellValueFactory(new PropertyValueFactory<customer_order, String>("Colour"));

        // load dummy data
        viewTable.setItems(history);

    }
}
