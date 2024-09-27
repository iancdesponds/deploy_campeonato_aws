package br.insper.campeonato.partida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.insper.campeonato.partida.model.Partida;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Integer> {


}
