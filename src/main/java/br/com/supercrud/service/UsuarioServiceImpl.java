package br.com.supercrud.service;

import br.com.supercrud.dao.UsuarioDao;
import br.com.supercrud.model.Usuario;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    UsuarioDao dao = new UsuarioDao();

    @Override
    public boolean adicionar(Usuario usuario) {
        return dao.adicionar(usuario);
    }

    @Override
    public boolean deletar(Long id) {
        return dao.deletar(id);
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        return dao.atualizar(usuario);
    }

    @Override
    public Usuario buscar(Long id) {
        return dao.buscar(id);
    }

    @Override
    public List<Usuario> listar() {
        return dao.listar();
    }
}
