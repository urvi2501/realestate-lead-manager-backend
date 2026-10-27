
package RealEstateLeadManager.service;

import RealEstateLeadManager.entity.Property;
import RealEstateLeadManager.repository.PropertyRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {

        this.propertyRepository = propertyRepository;
    }

    // =========================
    // CREATE
    // =========================

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    // =========================
    // GET ALL
    // =========================

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    // =========================
    // GET BY ID
    // =========================

    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    // =========================
    // UPDATE
    // =========================

    public Optional<Property> updateProperty(
            Long id,
            Property propertyDetails) {

        return propertyRepository.findById(id)

                .map(existingProperty -> {

                    // =========================
                    // BASIC DETAILS
                    // =========================

                    existingProperty.setPurpose(
                            propertyDetails.getPurpose());

                    existingProperty.setCategory(
                            propertyDetails.getCategory());

                    existingProperty.setPropertyType(
                            propertyDetails.getPropertyType());

                    // =========================
                    // LOCATION
                    // =========================

                    existingProperty.setCity(
                            propertyDetails.getCity());

                    existingProperty.setLocality(
                            propertyDetails.getLocality());

                    // =========================
                    // AREA
                    // =========================

                    existingProperty.setCarpetArea(
                            propertyDetails.getCarpetArea());

                    existingProperty.setBuiltUpArea(
                            propertyDetails.getBuiltUpArea());

                    existingProperty.setSuperBuiltUpArea(
                            propertyDetails.getSuperBuiltUpArea());

                    // =========================
                    // RESIDENTIAL DETAILS
                    // =========================

                    existingProperty.setBedrooms(
                            propertyDetails.getBedrooms());

                    existingProperty.setBathrooms(
                            propertyDetails.getBathrooms());

                    existingProperty.setBalconies(
                            propertyDetails.getBalconies());

                    existingProperty.setFurnishing(
                            propertyDetails.getFurnishing());

                    existingProperty.setPropertyFloor(
                            propertyDetails.getPropertyFloor());

                    existingProperty.setTotalFloors(
                            propertyDetails.getTotalFloors());

                    // =========================
                    // PARKING
                    // =========================

                    existingProperty.setParking(
                            propertyDetails.getParking());

                    existingProperty.setParkingType(
                            propertyDetails.getParkingType());

                    // =========================
                    // COMMERCIAL PROPERTY LEVEL
                    // =========================

                    existingProperty.setPropertyLevel(
                            propertyDetails.getPropertyLevel());

                    existingProperty.setSpecifyLevel(
                            propertyDetails.getSpecifyLevel());

                    // =========================
                    // OFFICE DETAILS
                    // =========================

                    existingProperty.setOfficeType(
                            propertyDetails.getOfficeType());

                    existingProperty.setMinSeats(
                            propertyDetails.getMinSeats());

                    existingProperty.setMaxSeats(
                            propertyDetails.getMaxSeats());

                    existingProperty.setCabins(
                            propertyDetails.getCabins());

                    existingProperty.setMeetingRooms(
                            propertyDetails.getMeetingRooms());

                    existingProperty.setWashrooms(
                            propertyDetails.getWashrooms());

                    existingProperty.setConferenceRoom(
                            propertyDetails.getConferenceRoom());

                    existingProperty.setReceptionArea(
                            propertyDetails.getReceptionArea());

                    existingProperty.setPantryType(
                            propertyDetails.getPantryType());

                    existingProperty.setCentralAirConditioning(
                            propertyDetails.getCentralAirConditioning());

                    // =========================
                    // ADDITIONAL COMMERCIAL
                    // =========================

                    existingProperty.setBasement(
                            propertyDetails.getBasement());

                    existingProperty.setLowerGround(
                            propertyDetails.getLowerGround());

                    existingProperty.setGround(
                            propertyDetails.getGround());

                    existingProperty.setLifts(
                            propertyDetails.getLifts());

                    // =========================
                    // PRICING
                    // =========================

                    existingProperty.setExpectedPrice(
                            propertyDetails.getExpectedPrice());

                    existingProperty.setDepositAmount(
                            propertyDetails.getDepositAmount());

                    existingProperty.setPricePerUnit(
                            propertyDetails.getPricePerUnit());

                    existingProperty.setPriceInWords(
                            propertyDetails.getPriceInWords());

                    existingProperty.setTaxAndGovtChargesExcluded(
                            propertyDetails.getTaxAndGovtChargesExcluded());

                    existingProperty.setDgUpsPriceIncluded(
                            propertyDetails.getDgUpsPriceIncluded());

                    existingProperty.setPriceNegotiable(
                            propertyDetails.getPriceNegotiable());

                    existingProperty.setAdditionalPricingDetails(
                            propertyDetails.getAdditionalPricingDetails());

                    // =========================
                    // AVAILABILITY
                    // =========================

                    existingProperty.setAvailabilityStatus(
                            propertyDetails.getAvailabilityStatus());

                    // =========================
                    // PRE-LEASE / PRE-RENT
                    // =========================

                    existingProperty.setPreLeasedOrPreRented(
                            propertyDetails.getPreLeasedOrPreRented());

                    // =========================
                    // DESCRIPTION
                    // =========================

                    existingProperty.setDescription(
                            propertyDetails.getDescription());

                            existingProperty.setOwnerName(
        propertyDetails.getOwnerName());

existingProperty.setOwnerContactDetails(
        propertyDetails.getOwnerContactDetails());

                    return propertyRepository.save(existingProperty);
                });
    }

    // =========================
    // DELETE
    // =========================

    public boolean deleteProperty(Long id) {

        if (!propertyRepository.existsById(id)) {
            return false;
        }
        propertyRepository.deleteById(id);

        return true;
    }
}


