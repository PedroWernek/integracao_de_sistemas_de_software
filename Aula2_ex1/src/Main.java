import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Forma> formas = new ArrayList<>();

        Forma f1 = new Circulo(10);
        Forma f2 = new Retangulo(10, 20);
        formas.addAll(Arrays.asList(f1,f2));

        for(Forma forma : formas) {
            System.out.println(forma);
            System.out.println(forma.calcularArea());
            System.out.println(forma.calcularPerimetro());
            System.out.println();
        }
    }
}