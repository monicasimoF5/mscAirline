package org.msc.mscAirline.config;

import org.msc.mscAirline.security.JpaUserDetailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${api-endpoints}")
    String endpoint;

    private JpaUserDetailService jpaUserDetailService;

    public SecurityConfiguration(JpaUserDetailService jpaUserDetailService) {
        this.jpaUserDetailService = jpaUserDetailService;
    }
}
