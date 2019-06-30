import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class controller_placeorder {
    public TableView<motorcycle> viewTable;
    public TableColumn<motorcycle, String> idColumn;
    public TableColumn<motorcycle, String> brandColumn;
    public TableColumn<motorcycle, String> productColumn;
    public TableColumn<motorcycle, String> colourColumn;
    public TextField brand,product,colour,name;

    ObservableList<motorcycle> history = FXCollections.observableArrayList();

    public void back() throws IOException {     // function to go back to the MENU
    FXMLLoader loader = new FXMLLoader(getClass().getResource("USER MENU.fxml"));
    Parent root = loader.load();
    Main.primaryStage.setScene(new Scene(root));
    }
    public void finish() throws IOException {       // function to finish the orders and insert the data to database
            String sql = String.format("insert into customer_order(Customer,Brand,Product,Colour) VALUES('%s', '%s' ,'%s','%s')"  , name.getText() ,brand.getText(),product.getText(),colour.getText());
            System.out.println(sql);
            try {Connection conn = Main.connect.con;
                // create the java statement
                Statement st = conn.createStatement();
                st.executeUpdate(sql);
                System.out.println("Data Inserted");
            }
            catch (Exception e){
                System.out.println(e);
            }


        FXMLLoader loader = new FXMLLoader(getClass().getResource("ORDER SUKSES.fxml"));    // load the next page
        Parent root = loader.load();
        Main.primaryStage.setScene(new Scene(root));
    }
    public void initialize() throws Exception {     // to insert the customer's data to the database
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

