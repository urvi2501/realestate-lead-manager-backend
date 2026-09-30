package RealEstateLeadManager.service;

import RealEstateLeadManager.entity.Customer;
import RealEstateLeadManager.entity.FollowUp;
import RealEstateLeadManager.entity.Lead;
import RealEstateLeadManager.repository.CustomerRepository;
import RealEstateLeadManager.repository.FollowUpRepository;
import RealEstateLeadManager.repository.LeadRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    // =========================
    // Create Lead
    // =========================

    public Lead createLead(Lead lead) {

        // Automatically set enquiry date and time
        // when a new Lead is created.
        if (lead.getEnquiryDateTime() == null) {
            lead.setEnquiryDateTime(LocalDateTime.now());
        }

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


    // =========================
    // Get all Leads
    // =========================

    public List<Lead> getAllLeads() {

        return leadRepository.findAll();
    }


    // =========================
    // Get Lead by ID
    // =========================

    public Lead getLeadById(Long id) {

        return leadRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Lead not found with ID: " + id
                        ));
    }


    // =========================
    // Update Lead
    // =========================

    public Lead updateLead(Long id, Lead updatedLead) {

        Lead existingLead = getLeadById(id);

        existingLead.setName(updatedLead.getName());

        existingLead.setPhone(updatedLead.getPhone());

        existingLead.setEmail(updatedLead.getEmail());

        // Keep original enquiry date/time.
        // It should represent when the enquiry was first created.
        if (existingLead.getEnquiryDateTime() == null) {

            existingLead.setEnquiryDateTime(
                    updatedLead.getEnquiryDateTime() != null
                            ? updatedLead.getEnquiryDateTime()
                            : LocalDateTime.now()
            );
        }

        // Property requirement
        existingLead.setPurpose(updatedLead.getPurpose());

        existingLead.setCategory(updatedLead.getCategory());

        existingLead.setPropertyType(
                updatedLead.getPropertyType()
        );

        existingLead.setOtherPropertyType(
                updatedLead.getOtherPropertyType()
        );

        // Budget
        existingLead.setBudget(updatedLead.getBudget());

        // Existing Location - unchanged
        existingLead.setLocation(updatedLead.getLocation());

        // Area requirement
        existingLead.setCarpetArea(
                updatedLead.getCarpetArea()
        );

        existingLead.setBuiltUpArea(
                updatedLead.getBuiltUpArea()
        );

        existingLead.setSuperBuiltUpArea(
                updatedLead.getSuperBuiltUpArea()
        );

        // Lead information
        existingLead.setLeadSource(
                updatedLead.getLeadSource()
        );

        existingLead.setStatus(
                updatedLead.getStatus()
        );

        existingLead.setFollowUpDate(
                updatedLead.getFollowUpDate()
        );

        existingLead.setAdditionalInformation(
                updatedLead.getAdditionalInformation()
        );

        Lead savedLead = leadRepository.save(existingLead);


        // =========================
        // Follow-Up handling
        // =========================

        if (savedLead.getFollowUpDate() != null) {

            List<FollowUp> existingFollowUps =
                    followUpRepository.findByLeadId(
                            savedLead.getId()
                    );

            if (existingFollowUps.isEmpty()) {

                FollowUp followUp = new FollowUp(
                        savedLead.getId(),
                        savedLead.getFollowUpDate(),
                        "Follow-up for " + savedLead.getName(),
                        "PENDING"
                );

                followUpRepository.save(followUp);

            } else {

                FollowUp followUp =
                        existingFollowUps.get(0);

                followUp.setFollowUpDate(
                        savedLead.getFollowUpDate()
                );

                followUp.setNotes(
                        "Follow-up for " + savedLead.getName()
                );

                followUpRepository.save(followUp);
            }

        } else {

            // If follow-up date is removed from Lead,
            // remove its existing Follow-Up records.

            List<FollowUp> existingFollowUps =
                    followUpRepository.findByLeadId(
                            savedLead.getId()
                    );

            if (!existingFollowUps.isEmpty()) {

                followUpRepository.deleteAll(
                        existingFollowUps
                );
            }
        }

        return savedLead;
    }


    // =========================
    // Delete Lead
    // =========================

    public void deleteLead(Long id) {

        Lead existingLead = getLeadById(id);

        // Delete related follow-ups first
        List<FollowUp> existingFollowUps =
                followUpRepository.findByLeadId(id);

        if (!existingFollowUps.isEmpty()) {

            followUpRepository.deleteAll(
                    existingFollowUps
            );
        }

        leadRepository.delete(existingLead);
    }


    // =========================
    // Convert Lead to Customer
    // =========================

   // =========================
// Convert Lead to Customer
// =========================

public Customer convertLeadToCustomer(Long id) {

    Lead lead = getLeadById(id);

    // Prevent duplicate customer creation
    if ("Converted".equalsIgnoreCase(lead.getStatus())) {
        throw new RuntimeException(
                "This lead has already been converted to a customer."
        );
    }

    Customer customer = new Customer();

    // =========================
    // Customer Information
    // =========================

    customer.setName(lead.getName());
    customer.setPhone(lead.getPhone());
    customer.setEmail(lead.getEmail());

    // Lead location → Customer address/location
    customer.setAddress(lead.getLocation());
    customer.setLocation(lead.getLocation());

    // =========================
    // Enquiry Information
    // =========================

    if (lead.getEnquiryDateTime() != null) {
        customer.setEnquiryDateTime(
                lead.getEnquiryDateTime().toString()
        );
    }

    // =========================
    // Property Requirement
    // =========================

    customer.setPurpose(lead.getPurpose());
    customer.setCategory(lead.getCategory());
    customer.setPropertyType(lead.getPropertyType());
    customer.setOtherPropertyType(
            lead.getOtherPropertyType()
    );

    // =========================
    // Area & Budget
    // =========================

    customer.setCarpetArea(
            lead.getCarpetArea()
    );

    customer.setBuiltUpArea(
            lead.getBuiltUpArea()
    );

    customer.setSuperBuiltUpArea(
            lead.getSuperBuiltUpArea()
    );

    customer.setBudget(
            lead.getBudget()
    );

    // =========================
    // Customer Tracking
    // =========================

    customer.setLeadSource(
            lead.getLeadSource()
    );

    // New customer starts as Active
    customer.setStatus("Active");

    // =========================
    // Additional Information
    // =========================

    customer.setAdditionalInformation(
            lead.getAdditionalInformation()
    );

    // Save Customer
    Customer savedCustomer =
            customerRepository.save(customer);

    // =========================
    // Mark Lead as Converted
    // =========================

    lead.setStatus("Converted");
    leadRepository.save(lead);

    return savedCustomer;
}
}