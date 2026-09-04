package RealEstateLeadManager.controller;

import RealEstateLeadManager.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = {"http://localhost:5173", "https://realestate-lead-manager-production.up.railway.app"})
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String message) {

        try {
            emailService.sendEmail(to, subject, message);

            return ResponseEntity.ok("Email sent successfully");

        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Failed to send email: " + e.getMessage());
        }
    }
}
