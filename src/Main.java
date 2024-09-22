import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nome = "Josefino Alcantara";
        String tipoConta = "Corrente";
        double saldo = 1250.00;
        int opcao = 0;

        System.out.println("\n***********************");
        System.out.println("Nome do cliente: " + nome);
        System.out.println("Tipo conta: " + tipoConta);
        System.out.println("Saldo atual: " + saldo);
        System.out.println("***********************");

        String menu = """
                \n --- Digite sua opção ---
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor 
                4 - Sair
                """;

        Scanner leitura = new Scanner(System.in);

        while (opcao != 4) {
            System.out.println(menu);
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1 -> System.out.println("O saldo atualizado é " + saldo);
                case 2 -> saldo = transferirValor(saldo, leitura);
                case 3 -> saldo = receberValor(saldo, leitura);
                case 4 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        }
        leitura.close();
    }


    public static double transferirValor(double saldo, Scanner leitura) {
        System.out.println("Qual o valor que deseja transferir?");
        double valor = leitura.nextDouble();
        if (valor > saldo) {
            System.out.println("Não há saldo para realizar a transferência.");
        } else {
            saldo -= valor;
            System.out.println("Novo saldo: " + saldo);
        }
        return saldo;
    }


    public static double receberValor(double saldo, Scanner leitura) {
        System.out.println("Valor recebido: ");
        double valor = leitura.nextDouble();
        saldo += valor;
        System.out.println("Novo saldo: " + saldo);
        return saldo;
    }
}
