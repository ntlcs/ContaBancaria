import java.util.Scanner;

public class ContaBancaria {
    private String nomeCliente;
    private String tipoConta;
    private double saldo;

    public ContaBancaria(String nomeCliente, String tipoConta, double saldo) {
        this.nomeCliente = nomeCliente;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public void recebeValor(double valor) {
        saldo += valor;
        System.out.println("Valor recebido. Novo saldo: R$" + saldo);
    }

    public void transfereValor(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            saldo -= valor;
            System.out.println("Transferência realizada com sucesso. Novo saldo: R$" + saldo);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o tipo de conta: ");
        String tipoConta = scanner.nextLine();
        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(nomeCliente, tipoConta, saldoInicial);


        String menu = "Menu:\n" +
                "1. Consultar saldo\n" +
                "2. Receber valor\n" +
                "3. Transferir valor\n" +
                "4. Sair\n";

        int opcao;
        do {
            System.out.println(menu);
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor a ser recebido: ");
                    double valorRecebido = scanner.nextDouble();
                    conta.recebeValor(valorRecebido);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser transferido: ");
                    double valorTransferido = scanner.nextDouble();
                    conta.transfereValor(valorTransferido);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
