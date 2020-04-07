package br.com.supercrud.dao;

import br.com.supercrud.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UsuarioDao {
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("usuario");
    EntityManager entityManager = managerFactory.createEntityManager();

    public boolean adicionar(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(usuario);
            entityManager.persist(usuario.getEndereco());

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Long id) {
        try {
            entityManager.getTransaction().begin();

            Usuario usuario = entityManager.find(Usuario.class, id);
            entityManager.remove(usuario);

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizar(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();

            entityManager.merge(usuario);
            entityManager.merge(usuario.getEndereco());

            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario buscar(Long id) {
        try {
            entityManager.getTransaction().begin();

            Usuario usuario = entityManager.find(Usuario.class, id);

            entityManager.getTransaction().commit();
            entityManager.close();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Usuario> listar() {
        try {
            entityManager.getTransaction().begin();

            List usuarios = entityManager.createQuery("Select u from Usuario u").getResultList();

            entityManager.getTransaction().commit();
            entityManager.close();
            return usuarios;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
