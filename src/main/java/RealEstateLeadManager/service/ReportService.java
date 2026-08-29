package RealEstateLeadManager.service;

import RealEstateLeadManager.repository.CustomerRepository;
import RealEstateLeadManager.repository.FollowUpRepository;
import RealEstateLeadManager.repository.LeadRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    private final LeadRepository leadRepository;
    private final CustomerRepository customerRepository;
    private final FollowUpRepository followUpRepository;

    public ReportService(
            LeadRepository leadRepository,
            CustomerRepository customerRepository,
            FollowUpRepository followUpRepository) {

        this.leadRepository = leadRepository;
        this.customerRepository = customerRepository;
        this.followUpRepository = followUpRepository;
    }

    public Map<String, Long> getBasicReport() {

        Map<String, Long> report = new HashMap<>();

        report.put("totalLeads", leadRepository.count());

        report.put("totalCustomers", customerRepository.count());

        report.put("totalFollowUps", followUpRepository.count());

        return report;
    }

    public Map<String, Long> getLeadStatusReport() {

    Map<String, Long> statusReport = new HashMap<>();

    leadRepository.findAll().forEach(lead -> {

        String status = lead.getStatus();

        if (status == null || status.trim().isEmpty()) {
            status = "UNKNOWN";
        }

        statusReport.put(
                status,
                statusReport.getOrDefault(status, 0L) + 1
        );
    });

    return statusReport;
}
public Map<String, Long> getLeadSourceReport() {

    Map<String, Long> sourceReport = new HashMap<>();

    leadRepository.findAll().forEach(lead -> {

        String source = lead.getLeadSource();

        if (source == null || source.trim().isEmpty()) {
            source = "UNKNOWN";
        }

        sourceReport.put(
                source,
                sourceReport.getOrDefault(source, 0L) + 1
        );
    });

    return sourceReport;
}
public Map<String, Long> getPropertyTypeReport() {

    Map<String, Long> propertyTypeReport = new HashMap<>();

    leadRepository.findAll().forEach(lead -> {

        String propertyType = lead.getPropertyType();

        if (propertyType == null || propertyType.trim().isEmpty()) {
            propertyType = "UNKNOWN";
        }

        propertyTypeReport.put(
                propertyType,
                propertyTypeReport.getOrDefault(propertyType, 0L) + 1
        );
    });

    return propertyTypeReport;
}
public Map<String, Long> getLocationReport() {

    Map<String, Long> locationReport = new HashMap<>();

    leadRepository.findAll().forEach(lead -> {

        String location = lead.getLocation();

        if (location == null || location.trim().isEmpty()) {
            location = "UNKNOWN";
        }

        locationReport.put(
                location,
                locationReport.getOrDefault(location, 0L) + 1
        );
    });

    return locationReport;
}
public Map<String, Long> getBudgetRangeReport() {

    Map<String, Long> budgetReport = new HashMap<>();

    leadRepository.findAll().forEach(lead -> {

        Double budget = lead.getBudget();

        String range;

        if (budget == null) {
            range = "UNKNOWN";
        } else if (budget < 25) {
            range = "Below 25L";
        } else if (budget < 50) {
            range = "25L - 50L";
        } else if (budget < 100) {
            range = "50L - 1Cr";
        } else {
            range = "Above 1Cr";
        }

        budgetReport.put(
                range,
                budgetReport.getOrDefault(range, 0L) + 1
        );
    });

    return budgetReport;
}
public Map<String, Long> getFollowUpStatusReport() {

    Map<String, Long> statusReport = new HashMap<>();

    followUpRepository.findAll().forEach(followUp -> {

        String status = followUp.getStatus();

        if (status == null || status.trim().isEmpty()) {
            status = "UNKNOWN";
        }

        statusReport.put(
                status,
                statusReport.getOrDefault(status, 0L) + 1
        );
    });

    return statusReport;
}
public Map<String, Long> getFollowUpDateReport() {

    Map<String, Long> report = new HashMap<>();

    LocalDate today = LocalDate.now();

    long overdue = followUpRepository.findAll()
            .stream()
            .filter(followUp ->
                    followUp.getFollowUpDate() != null &&
                    followUp.getFollowUpDate().isBefore(today))
            .count();

    long todayCount = followUpRepository.findAll()
            .stream()
            .filter(followUp ->
                    followUp.getFollowUpDate() != null &&
                    followUp.getFollowUpDate().isEqual(today))
            .count();

    long upcoming = followUpRepository.findAll()
            .stream()
            .filter(followUp ->
                    followUp.getFollowUpDate() != null &&
                    followUp.getFollowUpDate().isAfter(today))
            .count();

    report.put("OVERDUE", overdue);
    report.put("TODAY", todayCount);
    report.put("UPCOMING", upcoming);

    return report;
}
public Map<String, Long> getLeadConversionReport() {

    Map<String, Long> report = new HashMap<>();

    long totalLeads = leadRepository.count();

    long convertedLeads = leadRepository.findAll()
            .stream()
            .filter(lead ->
                    lead.getStatus() != null &&
                    lead.getStatus().equalsIgnoreCase("Converted"))
            .count();

    long pendingLeads = totalLeads - convertedLeads;

    report.put("totalLeads", totalLeads);
    report.put("convertedLeads", convertedLeads);
    report.put("pendingLeads", pendingLeads);

    return report;
}
public Map<String, Long> getCustomerStatusReport() {

    Map<String, Long> statusReport = new HashMap<>();

    customerRepository.findAll().forEach(customer -> {

        String status = customer.getStatus();

        if (status == null || status.trim().isEmpty()) {
            status = "UNKNOWN";
        }

        statusReport.put(
                status,
                statusReport.getOrDefault(status, 0L) + 1
        );
    });

    return statusReport;
}
}