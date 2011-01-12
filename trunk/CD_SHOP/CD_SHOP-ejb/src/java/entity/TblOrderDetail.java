/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author TuyenCk
 */
@Entity
@Table(name = "tblOrderDetail")
@NamedQueries({
    @NamedQuery(name = "TblOrderDetail.findAll", query = "SELECT t FROM TblOrderDetail t"),
    @NamedQuery(name = "TblOrderDetail.findByOrderDetailID", query = "SELECT t FROM TblOrderDetail t WHERE t.orderDetailID = :orderDetailID"),
    @NamedQuery(name = "TblOrderDetail.findByOrderDetailCate", query = "SELECT t FROM TblOrderDetail t WHERE t.orderDetailCate = :orderDetailCate"),
    @NamedQuery(name = "TblOrderDetail.findByAmount", query = "SELECT t FROM TblOrderDetail t WHERE t.amount = :amount"),
    @NamedQuery(name = "TblOrderDetail.findByDateRent", query = "SELECT t FROM TblOrderDetail t WHERE t.dateRent = :dateRent"),
    @NamedQuery(name = "TblOrderDetail.findByDateRelease", query = "SELECT t FROM TblOrderDetail t WHERE t.dateRelease = :dateRelease"),
    @NamedQuery(name = "TblOrderDetail.findByOrderDetailPrice", query = "SELECT t FROM TblOrderDetail t WHERE t.orderDetailPrice = :orderDetailPrice"),
    @NamedQuery(name = "TblOrderDetail.findByOrderDetailStatus", query = "SELECT t FROM TblOrderDetail t WHERE t.orderDetailStatus = :orderDetailStatus")})
public class TblOrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "orderDetailID")
    private Integer orderDetailID;
    @Basic(optional = false)
    @Column(name = "orderDetailCate")
    private int orderDetailCate;
    @Column(name = "Amount")
    private Integer amount;
    @Basic(optional = false)
    @Column(name = "dateRent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRent;
    @Basic(optional = false)
    @Column(name = "dateRelease")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRelease;
    @Column(name = "orderDetailPrice")
    private BigDecimal orderDetailPrice;
    @Column(name = "orderDetailStatus")
    private Integer orderDetailStatus;
    @JoinColumn(name = "proID", referencedColumnName = "proID")
    @ManyToOne
    private TblProduct tblProduct;
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    @ManyToOne
    private TblOrder tblOrder;

    public TblOrderDetail() {
    }

    public TblOrderDetail(Integer orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public TblOrderDetail(Integer orderDetailID, int orderDetailCate, Date dateRent, Date dateRelease) {
        this.orderDetailID = orderDetailID;
        this.orderDetailCate = orderDetailCate;
        this.dateRent = dateRent;
        this.dateRelease = dateRelease;
    }

    public Integer getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(Integer orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getOrderDetailCate() {
        return orderDetailCate;
    }

    public void setOrderDetailCate(int orderDetailCate) {
        this.orderDetailCate = orderDetailCate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDateRent() {
        return dateRent;
    }

    public void setDateRent(Date dateRent) {
        this.dateRent = dateRent;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public BigDecimal getOrderDetailPrice() {
        return orderDetailPrice;
    }

    public void setOrderDetailPrice(BigDecimal orderDetailPrice) {
        this.orderDetailPrice = orderDetailPrice;
    }

    public Integer getOrderDetailStatus() {
        return orderDetailStatus;
    }

    public void setOrderDetailStatus(Integer orderDetailStatus) {
        this.orderDetailStatus = orderDetailStatus;
    }

    public TblProduct getTblProduct() {
        return tblProduct;
    }

    public void setTblProduct(TblProduct tblProduct) {
        this.tblProduct = tblProduct;
    }

    public TblOrder getTblOrder() {
        return tblOrder;
    }

    public void setTblOrder(TblOrder tblOrder) {
        this.tblOrder = tblOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailID != null ? orderDetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrderDetail)) {
            return false;
        }
        TblOrderDetail other = (TblOrderDetail) object;
        if ((this.orderDetailID == null && other.orderDetailID != null) || (this.orderDetailID != null && !this.orderDetailID.equals(other.orderDetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblOrderDetail[orderDetailID=" + orderDetailID + "]";
    }

}
