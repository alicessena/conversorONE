import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conversor conversor = new Conversor();

        System.out.println("Digite o valor que deseja converter: ");
        double valor = sc.nextDouble();

        System.out.println("""
                ********************
                Selecione o câmbio:
                1 - BRL -> USD
                2 - BRL -> EUR
                3 - BRL -> CAD
                4 - USD -> BRL
                5 - USD -> EUR
                6 - USD -> CAD
                7 - sair
                *********************
                """);
        int opcao = sc.nextInt();
        double resultado = 0;
        switch (opcao) {
            case 1 -> {
                Moedas moedas = conversor.escolheReal(); // base BRL
                resultado = valor * moedas.USD();
                System.out.printf("%.2f BRL = %.2f USD%n", valor, resultado);
            }
            case 2 -> {
                Moedas moedas = conversor.escolheReal();
                resultado = valor * moedas.EUR();
                System.out.printf("%.2f BRL = %.2f EUR%n", valor, resultado);
            }
            case 3 -> {
                Moedas moedas = conversor.escolheReal();
                resultado = valor * moedas.CAD();
                System.out.printf("%.2f BRL = %.2f CAD%n", valor, resultado);
            }
            case 4 -> {
                Moedas moedas = conversor.escolheDolar();
                resultado = valor * moedas.BRL();
                System.out.printf("%.2f USD = %.2f BRL%n", valor, resultado);
            }
            case 5 -> {
                Moedas moedas = conversor.escolheDolar();
                resultado = valor * moedas.EUR();
                System.out.printf("%.2f USD = %.2f EUR%n", valor, resultado);
            }
            case 6 -> {
                Moedas moedas = conversor.escolheDolar();
                resultado = valor * moedas.CAD();
                System.out.printf("%.2f USD = %.2f CAD%n", valor, resultado);
            }
            case 7 ->{
                break;
            }
            default -> System.out.println("Opção inválida.");
        }

        sc.close();
    }
}

