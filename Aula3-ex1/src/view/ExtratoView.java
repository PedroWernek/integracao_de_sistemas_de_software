package view;

import model.ContaBancaria;

import java.util.List;

public class ExtratoView {
    public void exibirSaldo(ContaBancaria conta) {
        System.out.println("Saldo disponível: " + conta.getSaldo());
    }

    public void exibirUsuarios(List<ContaBancaria> contas) {
        for (ContaBancaria conta : contas) {
            System.out.println("==+ Lista de Usuários +==");
            System.out.println("Usuário {");
            System.out.println("\tid: " + conta.getUsuario().usuarioId());
            System.out.println("\tnome: " + conta.getUsuario().nome());
            System.out.println("\tnome: " + conta.getUsuario().cpf());

        }
    }

    public void exibirUsuario(ContaBancaria conta) {
        System.out.println("==+ Lista de Usuários +==");
        System.out.println("Usuário {");
        System.out.println("\tid: " + conta.getUsuario().usuarioId());
        System.out.println("\tnome: " + conta.getUsuario().nome());
        System.out.println("\tnome: " + conta.getUsuario().cpf());
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }
}
