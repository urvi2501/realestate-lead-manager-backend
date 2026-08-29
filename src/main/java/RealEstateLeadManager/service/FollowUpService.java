package RealEstateLeadManager.service;

import RealEstateLeadManager.entity.FollowUp;
import RealEstateLeadManager.repository.FollowUpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowUpService {

    private final FollowUpRepository followUpRepository;

    public FollowUpService(FollowUpRepository followUpRepository) {
        this.followUpRepository = followUpRepository;
    }

    // CREATE
    public FollowUp createFollowUp(FollowUp followUp) {
        return followUpRepository.save(followUp);
    }

    // GET ALL
    public List<FollowUp> getAllFollowUps() {
        return followUpRepository.findAll();
    }

    // GET BY ID
    public Optional<FollowUp> getFollowUpById(Long id) {
        return followUpRepository.findById(id);
    }

    // GET BY LEAD ID
    public List<FollowUp> getFollowUpsByLeadId(Long leadId) {
        return followUpRepository.findByLeadId(leadId);
    }

    // UPDATE
    public Optional<FollowUp> updateFollowUp(
            Long id,
            FollowUp followUpDetails) {

        return followUpRepository.findById(id)
                .map(existingFollowUp -> {

                    existingFollowUp.setLeadId(
                            followUpDetails.getLeadId());

                    existingFollowUp.setFollowUpDate(
                            followUpDetails.getFollowUpDate());

                    existingFollowUp.setNotes(
                            followUpDetails.getNotes());

                    existingFollowUp.setStatus(
                            followUpDetails.getStatus());

                    return followUpRepository.save(
                            existingFollowUp);
                });
    }

    // DELETE
    public boolean deleteFollowUp(Long id) {

        if (!followUpRepository.existsById(id)) {
            return false;
        }

        followUpRepository.deleteById(id);

        return true;
    }
}