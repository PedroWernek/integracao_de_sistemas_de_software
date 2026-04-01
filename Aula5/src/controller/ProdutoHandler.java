package controller;

import com.sun.net.httpserver.*;
import model.Produto;
import repository.BancoFake;

import java.io.*;
import java.util.*;

public class ProdutoHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        //redirecionamento para cada tipo de método pedido
        String metodo = exchange.getRequestMethod();
        String caminho = exchange.getRequestURI().getPath();
        String[] partes = caminho.split("/");
        if (metodo.equals("GET")) {
            if (partes.length > 2){
                pegarProdutoPorID(exchange, partes[2]);
            }else {
                listarProdutos(exchange);
            }
        } else if (metodo.equals("POST")) {
            criarProduto(exchange);
        }else if(metodo.equals("DELETE") && partes.length > 2){
            excluirProduto(exchange, partes[2]);
        }else {
            exchange.sendResponseHeaders(405, -1);
        }
    }

    private void listarProdutos(HttpExchange exchange) throws IOException
    {
        String json = "[";
        for (int i = 0; i < BancoFake.produtos.size(); i++) {
            Produto p = BancoFake.produtos.get(i);
            json += String.format(
                    "{\"id\":\"%s\",\"nome\":\"%s\",\"preco\":%f}",
                    p.getId(), p.getNome(), p.getPreco()
            );
            if (i < BancoFake.produtos.size() - 1) {
                json += ",";
            }
        }
        json += "]";
        enviarResposta(exchange, json);
    }

    private void criarProduto(HttpExchange exchange) throws IOException
    {
        InputStream is = exchange.getRequestBody();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String body = reader.readLine();

        // Exemplo simples (sem parsing JSON real)
        Produto p = new Produto(UUID.randomUUID().toString(), body, 0);

        BancoFake.produtos.add(p);
        enviarResposta(exchange, "{\"mensagem\":\"Produto criado\"}");
    }

    private void excluirProduto(HttpExchange exchange, String id) throws IOException
    {
        InputStream is = exchange.getRequestBody();
        String json = "[";
        for (Produto p : BancoFake.produtos){
            if(p.getId().equals(id)){
                json += String.format(
                        "{\"id\":\"%s\",\"nome\":\"%s\",\"preco\":%f}",
                        p.getId(), p.getNome(), p.getPreco()
                );
                json += "]";
                BancoFake.produtos.remove(p);
                enviarResposta(exchange,json + "Produto excluido com sucesso");
                return;
            }
        }
        enviarResposta(exchange, "Produto não encontrado");
    }

    private void enviarResposta(HttpExchange exchange, String resposta) throws IOException
    {
        exchange.getResponseHeaders().add("Content-Type",
                "application/json");
        exchange.sendResponseHeaders(200,
                resposta.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(resposta.getBytes());
        os.close();
    }

    private void pegarProdutoPorID(HttpExchange exchange, String id) throws IOException
    {
        String json = "[";
        for (Produto p : BancoFake.produtos){
            if(p.getId().equals(id)){
                json += String.format(
                        "{\"id\":\"%s\",\"nome\":\"%s\",\"preco\":%f}",
                        p.getId(), p.getNome(), p.getPreco()
                );
                json += "]";
                enviarResposta(exchange,json);
                return;
            }
        }
        enviarResposta(exchange, "Produto não encontrado");
    }
}

