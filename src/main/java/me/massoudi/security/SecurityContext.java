package me.massoudi.security;

import java.util.Set;

public class SecurityContext {
    private static String username;
    private static Set<String> roles;

    public static void setUser(String username, Set<String> roles) {
        SecurityContext.username = username;
        SecurityContext.roles = roles;
    }

    public static String getUsername() {
        return username;
    }

    public static boolean hasRole(String role) {
        return roles != null && roles.contains(role);
    }
}
