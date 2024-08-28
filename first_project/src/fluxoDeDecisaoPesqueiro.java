import javax.swing.JOptionPane;

public class fluxoDeDecisaoPesqueiro {
    public static void main(String[] args){
        //P é o Peso dos Peixes
        double P = Double.parseDouble(JOptionPane.showInputDialog(null,
        "Digite a quantidade de peso que você pegou:" +
                "Se o peso for maior que 50 kilos você terá que pagar um multa de R$ 4,00 por kilo excedente!",
        "Entrada de Kilos a Levar",
            JOptionPane.QUESTION_MESSAGE
        ));

        //E é de peso excedente
        //M é a multa a pagar por quilo excedido
        double E, M;

        if (P > 50){
            E = P - 50;
        } else {
            E = 0;
        }

        M = E * 4.00;

        JOptionPane.showMessageDialog(null,
            String.format("Peso excedente: %.2f", E) + " kg\n" +
                    String.format("Multa a pagar: R$ %.2f", M),
            "Resultado",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
