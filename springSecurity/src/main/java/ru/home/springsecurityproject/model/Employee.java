package ru.home.springsecurityproject.model;

import java.util.Objects;

/**
 * Модель пользователя системы
 *
 * @author mplotnikov
 * @since 11.09.2021
 */
public class Employee
{
    private Long id;
    private String firstName;
    private String lastName;

    public Employee(Long id, String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee)o;
        return getId().equals(employee.getId()) && getFirstName().equals(employee.getFirstName())
                && getLastName().equals(
                employee.getLastName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getFirstName(), getLastName());
    }
}
