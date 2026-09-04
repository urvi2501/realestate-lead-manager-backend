package RealEstateLeadManager.controller;

import RealEstateLeadManager.service.AnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = {"http://localhost:5173", "https://realestate-lead-manager-production.up.railway.app"})
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    // =========================================================
    // ANALYTICS OVERVIEW
    // =========================================================

    @GetMapping("/overview")
    public ResponseEntity<Map<String, Long>> getOverview() {

        return ResponseEntity.ok(
                analyticsService.getOverview()
        );
    }

    // =========================================================
// LEAD STATUS ANALYTICS
// =========================================================

@GetMapping("/status")
public ResponseEntity<Map<String, Long>> getLeadStatusAnalytics() {

    return ResponseEntity.ok(
            analyticsService.getLeadStatusAnalytics()
    );
}

// =========================================================
// PROPERTY TYPE ANALYTICS
// =========================================================

@GetMapping("/property-type")
public ResponseEntity<Map<String, Long>> getPropertyTypeAnalytics() {

    return ResponseEntity.ok(
            analyticsService.getPropertyTypeAnalytics()
    );
}

// =========================================================
// LEAD SOURCE ANALYTICS
// =========================================================

@GetMapping("/source")
public ResponseEntity<Map<String, Long>> getLeadSourceAnalytics() {

    return ResponseEntity.ok(
            analyticsService.getLeadSourceAnalytics()
    );
}
// =========================================================
// BUDGET ANALYTICS
// =========================================================

@GetMapping("/budget")
public ResponseEntity<Map<String, Double>> getBudgetAnalytics() {

    return ResponseEntity.ok(
            analyticsService.getBudgetAnalytics()
    );
}
// =========================================================
// CONVERSION RATE ANALYTICS
// =========================================================

@GetMapping("/conversion-rate")
public ResponseEntity<Map<String, Double>> getConversionRateAnalytics() {

    return ResponseEntity.ok(
            analyticsService.getConversionRateAnalytics()
    );
}
// =========================================================
// FOLLOW-UP ANALYTICS
// =========================================================

@GetMapping("/follow-ups")
public ResponseEntity<Map<String, Long>> getFollowUpAnalytics() {

    return ResponseEntity.ok(
            analyticsService.getFollowUpAnalytics()
    );
}
}
