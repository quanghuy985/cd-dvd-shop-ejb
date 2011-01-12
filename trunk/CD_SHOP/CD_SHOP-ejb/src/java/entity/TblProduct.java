/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author TuyenCk
 */
@Entity
@Table(name = "tblProduct")
@NamedQueries({
    @NamedQuery(name = "TblProduct.findAll", query = "SELECT t FROM TblProduct t"),
    @NamedQuery(name = "TblProduct.findByProID", query = "SELECT t FROM TblProduct t WHERE t.proID = :proID"),
    @NamedQuery(name = "TblProduct.findByCateCollection", query = "SELECT t FROM TblProduct t WHERE t.cateCollection = :cateCollection"),
    @NamedQuery(name = "TblProduct.findByProName", query = "SELECT t FROM TblProduct t WHERE t.proName = :proName"),
    @NamedQuery(name = "TblProduct.findByProImage", query = "SELECT t FROM TblProduct t WHERE t.proImage = :proImage"),
    @NamedQuery(name = "TblProduct.findByProPublish", query = "SELECT t FROM TblProduct t WHERE t.proPublish = :proPublish"),
    @NamedQuery(name = "TblProduct.findByProAmountAvailable", query = "SELECT t FROM TblProduct t WHERE t.proAmountAvailable = :proAmountAvailable"),
    @NamedQuery(name = "TblProduct.findByProPrice", query = "SELECT t FROM TblProduct t WHERE t.proPrice = :proPrice"),
    @NamedQuery(name = "TblProduct.findByProPriceRent", query = "SELECT t FROM TblProduct t WHERE t.proPriceRent = :proPriceRent"),
    @NamedQuery(name = "TblProduct.findByProStatus", query = "SELECT t FROM TblProduct t WHERE t.proStatus = :proStatus")})
public class TblProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "proID")
    private String proID;
    @Basic(optional = false)
    @Column(name = "cateCollection")
    private String cateCollection;
    @Basic(optional = false)
    @Column(name = "proName")
    private String proName;
    @Basic(optional = false)
    @Lob
    @Column(name = "proDetail")
    private String proDetail;
    @Basic(optional = false)
    @Column(name = "proImage")
    private String proImage;
    @Basic(optional = false)
    @Column(name = "proPublish")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proPublish;
    @Column(name = "proAmountAvailable")
    private Integer proAmountAvailable;
    @Column(name = "proPrice")
    private BigDecimal proPrice;
    @Column(name = "proPriceRent")
    private BigDecimal proPriceRent;
    @Column(name = "proStatus")
    private Integer proStatus;
    @OneToMany(mappedBy = "tblProduct")
    private List<TblOrderDetail> tblOrderDetailList;
    @JoinColumn(name = "proCateID", referencedColumnName = "proCateID")
    @ManyToOne
    private TblProductCategory tblProductCategory;

    public TblProduct() {
    }

    public TblProduct(String proID) {
        this.proID = proID;
    }

    public TblProduct(String proID, String cateCollection, String proName, String proDetail, String proImage, Date proPublish) {
        this.proID = proID;
        this.cateCollection = cateCollection;
        this.proName = proName;
        this.proDetail = proDetail;
        this.proImage = proImage;
        this.proPublish = proPublish;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getCateCollection() {
        return cateCollection;
    }

    public void setCateCollection(String cateCollection) {
        this.cateCollection = cateCollection;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDetail() {
        return proDetail;
    }

    public void setProDetail(String proDetail) {
        this.proDetail = proDetail;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public Date getProPublish() {
        return proPublish;
    }

    public void setProPublish(Date proPublish) {
        this.proPublish = proPublish;
    }

    public Integer getProAmountAvailable() {
        return proAmountAvailable;
    }

    public void setProAmountAvailable(Integer proAmountAvailable) {
        this.proAmountAvailable = proAmountAvailable;
    }

    public BigDecimal getProPrice() {
        return proPrice;
    }

    public void setProPrice(BigDecimal proPrice) {
        this.proPrice = proPrice;
    }

    public BigDecimal getProPriceRent() {
        return proPriceRent;
    }

    public void setProPriceRent(BigDecimal proPriceRent) {
        this.proPriceRent = proPriceRent;
    }

    public Integer getProStatus() {
        return proStatus;
    }

    public void setProStatus(Integer proStatus) {
        this.proStatus = proStatus;
    }

    public List<TblOrderDetail> getTblOrderDetailList() {
        return tblOrderDetailList;
    }

    public void setTblOrderDetailList(List<TblOrderDetail> tblOrderDetailList) {
        this.tblOrderDetailList = tblOrderDetailList;
    }

    public TblProductCategory getTblProductCategory() {
        return tblProductCategory;
    }

    public void setTblProductCategory(TblProductCategory tblProductCategory) {
        this.tblProductCategory = tblProductCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proID != null ? proID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProduct)) {
            return false;
        }
        TblProduct other = (TblProduct) object;
        if ((this.proID == null && other.proID != null) || (this.proID != null && !this.proID.equals(other.proID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblProduct[proID=" + proID + "]";
    }

}
