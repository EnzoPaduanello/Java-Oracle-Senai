import javax.swing.JOptionPane;

public class desafioAdega {
    public static void main(String[] args){
        int T = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Digite a quantidade de garrafas de vinho tinto na adega: ",
                "Entrada da Quantidade de Vinho Tinto",
                JOptionPane.QUESTION_MESSAGE
        ));

        int B = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Digite a quantidade de garrafas de vinho branco na adega: ",
                "Entrada da Quantidade de Vinho Branco",
                JOptionPane.QUESTION_MESSAGE
        ));

        int R = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Digite a quantidade de garrafas de vinho rose na adega: ",
                "Entrada da Quantidade de Vinho Rose",
                JOptionPane.QUESTION_MESSAGE
        ));

        double totalQuantidade = T + B + R;

        double porcentagemTinto = (T * 100) / totalQuantidade;
        double porcentagemBranco = (B * 100) / totalQuantidade;
        double porcentagemRose = (R * 100) / totalQuantidade;

        StringBuilder F = new StringBuilder();

        F.append("Porcentagem de vinhos: \n")
                .append("Vinho Tinto: ").append(String.format("%.2f", porcentagemTinto)).append("% \n")
                .append("Vinho Branco: ").append(String.format("%.2f", porcentagemBranco)).append("% \n")
                .append("Vinho Rose: ").append(String.format("%.2f", porcentagemRose)).append("%");

        JOptionPane.showMessageDialog(
                null,
                F.toString(),
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
