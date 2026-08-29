package RealEstateLeadManager.controller;

import RealEstateLeadManager.entity.User;
import RealEstateLeadManager.repository.UserRepository;
import RealEstateLeadManager.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

 public AuthController(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        JwtService jwtService) {

    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
}
   
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {

        Optional<User> user = userRepository.findByEmail(loginUser.getEmail());

        if (user.isPresent()
                && passwordEncoder.matches(
    loginUser.getPassword(),
    user.get().getPassword()
)) {

            String token = jwtService.generateToken(
        user.get().getEmail(),
        user.get().getRole()
);

return ResponseEntity.ok(token);
        }

        return ResponseEntity
                .status(401)
                .body("Invalid email or password");
    }

@PostMapping("/create-test-user")
public ResponseEntity<String> createTestUser() {

    User user = new User();

    user.setName("Test User");
    user.setEmail("user@gmail.com");
    user.setPassword(passwordEncoder.encode("user123"));
    user.setRole("USER");

    userRepository.save(user);

    return ResponseEntity.ok("Test USER created successfully");
}
   
}