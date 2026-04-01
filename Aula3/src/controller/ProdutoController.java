package controller;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import view.ProdutoView;

public class ProdutoController {
    private List<Produto> produtos;
    private ProdutoView view;

    public ProdutoController(ProdutoView view) {
        this.produtos = new ArrayList<>();
        this.view = view;
    }

    public void adicionarProduto(int id, String nome, double
            preco) {
        Produto p = new Produto(id, nome, preco);
        produtos.add(p);
        view.mostrarMensagem("Produto adicionado com sucesso!");
    }

    public void atualizarProduto(int id, String novoNome, double novoPreco) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setNome(novoNome);
                p.setPreco(novoPreco);
                view.mostrarMensagem("Produto atualizado!");
                return;
            }
        }
        view.mostrarMensagem("Produto não encontrado.");
    }
    public void exibirProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                view.exibirProduto(p);
                return;
            }
        }
        view.mostrarMensagem("Produto não encontrado.");
    }
    public void listarTodos() {
        view.listarProdutos(produtos);
    }
}