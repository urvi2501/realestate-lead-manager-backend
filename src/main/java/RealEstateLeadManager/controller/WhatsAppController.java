package RealEstateLeadManager.controller;

import RealEstateLeadManager.service.WhatsAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/whatsapp")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://realestate-lead-manager-production.up.railway.app"
})
public class WhatsAppController {

    private final WhatsAppService whatsAppService;

    public WhatsAppController(WhatsAppService whatsAppService) {
        this.whatsAppService = whatsAppService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendWhatsApp(
            @RequestParam String to,
            @RequestParam String message) {

        try {
            whatsAppService.sendWhatsApp(to, message);

            return ResponseEntity.ok("WhatsApp message sent successfully");

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Failed to send WhatsApp message: " + e.getMessage());
        }
    }
}