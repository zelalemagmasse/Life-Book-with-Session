package com.lifebook.Service;

import com.lifebook.Model.Shopping.Item;

import java.io.Serializable;

public class OrderItem implements Serializable {

   // private static final long serialVersionUID = -3480296374500403880L;
    public OrderItem() {
    }

    private int purchasedQuantity;
    private Item item;

    public OrderItem(Item item,int purchasedQuantity) {
        this.purchasedQuantity = purchasedQuantity;
        this.item = item;
    }



    public int getPurchasedQuantity() {
        return purchasedQuantity;
    }

    public void setPurchasedQuantity(int purchasedQuantity) {
        this.purchasedQuantity = purchasedQuantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
