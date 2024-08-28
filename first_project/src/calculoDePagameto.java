import javax.swing.JOptionPane;

public class calculoDePagameto {
    public static void main(String[] args) {
        double precoEtiqueta = Double.parseDouble(JOptionPane.showInputDialog(null,
            "Informe o preço de etiqueta do produto: ",
            "Entrada Preço do Produto", JOptionPane.QUESTION_MESSAGE
        ));

        int condicaoPagamento = Integer.parseInt(JOptionPane.showInputDialog(null,
        "Escolha a condição de pagamento: \n" +
            "1 - À vista em dinheiro ou pix (15% de desconto) \n" +
            "2 - À vista no cartão de crédito (10% de desconto) \n" +
            "3 - Em duas vezes (preço normal sem juros) \n" +
            "4 - Em três vezes (preço normal mais 10% de juros) \n",
            "Opções de Pagamento", JOptionPane.QUESTION_MESSAGE
        ));

        double valorFinal;


        switch (condicaoPagamento) {
            case 1:
                valorFinal = precoEtiqueta * 0.85; // 15% de desconto
                break;
            case 2:
                valorFinal = precoEtiqueta * 0.90; // 10% de desconto
                break;
            case 3:
                valorFinal = precoEtiqueta; // Preço normal sem juros
                break;
            case 4:
                valorFinal = precoEtiqueta * 1.10; // Preço normal mais 10% de juros
                break;
            default:
                JOptionPane.showMessageDialog(null,
                    "Opção de pagamento inválida!",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE);
                return ;
        }

        JOptionPane.showMessageDialog(null,
            String.format("O valor final a ser pago é: R$ %.2f", valorFinal),
            "Resultado",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

}
