package ma.tamount.backend.config;

import lombok.RequiredArgsConstructor;
import ma.tamount.backend.exceptions.ResourceNotFoundException;
import ma.tamount.backend.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuration class for application-related beans and settings.
 * This class includes configurations for user details service, authentication provider,
 * auditor awareness, authentication manager, password encoder, model mapper, and opaque token introspector.
 *
 * @author Mohamed Ossalhe
 */
@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguratoin {

    private final UserRepository repository;
    /**
     * Creates a custom implementation of UserDetailsService to load user details by email.
     *
     * @return UserDetailsService implementation
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> repository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    /**
     * Configures and provides a custom AuthenticationProvider using DaoAuthenticationProvider.
     *
     * @return AuthenticationProvider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Retrieves the AuthenticationManager from the provided AuthenticationConfiguration.
     *
     * @param config AuthenticationConfiguration
     * @return AuthenticationManager
     * @throws Exception if an error occurs while retrieving the AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * Creates an instance of BCryptPasswordEncoder as the password encoder.
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
