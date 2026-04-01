import controller.ProdutoController;
import view.ProdutoView;

public class App {
    public static void run() {
        ProdutoView view = new ProdutoView();
        ProdutoController controller = new ProdutoController(view);
        controller.adicionarProduto(1, "Teclado", 250.00);
        controller.adicionarProduto(2, "Mouse", 150.00);
        controller.adicionarProduto(3, "Monitor", 899.90);
        controller.listarTodos();
        controller.atualizarProduto(2, "Mouse Gamer RGB",
                199.90);
        controller.exibirProduto(2);
    }
}