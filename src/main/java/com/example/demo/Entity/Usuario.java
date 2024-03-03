package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private String email;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String password;
    private String repPassword;
    private Boolean enabled;
    private String foto;
    private String rol;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "usuario")
    private List<Sugerencia> sugerencias;

    @ManyToMany(mappedBy = "usuarios")
    private List<Partida> partidas;

    @OneToMany(mappedBy = "usuario")
    private List<Mensaje> mensajes;

    public Usuario(Long id, String username, String email, String nombre, String apellidos, Integer edad, String password,
                   String repPassword, Boolean enabled, String foto, String rol, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.password = password;
        this.repPassword = repPassword;
        this.enabled = enabled;
        this.foto = foto;
        this.rol = rol;
        this.createdAt = createdAt;
    }
}
