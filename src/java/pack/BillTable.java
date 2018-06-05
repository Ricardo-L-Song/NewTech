/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sl
 */
@Entity
@Table(name = "bill_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillTable.findAll", query = "SELECT b FROM BillTable b")
    , @NamedQuery(name = "BillTable.findByIdBillTable", query = "SELECT b FROM BillTable b WHERE b.idBillTable = :idBillTable")
    , @NamedQuery(name = "BillTable.findByBillNum", query = "SELECT b FROM BillTable b WHERE b.billNum = :billNum")
    , @NamedQuery(name = "BillTable.findByQuantity", query = "SELECT b FROM BillTable b WHERE b.quantity = :quantity")
    , @NamedQuery(name = "BillTable.findByPrice", query = "SELECT b FROM BillTable b WHERE b.price = :price")
    , @NamedQuery(name = "BillTable.findByDate", query = "SELECT b FROM BillTable b WHERE b.date = :date")})
public class BillTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idBill_Table")
    private Integer idBillTable;
    @Basic(optional = false)
    @Column(name = "bill_num")
    private int billNum;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billNum")
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne(optional = false)
    private BookDetails bookId;

    public BillTable() {
    }

    public BillTable(Integer idBillTable) {
        this.idBillTable = idBillTable;
    }

    public BillTable(Integer idBillTable, int billNum, int quantity, int price, String date) {
        this.idBillTable = idBillTable;
        this.billNum = billNum;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public Integer getIdBillTable() {
        return idBillTable;
    }

    public void setIdBillTable(Integer idBillTable) {
        this.idBillTable = idBillTable;
    }

    public int getBillNum() {
        return billNum;
    }

    public void setBillNum(int billNum) {
        this.billNum = billNum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public BookDetails getBookId() {
        return bookId;
    }

    public void setBookId(BookDetails bookId) {
        this.bookId = bookId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBillTable != null ? idBillTable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillTable)) {
            return false;
        }
        BillTable other = (BillTable) object;
        if ((this.idBillTable == null && other.idBillTable != null) || (this.idBillTable != null && !this.idBillTable.equals(other.idBillTable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.BillTable[ idBillTable=" + idBillTable + " ]";
    }
    
}
