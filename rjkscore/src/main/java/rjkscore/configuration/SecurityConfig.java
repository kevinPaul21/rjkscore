package rjkscore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 🔓 desactiva CSRF (solo en desarrollo)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/register").permitAll()  // ✅ permite sin login
                .anyRequest().permitAll()  // 🔓 permite TODO temporalmente
            )
            .formLogin(Customizer.withDefaults()); // opcional: muestra login si accedes por navegador

        return http.build();
    }
}
