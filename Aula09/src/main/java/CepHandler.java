import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class CepHandler implements HttpHandler {
    private final CepService cepService = new CepService();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String metodo = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        try {
            if (metodo.equals("GET") && path.startsWith("/cep")) {
                buscarCep(exchange);
            }
        }catch (Exception e){
            enviarErro(exchange, e.getMessage());
        }
    }

    private void buscarCep(HttpExchange exchange) throws Exception
    {
        String cep = exchange.getRequestURI().getPath().split("/")[2];
        Endereco endereco = cepService.buscarEndereco(cep);
        String json = mapper.writeValueAsString(endereco);
        enviar(exchange, json);
    }

    private void enviar(HttpExchange exchange, String resposta) throws IOException {
        byte[] rs = resposta.getBytes();

        exchange.getResponseHeaders().add("Content-type","application/json");
        exchange.sendResponseHeaders(200, rs.length);

        OutputStream os = exchange.getResponseBody();
        os.write(rs);
        os.close();
    }

    private void enviarErro(HttpExchange exchange, String erro) throws IOException {
        byte[] rs = erro.getBytes();

        exchange.sendResponseHeaders(400, rs.length);
        OutputStream os = exchange.getResponseBody();
        os.write(rs);
        os.close();
    }

}
