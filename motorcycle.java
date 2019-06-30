

import javafx.beans.property.SimpleStringProperty;


public class motorcycle {
    private SimpleStringProperty ID,Brand , Product , Colour;


    public motorcycle(String id,String brand , String product , String colour){     // To insert new data to the database
        this.ID = new SimpleStringProperty(id);
        this.Brand = new SimpleStringProperty(brand);
        this.Product = new SimpleStringProperty(product);
        this.Colour = new SimpleStringProperty(colour);
    }
    public String getID(){
        return ID.get();
    }                           // Get the ID which is randomize

    public String getBrand(){
        return Brand.get();
    }                     // Get the brand of motorcycle

    public String getProduct(){
        return Product.get();
    }                 // Name of the motorcycle

    public String getColour(){
        return Colour.get();
    }                   // Get the colour


}

