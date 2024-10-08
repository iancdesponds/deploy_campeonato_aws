package br.insper.campeonato.time.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.insper.campeonato.time.model.Time;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {

    public List<Time> findByEstado(String estado);


}
