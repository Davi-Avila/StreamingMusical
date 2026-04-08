package org.example.streamingmusical.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Insira o nome da música")
    private String nome;

    @NotBlank(message = "Insira o artista")
    private String artista;

    @NotBlank(message = "Insira o gênero musical")
    private String genero;

    @NotNull(message = "Insira a duração a música")
    @Positive(message = "Insira uma duração válida")
    private Double duracao;

    @NotNull
    @Max(value = 2026, message = "Insira um ano válido")
    private Integer ano;


    private String token;

    @PrePersist
    public void setup(){
        if(this.token == null){
            this.token = UUID.randomUUID().toString().toUpperCase();
        }
    }

    @PreUpdate
    public void update(){
        if(this.token == null){
            this.token = UUID.randomUUID().toString().toUpperCase();
        }
    }

    public Musica(){}

}
