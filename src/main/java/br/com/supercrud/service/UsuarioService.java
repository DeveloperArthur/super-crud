package br.com.supercrud.service;

import br.com.supercrud.model.Usuario;

import java.util.List;

public interface UsuarioService {
    public boolean adicionar(Usuario usuario);

    public boolean deletar(Long id);

    public boolean atualizar(Usuario usuario);

    public Usuario buscar(Long id);

    public List<Usuario> listar();
}
