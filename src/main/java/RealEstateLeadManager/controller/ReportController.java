package RealEstateLeadManager.controller;

import RealEstateLeadManager.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = {"http://localhost:5173", "https://realestate-lead-manager-production.up.railway.app"})
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // =========================================================
    // BASIC REPORT
    // =========================================================

    @GetMapping
    public ResponseEntity<Map<String, Long>> getBasicReport() {

        return ResponseEntity.ok(
                reportService.getBasicReport()
        );
    }

    // =========================================================
    // LEAD STATUS REPORT
    // =========================================================

    @GetMapping("/status")
    public ResponseEntity<Map<String, Long>> getLeadStatusReport() {

        return ResponseEntity.ok(
                reportService.getLeadStatusReport()
        );
    }

    // =========================================================
    // LEAD SOURCE REPORT
    // =========================================================

    @GetMapping("/source")
    public ResponseEntity<Map<String, Long>> getLeadSourceReport() {

        return ResponseEntity.ok(
                reportService.getLeadSourceReport()
        );
    }

    // =========================================================
    // PROPERTY TYPE REPORT
    // =========================================================

    @GetMapping("/property-type")
    public ResponseEntity<Map<String, Long>> getPropertyTypeReport() {

        return ResponseEntity.ok(
                reportService.getPropertyTypeReport()
        );
    }

    // =========================================================
    // LOCATION REPORT
    // =========================================================

    @GetMapping("/location")
    public ResponseEntity<Map<String, Long>> getLocationReport() {

        return ResponseEntity.ok(
                reportService.getLocationReport()
        );
    }

    // =========================================================
    // BUDGET REPORT
    // =========================================================

    @GetMapping("/budget")
    public ResponseEntity<Map<String, Long>> getBudgetRangeReport() {

        return ResponseEntity.ok(
                reportService.getBudgetRangeReport()
        );
    }

    // =========================================================
    // FOLLOW-UP STATUS REPORT
    // =========================================================

    @GetMapping("/followup-status")
    public ResponseEntity<Map<String, Long>> getFollowUpStatusReport() {

        return ResponseEntity.ok(
                reportService.getFollowUpStatusReport()
        );
    }

    // =========================================================
    // FOLLOW-UP DATE REPORT
    // =========================================================

    @GetMapping("/followup-date")
    public ResponseEntity<Map<String, Long>> getFollowUpDateReport() {

        return ResponseEntity.ok(
                reportService.getFollowUpDateReport()
        );
    }

    // =========================================================
    // LEAD CONVERSION REPORT
    // =========================================================

    @GetMapping("/conversion")
    public ResponseEntity<Map<String, Long>> getLeadConversionReport() {

        return ResponseEntity.ok(
                reportService.getLeadConversionReport()
        );
    }

    // =========================================================
    // CUSTOMER STATUS REPORT
    // =========================================================

    @GetMapping("/customer-status")
    public ResponseEntity<Map<String, Long>> getCustomerStatusReport() {

        return ResponseEntity.ok(
                reportService.getCustomerStatusReport()
        );
    }
}
