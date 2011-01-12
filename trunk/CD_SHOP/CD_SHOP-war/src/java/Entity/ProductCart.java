/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author TuyenCk
 */
public class ProductCart {

    public int OrderID;
    public String ProductName;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public ProductCart() {
    }

    public ProductCart(String ProductCode, float Price, int Quantity, String productName) {
        this.ProductCode = ProductCode;
        this.Price = Price;
        this.Quantity = Quantity;
        this.ProductName = productName;
    }

    public ProductCart(int OrderID, String ProductCode, float Price, int Quantity) {
        this.OrderID = OrderID;
        this.ProductCode = ProductCode;
        this.Price = Price;
        this.Quantity = Quantity;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String ProductCode) {
        this.ProductCode = ProductCode;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    public String ProductCode;
    public float Price;
    public int Quantity;
}
