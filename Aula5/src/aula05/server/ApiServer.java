package aula05.server;

import com.sun.net.httpserver.HttpServer;
import controller.ProdutoHandler;

import java.net.InetSocketAddress;

public class ApiServer {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/produtos", new ProdutoHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("API rodando na porta 8000...");
    }
}