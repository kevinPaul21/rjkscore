package rjkscore.Domain;

import java.time.LocalDateTime;
import java.io.Serializable;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name ="password_hash", nullable = false)
    private String password;

    @Builder.Default
    @Column(name = "coins", nullable = false)
    private Integer coins = 100;

    @Builder.Default
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    @Column(name = "roles", nullable = false)
    private String roles = "USER";

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if(this.coins == null) this.coins = 100;
        if(this.roles == null) this.roles = "USER";
    }
}