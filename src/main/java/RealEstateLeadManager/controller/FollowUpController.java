package RealEstateLeadManager.controller;

import RealEstateLeadManager.entity.FollowUp;
import RealEstateLeadManager.service.FollowUpService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/followups")
@CrossOrigin(origins = {"http://localhost:5173", "https://realestate-lead-manager-production.up.railway.app"})
public class FollowUpController {

    private final FollowUpService followUpService;

    public FollowUpController(FollowUpService followUpService) {
        this.followUpService = followUpService;
    }

    // =========================================================
    // CREATE FOLLOW-UP
    // =========================================================

    @PostMapping
    public ResponseEntity<FollowUp> createFollowUp(
            @RequestBody FollowUp followUp) {

        return ResponseEntity.ok(
                followUpService.createFollowUp(followUp)
        );
    }

    // =========================================================
    // GET ALL FOLLOW-UPS
    // =========================================================

    @GetMapping
    public ResponseEntity<List<FollowUp>> getAllFollowUps() {

        return ResponseEntity.ok(
                followUpService.getAllFollowUps()
        );
    }

    // =========================================================
    // GET FOLLOW-UP BY ID
    // =========================================================

    @GetMapping("/{id}")
    public ResponseEntity<FollowUp> getFollowUpById(
            @PathVariable Long id) {

        return followUpService.getFollowUpById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // =========================================================
    // GET FOLLOW-UPS BY LEAD ID
    // =========================================================

    @GetMapping("/lead/{leadId}")
    public ResponseEntity<List<FollowUp>> getFollowUpsByLeadId(
            @PathVariable Long leadId) {

        return ResponseEntity.ok(
                followUpService.getFollowUpsByLeadId(leadId)
        );
    }

    // =========================================================
    // UPDATE FOLLOW-UP
    // =========================================================

    @PutMapping("/{id}")
    public ResponseEntity<FollowUp> updateFollowUp(
            @PathVariable Long id,
            @RequestBody FollowUp followUpDetails) {

        return followUpService
                .updateFollowUp(id, followUpDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // =========================================================
    // DELETE FOLLOW-UP
    // =========================================================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollowUp(
            @PathVariable Long id) {

        boolean deleted =
                followUpService.deleteFollowUp(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
