package RealEstateLeadManager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email;
    private String address;

    private String enquiryDateTime;
    private String purpose;
    private String category;
    private String propertyType;
    private String otherPropertyType;

    private Double budget;
    private String location;

    private Double carpetArea;
    private Double builtUpArea;
    private Double superBuiltUpArea;

    private String leadSource;
    private String status;

    @Column(length = 2000)
    private String additionalInformation;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getEnquiryDateTime() {
        return enquiryDateTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getCategory() {
        return category;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public String getOtherPropertyType() {
        return otherPropertyType;
    }

    public Double getBudget() {
        return budget;
    }

    public String getLocation() {
        return location;
    }

    public Double getCarpetArea() {
        return carpetArea;
    }

    public Double getBuiltUpArea() {
        return builtUpArea;
    }

    public Double getSuperBuiltUpArea() {
        return superBuiltUpArea;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public String getStatus() {
        return status;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEnquiryDateTime(String enquiryDateTime) {
        this.enquiryDateTime = enquiryDateTime;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public void setOtherPropertyType(String otherPropertyType) {
        this.otherPropertyType = otherPropertyType;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCarpetArea(Double carpetArea) {
        this.carpetArea = carpetArea;
    }

    public void setBuiltUpArea(Double builtUpArea) {
        this.builtUpArea = builtUpArea;
    }

    public void setSuperBuiltUpArea(Double superBuiltUpArea) {
        this.superBuiltUpArea = superBuiltUpArea;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}