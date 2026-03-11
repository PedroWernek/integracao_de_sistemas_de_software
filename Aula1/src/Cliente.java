public class Cliente {
    private final String nome;
    private final String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\n\t\tCliente: {" +
                "\n\t\t\tnome='" + nome + '\'' +
                "\n\t\t\tcpf='" + cpf + '\'' +
                "\n\t\t}";
    }
}
