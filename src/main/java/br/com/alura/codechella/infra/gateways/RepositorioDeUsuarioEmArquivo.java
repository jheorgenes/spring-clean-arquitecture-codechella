package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUsuarioEmArquivo implements RepositorioDeUsuario {
    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    @Override
    public Usuario alterarUsuario(String cpf, Usuario usuario) {
        Usuario usuarioAlterado = usuarios.stream().filter(u -> u.getCpf().equals(cpf)).findFirst().orElse(null);
        if (usuarioAlterado != null) {
            usuarioAlterado.setNome(usuario.getNome());
            usuarioAlterado.setNascimento(usuario.getNascimento());
            usuarioAlterado.setEmail(usuario.getEmail());
        }
        return usuarioAlterado;
    }

    @Override
    public void excluirUsuario(String cpf) {
        this.usuarios.removeIf(u -> u.getCpf().equals(cpf));
    }

    public void gravaEmArquivo(String nomeArquivo) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(this.usuarios.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
