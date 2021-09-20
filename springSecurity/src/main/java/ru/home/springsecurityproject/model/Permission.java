package ru.home.springsecurityproject.model;

import static ru.home.springsecurityproject.config.Constants.Permission.*;

/**
 * Права для ролей системы
 *
 * @author mplotnikov
 * @since 20.09.2021
 */
public enum Permission
{
    EMPLOYEES_READ(READ),
    EMPLOYEES_WRITE(WRITE);
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
