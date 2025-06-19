package rjkscore.infrastructure.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rjkscore.application.service.FavoriteService;
import rjkscore.infrastructure.Dto.Request.FavoriteRequestDto;
import rjkscore.infrastructure.Dto.Response.FavoriteResponseDto;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public List<FavoriteResponseDto> getFavorites(Principal principal) {
        return favoriteService.getFavorites(principal.getName());
    }

    @PostMapping
    public ResponseEntity<FavoriteResponseDto> addFavorite(@RequestBody FavoriteRequestDto dto,
                                                           Principal principal) {
        return ResponseEntity.ok(favoriteService.addFavorite(principal.getName(), dto));
    }

    @DeleteMapping("/{favoriteId}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Integer favoriteId, Principal principal) {
        favoriteService.removeFavorite(favoriteId, principal.getName());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllFavorites(Principal principal) {
        favoriteService.removeAllFavorites(principal.getName());
        return ResponseEntity.noContent().build();
    }
}
