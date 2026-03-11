import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Produto> produtos = new HashSet<Produto>();

        String decricao;
        double preco;

        String nome;
        System.out.print("Digite seu nome: ");
        nome = scanner.nextLine();
        String cpf;
        System.out.print("Digite seu cpf: ");
        cpf = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf);



        for (int i = 0; i < 3; i++) {
            //try {
                System.out.printf("\n=== Produto %d ===\n -decricao: ", i + 1);
                decricao = scanner.nextLine();
                System.out.print("- preco: ");
                preco = Double.parseDouble(scanner.nextLine());
                Produto produto = new Produto(decricao, preco);
                produtos.add(produto);
            //}catch (Exception e){
               // i--;
            //}
        }

        Venda venda = new Venda(produtos, cliente);
        System.out.println(venda);
    }
}