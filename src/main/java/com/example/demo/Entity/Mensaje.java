package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "mensajes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mensaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String creador;
    private String destinatario;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
