package controller;

import model.Usuario;
import view.BancoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoController {
    private final BancoView view = new BancoView();
    private final List<Usuario> usuarios = new ArrayList<>();
    private int tentativas = 3;
    private final Scanner scanner = new Scanner(System.in);

    public BancoController(){
        usuarios.add(new Usuario("Ana", "ana@email.com", "senha456@"));
        usuarios.add(new Usuario("Carlos", "carlos@email.com", "senha789@"));
        usuarios.add(new Usuario("Beatriz", "beatriz@email.com", "senha321@"));
        usuarios.add(new Usuario("Lucas", "lucas@email.com", "senha654@"));
        usuarios.add(new Usuario("Mariana", "mariana@email.com", "senha987@"));
        usuarios.add(new Usuario("João", "joao@email.com", "senha147@"));
        usuarios.add(new Usuario("Fernanda", "fernanda@email.com", "senha258@"));
        usuarios.add(new Usuario("Rafael", "rafael@email.com", "senha369@"));
        usuarios.add(new Usuario("Juliana", "juliana@email.com", "senha159@"));
        usuarios.add(new Usuario("Marcos", "marcos@email.com", "senha753@"));
        usuarios.add(new Usuario("Camila", "camila@email.com", "senha951@"));
        usuarios.add(new Usuario("Diego", "diego@email.com", "senha852@"));
        usuarios.add(new Usuario("Amanda", "amanda@email.com", "senha456!"));
        usuarios.add(new Usuario("Gabriel", "gabriel@email.com", "senha123!"));
        usuarios.add(new Usuario("Larissa", "larissa@email.com", "senha789!"));
        usuarios.add(new Usuario("Thiago", "thiago@email.com", "senha321!"));
        usuarios.add(new Usuario("Natália", "natalia@email.com", "senha654!"));
        usuarios.add(new Usuario("Bruno", "bruno@email.com", "senha987!"));
        usuarios.add(new Usuario("Letícia", "leticia@email.com", "senha159!"));
    }

    public void navegar(){
        while (true) {
            view.exibirMenu();
            switch (Integer.parseInt(receberInput("Digite sua escolha:"))){
                case 1:
                    validarCredenciais();
                    break;
                case 2:
                    sair();
                    return;
                default:
                    view.exibirMensagem("Escolha inválida!");
                    break;
            }
            if(tentativas <= 0){
                sair();
                return;
            }
        }

    }
    public void validarCredenciais(){
        while (tentativas >= 0) {
            String email = receberInput("Email:");
            String senha = receberInput("Senha:");
            if (tentativas > 0) {
                if (!encontrarUsuario(email, senha).isEmpty()) {
                    view.exibirMensagem("Usuário encontrado, seja bem vindo!");
                    tentativas = 3;
                    return;
                } else {
                    view.exibirMensagem("Email ou Senha incorretos");
                    tentativas--;
                    if (!receberInput("Tentar novamente?(s/n)").toLowerCase().contains("s")){
                        return;
                    }
                }
            } else {
                view.exibirMensagem("Limite de tentativas excedido!\n\nSaindo do sistema...");
                return;
            }
        }
    }

    public String encontrarUsuario(String email, String senha){
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return usuario.getNome();
            }
        }
        return "";
    }

    public String receberInput(String mensagem){
        view.exibirMensagem(mensagem);
        return scanner.nextLine();
    }

    public void sair(){
        scanner.close();
    }
}
