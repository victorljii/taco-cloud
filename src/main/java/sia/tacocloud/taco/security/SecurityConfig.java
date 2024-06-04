package sia.tacocloud.taco.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import sia.tacocloud.taco.data.UserRepository;
import sia.tacocloud.taco.model.User;

/**
 * Spring Security 配置类
 *
 * @date 2024/05/28
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findFirstByUsername(username);
            if (user != null) {
                return user;
            }
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                    .antMatchers("/design", "/orders").hasRole("USER")
                    .antMatchers("/", "/**").permitAll()
                .and().formLogin()
                    .loginPage("/login").defaultSuccessUrl("/design", true)
                // TODO: oauth2 没调通
//                .and()
//                    .oauth2Login().loginPage("/login")
                .and()
                    .logout().logoutSuccessUrl("/")
                .and().build();
    }
}
