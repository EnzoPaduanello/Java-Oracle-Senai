package estoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadCliente extends JFrame {
    
    private JLabel lblNomeCompleto, lblCpf, lblOrigem, lblScore;
    private JTextField txtNomeCompleto, txtCpf, txtOrigem, txtScore;
    private JButton btnCadastrar, btnVoltar;

    public CadCliente() {
        // Configurações do JFrame
        setTitle("Cadastro de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10)); // Grid com 6 linhas e 2 colunas

        // Inicializar componentes
        lblNomeCompleto = new JLabel("Nome Completo:");
        lblCpf = new JLabel("CPF:");
        lblOrigem = new JLabel("Origem:");
        lblScore = new JLabel("Score:");
        
        txtNomeCompleto = new JTextField();
        txtCpf = new JTextField();
        txtOrigem = new JTextField();
        txtScore = new JTextField();
        
        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");

        // Adicionar componentes ao JFrame
        add(lblNomeCompleto);
        add(txtNomeCompleto);
        
        add(lblCpf);
        add(txtCpf);
        
        add(lblOrigem);
        add(txtOrigem);
        
        add(lblScore);
        add(txtScore);
        
        add(btnCadastrar);
        add(btnVoltar);

        // Ação para o botão "Cadastrar"
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCompleto = txtNomeCompleto.getText();
                String cpf = txtCpf.getText();
                String origem = txtOrigem.getText();
                int score;

                try {
                    score = Integer.parseInt(txtScore.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Score deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Cliente novoCliente = new Cliente(nomeCompleto, cpf, origem, score);
                ClienteDAO clienteDAO = new ClienteDAO();
                boolean sucesso = clienteDAO.cadastrarCliente(novoCliente);

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação para o botão "Voltar"
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Voltar para o menu principal
                GUIPrincipal menuPrincipal = new GUIPrincipal();
                menuPrincipal.setVisible(true);
                dispose();
            }
        });
    }

    // Método para limpar os campos após o cadastro
    private void limparCampos() {
        txtNomeCompleto.setText("");
        txtCpf.setText("");
        txtOrigem.setText("");
        txtScore.setText("");
    }

    // Método principal para rodar a interface (opcional para testes)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadCliente telaCadastro = new CadCliente();
            telaCadastro.setVisible(true);
        });
    }
}

