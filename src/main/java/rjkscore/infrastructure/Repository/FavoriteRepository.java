package rjkscore.infrastructure.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rjkscore.Domain.AppUser;
import rjkscore.Domain.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> findByUser(AppUser user);
}
