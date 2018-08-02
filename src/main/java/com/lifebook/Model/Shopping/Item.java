package com.lifebook.Model.Shopping;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nameOfItem;

    public boolean isSoldout() {
        return Soldout;
    }
    public void setSoldout(boolean soldout) {
        Soldout = soldout;
    }

    private String description;
    private String tags;
    private double price;
    private int numOfItem;
    private boolean Soldout;
    private String productImage;

    private double totalPrice;

    private boolean added;
    private int totalItemPuchased;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Cart cartToPurchase;

    public int getTotalItemPuchased() {
        return totalItemPuchased;
    }

    public void setTotalItemPuchased(int totalItemPuchased) {
        this.totalItemPuchased = totalItemPuchased;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }


    public int getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(int numOfItem) {
        this.numOfItem = numOfItem;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }



    public Cart getCartToPurchase() {
        return cartToPurchase;
    }

    public void setCartToPurchase(Cart cartToPurchase) {
        this.cartToPurchase = cartToPurchase;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nameOfItem='" + nameOfItem + '\'' +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                ", price=" + price +
                ", Soldout=" + Soldout +
                '}';
    }


}
