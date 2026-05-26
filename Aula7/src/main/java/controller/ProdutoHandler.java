package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import model.Produto;
import service.ProdutoService;

import java.io.IOException;
import java.util.List;

public class ProdutoHandler implements HttpHandler {
    private ObjectMapper mapper = new ObjectMapper();
    private ProdutoService service = new ProdutoService();
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            if(exchange.getRequestMethod().equals("GET")){
                listar(exchange);
            } else if (exchange.getRequestMethod().equals("POST")) {
                
            } else{
                exchange.sendResponseHeaders(405,-1);
            }
        }catch (Exception e){
            exchange.sendResponseHeaders(500,-1);
        }
    }

    private void listar(HttpExchange exchange) throws Exception{

        List<Produto> produtos = service.listarProdutos();
        mapper.writeValueAsString(produtos);
    }
}
