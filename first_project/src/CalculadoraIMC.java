import java.awt.desktop.AboutEvent;
import java.util.Scanner;

public class CalculadoraIMC {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        double altura, peso, imc;

        System.out.println("Digite a sua altura em metros: ");
        altura = input.nextDouble();

        System.out.println("DIgite o seu peso em kilos: ");
        peso = input.nextDouble();

        imc = peso / Math.pow(altura, 2);

        if( imc < 18.5 ){
            System.out.println("Seu imc é: " + imc + ", abaixo do peso!");
        }
        else if (imc >= 18.5 && imc < 25) {
            System.out.println("Seu imc é: " + imc + ", peso normal!");
        }
        else if (imc >= 25 && imc < 30) {
            System.out.println("Seu imc é: " + imc + ", acima do peso!");
        }
        else if (imc >= 30) {
            System.out.println("Seu imc é: " + imc + ", obeso!");
        }
        else {
            System.out.println("Digite valores validos!");
        }

        input.close();
    }
}
