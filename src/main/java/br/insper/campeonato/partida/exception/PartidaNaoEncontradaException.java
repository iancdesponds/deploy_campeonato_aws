package br.insper.campeonato.partida.exception;

public class PartidaNaoEncontradaException extends RuntimeException {

    public PartidaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
