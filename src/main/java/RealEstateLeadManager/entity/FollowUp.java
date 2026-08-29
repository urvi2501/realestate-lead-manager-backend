package RealEstateLeadManager.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "follow_ups")
public class FollowUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Lead ID to which this follow-up belongs
    private Long leadId;

    // Follow-up date
    private LocalDate followUpDate;

    // Follow-up notes
    private String notes;

    // Status: PENDING, COMPLETED, CANCELLED
    private String status;

    // Default constructor
    public FollowUp() {
    }

    // Constructor
    public FollowUp(
            Long leadId,
            LocalDate followUpDate,
            String notes,
            String status) {

        this.leadId = leadId;
        this.followUpDate = followUpDate;
        this.notes = notes;
        this.status = status;
    }

    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Lead ID
    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }

    // Follow-up Date
    public LocalDate getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(LocalDate followUpDate) {
        this.followUpDate = followUpDate;
    }

    // Notes
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}