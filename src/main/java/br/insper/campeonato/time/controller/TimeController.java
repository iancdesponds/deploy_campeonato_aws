package br.insper.campeonato.time.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.insper.campeonato.partida.service.PartidaService;
import br.insper.campeonato.time.model.Time;
import br.insper.campeonato.time.service.TimeService;

import java.util.List;

@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private PartidaService partidaService;

    @GetMapping("/time")
    public List<Time> getTimes(@RequestParam(required = false) String estado) {
        return timeService.listarTimes(estado);
    }

    @GetMapping("/time/{identificador}")
    public Time getTime(@PathVariable Integer identificador) {
        return timeService.getTime(identificador);
    }

    @PostMapping("/time")
    @ResponseStatus(HttpStatus.CREATED)
    public Time salvarTime(@RequestBody Time time) {
        return timeService.cadastrarTime(time);
    }


}
