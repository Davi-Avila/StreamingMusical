package org.example.streamingmusical.repository;

import org.example.streamingmusical.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository <Musica, Long>{
    List<Musica> findByNomeContainingIgnoreCase(String nome);
    List<Musica> findByArtistaContainingIgnoreCase(String artista);
    List<Musica> findByGeneroContainingIgnoreCase(String genero);

}
