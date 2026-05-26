package service;

import model.Produto;
import repository.ProdutoRepository;

import java.util.List;
import java.util.UUID;

public class ProdutoService {
    //chamando aonde vai haver a comunicação com o banco
    private final ProdutoRepository produtoRepository = new ProdutoRepository();

    public Produto criarProduto(Produto p) throws Exception{
        //criando regra de negócio
        if(p.getNome() == null || p.getNome().isEmpty()){
            throw new Exception("Nome é obrigatório");
        }

        p.setId(UUID.randomUUID().toString());

        produtoRepository.salvar(p);

        return p;
    }

    public List<Produto> listarProdutos() throws Exception{
        return produtoRepository.listar();
    }
}
