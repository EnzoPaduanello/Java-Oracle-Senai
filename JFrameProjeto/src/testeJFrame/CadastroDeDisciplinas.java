package testeJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class CadastroDeDisciplinas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDisciplina;
	private JTextField textFieldProfessor;
	private JTextField textFieldCodigo;
	private JTextField textFieldCargaHoraria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeDisciplinas frame = new CadastroDeDisciplinas();
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
	public CadastroDeDisciplinas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Disciplinas: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 226, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeDaDisciplina = new JLabel("Nome da Disciplina:");
		lblNomeDaDisciplina.setBounds(50, 41, 141, 14);
		contentPane.add(lblNomeDaDisciplina);
		
		textFieldDisciplina = new JTextField();
		textFieldDisciplina.setColumns(10);
		textFieldDisciplina.setBounds(31, 62, 150, 20);
		contentPane.add(textFieldDisciplina);
		
		JLabel lblProfessorResponsvel = new JLabel("Professor Responsável:");
		lblProfessorResponsvel.setBounds(31, 105, 150, 20);
		contentPane.add(lblProfessorResponsvel);
		
		textFieldProfessor = new JTextField();
		textFieldProfessor.setColumns(10);
		textFieldProfessor.setBounds(31, 136, 150, 20);
		contentPane.add(textFieldProfessor);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(278, 41, 84, 14);
		contentPane.add(lblCdigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(230, 62, 150, 20);
		contentPane.add(textFieldCodigo);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(54, 189, 110, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnExibirFuncionario = new JButton("Exibir Funcionário");
		btnExibirFuncionario.setBounds(220, 189, 150, 23);
		contentPane.add(btnExibirFuncionario);
		
		JLabel lblResultado = new JLabel(" ");
		lblResultado.setBounds(50, 223, 300, 14);
		contentPane.add(lblResultado);
		
		JLabel lblCargaHorria = new JLabel("Carga Horária:");
		lblCargaHorria.setBounds(266, 108, 84, 14);
		contentPane.add(lblCargaHorria);
		
		textFieldCargaHoraria = new JTextField();
		textFieldCargaHoraria.setColumns(10);
		textFieldCargaHoraria.setBounds(230, 136, 150, 20);
		contentPane.add(textFieldCargaHoraria);
	}

}
