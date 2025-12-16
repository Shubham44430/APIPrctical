package main.java.app.components;

import java.sql.*;
import java.sql.ResultSet;

public class ProductEntry {

    private int id;
    private int price;
    private int stock;

    public ProductEntry(ResultSet ad) throws SQLException {

        id = ad.getInt("pno");
        price = ad.getInt("price");
        stock = ad.getInt("stock");

    }

    public int getId() {
         return id;
    }
    public void setId(int id) {
         this.id = id; 
    }

    public int getPrice() {
         return price;
    }
    public void setPrice(int price) { 
        this.price = price;
    }

    public int getStock() { 
        return stock;
    }
    public void setStock(int stock) {
         this.stock = stock; 
    }
}