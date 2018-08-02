package com.lifebook.Model.Shopping;

import com.lifebook.Model.AppUser;
import com.lifebook.Service.OrderItem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   // private static final long serialVersionUID = 4573229359755965961L;
    private LinkedHashMap<Long, OrderItem> map = new LinkedHashMap<>();
    @OneToMany(mappedBy = "cartToPurchase")
    private Set<Item> itemPurchased;
    private double totalPrice;
    private int numItemPurchased;
    @OneToOne(mappedBy = "userCart")
    private AppUser purchaser;

    public OrderItem addToCart(OrderItem OrderItem) {
        //If the item already exists in the cart, increment quantity..
        if (this.map.containsKey(OrderItem.getItem().getId())) {
            OrderItem existingOrderItem = this.map.get(OrderItem.getItem().getId());
            int newQuantity = existingOrderItem.getPurchasedQuantity() + OrderItem.getPurchasedQuantity();
            OrderItem newOrderItem = new OrderItem(OrderItem.getItem(), newQuantity);
            this.map.put(OrderItem.getItem().getId(), newOrderItem);
            return newOrderItem;
        } else {
            //assuming only one product at a time..but needs validation check
            this.map.put(OrderItem.getItem().getId(), OrderItem);
            return OrderItem;
        }
    }

    public void removeItemFromCart(Long itemId) {
        this.map.remove(itemId);
    }

    public void updateCart(List<OrderItem> orderItems) {
        if (orderItems != null) {
            for (OrderItem orderItem : orderItems) {
                updateCart(orderItem);
            }
        }
    }

    private void updateCart(OrderItem orderProduct) {
        if (this.map.containsKey(orderProduct.getItem().getId())) {
            if (orderProduct.getPurchasedQuantity() <= 0) {
                removeItemFromCart(orderProduct.getItem().getId());
            } else {
                map.put(orderProduct.getItem().getId(), orderProduct);
            }
        } else {
            map.put(orderProduct.getItem().getId(), orderProduct);
        }
    }

    public List<OrderItem> getItemsInCart() {
        return new ArrayList<OrderItem>(this.map.values());
    }


}
