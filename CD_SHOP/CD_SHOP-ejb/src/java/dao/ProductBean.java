/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.TblProduct;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author TuyenCk
 */
@Stateless
@LocalBean
public class ProductBean {
    @PersistenceContext(unitName = "CD_SHOP-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    public List<TblProduct> retrieveAllProduct() {
        return em.createNamedQuery("TblProduct.findAll").getResultList();
    }
}
