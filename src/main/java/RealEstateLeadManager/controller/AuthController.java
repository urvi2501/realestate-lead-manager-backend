package RealEstateLeadManager.controller;

import RealEstateLeadManager.entity.User;
import RealEstateLeadManager.repository.UserRepository;

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

    public AuthController(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder) {

    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
}
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {

        Optional<User> user = userRepository.findByEmail(loginUser.getEmail());

        if (user.isPresent()
                && passwordEncoder.matches(
    loginUser.getPassword(),
    user.get().getPassword()
)) {

            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity
                .status(401)
                .body("Invalid email or password");
    }


   
}