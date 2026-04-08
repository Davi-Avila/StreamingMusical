package org.example.streamingmusical.controller;

import jakarta.validation.Valid;
import org.example.streamingmusical.model.Musica;
import org.example.streamingmusical.service.MusicaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    private final MusicaService service;

    public MusicaController(MusicaService service){
        this.service = service;
    }

    @GetMapping
    public List<Musica> listar(){
        return service.listar();
    }

    @PostMapping
    public Musica salvar(@RequestBody @Valid Musica musica){
        return service.salvar(musica);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public Musica atualizar(@PathVariable Long id, @RequestBody @Valid Musica musica){
        return service.atualizar(id, musica);
    }

    @GetMapping("/{id}")
    public Musica buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping("/buscarNome")
    public List<Musica> buscarPorNome(@RequestParam String nome){
        return service.buscarPorNome(nome);
    }

    @GetMapping("/buscarArtista")
    public List<Musica> buscarPorArtista(@RequestParam String artista){
        return service.buscarPorArtista(artista);
    }

    @GetMapping("/buscarGenero")
    public List<Musica> buscarPorGenero(@RequestParam String genero){
        return service.buscarPorGenero(genero);
    }







}
