package ru.home.springsecurityproject.model;

/**
 * Права для ролей системы
 *
 * @author mplotnikov
 * @since 20.09.2021
 */
public enum Permission
{
    EMPLOYEES_READ("employees:read"),
    EMPLOYEES_WRITE("employees:write");
    private final String permission;

    Permission(String permission)
    {
        this.permission = permission;
    }

    public String getPermission()
    {
        return permission;
    }
}
