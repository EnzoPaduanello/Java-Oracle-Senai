package estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public boolean cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO Produto (nome, descricao, preco, quantidade, Categoria_idCategoria, Usuario_idUsuario) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Db.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setFloat(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getIdCategoria());
            stmt.setInt(6, produto.getIdUsuario());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto.");
            e.printStackTrace();
        }
        return false;
    }

    public List<Produto> listarProdutos() {
        String sql = "SELECT p.idProduto, p.nome AS produtoNome, p.descricao, p.preco, p.quantidade, " +
                     "p.Categoria_idCategoria, p.Usuario_idUsuario, " +
                     "c.nome AS categoriaNome, u.nome AS usuarioNome " +
                     "FROM Produto p " +
                     "JOIN Categoria c ON p.Categoria_idCategoria = c.idCategoria " +
                     "JOIN Usuario u ON p.Usuario_idUsuario = u.idUsuario";

        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = Db.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("produtoNome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setIdCategoria(rs.getInt("Categoria_idCategoria")); // ID da categoria
                produto.setIdUsuario(rs.getInt("Usuario_idUsuario"));       // ID do usuário

                // Mensagens para depuração
                System.out.println("Produto: " + produto.getNome());
                System.out.println("Categoria: " + rs.getString("categoriaNome"));
                System.out.println("Usuário: " + rs.getString("usuarioNome"));

                produtos.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos.");
            e.printStackTrace();
        }
        return produtos;
    }
}
