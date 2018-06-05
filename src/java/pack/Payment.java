/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sl
 */
@Entity
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByIdPayment", query = "SELECT p FROM Payment p WHERE p.idPayment = :idPayment")
    , @NamedQuery(name = "Payment.findByTotalAmount", query = "SELECT p FROM Payment p WHERE p.totalAmount = :totalAmount")
    , @NamedQuery(name = "Payment.findByCreditcardNum", query = "SELECT p FROM Payment p WHERE p.creditcardNum = :creditcardNum")
    , @NamedQuery(name = "Payment.findByCreditcardType", query = "SELECT p FROM Payment p WHERE p.creditcardType = :creditcardType")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPayment")
    private Integer idPayment;
    @Basic(optional = false)
    @Column(name = "total_amount")
    private int totalAmount;
    @Basic(optional = false)
    @Column(name = "creditcard_num")
    private int creditcardNum;
    @Basic(optional = false)
    @Column(name = "creditcard_type")
    private int creditcardType;
    @JoinColumn(name = "bill_num", referencedColumnName = "bill_num")
    @ManyToOne(optional = false)
    private BillTable billNum;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private UserProfile username;

    public Payment() {
    }

    public Payment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Payment(Integer idPayment, int totalAmount, int creditcardNum, int creditcardType) {
        this.idPayment = idPayment;
        this.totalAmount = totalAmount;
        this.creditcardNum = creditcardNum;
        this.creditcardType = creditcardType;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCreditcardNum() {
        return creditcardNum;
    }

    public void setCreditcardNum(int creditcardNum) {
        this.creditcardNum = creditcardNum;
    }

    public int getCreditcardType() {
        return creditcardType;
    }

    public void setCreditcardType(int creditcardType) {
        this.creditcardType = creditcardType;
    }

    public BillTable getBillNum() {
        return billNum;
    }

    public void setBillNum(BillTable billNum) {
        this.billNum = billNum;
    }

    public UserProfile getUsername() {
        return username;
    }

    public void setUsername(UserProfile username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPayment != null ? idPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.idPayment == null && other.idPayment != null) || (this.idPayment != null && !this.idPayment.equals(other.idPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Payment[ idPayment=" + idPayment + " ]";
    }
    
}
