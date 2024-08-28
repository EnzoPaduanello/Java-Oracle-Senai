import javax.swing.JOptionPane;

public class fluxoDeDecisaoCaculoPagamentoHoras {
    public static void main(String[] args){
        // C é o código do funcionário
        int C = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Digite seu código de matrícula: ",
                "Entrada de Matícula",
                JOptionPane.QUESTION_MESSAGE
        ));

        //N é o número de horas trabalhadas
        double N = Double.parseDouble(JOptionPane.showInputDialog(
                null,
                "Digite a quantidade de horas trabalhadas:",
                "Entrada de Horas",
                JOptionPane.QUESTION_MESSAGE
        ));

        //E são as horas excedentes de trabalho
        double E, salarioFinal, salarioExcedente;

        if (N > 50){
            E = N - 50;
            salarioExcedente = E * 20;
            salarioFinal = salarioExcedente + 500;

            JOptionPane.showMessageDialog(
                    null,
                    "Horas trabalhadas: " + N + "\n" +
                            "Número de horas excedentes: " + E + "\n" +
                            String.format("Salário excedente: R$ %.2f", salarioExcedente) + "\n" +
                            String.format("Salário final: R$ %.2f", salarioFinal),
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else if (N <= 50) {
            E = 0;
            salarioFinal = N * 10;
            salarioExcedente = 0;

            JOptionPane.showMessageDialog(
                    null,
                    "Horas trabalhadas: " + N + "\n" +
                            "Número de horas excedentes: " + E + "\n" +
                            String.format("Salário excedente: R$ %.2f", salarioExcedente) + "\n" +
                            String.format("Salário final: R$ %.2f", salarioFinal),
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Digite um valor válido para o código e/ou para as horas trabalhadas!",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
