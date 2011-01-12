/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import dao.ProductBean;
import entity.TblProduct;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author TuyenCk
 */
public class ProductController {
    ProductBean productBean = lookupProductBeanBean();

    private ProductBean lookupProductBeanBean() {
        try {
            Context c = new InitialContext();
            return (ProductBean) c.lookup("java:global/CD_SHOP/CD_SHOP-ejb/ProductBean!dao.ProductBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public List<TblProduct> getproductAll() {
        return productBean.retrieveAllProduct();
    }
}
