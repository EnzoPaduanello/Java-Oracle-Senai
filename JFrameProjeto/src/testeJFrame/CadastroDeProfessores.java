package testeJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroDeProfessores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldNumIdentificacao;
	private JTextField textFieldDepartamento;
	private JComboBox comboBoxDisciplinas;
    private JLabel lblResultado;
	
	private ArrayList<String> listaNomes = new ArrayList<>();
	private ArrayList<String> listaNumIdentificacao = new ArrayList<>();
	private ArrayList<String> listaDepartamentos = new ArrayList<>();
	private ArrayList<String> listaDisciplinas = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeProfessores frame = new CadastroDeProfessores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroDeProfessores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Disciplinas");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(117, 36, 57, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(57, 57, 150, 20);
		contentPane.add(textFieldNome);
		
		JLabel lblNmeroDeIdentificao = new JLabel("Número de Identificação:");
		lblNmeroDeIdentificao.setBounds(57, 100, 150, 20);
		contentPane.add(lblNmeroDeIdentificao);
		
		textFieldNumIdentificacao = new JTextField();
		textFieldNumIdentificacao.setColumns(10);
		textFieldNumIdentificacao.setBounds(57, 131, 150, 20);
		contentPane.add(textFieldNumIdentificacao);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(292, 36, 84, 14);
		contentPane.add(lblDepartamento);
		
		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setColumns(10);
		textFieldDepartamento.setBounds(256, 57, 150, 20);
		contentPane.add(textFieldDepartamento);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProfessor();
			}
		});
		btnCadastrar.setBounds(80, 184, 110, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnExibirFuncionario = new JButton("Exibir Funcionário");
		btnExibirFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirListaProfessores();			}
		});
		btnExibirFuncionario.setBounds(246, 184, 150, 23);
		contentPane.add(btnExibirFuncionario);
		
		lblResultado = new JLabel(" ");
		lblResultado.setBounds(76, 218, 300, 14);
		contentPane.add(lblResultado);

		String[] options = {"Selecione Uma Opção:", "Redes", "Banco de Dados", "Programação Web", "Ux e Ui"};
		
		comboBoxDisciplinas = new JComboBox(options);
		comboBoxDisciplinas.setBounds(246, 130, 173, 22);
		
		contentPane.add(comboBoxDisciplinas);
		
		JLabel lblNewLabel = new JLabel("Disciplinas:");
		lblNewLabel.setBounds(292, 103, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Professor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 322, 14);
		contentPane.add(lblNewLabel_1);
        
	}
	
	private void cadastrarProfessor() {
		try {
			String nome = textFieldNome.getText();
			String numIdentificacao = textFieldNumIdentificacao.getText();
			String departamento = textFieldDepartamento.getText();
			String disciplina = (String) comboBoxDisciplinas.getSelectedItem();
			
			if (nome.isEmpty()) {
                lblResultado.setText("Erro: Campo 'Nome' está vazio.");
                return;
            }

            if (numIdentificacao.isEmpty()) {
                lblResultado.setText("Erro: Campo 'numIdentificacao' está vazio.");
                return;
            }

            if (departamento.isEmpty()) {
                lblResultado.setText("Erro: Campo 'departamento' está vazio.");
                return;
            }
            
            if (disciplina.isEmpty()) {
                lblResultado.setText("Erro: Campo 'disciplina' está vazio.");
                return;
            }
            
            listaNomes.add(nome);
            listaNumIdentificacao.add(numIdentificacao);
            listaDepartamentos.add(departamento);
            listaDisciplinas.add(disciplina);
            
            lblResultado.setText("Professor " + nome + " Cadastrado com Sucesso");	
            
            textFieldNome.setText("");
            textFieldNumIdentificacao.setText("");
            textFieldDepartamento.setText("");
            comboBoxDisciplinas.setSelectedIndex(0);
		} catch (Exception ex) {
            lblResultado.setText("Erro ao cadastrar professor.");
        };
	}
	
	private void exibirListaProfessores() {
		System.out.println("Lista de Professores Cadastrados:");
        for (int i = 0; i < listaNomes.size(); i++) {
            System.out.println("Aluno " + (i + 1) + ":");
            System.out.println("Nome: " + listaNomes.get(i));
            System.out.println("Número de Identificação: " + listaNumIdentificacao.get(i));
            System.out.println("Departamento: " + listaDepartamentos.get(i));
            System.out.println("Disciplina: " + listaDisciplinas.get(i));
            System.out.println("--------------------------");
        }
	}
}
