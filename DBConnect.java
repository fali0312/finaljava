
import java.sql.*; // To connect with the sql

public class DBConnect {

    public Connection con;
    private Statement st;
    private int ps;
    private ResultSet rs;

    DBConnect() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            // Create Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject","root", "");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    void getData(){
        //String query = "select * from shop";
        String query = "SELECT * FROM menu INNER JOIN categories on menu.category_id = categories.id";
        try{

            rs = st.executeQuery(query);

            System.out.println("Records from Database");
            while (rs.next()){
                System.out.println("");
                String name = rs.getString("name");
                String qty = rs.getString("qty");
                String category = rs.getString("category_name");


                System.out.println("Name : " + name + "\nqty : " + qty + "\ncategory : " + category );


            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("");
    }

    void insertData( String name, int qty , int cat){
        String sql = String.format("insert into menu(name,qty,category_id) VALUES('%s', %h ,%h)" , name ,qty,cat);
        //String name ;
        //name = scanner.next();
        //String sql = String.format("insert into orang(id,name,age) VALUES(%h , '%h' , '%h')", id , name , age);
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Data Inserted");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    void updateData(String name , int id){
        String query = String.format("update menu set name = '%s' where id = %h" , name, id);
        try{
            st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("Database Updated");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    void deleteData(int x){
        String sql = String.format("delete from menu where id = %h" , x);
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Row Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    void createTable() {
        String myTableName = "CREATE TABLE Motorcycle ("
                + "ID INT(64) NOT NULL AUTO_INCREMENT,"
                + "Brand VARCHAR(255),"
                + "Product VARCHAR(255),"
                + "Colour VARCHAR(255),"
                + "PRIMARY KEY (ID))";
        try {
            st = con.createStatement();
            st.executeUpdate(myTableName);
            System.out.println("Data Inserted");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}


