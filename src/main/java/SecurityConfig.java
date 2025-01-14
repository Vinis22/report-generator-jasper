import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Libera todas as rotas
                )
                .csrf(csrf -> csrf.disable()) // Desativa CSRF
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())); // Desativa frameOptions sem usar o método deprecado
        return http.build();
    }
}
