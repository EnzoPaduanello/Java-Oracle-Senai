package estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Método para cadastrar um novo usuário
    public boolean cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nome, email, senha, perfil_idperfil) VALUES (?, ?, ?, ?)";

        try (Connection conn = Db.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getIdPerfil());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário.");
            e.printStackTrace();
        }
        return false;
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() {
        String sql = "SELECT u.idUsuario, u.nome, u.email, u.senha, p.nome AS perfil " +
                     "FROM Usuario u " +
                     "JOIN perfil p ON u.perfil_idperfil = p.idperfil";

        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = Db.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setIdPerfil(rs.getInt("perfil"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários.");
            e.printStackTrace();
        }
        return usuarios;
    }
}
