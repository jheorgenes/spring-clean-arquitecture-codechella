package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivos {

    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("456.789.888-00", "João", LocalDate.parse("2000-10-15"), "joao@gmail.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("456.789.888-00", "Maria", LocalDate.parse("2000-10-15"), "maria@gmail.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("456.789.888-00", "Vinicius", LocalDate.parse("2000-10-15"), "vinicius@gmail.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("456.789.888-88", "Raphael", LocalDate.parse("2000-10-15"), "raphael@gmail.com"));
        System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());

        repositorioDeUsuarioEmArquivo.alterarUsuario("456.789.888-88", new Usuario("456.789.888-88", "Raphael Gomes", LocalDate.parse("2000-10-15"), "raphaelgomes@gmail.com"));
        System.out.println("\n");
        System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());

        repositorioDeUsuarioEmArquivo.excluirUsuario("456.789.888-88");
        System.out.println("\n");
        System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());

        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");
    }
}
