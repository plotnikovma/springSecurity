package ru.home.springsecurityproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import ru.home.springsecurityproject.model.Permission;
import ru.home.springsecurityproject.model.Roles;

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
        http.csrf().disable()                                               //отключаем защиту CSRF
                .authorizeRequests()                                        //авторизуем запросы следующим образом
                .antMatchers("/").permitAll()                   //могут отправлять все пользователи по этому паттерну
                .antMatchers(HttpMethod.GET, "/employees/**").hasAuthority(Permission.EMPLOYEES_READ.getPermission())
                .antMatchers(HttpMethod.POST, "/employees/**").hasAuthority(Permission.EMPLOYEES_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/employees/**").hasAuthority(Permission.EMPLOYEES_WRITE.getPermission())
                .anyRequest()                                               //каждый запрос
                .authenticated()                                            //должен быть аутентифицирован
                .and()
                .httpBasic();                                               //и я хочу использовать HTTP Basic для аутентификации
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
                //добавляем пользователя Admin
                User.builder()
                        .username("admin")
                        .password(encoder().encode("admin"))
                        .authorities(Roles.ADMIN.getAuthorities())
                        .build(),
                //Добавляем пользователя User
                User.builder()
                        .username("user")
                        .password(encoder().encode("user"))
                        .authorities(Roles.USER.getAuthorities())
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
