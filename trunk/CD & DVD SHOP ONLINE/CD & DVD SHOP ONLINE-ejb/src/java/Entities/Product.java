/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author TuyenCk
 */
public class Product {
    String proID;
    String proCateID;
    String cateCollection;
    String proName;
    String proDetail;
    String proImage;
    String proPublish;
    int proAmountAvailable;
    float proPrice;
    float proPriceRent;
    int proStatus;

    public String getCateCollection() {
        return cateCollection;
    }

    public void setCateCollection(String cateCollection) {
        this.cateCollection = cateCollection;
    }

    public String getProCateID() {
        return proCateID;
    }

    public void setProCateID(String proCateID) {
        this.proCateID = proCateID;
    }

    public int getProAmountAvailable() {
        return proAmountAvailable;
    }

    public void setProAmountAvailable(int proAmountAvailable) {
        this.proAmountAvailable = proAmountAvailable;
    }

    public String getProDetail() {
        return proDetail;
    }

    public void setProDetail(String proDetail) {
        this.proDetail = proDetail;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }

    public float getProPriceRent() {
        return proPriceRent;
    }

    public void setProPriceRent(float proPriceRent) {
        this.proPriceRent = proPriceRent;
    }

    public String getProPublish() {
        return proPublish;
    }

    public void setProPublish(String proPublish) {
        this.proPublish = proPublish;
    }

    public int getProStatus() {
        return proStatus;
    }

    public void setProStatus(int proStatus) {
        this.proStatus = proStatus;
    }
    
}
