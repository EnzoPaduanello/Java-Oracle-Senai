package estoque;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPrincipal extends JFrame {

    public GUIPrincipal() {
        // Configuração da janela principal
        setTitle("Sistema de Controle de Estoque");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu principal
        JMenuBar menuBar = new JMenuBar();

        // Menu Cliente
        JMenu menuCliente = new JMenu("Cliente");

        // Opção Cadastro
        JMenuItem itemCadastro = new JMenuItem("Cadastro");
        itemCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir a tela de cadastro de cliente
                CadCliente telaCadastro = new CadCliente();
                telaCadastro.setVisible(true);
            }
        });

        // Opção Consulta
        JMenuItem itemConsulta = new JMenuItem("Consulta");
        itemConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir a tela de consulta de cliente
                ConsultaCliente telaConsulta = new ConsultaCliente();
                telaConsulta.setVisible(true);
            }
        });

        // Adicionar opções ao menu Cliente
        menuCliente.add(itemCadastro);
        menuCliente.add(itemConsulta);

        // Adicionar menus à barra de menu
        menuBar.add(menuCliente);

        // Configurar barra de menu na janela principal
        setJMenuBar(menuBar);
    }

    // Método principal para rodar a interface
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUIPrincipal telaPrincipal = new GUIPrincipal();
            telaPrincipal.setVisible(true);
        });
    }
}