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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "book_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookDetails.findAll", query = "SELECT b FROM BookDetails b")
    , @NamedQuery(name = "BookDetails.findByIdBookDetails", query = "SELECT b FROM BookDetails b WHERE b.idBookDetails = :idBookDetails")
    , @NamedQuery(name = "BookDetails.findByCategoryName", query = "SELECT b FROM BookDetails b WHERE b.categoryName = :categoryName")
    , @NamedQuery(name = "BookDetails.findByBookId", query = "SELECT b FROM BookDetails b WHERE b.bookId = :bookId")
    , @NamedQuery(name = "BookDetails.findByTitle", query = "SELECT b FROM BookDetails b WHERE b.title = :title")
    , @NamedQuery(name = "BookDetails.findByAuthor", query = "SELECT b FROM BookDetails b WHERE b.author = :author")
    , @NamedQuery(name = "BookDetails.findByPublisher", query = "SELECT b FROM BookDetails b WHERE b.publisher = :publisher")
    , @NamedQuery(name = "BookDetails.findByIsbn", query = "SELECT b FROM BookDetails b WHERE b.isbn = :isbn")
    , @NamedQuery(name = "BookDetails.findByPrice", query = "SELECT b FROM BookDetails b WHERE b.price = :price")
    , @NamedQuery(name = "BookDetails.findByDescription", query = "SELECT b FROM BookDetails b WHERE b.description = :description")
    , @NamedQuery(name = "BookDetails.findByPic", query = "SELECT b FROM BookDetails b WHERE b.pic = :pic")})
public class BookDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBook_Details")
    private Integer idBookDetails;
    @Basic(optional = false)
    @Column(name = "category_name")
    private String categoryName;
    @Basic(optional = false)
    @Column(name = "book_id")
    private int bookId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @Column(name = "publisher")
    private String publisher;
    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "pic")
    private String pic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private Collection<BillTable> billTableCollection;

    public BookDetails() {
    }

    public BookDetails(Integer idBookDetails) {
        this.idBookDetails = idBookDetails;
    }

    public BookDetails(Integer idBookDetails, String categoryName, int bookId, String title, String author, String publisher, String isbn, int price, String description, String pic) {
        this.idBookDetails = idBookDetails;
        this.categoryName = categoryName;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.price = price;
        this.description = description;
        this.pic = pic;
    }

    public Integer getIdBookDetails() {
        return idBookDetails;
    }

    public void setIdBookDetails(Integer idBookDetails) {
        this.idBookDetails = idBookDetails;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @XmlTransient
    public Collection<BillTable> getBillTableCollection() {
        return billTableCollection;
    }

    public void setBillTableCollection(Collection<BillTable> billTableCollection) {
        this.billTableCollection = billTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBookDetails != null ? idBookDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookDetails)) {
            return false;
        }
        BookDetails other = (BookDetails) object;
        if ((this.idBookDetails == null && other.idBookDetails != null) || (this.idBookDetails != null && !this.idBookDetails.equals(other.idBookDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.BookDetails[ idBookDetails=" + idBookDetails + " ]";
    }
    
}
