package RealEstateLeadManager.repository;

import RealEstateLeadManager.entity.MessageTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageTemplateRepository
        extends JpaRepository<MessageTemplate, Long> {
}