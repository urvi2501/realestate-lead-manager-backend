package RealEstateLeadManager.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class EmailService {

    @Value("${resend.api.key}")
    private String resendApiKey;

    @Value("${resend.from}")
    private String resendFrom;

    public void sendEmail(String to, String subject, String message) {

        String jsonBody = """
                {
                  "from": "%s",
                  "to": ["%s"],
                  "subject": "%s",
                  "text": "%s"
                }
                """.formatted(
                escapeJson(resendFrom),
                escapeJson(to),
                escapeJson(subject),
                escapeJson(message)
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.resend.com/emails"))
                .header("Authorization", "Bearer " + resendApiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                throw new RuntimeException(
                        "Resend email failed: " + response.body()
                );
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(
                    "Failed to connect to Resend: " + e.getMessage(), e
            );
        }
    }

    private String escapeJson(String value) {
        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}