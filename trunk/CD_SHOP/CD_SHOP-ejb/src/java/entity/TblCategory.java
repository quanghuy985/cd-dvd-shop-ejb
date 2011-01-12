/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author TuyenCk
 */
@Entity
@Table(name = "tblCategory")
@NamedQueries({
    @NamedQuery(name = "TblCategory.findAll", query = "SELECT t FROM TblCategory t"),
    @NamedQuery(name = "TblCategory.findByCateID", query = "SELECT t FROM TblCategory t WHERE t.cateID = :cateID"),
    @NamedQuery(name = "TblCategory.findByCateName", query = "SELECT t FROM TblCategory t WHERE t.cateName = :cateName"),
    @NamedQuery(name = "TblCategory.findByAddFee", query = "SELECT t FROM TblCategory t WHERE t.addFee = :addFee"),
    @NamedQuery(name = "TblCategory.findByCateStatus", query = "SELECT t FROM TblCategory t WHERE t.cateStatus = :cateStatus")})
public class TblCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cateID")
    private Integer cateID;
    @Basic(optional = false)
    @Column(name = "cateName")
    private String cateName;
    @Basic(optional = false)
    @Lob
    @Column(name = "cateDetail")
    private String cateDetail;
    @Basic(optional = false)
    @Column(name = "addFee")
    private BigDecimal addFee;
    @Column(name = "cateStatus")
    private Integer cateStatus;

    public TblCategory() {
    }

    public TblCategory(Integer cateID) {
        this.cateID = cateID;
    }

    public TblCategory(Integer cateID, String cateName, String cateDetail, BigDecimal addFee) {
        this.cateID = cateID;
        this.cateName = cateName;
        this.cateDetail = cateDetail;
        this.addFee = addFee;
    }

    public Integer getCateID() {
        return cateID;
    }

    public void setCateID(Integer cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDetail() {
        return cateDetail;
    }

    public void setCateDetail(String cateDetail) {
        this.cateDetail = cateDetail;
    }

    public BigDecimal getAddFee() {
        return addFee;
    }

    public void setAddFee(BigDecimal addFee) {
        this.addFee = addFee;
    }

    public Integer getCateStatus() {
        return cateStatus;
    }

    public void setCateStatus(Integer cateStatus) {
        this.cateStatus = cateStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cateID != null ? cateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCategory)) {
            return false;
        }
        TblCategory other = (TblCategory) object;
        if ((this.cateID == null && other.cateID != null) || (this.cateID != null && !this.cateID.equals(other.cateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblCategory[cateID=" + cateID + "]";
    }

}
