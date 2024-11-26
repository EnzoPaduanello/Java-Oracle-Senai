package estoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuario extends JFrame {
    private JTextField txtNome, txtEmail, txtSenha, txtIdPerfil;
    private JButton btnCadastrar, btnVoltar;

    public CadastroUsuario() {
        setTitle("Cadastro de Usuário");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Componentes
        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel("Senha:"));
        txtSenha = new JTextField();
        add(txtSenha);

        add(new JLabel("ID Perfil:"));
        txtIdPerfil = new JTextField();
        add(txtIdPerfil);

        btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar);

        btnVoltar = new JButton("Voltar");
        add(btnVoltar);

        // Ação para cadastrar
        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText();
            String email = txtEmail.getText();
            String senha = txtSenha.getText();
            int idPerfil;

            try {
                idPerfil = Integer.parseInt(txtIdPerfil.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID Perfil deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Usuario usuario = new Usuario(nome, email, senha, idPerfil);
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.cadastrarUsuario(usuario)) {
                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
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
        txtEmail.setText("");
        txtSenha.setText("");
        txtIdPerfil.setText("");
    }
}

