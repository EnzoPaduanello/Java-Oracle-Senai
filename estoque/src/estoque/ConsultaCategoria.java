package estoque;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultaCategoria extends JFrame {
    private JTable tabelaCategorias;
    private DefaultTableModel modeloTabela;
    private JButton btnVoltar;

    public ConsultaCategoria() {
        setTitle("Consulta de Categorias");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configurar tabela
        modeloTabela = new DefaultTableModel(new String[]{"ID", "Nome", "Descrição"}, 0);
        tabelaCategorias = new JTable(modeloTabela);

        // Botões
        btnVoltar = new JButton("Voltar");

        // Adicionar componentes
        add(new JScrollPane(tabelaCategorias), BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);

        // Carregar dados
        carregarCategorias();

        // Ação para voltar
        btnVoltar.addActionListener(e -> {
            GUIPrincipal menu = new GUIPrincipal();
            menu.setVisible(true);
            dispose();
        });
    }

    private void carregarCategorias() {
        CategoriaDAO dao = new CategoriaDAO();
        List<Categoria> categorias = dao.listarCategorias();

        for (Categoria categoria : categorias) {
            modeloTabela.addRow(new Object[]{
                    categoria.getIdCategoria(),
                    categoria.getNome(),
                    categoria.getDescricao()
            });
        }

        if (categorias.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma categoria encontrada.", "Consulta", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}


