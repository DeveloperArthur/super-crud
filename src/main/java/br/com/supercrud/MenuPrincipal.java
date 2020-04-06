package br.com.supercrud;

import br.com.supercrud.controller.UsuarioController;
import br.com.supercrud.model.Endereco;
import br.com.supercrud.model.Usuario;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        System.out.println("********************************");
        System.out.println("*       Super Crud             *");
        System.out.println("*  1 - Adicionar usuario       *");
        System.out.println("*  2 - Atualizar usuario       *");
        System.out.println("*  3 - Deletar usuario         *");
        System.out.println("*  4 - Buscar usuario          *");
        System.out.println("*  5 - Listar todos usuarios   *");
        System.out.println("*                              *");
        System.out.println("********************************");

        UsuarioController controller = new UsuarioController();
        Scanner sc = new Scanner(System.in);
        System.out.println("INFORME UMA OPCAO DO MENU: ");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Informacoes do Usuario");
                System.out.println("Digite o nome");
                String nome = sc.next();
                System.out.println("Digite a idade");
                int idade = sc.nextInt();
                System.out.println("Digite o CPF");
                String cpf = sc.next();

                System.out.println("Informacoes de Endereco");
                System.out.println("Digite o logradouro");
                String logradouro = sc.next();
                System.out.println("Digite o numero");
                int numero = sc.nextInt();
                System.out.println("Digite o Estado");
                String estado = sc.next();
                System.out.println("Digite o bairro");
                String bairro = sc.next();

                Endereco endereco = new Endereco(logradouro, numero, estado, bairro);
                Usuario usuario = new Usuario(nome, idade, cpf, endereco);
                controller.adicionar(usuario);
                break;
            case 2:
                System.out.println("Informe o id que deseja do usuario que deseja alterar");
                Long idParaAlterar = sc.nextLong();

                System.out.println("Digite o novo nome");
                String novoNome = sc.next();
                System.out.println("Digite a nova idade");
                int novaIdade = sc.nextInt();
                System.out.println("Digite o novo CPF");
                String novoCpf = sc.next();

                System.out.println("Digite o novo logradouro");
                String novoLogradouro = sc.next();
                System.out.println("Digite o novo numero");
                int novoNumero = sc.nextInt();
                System.out.println("Digite o novo Estado");
                String novoEstado = sc.next();
                System.out.println("Digite o novo bairro");
                String novoBairro = sc.next();

                Endereco novoEndereco = new Endereco(novoLogradouro, novoNumero, novoEstado, novoBairro);
                Usuario novoUsuario = new Usuario(novoNome, novaIdade, novoCpf, novoEndereco);
                controller.atualizar(idParaAlterar, novoUsuario);
                break;
            case 3:
                System.out.println("Digite o id que deseja deletar");
                Long idParaDeletar = sc.nextLong();
                controller.deletar(idParaDeletar);
                break;
            case 4:
                System.out.println("Digite o id que deseja buscar");
                Long idParaBuscar = sc.nextLong();
                controller.buscar(idParaBuscar);
                break;
            case 5:
                controller.listar();
                break;
            default:
                System.err.println("Escolha uma opção válida");
        }
    }
}
