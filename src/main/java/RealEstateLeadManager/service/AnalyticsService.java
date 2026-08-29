package RealEstateLeadManager.service;

import RealEstateLeadManager.entity.Lead;
import RealEstateLeadManager.repository.CustomerRepository;
import RealEstateLeadManager.repository.FollowUpRepository;
import RealEstateLeadManager.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnalyticsService {

    private final LeadRepository leadRepository;
    private final CustomerRepository customerRepository;
    private final FollowUpRepository followUpRepository;

    public AnalyticsService(
            LeadRepository leadRepository,
            CustomerRepository customerRepository,
            FollowUpRepository followUpRepository) {

        this.leadRepository = leadRepository;
        this.customerRepository = customerRepository;
        this.followUpRepository = followUpRepository;
    }

    // =========================================================
    // ANALYTICS OVERVIEW
    // =========================================================

    public Map<String, Long> getOverview() {

        Map<String, Long> analytics = new HashMap<>();

        long totalLeads = leadRepository.count();

        long totalCustomers = customerRepository.count();

        long totalFollowUps = followUpRepository.count();

        long convertedLeads = leadRepository.findAll()
                .stream()
                .filter(lead ->
                        "Converted".equalsIgnoreCase(
                                lead.getStatus()
                        )
                )
                .count();

        analytics.put("totalLeads", totalLeads);
        analytics.put("totalCustomers", totalCustomers);
        analytics.put("totalFollowUps", totalFollowUps);
        analytics.put("convertedLeads", convertedLeads);

        return analytics;
    }

    // =========================================================
// LEAD STATUS ANALYTICS
// =========================================================

public Map<String, Long> getLeadStatusAnalytics() {

    Map<String, Long> statusAnalytics = new HashMap<>();

    leadRepository.findAll().forEach(lead -> {

        String status = lead.getStatus();

        if (status == null || status.trim().isEmpty()) {
            status = "UNKNOWN";
        }

        statusAnalytics.put(
                status,
                statusAnalytics.getOrDefault(status, 0L) + 1
        );
    });

    return statusAnalytics;
}
// =========================================================
// PROPERTY TYPE ANALYTICS
// =========================================================

public Map<String, Long> getPropertyTypeAnalytics() {

    Map<String, Long> propertyTypeAnalytics = new HashMap<>();

    leadRepository.findAll().forEach(lead -> {

        String propertyType = lead.getPropertyType();

        if (propertyType == null || propertyType.trim().isEmpty()) {
            propertyType = "UNKNOWN";
        }

        propertyTypeAnalytics.put(
                propertyType,
                propertyTypeAnalytics.getOrDefault(propertyType, 0L) + 1
        );
    });

    return propertyTypeAnalytics;
}
// =========================================================
// LEAD SOURCE ANALYTICS
// =========================================================

public Map<String, Long> getLeadSourceAnalytics() {

    Map<String, Long> sourceAnalytics = new HashMap<>();

    leadRepository.findAll().forEach(lead -> {

        String source = lead.getLeadSource();

        if (source == null || source.trim().isEmpty()) {
            source = "UNKNOWN";
        }

        sourceAnalytics.put(
                source,
                sourceAnalytics.getOrDefault(source, 0L) + 1
        );
    });

    return sourceAnalytics;
}

// =========================================================
// BUDGET ANALYTICS
// =========================================================

public Map<String, Double> getBudgetAnalytics() {

    Map<String, Double> budgetAnalytics = new HashMap<>();

    double totalBudget = 0;
    double minBudget = Double.MAX_VALUE;
    double maxBudget = Double.MIN_VALUE;
    long count = 0;

    for (Lead lead : leadRepository.findAll()) {

        if (lead.getBudget() != null) {

            double budget = lead.getBudget();

            totalBudget += budget;

            if (budget < minBudget) {
                minBudget = budget;
            }

            if (budget > maxBudget) {
                maxBudget = budget;
            }

            count++;
        }
    }

    double averageBudget = 0;

    if (count > 0) {
        averageBudget = totalBudget / count;
    } else {
        minBudget = 0;
        maxBudget = 0;
    }

    budgetAnalytics.put("totalBudget", totalBudget);
    budgetAnalytics.put("minimumBudget", minBudget);
    budgetAnalytics.put("maximumBudget", maxBudget);
    budgetAnalytics.put("averageBudget", averageBudget);

    return budgetAnalytics;
}
// =========================================================
// CONVERSION RATE ANALYTICS
// =========================================================

public Map<String, Double> getConversionRateAnalytics() {

    Map<String, Double> conversionAnalytics = new HashMap<>();

    long totalLeads = leadRepository.count();

    long convertedLeads = leadRepository.findAll()
            .stream()
            .filter(lead ->
                    "Converted".equalsIgnoreCase(
                            lead.getStatus()
                    )
            )
            .count();

    double conversionRate = 0.0;

    if (totalLeads > 0) {
        conversionRate =
                ((double) convertedLeads / totalLeads) * 100;
    }

    conversionAnalytics.put(
            "totalLeads",
            (double) totalLeads
    );

    conversionAnalytics.put(
            "convertedLeads",
            (double) convertedLeads
    );

    conversionAnalytics.put(
            "conversionRate",
            conversionRate
    );

    return conversionAnalytics;
}

// =========================================================
// FOLLOW-UP ANALYTICS
// =========================================================

public Map<String, Long> getFollowUpAnalytics() {

    Map<String, Long> followUpAnalytics = new HashMap<>();

    long total = followUpRepository.count();

    long pending = followUpRepository.findAll()
            .stream()
            .filter(followUp ->
                    "PENDING".equalsIgnoreCase(
                            followUp.getStatus()
                    )
            )
            .count();

    long completed = followUpRepository.findAll()
            .stream()
            .filter(followUp ->
                    "COMPLETED".equalsIgnoreCase(
                            followUp.getStatus()
                    )
            )
            .count();

    long cancelled = followUpRepository.findAll()
            .stream()
            .filter(followUp ->
                    "CANCELLED".equalsIgnoreCase(
                            followUp.getStatus()
                    )
            )
            .count();

    followUpAnalytics.put("totalFollowUps", total);
    followUpAnalytics.put("pending", pending);
    followUpAnalytics.put("completed", completed);
    followUpAnalytics.put("cancelled", cancelled);

    return followUpAnalytics;
}
}