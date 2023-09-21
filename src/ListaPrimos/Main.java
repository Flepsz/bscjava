package ListaPrimos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int numero = 0;
                int plyagn = 0;
                int op = 0;

                while (numero < 1 || numero > 10000) {
                    System.out.println("\n\nDigite um número entre 1 e 10.000: ");
                    numero = sc.nextInt();
                }

                boolean isPrimo = verificarPrimo(numero);
                if (isPrimo) {
                    System.out.println("\nO " + numero + " é um número primo.\n");
                } else {
                    System.out.println("\nO " + numero + " não é um número primo.\n");
                }

                while (op != 1 && op != 2) {
                    System.out.println("[1] - Inserir\n[2] - Remover");
                    op = sc.nextInt();
                }
                System.out.println(" ");
                if (op == 1) {
                    for (int i = 1; i <= numero; i++) {
                        if (verificarPrimo(i)) {
                            System.out.println(i + " ");
                        }
                    }
                    if (isPrimo) {
                        System.out.println(numero);
                    }
                } else {
                    for (int i = 1; i <= numero; i++) {
                        if (!verificarPrimo(i)) {
                            System.out.println(i + " ");
                        }
                    }
                    if (!isPrimo) {
                        System.out.println(numero);
                    }
                }

                System.out.println("\nDeseja jogar novamente?");
                while (plyagn != 1 && plyagn != 2) {
                    System.out.println("[1] - Sim\n[2] - Não");
                    System.out.print("Digite: ");
                    plyagn = sc.nextInt();
                }

                if (plyagn == 1) {
                    continue;
                } else {
                    System.out.println("\nObrigado por jogar!\n");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("\nOps... Acho que você digitou errado!\n");
                sc.nextLine();
            }
        }
    }

    public static boolean verificarPrimo (int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }


}
