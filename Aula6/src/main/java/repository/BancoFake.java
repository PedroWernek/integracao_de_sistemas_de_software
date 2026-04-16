package repository;

import model.Produto;

import java.util.List;

public class BancoFake {

    public static List<Produto> produtos;

    static{
        produtos.add(new Produto("1","Notebook", 15000.00));
        produtos.add(new Produto("2","Teclado", 300.00));
        produtos.add(new Produto("3","Mouse", 400.00));
    }
}
