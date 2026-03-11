public class Produto {
    private final String descricao;
    private final double preco;

    public Produto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "\n\t\tProduto: {" +
                "\n\t\t\tdescricao='" + descricao + '\'' +
                "\n\t\t\tpreco=" + preco +
                "\n\t\t}";
    }
}
