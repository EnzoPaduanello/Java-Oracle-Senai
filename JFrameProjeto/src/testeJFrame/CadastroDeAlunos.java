package testeJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CadastroDeAlunos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JTextField textFieldDataNasc;
	private JTextField textFieldCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeAlunos frame = new CadastroDeAlunos();
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
	public CadastroDeAlunos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Alunos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 0, 217, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Completo:");
		lblNewLabel_1.setBounds(20, 48, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(130, 45, 145, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Número da Matrícula:");
		lblNewLabel_2.setBounds(20, 73, 109, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento:");
		lblNewLabel_3.setBounds(20, 104, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Curso Matriculado:");
		lblNewLabel_4.setBounds(20, 129, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);
		textFieldMatricula.setBounds(130, 73, 145, 20);
		contentPane.add(textFieldMatricula);
		
		textFieldDataNasc = new JTextField();
		textFieldDataNasc.setColumns(10);
		textFieldDataNasc.setBounds(130, 101, 145, 20);
		contentPane.add(textFieldDataNasc);
		
		textFieldCurso = new JTextField();
		textFieldCurso.setColumns(10);
		textFieldCurso.setBounds(130, 126, 145, 20);
		contentPane.add(textFieldCurso);
		
		JLabel lblNewLabel_5 = new JLabel("Status:");
		lblNewLabel_5.setBounds(20, 154, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtnRadioButtonStatusAtivo = new JRadioButton("Ativo");
		rdbtnRadioButtonStatusAtivo.setBounds(72, 150, 57, 23);
		contentPane.add(rdbtnRadioButtonStatusAtivo);
		
		JRadioButton rdbtnRadioButtonStatusInativo = new JRadioButton("Inativo");
		rdbtnRadioButtonStatusInativo.setBounds(130, 150, 109, 23);
		contentPane.add(rdbtnRadioButtonStatusInativo);
		
		JButton btnNewButton = new JButton("Exibir Alunos");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnNewButton.setBounds(175, 185, 150, 30);
		contentPane.add(btnNewButton);
	}
}
