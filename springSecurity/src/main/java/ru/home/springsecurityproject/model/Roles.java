package ru.home.springsecurityproject.model;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Роли доступные в системе
 *
 * @author mplotnikov
 * @since 12.09.2021
 */
public enum Roles
{
    USER(Set.of(Permission.EMPLOYEES_READ)),
    ADMIN(Set.of(Permission.EMPLOYEES_WRITE, Permission.EMPLOYEES_READ));

    private final Set<Permission> permissions;

    Roles(Set<Permission> permissions)
    {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions()
    {
        return permissions;
    }

    /**
     * Штатная система прав в SpringSecurity основана на работе с объектами GrantedAuthority, именно эта сущность
     * определяет доступные действия для пользователей системы.
     * Метод конвертации наших прав в GrantedAuthority
     */
    public Set<SimpleGrantedAuthority> getAuthorities()
    {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
