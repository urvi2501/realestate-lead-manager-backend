
package RealEstateLeadManager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // BASIC PROPERTY DETAILS
    // =========================

    private String purpose;
    private String category;
    private String propertyType;

    // =========================
    // LOCATION
    // =========================

    private String city;
    private String locality;

    // =========================
    // AREA DETAILS
    // =========================

    private Double carpetArea;
    private Double builtUpArea;
    private Double superBuiltUpArea;

    // =========================
    // RESIDENTIAL DETAILS
    // =========================

    private Integer bedrooms;
    private Integer bathrooms;
    private Integer balconies;
    private Integer totalFloors;
    private Integer propertyFloor;
    private String furnishing;

    // =========================
    // PARKING
    // =========================

    private String parking;
    private String parkingType;

    // =========================
    // COMMERCIAL PROPERTY LEVEL
    // =========================

    private String propertyLevel;
    private String specifyLevel;

    // =========================
    // COMMERCIAL OFFICE DETAILS
    // =========================

    private String officeType;
    private Integer minSeats;
    private Integer maxSeats;
    private Integer cabins;
    private Integer meetingRooms;
    private String washrooms;
    private String conferenceRoom;
    private String receptionArea;
    private String pantryType;
    private String centralAirConditioning;

    private String basement;
    private String lowerGround;
    private String ground;
    private String lifts;

    // =========================
    // PRICING DETAILS
    // =========================

    private Double expectedPrice;
    private Double depositAmount;
    private Double pricePerUnit;

    @Column(length = 1000)
    private String priceInWords;

    private Boolean taxAndGovtChargesExcluded;
    private Boolean dgUpsPriceIncluded;
    private Boolean priceNegotiable;

    @Column(length = 2000)
    private String additionalPricingDetails;

    // =========================
    // AVAILABILITY
    // =========================

    private String availabilityStatus;

    // =========================
    // PRE-LEASE / PRE-RENT
    // =========================

    private String preLeasedOrPreRented;

    // =========================
    // DESCRIPTION
    // =========================

    @Column(length = 5000)
    private String description;

    // =========================
    // CONSTRUCTORS
    // =========================

    public Property() {
    }

    // =========================
    // GETTERS AND SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
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

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getBalconies() {
        return balconies;
    }

    public void setBalconies(Integer balconies) {
        this.balconies = balconies;
    }

    public Integer getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(Integer totalFloors) {
        this.totalFloors = totalFloors;
    }

    public Integer getPropertyFloor() {
        return propertyFloor;
    }

    public void setPropertyFloor(Integer propertyFloor) {
        this.propertyFloor = propertyFloor;
    }

    public String getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(String furnishing) {
        this.furnishing = furnishing;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getParkingType() {
        return parkingType;
    }

    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }

    public String getPropertyLevel() {
        return propertyLevel;
    }

    public void setPropertyLevel(String propertyLevel) {
        this.propertyLevel = propertyLevel;
    }

    public String getSpecifyLevel() {
        return specifyLevel;
    }

    public void setSpecifyLevel(String specifyLevel) {
        this.specifyLevel = specifyLevel;
    }

    public String getOfficeType() {
        return officeType;
    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }

    public Integer getMinSeats() {
        return minSeats;
    }

    public void setMinSeats(Integer minSeats) {
        this.minSeats = minSeats;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Integer getCabins() {
        return cabins;
    }

    public void setCabins(Integer cabins) {
        this.cabins = cabins;
    }

    public Integer getMeetingRooms() {
        return meetingRooms;
    }

    public void setMeetingRooms(Integer meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

    public String getWashrooms() {
        return washrooms;
    }

    public void setWashrooms(String washrooms) {
        this.washrooms = washrooms;
    }

    public String getConferenceRoom() {
        return conferenceRoom;
    }

    public void setConferenceRoom(String conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }

    public String getReceptionArea() {
        return receptionArea;
    }

    public void setReceptionArea(String receptionArea) {
        this.receptionArea = receptionArea;
    }

    public String getPantryType() {
        return pantryType;
    }

    public void setPantryType(String pantryType) {
        this.pantryType = pantryType;
    }

    public String getCentralAirConditioning() {
        return centralAirConditioning;
    }

    public void setCentralAirConditioning(String centralAirConditioning) {
        this.centralAirConditioning = centralAirConditioning;
    }

    public String getBasement() {
        return basement;
    }

    public void setBasement(String basement) {
        this.basement = basement;
    }

    public String getLowerGround() {
        return lowerGround;
    }

    public void setLowerGround(String lowerGround) {
        this.lowerGround = lowerGround;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public String getLifts() {
        return lifts;
    }

    public void setLifts(String lifts) {
        this.lifts = lifts;
    }

    public Double getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(Double expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getPriceInWords() {
        return priceInWords;
    }

    public void setPriceInWords(String priceInWords) {
        this.priceInWords = priceInWords;
    }

    public Boolean getTaxAndGovtChargesExcluded() {
        return taxAndGovtChargesExcluded;
    }

    public void setTaxAndGovtChargesExcluded(Boolean taxAndGovtChargesExcluded) {
        this.taxAndGovtChargesExcluded = taxAndGovtChargesExcluded;
    }

    public Boolean getDgUpsPriceIncluded() {
        return dgUpsPriceIncluded;
    }

    public void setDgUpsPriceIncluded(Boolean dgUpsPriceIncluded) {
        this.dgUpsPriceIncluded = dgUpsPriceIncluded;
    }

    public Boolean getPriceNegotiable() {
        return priceNegotiable;
    }

    public void setPriceNegotiable(Boolean priceNegotiable) {
        this.priceNegotiable = priceNegotiable;
    }

    public String getAdditionalPricingDetails() {
        return additionalPricingDetails;
    }

    public void setAdditionalPricingDetails(String additionalPricingDetails) {
        this.additionalPricingDetails = additionalPricingDetails;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getPreLeasedOrPreRented() {
        return preLeasedOrPreRented;
    }

    public void setPreLeasedOrPreRented(String preLeasedOrPreRented) {
        this.preLeasedOrPreRented = preLeasedOrPreRented;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

