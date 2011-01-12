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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author TuyenCk
 */
@Entity
@Table(name = "tblProductCategory")
@NamedQueries({
    @NamedQuery(name = "TblProductCategory.findAll", query = "SELECT t FROM TblProductCategory t"),
    @NamedQuery(name = "TblProductCategory.findByProCateID", query = "SELECT t FROM TblProductCategory t WHERE t.proCateID = :proCateID"),
    @NamedQuery(name = "TblProductCategory.findByProCateName", query = "SELECT t FROM TblProductCategory t WHERE t.proCateName = :proCateName"),
    @NamedQuery(name = "TblProductCategory.findByProCateStatus", query = "SELECT t FROM TblProductCategory t WHERE t.proCateStatus = :proCateStatus")})
public class TblProductCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "proCateID")
    private String proCateID;
    @Basic(optional = false)
    @Column(name = "proCateName")
    private String proCateName;
    @Basic(optional = false)
    @Lob
    @Column(name = "proCateDescription")
    private String proCateDescription;
    @Column(name = "proCateStatus")
    private Integer proCateStatus;
    @OneToMany(mappedBy = "tblProductCategory")
    private List<TblProduct> tblProductList;

    public TblProductCategory() {
    }

    public TblProductCategory(String proCateID) {
        this.proCateID = proCateID;
    }

    public TblProductCategory(String proCateID, String proCateName, String proCateDescription) {
        this.proCateID = proCateID;
        this.proCateName = proCateName;
        this.proCateDescription = proCateDescription;
    }

    public String getProCateID() {
        return proCateID;
    }

    public void setProCateID(String proCateID) {
        this.proCateID = proCateID;
    }

    public String getProCateName() {
        return proCateName;
    }

    public void setProCateName(String proCateName) {
        this.proCateName = proCateName;
    }

    public String getProCateDescription() {
        return proCateDescription;
    }

    public void setProCateDescription(String proCateDescription) {
        this.proCateDescription = proCateDescription;
    }

    public Integer getProCateStatus() {
        return proCateStatus;
    }

    public void setProCateStatus(Integer proCateStatus) {
        this.proCateStatus = proCateStatus;
    }

    public List<TblProduct> getTblProductList() {
        return tblProductList;
    }

    public void setTblProductList(List<TblProduct> tblProductList) {
        this.tblProductList = tblProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proCateID != null ? proCateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProductCategory)) {
            return false;
        }
        TblProductCategory other = (TblProductCategory) object;
        if ((this.proCateID == null && other.proCateID != null) || (this.proCateID != null && !this.proCateID.equals(other.proCateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblProductCategory[proCateID=" + proCateID + "]";
    }

}
