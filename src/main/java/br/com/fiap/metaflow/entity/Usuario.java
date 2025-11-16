package br.com.fiap.metaflow.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "metaflow_usuario")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private String email;
    private String tituloProfissional;
    private String objetivoCarreira;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    private String password;
    @Enumerated(EnumType.STRING)
    private UsuarioRole role;

    public Usuario() {}

    public Usuario(String username, String email, String tituloProfissional, String objetivoCarreira,
                   LocalDateTime dataCriacao, String password, UsuarioRole role) {
        this.username = username;
        this.email = email;
        this.tituloProfissional = tituloProfissional;
        this.objetivoCarreira = objetivoCarreira;
        this.dataCriacao = dataCriacao;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTituloProfissional() {
        return tituloProfissional;
    }

    public void setTituloProfissional(String tituloProfissional) {
        this.tituloProfissional = tituloProfissional;
    }

    public String getObjetivoCarreira() {
        return objetivoCarreira;
    }

    public void setObjetivoCarreira(String objetivoCarreira) {
        this.objetivoCarreira = objetivoCarreira;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (UsuarioRole.ADMIN.equals(role)) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
