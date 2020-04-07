package br.com.supercrud.controller;

import br.com.supercrud.MenuPrincipal;
import br.com.supercrud.model.Usuario;
import br.com.supercrud.service.UsuarioService;
import br.com.supercrud.service.UsuarioServiceImpl;

import javax.swing.*;
import java.util.List;

public class UsuarioController {
    MenuPrincipal menuPrincipal = new MenuPrincipal();
    UsuarioService service = new UsuarioServiceImpl();

    public void adicionar(Usuario usuario) {
        boolean sucesso = service.adicionar(usuario);
        if (sucesso)
            JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso");
        else
            JOptionPane.showMessageDialog(null, "Erro ao adicionar usuario");

        menuPrincipal.carregaMenu();
    }

    public void deletar(Long id) {
        boolean sucesso = service.deletar(id);
        if (sucesso)
            JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
        else
            JOptionPane.showMessageDialog(null, "Erro ao deletar usuario");

        menuPrincipal.carregaMenu();
    }

    public void atualizar(Usuario usuario) {
        boolean sucesso = service.atualizar(usuario);
        if (sucesso)
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
        else
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuario");

        menuPrincipal.carregaMenu();
    }

    public void buscar(Long id) {
        Usuario usuario = service.buscar(id);
        if (usuario != null) {
            JOptionPane.showMessageDialog(null, "" +
                    "Nome: " + usuario.getNome() + "\n" +
                    "Idade: " + usuario.getIdade() + "\n" +
                    "CPF: " + usuario.getCpf() + "\n" +
                    "Logradouro: " + usuario.getEndereco().getLogradouro() + "\n" +
                    "Numero: " + usuario.getEndereco().getNumero() + "\n" +
                    "Estado: " + usuario.getEndereco().getEstado() + "\n" +
                    "Bairro: " + usuario.getEndereco().getBairro());
        } else
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuario");

        menuPrincipal.carregaMenu();
    }

    public void listar() {
        List<Usuario> usuarios = service.listar();
        if (usuarios != null) {
            String mensagemComTodosUsuarios = "";
            for (Usuario usuario : usuarios) {
                mensagemComTodosUsuarios += "" +
                        "Id: " + usuario.getId() + "\n" +
                        "Nome: " + usuario.getNome() + "\n" +
                        "Idade: " + usuario.getIdade() + "\n" +
                        "CPF: " + usuario.getCpf() + "\n" +
                        "Logradouro: " + usuario.getEndereco().getLogradouro() + "\n" +
                        "Numero: " + usuario.getEndereco().getNumero() + "\n" +
                        "Estado: " + usuario.getEndereco().getEstado() + "\n" +
                        "Bairro: " + usuario.getEndereco().getBairro() + "\n\n";
            }
            JOptionPane.showMessageDialog(null, mensagemComTodosUsuarios);
        } else
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuarios");

        menuPrincipal.carregaMenu();
    }
}
