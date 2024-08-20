import java.util.Scanner;

public class Media1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double nota1, nota2, media;

        System.out.println("Informe a nota 1: ");
        nota1 = input.nextDouble();

        System.out.println("Informe a nota 2: ");
        nota2 = input.nextDouble();

        media = (nota1 + nota2) / 2;

        System.out.println("Média: " + media);

        if (media >= 7.0){
            System.out.println("Resultado: Aprovado");
        } else {
            System.out.println("Resultado: Reprovado");
        }

        input.close();
    }
}
