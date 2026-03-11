import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Animal a1 = new Cachorro();
        Animal a2 = new Gato();

        List<Animal> animais = new ArrayList<>();
        animais.add(a1);
        animais.add(a2);

        for (Animal animal : animais) {
            animal.emitirSom();
        }
    }
}