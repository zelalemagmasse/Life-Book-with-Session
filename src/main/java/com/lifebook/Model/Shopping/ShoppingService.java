package com.lifebook.Model.Shopping;

import com.lifebook.Model.Shopping.Cart;
import com.lifebook.Model.Shopping.Item;
import com.lifebook.Repositories.AppUserRepository;
import com.lifebook.Service.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Service
public class ShoppingService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    private HttpSession httpSession;
    private static final String CART_ATTROBITE_Name="shoppingcart";

    private Cart getShoppingCartInSession(){
        Cart cart=(Cart)this.httpSession.getAttribute(CART_ATTROBITE_Name);
        if(cart==null){
            cart=new Cart();
            this.httpSession.setAttribute(CART_ATTROBITE_Name,cart);
        }
        return cart;
    }

    public void updateCartInSession(Cart cart){
        this.httpSession.setAttribute(CART_ATTROBITE_Name,cart);
    }

    public OrderItem addToCart(OrderItem OrderItem) {
       Cart cart = getShoppingCartInSession();
        OrderItem OrderItemInCart = cart.addToCart(OrderItem);
        updateCartInSession(cart);
        return OrderItemInCart;
    }

    public void removeFromCart(long productId) {
        Cart cart = getShoppingCartInSession();
        cart.removeItemFromCart(productId);
        updateCartInSession(cart);
    }

    public void updateCart(List<OrderItem> OrderItems) {
       Cart cart = getShoppingCartInSession();
        cart.updateCart(OrderItems);
        updateCartInSession(cart);
    }

    public List<OrderItem> getProductsInCart() {
        Cart cart = getShoppingCartInSession();
        return cart.getItemsInCart();
    }
    public int getNumberOfProductsInCart() {
       Cart cart = getShoppingCartInSession();
        List<OrderItem> OrderItems = cart.getItemsInCart();
        int itemsInCart = 0;
        if (OrderItems!=null) {
            for (OrderItem OrderItem: OrderItems) {
                itemsInCart += OrderItem.getPurchasedQuantity();
            }
        }
        return itemsInCart;
    }

//    public Cart priceCalculator(Cart myCart){
//       double total=0;
//       Set<Item> items=myCart.getItemPurchased();
//       for(Item eachItem:items){
//
//          total=total + (eachItem.getPrice()* 0.02) + eachItem.getPrice();
//
//       }
//        myCart.setTotalPrice(total);
//        myCart.setNumItemPurchased(myCart.getItemPurchased().size());
//     return  myCart;
//    }
}
