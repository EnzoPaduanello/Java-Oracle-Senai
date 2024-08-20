import java.util.Scanner;

public class SimuladorDeFinanciamento {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        double valorEmprestimo, taxaJurosAnual, taxaJurosMensal, numMeses, prazoPagamento, parcelaMensal, exponenciacao;

        System.out.println("Digite valor do empréstimo: ");
        valorEmprestimo = input.nextDouble();

        System.out.println("Digite taxa de juros anual em porcentagem: ");
        taxaJurosAnual = input.nextDouble();

        System.out.println("Digite o prazo de pagamento em anos: ");
        prazoPagamento = input.nextDouble();

        if (valorEmprestimo >= 1 || taxaJurosAnual >= 0.01 || prazoPagamento >= 0.08) {
            taxaJurosMensal = (taxaJurosAnual / 100) / 12;

            numMeses = prazoPagamento * 12;

            exponenciacao = Math.pow(1 + taxaJurosMensal, -1 * numMeses);

            parcelaMensal = (valorEmprestimo * taxaJurosMensal) / (1 - exponenciacao);

            System.out.println("A parcela mensal será: " + parcelaMensal);
        } else {

        }

        input.close();
    }
}
