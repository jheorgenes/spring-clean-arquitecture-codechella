package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repository;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario alterarUsuario(String cpf, Usuario usuario) {
        UsuarioEntity entity = repository.findByCpf(cpf);
        if(entity != null) {
            var atualizado = mapper.toEntity(usuario);
            atualizado.setId(entity.getId());
            repository.save(atualizado);
            return mapper.toDomain(atualizado);
        }
        return null;
    }

    @Override
    public void excluirUsuario(String cpf) {
        UsuarioEntity entity = repository.findByCpf(cpf);
        repository.deleteById(entity.getId());
    }
}
