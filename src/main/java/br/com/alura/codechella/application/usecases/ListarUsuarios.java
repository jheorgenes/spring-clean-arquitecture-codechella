package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuarios {
    private final RepositorioDeUsuario repository;

    public ListarUsuarios(RepositorioDeUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> obterTodosUsuarios() {
        return repository.listarTodos();
    }
}
