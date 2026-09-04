package RealEstateLeadManager.controller;

import RealEstateLeadManager.entity.Property;
import RealEstateLeadManager.service.PropertyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = {"http://localhost:5173", "https://realestate-lead-manager-production.up.railway.app"})
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // CREATE PROPERTY
    @PostMapping
    public ResponseEntity<Property> createProperty(
            @RequestBody Property property) {

        return ResponseEntity.ok(
                propertyService.createProperty(property)
        );
    }

    // GET ALL PROPERTIES
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {

        return ResponseEntity.ok(
                propertyService.getAllProperties()
        );
    }

    // GET PROPERTY BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(
            @PathVariable Long id) {

        return propertyService.getPropertyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE PROPERTY
    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(
            @PathVariable Long id,
            @RequestBody Property propertyDetails) {

        return propertyService
                .updateProperty(id, propertyDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE PROPERTY
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(
            @PathVariable Long id) {

        boolean deleted =
                propertyService.deleteProperty(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
