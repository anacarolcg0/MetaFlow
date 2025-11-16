package br.com.fiap.metaflow.entity;

public enum UsuarioRole {
    ADMIN("admin"),
    USER("user");

    private final String role;

    UsuarioRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}