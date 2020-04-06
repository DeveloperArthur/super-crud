package br.com.supercrud.controller;

import br.com.supercrud.model.Usuario;
import br.com.supercrud.service.UsuarioService;
import br.com.supercrud.service.UsuarioServiceImpl;

import java.util.List;

public class UsuarioController {
    UsuarioService service = new UsuarioServiceImpl();

    public void adicionar(Usuario usuario) {
        boolean sucesso = service.adicionar(usuario);
        if (sucesso)
            System.out.println("Usuario adicionado com sucesso");
        else
            System.err.println("Erro ao adicionar usuario");
    }

    public void deletar(Long id) {
        boolean sucesso = service.deletar(id);
        if (sucesso)
            System.out.println("Usuario deletado com sucesso");
        else
            System.err.println("Erro ao deletar usuario");
    }

    public void atualizar(Long id, Usuario usuario) {
        boolean sucesso = service.atualizar(id, usuario);
        if (sucesso)
            System.out.println("Usuario atualizado com sucesso");
        else
            System.err.println("Erro ao atualizar usuario");
    }

    public void buscar(Long id) {
        Usuario usuario = service.buscar(id);
        if (usuario != null) {
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Idade: " + usuario.getIdade());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("Logradouro: " + usuario.getEndereco().getLogradouro());
            System.out.println("Numero: " + usuario.getEndereco().getNumero());
            System.out.println("Estado: " + usuario.getEndereco().getEstado());
            System.out.println("Bairro: " + usuario.getEndereco().getBairro());
        } else
            System.err.println("Erro ao buscar usuario");
    }

    public void listar() {
        List<Usuario> usuarios = service.listar();
        if (usuarios != null) {
            for (Usuario usuario : usuarios) {
                System.out.println("Id: " + usuario.getId());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Idade: " + usuario.getIdade());
                System.out.println("CPF: " + usuario.getCpf());
                System.out.println("Logradouro: " + usuario.getEndereco().getLogradouro());
                System.out.println("Numero: " + usuario.getEndereco().getNumero());
                System.out.println("Estado: " + usuario.getEndereco().getEstado());
                System.out.println("Bairro: " + usuario.getEndereco().getBairro());
                System.out.println();
            }
        } else
            System.err.println("Erro ao buscar usuarios");
    }
}
