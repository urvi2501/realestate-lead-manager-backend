package RealEstateLeadManager.service;

import RealEstateLeadManager.entity.Lead;
import RealEstateLeadManager.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    // Create Lead
    public Lead createLead(Lead lead) {
        return leadRepository.save(lead);
    }

    // Get all Leads
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    // Get Lead by ID
    public Lead getLeadById(Long id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found with ID: " + id));
    }

    // Update Lead
    public Lead updateLead(Long id, Lead updatedLead) {

        Lead existingLead = getLeadById(id);

        existingLead.setName(updatedLead.getName());
        existingLead.setPhone(updatedLead.getPhone());
        existingLead.setEmail(updatedLead.getEmail());
        existingLead.setPropertyType(updatedLead.getPropertyType());
        existingLead.setBudget(updatedLead.getBudget());
        existingLead.setLocation(updatedLead.getLocation());
        existingLead.setLeadSource(updatedLead.getLeadSource());
        existingLead.setStatus(updatedLead.getStatus());
        existingLead.setFollowUpDate(updatedLead.getFollowUpDate());

        return leadRepository.save(existingLead);
    }

    // Delete Lead
    public void deleteLead(Long id) {
        Lead existingLead = getLeadById(id);
        leadRepository.delete(existingLead);
    }
}