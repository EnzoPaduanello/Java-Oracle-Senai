package testeJFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;

public class ClasseTesteJFrame extends JFrame {
	int numero = 1;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nota2TextField;
	private JTextField nota1TextField;
	private JLabel lblNewLabel_1;
	private JTextField nomeTextField;
	private JLabel lblNewLabel_2;
	private JTextArea resultadoTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClasseTesteJFrame frame = new ClasseTesteJFrame();
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
	public ClasseTesteJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nota 1:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(97, 88, 75, 14);
		contentPane.add(lblNewLabel);
		
		nota1TextField = new JTextField();
		nota1TextField.setColumns(10);
		nota1TextField.setBounds(60, 106, 118, 20);
		contentPane.add(nota1TextField);
		
		JLabel lblNota = new JLabel("Nota 2:");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNota.setBounds(291, 88, 54, 14);
		contentPane.add(lblNota);
		
		nota2TextField = new JTextField();
		nota2TextField.setBounds(257, 106, 118, 20);
		contentPane.add(nota2TextField);
		nota2TextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular Média");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeTextField.getText();
				double nota1 = Double.parseDouble(nota1TextField.getText());
				double nota2 = Double.parseDouble(nota2TextField.getText());
				
				double media = (nota1 + nota2) / 2;
				
				String resultado;
				
				if(media > 0) {
					
					if(media >= 7.0) {
						resultado = "passou!";
					} else {
						resultado = "reprovou!";
					} 
					
					resultadoTextArea.setText(nome + "\n" + "O valor da média é: " + media + "\n" + "Você " + resultado);
					
				} else {
					resultadoTextArea.setText("Digite um número válido!");
				}
			}
		});
		btnNewButton.setBounds(164, 146, 118, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(197, 34, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(60, 56, 315, 20);
		contentPane.add(nomeTextField);
		
		lblNewLabel_2 = new JLabel("Calculo de Média");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 0, 174, 37);
		contentPane.add(lblNewLabel_2);
		
		resultadoTextArea = new JTextArea();
		resultadoTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		resultadoTextArea.setBounds(60, 180, 315, 70);
		contentPane.add(resultadoTextArea);
	}
}
