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
@Table(name = "user_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u")
    , @NamedQuery(name = "UserProfile.findByIdUserProfile", query = "SELECT u FROM UserProfile u WHERE u.idUserProfile = :idUserProfile")
    , @NamedQuery(name = "UserProfile.findByUsername", query = "SELECT u FROM UserProfile u WHERE u.username = :username")
    , @NamedQuery(name = "UserProfile.findByPassword", query = "SELECT u FROM UserProfile u WHERE u.password = :password")
    , @NamedQuery(name = "UserProfile.findByFirstname", query = "SELECT u FROM UserProfile u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "UserProfile.findByMiddlename", query = "SELECT u FROM UserProfile u WHERE u.middlename = :middlename")
    , @NamedQuery(name = "UserProfile.findByLastname", query = "SELECT u FROM UserProfile u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "UserProfile.findByAddress1", query = "SELECT u FROM UserProfile u WHERE u.address1 = :address1")
    , @NamedQuery(name = "UserProfile.findByAddress2", query = "SELECT u FROM UserProfile u WHERE u.address2 = :address2")
    , @NamedQuery(name = "UserProfile.findByCity", query = "SELECT u FROM UserProfile u WHERE u.city = :city")
    , @NamedQuery(name = "UserProfile.findByState", query = "SELECT u FROM UserProfile u WHERE u.state = :state")
    , @NamedQuery(name = "UserProfile.findByPincode", query = "SELECT u FROM UserProfile u WHERE u.pincode = :pincode")
    , @NamedQuery(name = "UserProfile.findByEmail", query = "SELECT u FROM UserProfile u WHERE u.email = :email")
    , @NamedQuery(name = "UserProfile.findByPhone", query = "SELECT u FROM UserProfile u WHERE u.phone = :phone")})
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser_Profile")
    private Integer idUserProfile;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "middlename")
    private String middlename;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "address1")
    private String address1;
    @Basic(optional = false)
    @Column(name = "address2")
    private String address2;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "pincode")
    private String pincode;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone")
    private int phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Payment> paymentCollection;

    public UserProfile() {
    }

    public UserProfile(Integer idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

    public UserProfile(Integer idUserProfile, String username, String password, String firstname, String middlename, String lastname, String address1, String address2, String city, String state, String pincode, String email, int phone) {
        this.idUserProfile = idUserProfile;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.email = email;
        this.phone = phone;
    }

    public Integer getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(Integer idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserProfile != null ? idUserProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.idUserProfile == null && other.idUserProfile != null) || (this.idUserProfile != null && !this.idUserProfile.equals(other.idUserProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.UserProfile[ idUserProfile=" + idUserProfile + " ]";
    }
    
}
