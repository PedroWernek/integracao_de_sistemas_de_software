public class Circulo implements Forma{
    private double raio;
    private double diametro;

    public Circulo(double raio) {
        this.raio = raio;
        this.diametro = (raio*2);
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio,2);
    }

    @Override
    public double calcularPerimetro() {
        return Math.PI * Math.pow((diametro/2),2);
    }
}
