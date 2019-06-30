

import javafx.beans.property.SimpleStringProperty;


public class customer_order {
    private SimpleStringProperty ID,Customer,Brand , Product , Colour;


    public customer_order(String id, String customer, String brand , String product , String colour){
        this.ID = new SimpleStringProperty(id);
        this.Customer = new SimpleStringProperty(customer);
        this.Brand = new SimpleStringProperty(brand);
        this.Product = new SimpleStringProperty(product);
        this.Colour = new SimpleStringProperty(colour);
    }
    public String getID(){ return ID.get(); }       // Getting all the data from the customer about the motorcycle

    public String getCustomer (){
        return Customer.get();
    }

    public String getBrand(){
        return Brand.get();
    }

    public String getProduct(){
        return Product.get();
    }

    public String getColour(){
        return Colour.get();
    }


}

