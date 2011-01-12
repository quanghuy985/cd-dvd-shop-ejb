/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author TuyenCk
 */
@Entity
@Table(name = "tblAdmin")
@NamedQueries({
    @NamedQuery(name = "TblAdmin.findAll", query = "SELECT t FROM TblAdmin t"),
    @NamedQuery(name = "TblAdmin.findByAdUserName", query = "SELECT t FROM TblAdmin t WHERE t.adUserName = :adUserName"),
    @NamedQuery(name = "TblAdmin.findByAdPassword", query = "SELECT t FROM TblAdmin t WHERE t.adPassword = :adPassword"),
    @NamedQuery(name = "TblAdmin.findByAdFullname", query = "SELECT t FROM TblAdmin t WHERE t.adFullname = :adFullname"),
    @NamedQuery(name = "TblAdmin.findByAdFunction", query = "SELECT t FROM TblAdmin t WHERE t.adFunction = :adFunction"),
    @NamedQuery(name = "TblAdmin.findByAdStatus", query = "SELECT t FROM TblAdmin t WHERE t.adStatus = :adStatus")})
public class TblAdmin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "adUserName")
    private String adUserName;
    @Basic(optional = false)
    @Column(name = "adPassword")
    private String adPassword;
    @Basic(optional = false)
    @Column(name = "adFullname")
    private String adFullname;
    @Column(name = "adFunction")
    private Integer adFunction;
    @Column(name = "adStatus")
    private Integer adStatus;

    public TblAdmin() {
    }

    public TblAdmin(String adUserName) {
        this.adUserName = adUserName;
    }

    public TblAdmin(String adUserName, String adPassword, String adFullname) {
        this.adUserName = adUserName;
        this.adPassword = adPassword;
        this.adFullname = adFullname;
    }

    public String getAdUserName() {
        return adUserName;
    }

    public void setAdUserName(String adUserName) {
        this.adUserName = adUserName;
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
    }

    public String getAdFullname() {
        return adFullname;
    }

    public void setAdFullname(String adFullname) {
        this.adFullname = adFullname;
    }

    public Integer getAdFunction() {
        return adFunction;
    }

    public void setAdFunction(Integer adFunction) {
        this.adFunction = adFunction;
    }

    public Integer getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(Integer adStatus) {
        this.adStatus = adStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adUserName != null ? adUserName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAdmin)) {
            return false;
        }
        TblAdmin other = (TblAdmin) object;
        if ((this.adUserName == null && other.adUserName != null) || (this.adUserName != null && !this.adUserName.equals(other.adUserName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblAdmin[adUserName=" + adUserName + "]";
    }

}
