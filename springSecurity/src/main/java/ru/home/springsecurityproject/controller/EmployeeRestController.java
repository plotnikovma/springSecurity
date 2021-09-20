package ru.home.springsecurityproject.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private static final List<Employee> USERS = Stream.of(
            new Employee(1L, "Alex", " Bron"),
            new Employee(2L, "Boris", "Crown"),
            new Employee(3L, "Natsu", "Dragonil")
    ).collect(Collectors.toList());

    @GetMapping()
    public List<Employee> getAll()
    {
        return USERS;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('employees:read')")
    public Employee getById(@PathVariable Long id)
    {
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('employees:write')")
    public Employee create(@RequestBody Employee employee)
    {
        USERS.add(employee);
        Arrays.asList();
        return employee;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('employees:write')")
    public void deleteById(@PathVariable Long id)
    {
        USERS.removeIf(user -> user.getId().equals(id));
    }
}
