import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Servidor {
    public static void run() throws IOException {

        int porta = 8080;
        String caminho = "/produtos";
        HttpServer server = HttpServer.create(new InetSocketAddress(porta),0);
        server.createContext(caminho, new ProdutoHandler());

        System.out.println("Microsserviço de Produtos rodando em " +
                "http://localhost:" + porta + caminho);

        server.start();
    }
}
