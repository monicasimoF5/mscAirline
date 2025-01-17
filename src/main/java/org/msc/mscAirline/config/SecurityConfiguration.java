package org.msc.mscAirline.config;

import org.msc.mscAirline.security.JpaUserDetailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${api-endpoints}")
    String endpoint;

    private JpaUserDetailService jpaUserDetailService;

    public SecurityConfiguration(JpaUserDetailService jpaUserDetailService) {
        this.jpaUserDetailService = jpaUserDetailService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .logout(out -> out
                        .logoutUrl(endpoint + "/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(endpoint).permitAll()
                        .requestMatchers(HttpMethod.POST, endpoint + "register").permitAll()
                        .requestMatchers(endpoint + "/login").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(endpoint + "/public").permitAll()
                        .requestMatchers(endpoint + "/private").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, endpoint + "/airports").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .userDetailsService(jpaUserDetailService)
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        httpSecurity.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));

        return httpSecurity.build();
    }

}
