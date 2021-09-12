package ru.home.springsecurityproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Конфигурационный класс SpringSecurity для аутентификации пользователей
 *
 * @author mplotnikov
 * @since 12.09.2021
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    /**
     * Custom HttpSecurity
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        super.configure(http);
    }

    /**
     * Сервис взаимодействия с хранилищем данных аутентификации пользователей.
     * В данном случае настроим InMemory хранилище.
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService()
    {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(encoder().encode("admin"))
                        .roles("ADMIN")
                        .build());
    }

    /**
     * Кодер паролей для сокрытия от посторонних
     */
    @Bean
    protected PasswordEncoder encoder()
    {
        return new BCryptPasswordEncoder(Constants.B_CRYPT_PASSWORD_CAPACITY);
    }
}
