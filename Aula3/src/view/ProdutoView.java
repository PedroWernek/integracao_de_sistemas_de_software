package view;

import model.Produto;

import java.util.List;

public class ProdutoView {

    public void exibirProduto(Produto produto) {
        System.out.println("\n=== Detalhes do Produto ===");
        System.out.println("ID: " + produto.getId());
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: R$ " + produto.getPreco());
    }

    public void listarProdutos(List<Produto> produtos){
        System.out.println("\n=== Lista de Produtos ===");
        for (Produto p : produtos) {
            System.out.println(p.getId() + " - " + p.getNome()
                    + " - R$ " + p.getPreco());
        }
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }
}
