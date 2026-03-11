import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Venda {
    private final Set<Produto> produtos = new HashSet<>();
    private final Cliente cliente;

    public Venda(Set<Produto> produtos, Cliente cliente){
        this.cliente = cliente;
        this.produtos.addAll(produtos);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "produtos=" + produtos +
                ", cliente=" + cliente +
                '}';
    }
}
