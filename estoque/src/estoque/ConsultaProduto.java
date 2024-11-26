package estoque;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultaProduto extends JFrame {
    private JTable tabelaProdutos;
    private DefaultTableModel modeloTabela;
    private JButton btnVoltar;

    public ConsultaProduto() {
        setTitle("Consulta de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configurar tabela
        modeloTabela = new DefaultTableModel(new String[]{"ID", "Nome", "Descrição", "Preço", "Quantidade", "Categoria", "Usuário"}, 0);
        tabelaProdutos = new JTable(modeloTabela);

        // Botões
        btnVoltar = new JButton("Voltar");

        // Adicionar componentes
        add(new JScrollPane(tabelaProdutos), BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);

        // Carregar dados
        carregarProdutos();

        // Ação para voltar
        btnVoltar.addActionListener(e -> {
            GUIPrincipal menu = new GUIPrincipal();
            menu.setVisible(true);
            dispose();
        });
    }

    private void carregarProdutos() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.listarProdutos();

        for (Produto produto : produtos) {
            modeloTabela.addRow(new Object[]{
                    produto.getIdProduto(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco(),
                    produto.getQuantidade(),
                    produto.getIdCategoria(),
                    produto.getIdUsuario()
            });
        }

        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum produto encontrado.", "Consulta", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
