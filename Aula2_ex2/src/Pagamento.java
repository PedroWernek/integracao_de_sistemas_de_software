public interface Pagamento {

    default void pagar(){
        System.out.println("Pago");
    }
    default void imprimirRecibo(){
        System.out.println("recibo impresso");
    }
}
