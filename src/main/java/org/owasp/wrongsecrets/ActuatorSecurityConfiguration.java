package org.owasp.wrongsecrets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ActuatorSecurityConfiguration {

    @Bean
    @Order(2)
    public SecurityFilterChain configureActuatorSecurity(HttpSecurity http) throws Exception {
        http.securityMatcher(r ->
                r.getRequestURL().toString().contains("/actuator/health"))
            .csrf().disable();
        return http.build();
    }
}

    /**
     * Arcane:
     * [Arcane]
     * aws_access_key_id = AKIAYVP4CIPPEMEC27B2
     * aws_secret_access_key = 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
     * output = json
     * region = us-east-2
     *
     * Arcane debug:
     * [default]
     * aws_access_key_id = AKIAYVP4CIPPJCJOPJWL
     * aws_secret_access_key = 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
     * output = json
     * region = us-east-2
     *
     * wrongsecrets debug:
     * [default]
     * aws_access_key_id = AKIAYVP4CIPPCXOWVNMW
     * aws_secret_access_key = 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
     * output = json
     * region = us-east-2
     */
