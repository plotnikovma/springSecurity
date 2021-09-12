package ru.home.springsecurityproject.config;

/**
 * Константы проекта StudySpringSecurity
 *
 * @author mplotnikov
 * @since 12.09.2021
 */
public interface Constants
{
    /**
     * "Мощность" шифрования пароля для {@link org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder}
     */
    int B_CRYPT_PASSWORD_CAPACITY = 12;
}