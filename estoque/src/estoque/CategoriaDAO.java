package estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    // Método para cadastrar uma nova categoria no banco de dados
    public boolean cadastrarCategoria(Categoria categoria) {
        String sql = "INSERT INTO Categoria (nome, descricao) VALUES (?, ?)";

        try (Connection conn = Db.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar categoria.");
            e.printStackTrace();
        }
        return false;
    }

    // Método para listar todas as categorias
    public List<Categoria> listarCategorias() {
        String sql = "SELECT idCategoria, nome, descricao FROM Categoria";
        List<Categoria> categorias = new ArrayList<>();

        try (Connection conn = Db.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));

                categorias.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar categorias.");
            e.printStackTrace();
        }
        return categorias;
    }
}
