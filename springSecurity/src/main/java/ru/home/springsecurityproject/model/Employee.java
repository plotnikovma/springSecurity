package ru.home.springsecurityproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Модель пользователя системы
 *
 * @author mplotnikov
 * @since 11.09.2021
 */
@Data
@AllArgsConstructor
public class Employee
{
    private Long id;
    private String firstName;
    private String lastName;
}
