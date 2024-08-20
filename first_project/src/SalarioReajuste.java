import java.util.Scanner;

public class SalarioReajuste {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        double salario, indiceReajuste, novoSalario;

        System.out.println("Digite o seu salário: ");
        salario = input.nextDouble();

        System.out.println("Agora digite a porcentagem do reajuste: ");
        indiceReajuste = input.nextDouble();

        novoSalario = salario * (indiceReajuste / 100) + salario;

        System.out.println("Seu novo salário é: " + novoSalario);

        input.close();
    }
}