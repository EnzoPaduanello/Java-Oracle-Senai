package estoque;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultaUsuario extends JFrame {
    private JTable tabelaUsuarios;
    private DefaultTableModel modeloTabela;
    private JButton btnVoltar;

    public ConsultaUsuario() {
        setTitle("Consulta de Usuários");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configurar tabela
        modeloTabela = new DefaultTableModel(new String[]{"ID", "Nome", "Email", "Senha", "Perfil"}, 0);
        tabelaUsuarios = new JTable(modeloTabela);

        // Botões
        btnVoltar = new JButton("Voltar");

        // Adicionar componentes
        add(new JScrollPane(tabelaUsuarios), BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);

        // Carregar dados
        carregarUsuarios();

        // Ação para voltar
        btnVoltar.addActionListener(e -> {
            GUIPrincipal menu = new GUIPrincipal();
            menu.setVisible(true);
            dispose();
        });
    }

    private void carregarUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.listarUsuarios();

        for (Usuario usuario : usuarios) {
            modeloTabela.addRow(new Object[]{
                    usuario.getIdUsuario(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.getIdPerfil()
            });
        }

        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum usuário encontrado.", "Consulta", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

