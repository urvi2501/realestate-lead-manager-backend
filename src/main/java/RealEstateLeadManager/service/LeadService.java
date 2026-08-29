
package RealEstateLeadManager.service;

import RealEstateLeadManager.entity.Customer;
import RealEstateLeadManager.entity.FollowUp;
import RealEstateLeadManager.entity.Lead;
import RealEstateLeadManager.repository.CustomerRepository;
import RealEstateLeadManager.repository.FollowUpRepository;
import RealEstateLeadManager.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    private final LeadRepository leadRepository;
    private final CustomerRepository customerRepository;
    private final FollowUpRepository followUpRepository;

    public LeadService(
            LeadRepository leadRepository,
            CustomerRepository customerRepository,
            FollowUpRepository followUpRepository) {

        this.leadRepository = leadRepository;
        this.customerRepository = customerRepository;
        this.followUpRepository = followUpRepository;
    }

    // Create Lead
    public Lead createLead(Lead lead) {

        Lead savedLead = leadRepository.save(lead);

        // Automatically create Follow-Up when date is provided
        if (savedLead.getFollowUpDate() != null) {

            FollowUp followUp = new FollowUp(
                    savedLead.getId(),
                    savedLead.getFollowUpDate(),
                    "Follow-up for " + savedLead.getName(),
                    "PENDING"
            );

            followUpRepository.save(followUp);
        }

        return savedLead;
    }

    // Get all Leads
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    // Get Lead by ID
    public Lead getLeadById(Long id) {
        return leadRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Lead not found with ID: " + id
                        ));
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

        Lead savedLead = leadRepository.save(existingLead);

        // Update/create Follow-Up when date is provided
        if (savedLead.getFollowUpDate() != null) {

            List<FollowUp> existingFollowUps =
                    followUpRepository.findByLeadId(savedLead.getId());

            if (existingFollowUps.isEmpty()) {

                FollowUp followUp = new FollowUp(
                        savedLead.getId(),
                        savedLead.getFollowUpDate(),
                        "Follow-up for " + savedLead.getName(),
                        "PENDING"
                );

                followUpRepository.save(followUp);

            } else {

                FollowUp followUp = existingFollowUps.get(0);

                followUp.setFollowUpDate(
                        savedLead.getFollowUpDate());

                followUp.setNotes(
                        "Follow-up for " + savedLead.getName());

                followUpRepository.save(followUp);
            }

        } else {

            // If follow-up date is removed from Lead,
            // remove its existing Follow-Up records.
            List<FollowUp> existingFollowUps =
                    followUpRepository.findByLeadId(savedLead.getId());

            if (!existingFollowUps.isEmpty()) {
                followUpRepository.deleteAll(existingFollowUps);
            }
        }

        return savedLead;
    }

    // Delete Lead
    public void deleteLead(Long id) {

        Lead existingLead = getLeadById(id);

        // Delete related follow-ups first
        List<FollowUp> existingFollowUps =
                followUpRepository.findByLeadId(id);

        if (!existingFollowUps.isEmpty()) {
            followUpRepository.deleteAll(existingFollowUps);
        }

        leadRepository.delete(existingLead);
    }

    // Convert Lead to Customer
    public Customer convertLeadToCustomer(Long id) {

        Lead lead = getLeadById(id);

        Customer customer = new Customer();

        customer.setName(lead.getName());
        customer.setPhone(lead.getPhone());
        customer.setEmail(lead.getEmail());

        // Lead location → Customer address
        customer.setAddress(lead.getLocation());

        customer.setPropertyType(lead.getPropertyType());
        customer.setBudget(lead.getBudget());

        customer.setStatus("Converted");

        Customer savedCustomer =
                customerRepository.save(customer);

        // Update Lead status
        lead.setStatus("Converted");

        leadRepository.save(lead);

        return savedCustomer;
    }
}
