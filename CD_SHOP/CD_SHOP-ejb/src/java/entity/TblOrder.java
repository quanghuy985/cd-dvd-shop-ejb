/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author TuyenCk
 */
@Entity
@Table(name = "tblOrder")
@NamedQueries({
    @NamedQuery(name = "TblOrder.findAll", query = "SELECT t FROM TblOrder t"),
    @NamedQuery(name = "TblOrder.findByOrderID", query = "SELECT t FROM TblOrder t WHERE t.orderID = :orderID"),
    @NamedQuery(name = "TblOrder.findByCusAccountBank", query = "SELECT t FROM TblOrder t WHERE t.cusAccountBank = :cusAccountBank"),
    @NamedQuery(name = "TblOrder.findByOrderStatus", query = "SELECT t FROM TblOrder t WHERE t.orderStatus = :orderStatus")})
public class TblOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "orderID")
    private Integer orderID;
    @Column(name = "cusAccountBank")
    private String cusAccountBank;
    @Column(name = "orderStatus")
    private Integer orderStatus;
    @JoinColumn(name = "cusEmail", referencedColumnName = "cusEmail")
    @ManyToOne
    private TblCustomer tblCustomer;
    @OneToMany(mappedBy = "tblOrder")
    private List<TblOrderDetail> tblOrderDetailList;

    public TblOrder() {
    }

    public TblOrder(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getCusAccountBank() {
        return cusAccountBank;
    }

    public void setCusAccountBank(String cusAccountBank) {
        this.cusAccountBank = cusAccountBank;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public TblCustomer getTblCustomer() {
        return tblCustomer;
    }

    public void setTblCustomer(TblCustomer tblCustomer) {
        this.tblCustomer = tblCustomer;
    }

    public List<TblOrderDetail> getTblOrderDetailList() {
        return tblOrderDetailList;
    }

    public void setTblOrderDetailList(List<TblOrderDetail> tblOrderDetailList) {
        this.tblOrderDetailList = tblOrderDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrder)) {
            return false;
        }
        TblOrder other = (TblOrder) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblOrder[orderID=" + orderID + "]";
    }

}
