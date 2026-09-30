package RealEstateLeadManager.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String email;

    // Enquiry date and time
    private LocalDateTime enquiryDateTime;

    // Property requirement
    private String purpose;          // Sell / Rent

    private String category;         // Residential / Commercial

    private String propertyType;

    private String otherPropertyType;

    // Budget
    private Double budget;

    // Existing Location field - kept unchanged
    private String location;

    // Area requirement
    private Double carpetArea;

    private Double builtUpArea;

    private Double superBuiltUpArea;

    // Lead information
    private String leadSource;

    private String status;

    private LocalDate followUpDate;

    // Additional information
    @Column(length = 2000)
    private String additionalInformation;


    // =========================
    // Getters and Setters
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getEnquiryDateTime() {
        return enquiryDateTime;
    }

    public void setEnquiryDateTime(LocalDateTime enquiryDateTime) {
        this.enquiryDateTime = enquiryDateTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getOtherPropertyType() {
        return otherPropertyType;
    }

    public void setOtherPropertyType(String otherPropertyType) {
        this.otherPropertyType = otherPropertyType;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getCarpetArea() {
        return carpetArea;
    }

    public void setCarpetArea(Double carpetArea) {
        this.carpetArea = carpetArea;
    }

    public Double getBuiltUpArea() {
        return builtUpArea;
    }

    public void setBuiltUpArea(Double builtUpArea) {
        this.builtUpArea = builtUpArea;
    }

    public Double getSuperBuiltUpArea() {
        return superBuiltUpArea;
    }

    public void setSuperBuiltUpArea(Double superBuiltUpArea) {
        this.superBuiltUpArea = superBuiltUpArea;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(LocalDate followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}