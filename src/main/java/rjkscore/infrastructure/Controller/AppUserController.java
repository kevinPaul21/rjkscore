package rjkscore.infrastructure.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rjkscore.application.service.AppUserService;
import rjkscore.infrastructure.Dto.Request.CoinsUpdateDto;
import rjkscore.infrastructure.Dto.Request.UpdateUserDto;
import rjkscore.infrastructure.Dto.Response.AppUserResponseDto;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<AppUserResponseDto> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{userId}")
    public AppUserResponseDto getUserById(@PathVariable Long userId) {
        return service.getUserById(userId);
    }

    @PutMapping("/me")
    public ResponseEntity<AppUserResponseDto> updateCurrentUser(Principal principal, @RequestBody UpdateUserDto dto) {
        try {
            return ResponseEntity.ok(service.updateUser(principal.getName(), dto));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<AppUserResponseDto> updateUser(@PathVariable Long userId, @RequestBody UpdateUserDto dto) {
        try {
            return ResponseEntity.ok(service.updateUser(userId, dto));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/{userId}/coins")
    public ResponseEntity<AppUserResponseDto> updateCoins(@PathVariable long userId,
            @RequestBody CoinsUpdateDto coinsDto) {
        return ResponseEntity.ok(service.updateCoins(userId, coinsDto.getCoins()));

    }

}
