package br.insper.campeonato.partida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.insper.campeonato.partida.dto.EditarPartidaDTO;
import br.insper.campeonato.partida.dto.RetornarPartidaDTO;
import br.insper.campeonato.partida.dto.SalvarPartidaDTO;
import br.insper.campeonato.partida.service.PartidaService;

import java.util.List;

@RestController
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @GetMapping("/partida")
    public List<RetornarPartidaDTO> getPartida(@RequestParam(required = false) String mandante) {
        return partidaService.listarPartidas(mandante);
    }

    @GetMapping("/partida/{id}")
    public RetornarPartidaDTO getPartida(@PathVariable Integer id) {
        return partidaService.getPartida(id);
    }

    @PostMapping("/partida")
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarPartidaDTO salvarPartida(@RequestBody SalvarPartidaDTO partida) {
        return partidaService.cadastrarPartida(partida);
    }

    @PostMapping("/partida/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarPartidaDTO editarPartida(@RequestBody EditarPartidaDTO partida, @PathVariable Integer id) {
        return partidaService.editarPartida(partida, id);
    }

}
