import java.text.MessageFormat;

public class Main {
    public static void main (String[] args){
        double soma, subtracao, multiplicacao, divisao, media;
        double numero1, numero2;
         numero1 = -15.05;
         numero2 = 30;

         soma = numero1 + numero2;
         subtracao = numero1 - numero2;
         multiplicacao = numero1 * numero2;
         divisao = numero1 / numero2;
         media = (numero1 + numero2) / 2;

        String pattern = "Números: {0} e {1} \nSoma: {2} \nSubtração: {3} \nMultiplicação: {4} \nDivisão: {5} \nMédia: {6}";
        String objetoStringSaida = MessageFormat.format(pattern, numero1, numero2, soma, subtracao, multiplicacao, divisao, media);

        System.out.println(objetoStringSaida);
    }
}