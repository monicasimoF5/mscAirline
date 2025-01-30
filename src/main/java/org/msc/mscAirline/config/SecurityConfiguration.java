package org.msc.mscAirline.config;

import org.msc.mscAirline.security.JpaUserDetailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${api-endpoint}")
    String endpoint;

    private JpaUserDetailService jpaUserDetailService;

    public SecurityConfiguration(JpaUserDetailService jpaUserDetailService) {
        this.jpaUserDetailService = jpaUserDetailService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .logout(out -> out
                        .logoutUrl(endpoint + "/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(endpoint).permitAll()
                        .requestMatchers(HttpMethod.POST, endpoint + "/register").permitAll()
                        .requestMatchers(endpoint + "/login").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, endpoint + "/profiles").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, endpoint + "/profiles").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, endpoint + "/airports").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, endpoint + "/airports").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.PUT, endpoint + "/airports").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/airports").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, endpoint + "/flights").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, endpoint + "/flights").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.PUT, endpoint + "/flights").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/flights").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, endpoint + "/reservations").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.GET, endpoint + "/reservations").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.PUT, endpoint + "/reservations").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/reservations").hasAnyRole("USER","ADMIN")
                        .anyRequest().authenticated())
                .userDetailsService(jpaUserDetailService)
                .httpBasic(withDefaults())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        httpSecurity.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));

        return httpSecurity.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
