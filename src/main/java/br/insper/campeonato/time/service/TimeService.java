package br.insper.campeonato.time.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.insper.campeonato.time.exception.TimeNaoEncontradoException;
import br.insper.campeonato.time.model.Time;
import br.insper.campeonato.time.repository.TimeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time cadastrarTime(Time time) {
        if (time.getNome().equals("")
                || time.getIdentificador().equals("")) {
            throw  new RuntimeException("Dados invalidos");
        } else {
            return timeRepository.save(time);
        }
    }

    public List<Time> listarTimes(String estado) {
        if (estado != null) {
            return timeRepository.findByEstado(estado);
        }
        return timeRepository.findAll();
    }

    public Time getTime(Integer id) {
        Optional<Time> op = timeRepository.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        throw new TimeNaoEncontradoException("Time " + id + " não encontrado");
    }

}