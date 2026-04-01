package repository;

import model.Produto;

import java.util.*;

public class BancoFake {
    public static List<Produto> produtos = new ArrayList<>();
    static {
        produtos.add(new Produto("1", "Notebook", 3500));
        produtos.add(new Produto("2", "Mouse", 80));
    }
}
