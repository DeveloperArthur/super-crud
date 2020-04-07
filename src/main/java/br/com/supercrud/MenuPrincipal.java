package br.com.supercrud;

import br.com.supercrud.controller.UsuarioController;
import br.com.supercrud.model.Endereco;
import br.com.supercrud.model.Usuario;

import javax.swing.*;


public class MenuPrincipal {
    public static void main(String[] args) {
        new MenuPrincipal().carregaMenu();
    }

    public void carregaMenu() {
        UsuarioController controller = new UsuarioController();

        int opcao = Integer.parseInt(JOptionPane.showInputDialog("" +
                "Super Crud\n" +
                "1 - Adicionar usuario\n" +
                "2 - Atualizar usuario\n" +
                "3 - Deletar usuario\n" +
                "4 - Buscar usuario\n" +
                "5 - Listar todos usuarios\n"));

        switch (opcao) {
            case 1:
                String nome = String.valueOf(JOptionPane.showInputDialog("Informe o nome do Usuario"));
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do Usuario"));
                String cpf = String.valueOf(JOptionPane.showInputDialog("Informe o CPF do Usuario"));

                String logradouro = String.valueOf(JOptionPane.showInputDialog("Informe o logradouro do Endereco"));
                int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero do Endereco"));
                String estado = String.valueOf(JOptionPane.showInputDialog("Informe o estado"));
                String bairro = String.valueOf(JOptionPane.showInputDialog("Informe o bairro"));

                Endereco endereco = new Endereco(logradouro, numero, estado, bairro);
                Usuario usuario = new Usuario(nome, idade, cpf, endereco);
                controller.adicionar(usuario);
                break;
            case 2:
                Long idUsuarioParaAlterar = Long.valueOf(JOptionPane.showInputDialog("Informe o id do Usuario que deseja alterar"));

                String novoNome = String.valueOf(JOptionPane.showInputDialog("Informe o novo nome do Usuario"));
                int novaIdade = Integer.parseInt(JOptionPane.showInputDialog("Informe a nova idade do Usuario"));
                String novoCpf = String.valueOf(JOptionPane.showInputDialog("Informe o novo CPF do Usuario"));

                Long idEnderecoParaAlterar = Long.valueOf(JOptionPane.showInputDialog("Informe o id do Endereco que deseja alterar"));

                String novoLogradouro = String.valueOf(JOptionPane.showInputDialog("Informe o novo logradouro do Endereco"));
                int novoNumero = Integer.parseInt(JOptionPane.showInputDialog("Informe o novo numero do Endereco"));
                String novoEstado = String.valueOf(JOptionPane.showInputDialog("Informe o novo estado"));
                String novoBairro = String.valueOf(JOptionPane.showInputDialog("Informe o novo bairro"));

                Endereco novoEndereco = new Endereco(novoLogradouro, novoNumero, novoEstado, novoBairro);
                Usuario novoUsuario = new Usuario(novoNome, novaIdade, novoCpf, novoEndereco);

                novoUsuario.setId(idUsuarioParaAlterar);
                novoEndereco.setId(idEnderecoParaAlterar);

                controller.atualizar(novoUsuario);
                break;
            case 3:
                Long idParaDeletar = Long.valueOf(JOptionPane.showInputDialog("Digite o id que deseja deletar"));
                controller.deletar(idParaDeletar);
                break;
            case 4:
                Long idParaBuscar = Long.valueOf(JOptionPane.showInputDialog("Digite o id que deseja buscar"));
                controller.buscar(idParaBuscar);
                break;
            case 5:
                controller.listar();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Digite uma opcao valida");
                this.carregaMenu();
        }
    }
}
