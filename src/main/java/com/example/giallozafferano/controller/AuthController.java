package com.example.giallozafferano.controller;

import com.example.giallozafferano.model.dto.RegisterRequest;
import com.example.giallozafferano.model.entity.Role;
import com.example.giallozafferano.model.entity.User;
import com.example.giallozafferano.repository.UserRepository;
import com.example.giallozafferano.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.webauthn.api.AuthenticatorResponse;
import com.example.giallozafferano.model.dto.AuthRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            System.out.println("Tentativo di login per utente: " + request.getUsername());

            // Step 1: Esegui autenticazione
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            System.out.println("Autenticazione riuscita!");

            // Step 2: Recupera utente e genera il token JWT
            UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
            String token = jwtService.generateToken(user.getUsername());

            // Step 3: Ritorna il token al client
            return ResponseEntity.ok(token);
        } catch (UsernameNotFoundException e) {
            System.err.println("Errore: utente non trovato: " + e.getMessage());
            return ResponseEntity.status(401).body("Utente non trovato");
        } catch (Exception e) {
            // Catch di qualsiasi altro errore durante il login
            System.err.println("Errore durante il login: " + e.getMessage());
            return ResponseEntity.status(401).body("Credenziali non valide");
        }
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        if(userRepository.findByUsername(request.getUsername()).isPresent()){
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        System.out.println("Registrando password codificata: " + encodedPassword); // LOG: verifica la password codificata

        User newUser = User.builder()
                .username(request.getUsername())
                .password(encodedPassword)
                .role(request.getRole() == null ? Role.USER : request.getRole())
                .build();
        userRepository.save(newUser);

        return ResponseEntity.ok("Registration successful");
    }



}
