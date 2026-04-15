package repository;

import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    public void salvar(Produto p) throws SQLException {
        String sql = "INSERT INTO produto (id, nome, preco) VALUES (?, ?, ?)";

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ){
            stmt.setString(1, p.getId());
            stmt.setString(2, p.getNome());
            stmt.setDouble(3, p.getPreco());

            stmt.executeUpdate();
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ){
            while(rs.next()) {
                Produto p = new Produto(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco")
                );

                produtos.add(p);
            }
        }
    }
}
