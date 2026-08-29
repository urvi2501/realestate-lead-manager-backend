package RealEstateLeadManager.repository;

import RealEstateLeadManager.entity.FollowUp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowUpRepository
        extends JpaRepository<FollowUp, Long> {

    // Get all follow-ups for a particular lead
    List<FollowUp> findByLeadId(Long leadId);

}