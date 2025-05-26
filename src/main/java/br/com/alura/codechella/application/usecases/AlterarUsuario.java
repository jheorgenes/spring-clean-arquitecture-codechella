package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class AlterarUsuario {
    private final RepositorioDeUsuario repository;

    public AlterarUsuario(RepositorioDeUsuario repository) {
        this.repository = repository;
    }

    public Usuario alterarDadosUsuario(String cpf, Usuario usuario) {
        return repository.alterarUsuario(cpf, usuario);
    }
}
