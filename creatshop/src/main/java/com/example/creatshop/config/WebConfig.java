package com.example.creatshop.config;
/*
 * @author HongAnh
 * @created 20 / 09 / 2024 - 8:14 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.RoleType;
import com.example.creatshop.domain.entity.Cart;
import com.example.creatshop.domain.entity.Role;
import com.example.creatshop.domain.entity.User;
import com.example.creatshop.repository.CartRepository;
import com.example.creatshop.repository.RoleRepository;
import com.example.creatshop.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class WebConfig {
    UserRepository userRepository;

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(encoder());
        return provider;
    }

    @Bean
    public SecureRandom secureRandom() {
        return new SecureRandom();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public boolean initSystem(RoleRepository roleRepository, CartRepository cartRepository, PasswordEncoder encoder) {
        Role role = null;

        if (!roleRepository.existsByType(RoleType.ROLE_ADMIN)) {
            role = Role.builder()
                       .type(RoleType.ROLE_ADMIN)
                       .description("This role for admin")
                       .build();

            role = roleRepository.save(role);
        }

        if (!userRepository.existsByUsername("lehonganh")) {
            User user = User.builder()
                            .firstName("Le Hong")
                            .lastName("Anh")
                            .username("lehonganh")
                            .password(encoder.encode("Password123!"))
                            .phoneNumber("039125678")
                            .email("le292620@gmail.com")
                            .role(role)
                            .build();

            Cart cart = Cart.builder().build();
            cart = cartRepository.save(cart);

            user.setCart(cart);
            userRepository.save(user);
        }

        return true;
    }
}