// package com.example.grocery.model;

// public class Product {
//     private int id;
//     private String name;
//     private double price;
//     private String image;

//     public Product(int id, String name, double price, String image) {
//         this.id = id;
//         this.name = name;
//         this.price = price;
//         this.image = image;
//     }

//     // Getters
//     public int getId() { return id; }
//     public String getName() { return name; }
//     public double getPrice() { return price; }
//     public String getImage() { return image; }
// }

package com.example.grocery.model;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private double price;
    private String image;

    public Product(int id, String name, double price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImage() { return image; }

    // Override equals and hashCode based on 'id'
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
