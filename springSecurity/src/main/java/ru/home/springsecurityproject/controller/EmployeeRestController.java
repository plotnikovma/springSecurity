package ru.home.springsecurityproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.home.springsecurityproject.model.Employee;

/**
 * Контроллер обработки Rest запросов, связанных с пользователями системы
 *
 * @author mplotnikov
 * @since 11.09.2021
 */
@RestController
@RequestMapping("/employees")
public class EmployeeRestController
{
    private final static List<Employee> USERS = Arrays.asList(
            new Employee(1L, "Alex", " Bron"),
            new Employee(2L, "Boris", "Crown"),
            new Employee(3L, "Natsu", "Dragonil")
    );

    @GetMapping
    public List<Employee> getEmployees()
    {
        return USERS;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
