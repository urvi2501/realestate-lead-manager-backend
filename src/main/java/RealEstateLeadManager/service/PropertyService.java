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

    // CREATE
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    // GET ALL
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    // GET BY ID
    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    // UPDATE
    public Optional<Property> updateProperty(
            Long id,
            Property propertyDetails) {

        return propertyRepository.findById(id)
                .map(existingProperty -> {

                    existingProperty.setTitle(
                            propertyDetails.getTitle());

                    existingProperty.setPropertyType(
                            propertyDetails.getPropertyType());

                    existingProperty.setLocation(
                            propertyDetails.getLocation());

                    existingProperty.setPrice(
                            propertyDetails.getPrice());

                    existingProperty.setBedrooms(
                            propertyDetails.getBedrooms());

                    existingProperty.setBathrooms(
                            propertyDetails.getBathrooms());

                    existingProperty.setArea(
                            propertyDetails.getArea());

                    existingProperty.setStatus(
                            propertyDetails.getStatus());

                    return propertyRepository.save(existingProperty);
                });
    }

    // DELETE
    public boolean deleteProperty(Long id) {

        if (!propertyRepository.existsById(id)) {
            return false;
        }

        propertyRepository.deleteById(id);
        return true;
    }
}