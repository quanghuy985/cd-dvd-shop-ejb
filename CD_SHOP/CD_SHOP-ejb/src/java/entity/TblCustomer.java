/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tblCustomer")
@NamedQueries({
    @NamedQuery(name = "TblCustomer.findAll", query = "SELECT t FROM TblCustomer t"),
    @NamedQuery(name = "TblCustomer.findByCusEmail", query = "SELECT t FROM TblCustomer t WHERE t.cusEmail = :cusEmail"),
    @NamedQuery(name = "TblCustomer.findByCusPassword", query = "SELECT t FROM TblCustomer t WHERE t.cusPassword = :cusPassword"),
    @NamedQuery(name = "TblCustomer.findByCusFullname", query = "SELECT t FROM TblCustomer t WHERE t.cusFullname = :cusFullname"),
    @NamedQuery(name = "TblCustomer.findByCusAddress", query = "SELECT t FROM TblCustomer t WHERE t.cusAddress = :cusAddress"),
    @NamedQuery(name = "TblCustomer.findByCusBirthDay", query = "SELECT t FROM TblCustomer t WHERE t.cusBirthDay = :cusBirthDay"),
    @NamedQuery(name = "TblCustomer.findByCusPhone", query = "SELECT t FROM TblCustomer t WHERE t.cusPhone = :cusPhone"),
    @NamedQuery(name = "TblCustomer.findByCusStatus", query = "SELECT t FROM TblCustomer t WHERE t.cusStatus = :cusStatus")})
public class TblCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cusEmail")
    private String cusEmail;
    @Basic(optional = false)
    @Column(name = "cusPassword")
    private String cusPassword;
    @Basic(optional = false)
    @Column(name = "cusFullname")
    private String cusFullname;
    @Basic(optional = false)
    @Column(name = "cusAddress")
    private String cusAddress;
    @Basic(optional = false)
    @Column(name = "cusBirthDay")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cusBirthDay;
    @Basic(optional = false)
    @Column(name = "cusPhone")
    private String cusPhone;
    @Column(name = "cusStatus")
    private Integer cusStatus;
    @OneToMany(mappedBy = "tblCustomer")
    private List<TblOrder> tblOrderList;

    public TblCustomer() {
    }

    public TblCustomer(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public TblCustomer(String cusEmail, String cusPassword, String cusFullname, String cusAddress, Date cusBirthDay, String cusPhone) {
        this.cusEmail = cusEmail;
        this.cusPassword = cusPassword;
        this.cusFullname = cusFullname;
        this.cusAddress = cusAddress;
        this.cusBirthDay = cusBirthDay;
        this.cusPhone = cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    public String getCusFullname() {
        return cusFullname;
    }

    public void setCusFullname(String cusFullname) {
        this.cusFullname = cusFullname;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public Date getCusBirthDay() {
        return cusBirthDay;
    }

    public void setCusBirthDay(Date cusBirthDay) {
        this.cusBirthDay = cusBirthDay;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public Integer getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(Integer cusStatus) {
        this.cusStatus = cusStatus;
    }

    public List<TblOrder> getTblOrderList() {
        return tblOrderList;
    }

    public void setTblOrderList(List<TblOrder> tblOrderList) {
        this.tblOrderList = tblOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusEmail != null ? cusEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCustomer)) {
            return false;
        }
        TblCustomer other = (TblCustomer) object;
        if ((this.cusEmail == null && other.cusEmail != null) || (this.cusEmail != null && !this.cusEmail.equals(other.cusEmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblCustomer[cusEmail=" + cusEmail + "]";
    }

}
