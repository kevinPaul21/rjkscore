package rjkscore.infrastructure.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rjkscore.Domain.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmailOrUsername(String email, String username);

}
