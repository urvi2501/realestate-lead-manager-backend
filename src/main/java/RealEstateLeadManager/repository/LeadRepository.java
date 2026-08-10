package RealEstateLeadManager.repository;

import RealEstateLeadManager.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}