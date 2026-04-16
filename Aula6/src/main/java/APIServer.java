import com.sun.net.httpserver.HttpServer;
import controller.ProdutoHandler;
import model.Produto;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

public class APIServer {
    public static void run() throws IOException {
        int port = 1040;

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/produtos", new ProdutoHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server em http://localhost:"+port+"/produtos");

    }
}
