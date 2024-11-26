package estoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroCategoria extends JFrame {
    private JTextField txtNome, txtDescricao;
    private JButton btnCadastrar, btnVoltar;

    public CadastroCategoria() {
        setTitle("Cadastro de Categoria");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Componentes
        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        add(txtDescricao);

        btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar);

        btnVoltar = new JButton("Voltar");
        add(btnVoltar);

        // Ação para cadastrar
        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText();
            String descricao = txtDescricao.getText();

            if (nome.isEmpty() || descricao.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Categoria categoria = new Categoria(nome, descricao);
            CategoriaDAO dao = new CategoriaDAO();
            if (dao.cadastrarCategoria(categoria)) {
                JOptionPane.showMessageDialog(this, "Categoria cadastrada com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar categoria.", "Erro", JOptionPane.ERROR_MESSAGE);
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
    }
}

