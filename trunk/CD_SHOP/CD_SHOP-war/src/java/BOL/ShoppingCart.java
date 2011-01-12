/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BOL;

import Entity.ProductCart;
import java.util.ArrayList;

/**
 *
 * @author TuyenCk
 */
public class ShoppingCart {

    private ArrayList<ProductCart> cart = new ArrayList<ProductCart>();
    private ProductCart prCart;

    public ShoppingCart() {
        prCart = new ProductCart();
    }

    public void AddCart(ProductCart pr) {
        int status = 0;
        for (int i = 0; i < cart.size(); i++) {
            prCart = cart.get(i);
            if (pr.getProductCode().equals(prCart.getProductCode())) {
                cart.get(i).setQuantity(cart.get(i).getQuantity() + 1);
                status = 1;
                return;
            }
        }
        if (status == 0) {
            pr.setQuantity(1);
        }
        cart.add(pr);
    }

    public void UpdateCart(String id, int quantity) {
        for (int i = 0; i < cart.size(); i++) {
            prCart = cart.get(i);
            if (prCart.getProductCode().equals(id)) {
                cart.get(i).setQuantity(quantity);
            }
        }
    }

    public void RemoveCart(String id) {
        for (int i = 0; i <= cart.size(); i++) {
            prCart = cart.get(i);
            if (prCart.getProductCode().equals(id)) {
                cart.remove(i);
                return;
            }
        }
    }

    public float TotalPrice() {
        float price = 0;
        for (int i = 0; i < cart.size(); i++) {
            ProductCart temp = cart.get(i);
            price += temp.getPrice() * temp.getQuantity();
        }
        return price;
    }

    public float TotalQuantity() {
        float total = 0;
        for (int i = 0; i < cart.size(); i++) {
            prCart = cart.get(i);
            total = total + prCart.getQuantity();
        }
        return total;
    }

    public void DeleteCart() {
        cart.clear();
    }

    public int size() {
        return cart.size();
    }

    public ArrayList<ProductCart> getAllItem() {
        return cart;
    }
}
