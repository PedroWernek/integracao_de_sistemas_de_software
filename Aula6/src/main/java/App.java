import model.Produto;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        try {
            APIServer.run();

        }catch (IOException e){
            System.out.println("Erro ao rodar servidor:" + e.getMessage());
        }

    }
}
