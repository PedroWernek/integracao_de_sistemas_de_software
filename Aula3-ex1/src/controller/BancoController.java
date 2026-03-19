package controller;

import exceptions.ContaException;
import model.ContaBancaria;
import model.Usuario;
import view.ExtratoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class BancoController {
    private final ExtratoView view = new ExtratoView();
    private final List<ContaBancaria> contas = new ArrayList<>();
    private final Scanner scanner;
    private ContaBancaria usuarioAtual;

    public BancoController() {
        scanner = new Scanner(System.in);
        contas.add(new ContaBancaria("1", new Usuario("U101", "Ana Silva", "12345678901"), 1500.50));
        contas.add(new ContaBancaria("2", new Usuario("U102", "Bruno Oliveira", "98765432100"), 50.00));
        contas.add(new ContaBancaria("3", new Usuario("U103", "Carla Souza", "55566677788"), 5000.00));
        contas.add(new ContaBancaria("4", new Usuario("U104", "Diego Santos", "11122233344"), 0.00));
    }

    public void criarConta(String nome, String cpf) {
        try {
            Usuario usuario = new Usuario(UUID.randomUUID().toString(), nome, cpf);
            usuarioAtual = new ContaBancaria(UUID.randomUUID().toString(), usuario, 0);
            contas.add(usuarioAtual);
            view.exibirMensagem("Conta criada com sucesso");
        } catch (Exception e) {
            view.exibirMensagem("Erro desconhecido ao criar conta");
        }
    }

    public void atualizarUsuarioConta(String UsuarioId, String nome, String cpf) {
        try {
            if (contas.isEmpty() || usuarioAtual == null) {
                throw new ContaException("Não existe conta!");
            }

            int index = encontrarIndexContaUsuarioId(UsuarioId);
            ContaBancaria contaAntiaga = contas.get(index);

            if (nome.isBlank()) {
                nome = contaAntiaga.getUsuario().nome();
            }
            if (cpf.isBlank()) {
                cpf = contaAntiaga.getUsuario().cpf();
            }
            Usuario novoUsuario = new Usuario(contas.get(index).getUsuario().usuarioId(), nome, cpf);
            contas.get(index).setUsuario(novoUsuario);

            view.exibirMensagem("Usuário atualizado com sucesso!");

        } catch (ContaException e) {
            view.exibirMensagem(e.toString());
        }
    }

    public void deletarConta(String UsuarioId) {
        try {
            if (contas.isEmpty() || usuarioAtual == null) {
                throw new ContaException("Não existe conta!");
            }

            contas.removeIf(conta -> conta.getUsuario().usuarioId().equals(UsuarioId));

        } catch (ContaException e) {
            view.exibirMensagem(e.toString());
        }

    }

    public void exibirSaldo(String contaId) {
        try {
            if (contas.isEmpty() || usuarioAtual == null) {
                throw new ContaException("Não existe conta!");
            }
            view.exibirSaldo(contas.get(encontrarIndexContaContaId(contaId)));
        } catch (ContaException e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    public void sacar(String contaId, double valor) {
        try {
            int index = encontrarIndexContaContaId(contaId);
            ContaBancaria conta = contas.get(index);
            conta.sacar(valor);
            view.exibirMensagem(valor + "R$ sacados com sucesso!");
            view.exibirSaldo(conta);
        } catch (ContaException e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    public void depositar(String contaId, double valor) {
        int index = encontrarIndexContaContaId(contaId);
        ContaBancaria conta = contas.get(index);
        conta.depositar(valor);
        view.exibirMensagem(valor + "R$ depositados com sucesso!");
        view.exibirSaldo(conta);
    }

    public void listarUsuarios() {
        try {
            if (contas.isEmpty()) {
                throw new ContaException("Não existem contas!");
            }

            view.exibirUsuarios(contas);

        } catch (ContaException e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    public int encontrarIndexContaContaId(String contaId) {
        try {
            if (contas.isEmpty()) {
                throw new ContaException("Não existem contas!");
            }

            for (int i = 0; i < contas.size(); i++) {
                if (contas.get(i).getId().equals(contaId)) {
                    return i;
                }
            }

            throw new ContaException("Conta não encontrada");

        } catch (ContaException e) {
            view.exibirMensagem(e.getMessage());
            return -1;
        }
    }

    public int encontrarIndexContaUsuarioId(String usuarioId) {
        try {
            if (contas.isEmpty()) {
                throw new ContaException("Não existem contas!");
            }

            for (int i = 0; i < contas.size(); i++) {
                if (contas.get(i).getUsuario().usuarioId().equals(usuarioId)) {
                    return i;
                }
            }

            throw new ContaException("Usuario não encontrado");

        } catch (ContaException e) {
            view.exibirMensagem(e.getMessage());
            return -1;
        }
    }

    public void exibirMenu() {
        String sb = """
                ==+Banco Minimum+==\
                
                1-Criar Conta\
                
                2-Listar Usuarios\
                
                3-Exibir Saldo\
                
                4-Sacar\
                
                5-Depositar\
                
                6-Atualizar Conta\
                
                7-Deletar Conta\
                
                8-Sair""";

        view.exibirMensagem(sb);
        navegar();
    }


    public void navegar() {
        view.exibirMensagem("\nDigite sua escolha:");
        int escolha = Integer.parseInt(scanner.nextLine());
        int valor;
        while (true) {
            switch (escolha) {
                case 1:
                    view.exibirMensagem("Digite o nome:");
                    String nome = scanner.nextLine();
                    view.exibirMensagem("Digite o cpf:");
                    String cpf = scanner.nextLine();
                    criarConta(nome, cpf);
                    view.exibirUsuario(usuarioAtual);
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    if (usuarioAtual != null) {
                        exibirSaldo(usuarioAtual.getId());
                    } else {
                        view.exibirMensagem("Não existe conta");
                    }

                    break;
                case 4:
                    if (usuarioAtual != null) {
                        view.exibirMensagem("Digite o Valor desejado: ");
                        valor = Integer.parseInt(scanner.nextLine());
                        sacar(usuarioAtual.getId(), valor);
                    } else {
                        view.exibirMensagem("Não existe conta");
                    }
                    break;
                case 5:
                    if (usuarioAtual != null) {
                        view.exibirMensagem("Digite o Valor desejado: ");
                        valor = Integer.parseInt(scanner.nextLine());
                        depositar(usuarioAtual.getId(), valor);
                    } else {
                        view.exibirMensagem("Não existe conta");
                    }
                    break;
                case 6:
                    if (usuarioAtual != null) {
                        view.exibirMensagem("O que deseja mudar? (\nDeixe em branco para que não produzir mudanças)");
                        view.exibirMensagem("nome:");
                        String novonome = scanner.nextLine();
                        view.exibirMensagem("cpf:");
                        String cpfnovo = scanner.nextLine();
                        atualizarUsuarioConta(usuarioAtual.getId(), novonome, cpfnovo);
                    } else {
                        view.exibirMensagem("Não existe conta");
                    }
                    break;
                case 7:
                    view.exibirMensagem("Tem certeza? (s/n)");
                    String decisao = scanner.nextLine();

                    if (decisao.toLowerCase().contains("s")) {
                        view.exibirMensagem("Deletando conta...");
                        deletarConta(usuarioAtual.getId());
                        view.exibirMensagem("Saindo do Sistema");
                        scanner.close();
                        return;
                    }
                    break;
                case 8:
                    view.exibirMensagem("Saindo do Sistema");
                    scanner.close();
                    return;
                default:
                    view.exibirMensagem("Escolha inválida");
                    navegar();
                    break;
            }
            exibirMenu();
        }
    }


}
