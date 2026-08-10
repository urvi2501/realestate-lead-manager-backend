package RealEstateLeadManager.controller;

import RealEstateLeadManager.entity.Lead;
import RealEstateLeadManager.service.LeadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "http://localhost:5173")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Lead> createLead(@RequestBody Lead lead) {
        return new ResponseEntity<>(
                leadService.createLead(lead),
                HttpStatus.CREATED
        );
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Lead>> getAllLeads() {
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable Long id) {
        return ResponseEntity.ok(leadService.getLeadById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(
            @PathVariable Long id,
            @RequestBody Lead lead) {

        return ResponseEntity.ok(
                leadService.updateLead(id, lead)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLead(@PathVariable Long id) {

        leadService.deleteLead(id);

        return ResponseEntity.ok("Lead deleted successfully");
    }
}