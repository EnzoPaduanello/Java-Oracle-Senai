package estoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProduto extends JFrame {
    private JTextField txtNome, txtDescricao, txtPreco, txtQuantidade, txtIdCategoria, txtIdUsuario;
    private JButton btnCadastrar, btnVoltar;

    public CadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));

        // Componentes
        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        add(txtDescricao);

        add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        add(txtPreco);

        add(new JLabel("Quantidade:"));
        txtQuantidade = new JTextField();
        add(txtQuantidade);

        add(new JLabel("ID Categoria:"));
        txtIdCategoria = new JTextField();
        add(txtIdCategoria);

        add(new JLabel("ID Usuário:"));
        txtIdUsuario = new JTextField();
        add(txtIdUsuario);

        btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar);

        btnVoltar = new JButton("Voltar");
        add(btnVoltar);

        // Ação para cadastrar
        btnCadastrar.addActionListener(e -> {
            try {
                Produto produto = new Produto(
                        txtNome.getText(),
                        txtDescricao.getText(),
                        Float.parseFloat(txtPreco.getText()),
                        Integer.parseInt(txtQuantidade.getText()),
                        Integer.parseInt(txtIdCategoria.getText()),
                        Integer.parseInt(txtIdUsuario.getText())
                );

                ProdutoDAO dao = new ProdutoDAO();
                if (dao.cadastrarProduto(produto)) {
                    JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Preencha os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Ação para voltar
        btnVoltar.addActionListener(e -> {
            GUIPrincipal menu = new GUIPrincipal();
            menu.setVisible(true);
            dispose();
        });
    }

    private void limparCampos() {
        txtNome.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
        txtIdCategoria.setText("");
        txtIdUsuario.setText("");
    }
}
