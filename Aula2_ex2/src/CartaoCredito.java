public class CartaoCredito implements Pagamento{
    private int parecelas;

    public CartaoCredito(int parecelas) {
        this.parecelas = parecelas;
    }

    @Override
    public void pagar(){
        System.out.println("pago em " + parecelas + "parcelas");
    }
}
