package RealEstateLeadManager.controller;

import RealEstateLeadManager.entity.MessageTemplate;
import RealEstateLeadManager.repository.MessageTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
@CrossOrigin(origins = {"http://localhost:5173", "https://realestate-lead-manager-production.up.railway.app"})
public class MessageTemplateController {

    @Autowired
    private MessageTemplateRepository templateRepository;

    @GetMapping
    public List<MessageTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }

    @PostMapping
    public MessageTemplate createTemplate(
            @RequestBody MessageTemplate template) {

        return templateRepository.save(template);
    }

    @PutMapping("/{id}")
    public MessageTemplate updateTemplate(
            @PathVariable Long id,
            @RequestBody MessageTemplate template) {

        MessageTemplate existing =
                templateRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Template not found"));

        existing.setName(template.getName());
        existing.setType(template.getType());
        existing.setMessage(template.getMessage());

        return templateRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public String deleteTemplate(@PathVariable Long id) {

        templateRepository.deleteById(id);

        return "Template deleted successfully";
    }
}
