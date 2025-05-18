package rjkscore.infrastructure.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rjkscore.application.service.AuthService;
import rjkscore.infrastructure.Dto.Request.RegisterRequestDto;
import rjkscore.infrastructure.Dto.Response.AppUserResponseDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AppUserResponseDto> register(@RequestBody RegisterRequestDto request) {
        AppUserResponseDto response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
