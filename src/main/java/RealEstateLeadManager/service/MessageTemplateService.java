package RealEstateLeadManager.service;

import RealEstateLeadManager.entity.MessageTemplate;
import RealEstateLeadManager.repository.MessageTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageTemplateService {

    private final MessageTemplateRepository repository;

    public MessageTemplateService(MessageTemplateRepository repository) {
        this.repository = repository;
    }

    public List<MessageTemplate> getAllTemplates() {
        return repository.findAll();
    }

    public MessageTemplate getTemplateById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MessageTemplate saveTemplate(MessageTemplate template) {
        return repository.save(template);
    }

    public void deleteTemplate(Long id) {
        repository.deleteById(id);
    }
}   