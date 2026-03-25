import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema de compras!");
        System.out.println("Digite o limite do cartão: ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite a descrição da compra:");
            String descricao = leitura.next();

            System.out.println("Digite o valor da compra:");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            System.out.println("Processando compra...");
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra efetuada!");
                System.out.println("Saldo atual: R$" + cartao.getSaldo());
                System.out.println("Digite 1 para fazer outra conta ou digite 0 para encerrar sessão:");
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("Encerrando sessão...\n");
        System.out.println("***********************");
        System.out.println("\nCOMPRAS REALIZADAS:\n");
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - R$" + c.getValor());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo final/restante: R$" + cartao.getSaldo());
    }
}
