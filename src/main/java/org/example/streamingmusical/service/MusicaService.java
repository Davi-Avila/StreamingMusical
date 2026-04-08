package org.example.streamingmusical.service;

import org.example.streamingmusical.controller.MusicaController;
import org.example.streamingmusical.model.Musica;
import org.example.streamingmusical.repository.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {
    private final MusicaRepository repository;

    public MusicaService(MusicaRepository repository){
        this.repository = repository;
    }


    public List<Musica> listar(){
        return repository.findAll();
    }

    public Musica salvar(Musica musica){
        return repository.save(musica);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public Musica atualizar(Long id, Musica musica){
        buscarPorId(id);
        musica.setId(id);
        return repository.save(musica);
    }

    public Musica buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Música não encontrada"));
    }

    public List<Musica> buscarPorNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Musica> buscarPorArtista(String artista){
        return repository.findByArtistaContainingIgnoreCase(artista);
    }

    public List<Musica> buscarPorGenero(String genero){
        return repository.findByGeneroContainingIgnoreCase(genero);
    }



}
