package estoque;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultaCliente extends JFrame {

    private JTable tabelaClientes;
    private DefaultTableModel modeloTabela;
    private ClienteDAO clienteDAO;

    public ConsultaCliente() {
        // Configuração da janela
        setTitle("Consulta de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        clienteDAO = new ClienteDAO();

        // Configurar tabela
        String[] colunas = {"ID", "Nome Completo", "CPF", "Origem", "Score"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaClientes = new JTable(modeloTabela);

        // Botão para carregar os dados
        JButton btnCarregar = new JButton("Carregar Clientes");
        btnCarregar.addActionListener(e -> carregarDados());

        // Layout
        setLayout(new BorderLayout());
        add(new JScrollPane(tabelaClientes), BorderLayout.CENTER);
        add(btnCarregar, BorderLayout.SOUTH);
    }

    // Método para carregar os dados na tabela
    private void carregarDados() {
        // Limpar os dados existentes na tabela
        modeloTabela.setRowCount(0);

        // Obter lista de clientes do banco de dados
        List<Cliente> clientes = clienteDAO.listarClientes();
        for (Cliente cliente : clientes) {
            Object[] linha = {
                cliente.getIdCliente(),
                cliente.getNomeCompleto(),
                cliente.getCpf(),
                cliente.getOrigem(),
                cliente.getScore()
            };
            modeloTabela.addRow(linha);
        }

        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente encontrado!", "Consulta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Clientes carregados com sucesso!", "Consulta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método principal para teste
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConsultaCliente telaConsulta = new ConsultaCliente();
            telaConsulta.setVisible(true);
        });
    }
}


