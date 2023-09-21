package CPF;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] splitedCPF = new int[11];
        String cpf;
        long num = 100000000L;
        long resto;
        int j;
        int i;
        int dig1 = 0;
        int dig2 = 0;

        while (true) {
            try {
                System.out.println("Digite seu CPF: ");
                cpf = sc.nextLine().replaceAll("[.-]", "");

                if (cpf.length() != 11) {
                    throw new InputMismatchException();
                }

                for (j = 0; j < 11; j++) {
                    splitedCPF[j] = Character.getNumericValue(cpf.charAt(j));
                }

                i = 10;
                for (j = 0; j < 9; j++) {
                    dig1 += splitedCPF[j] * i;
                    i--;
                }

                i = 11;
                for (j = 0; j < 10; j++) {
                    dig2 += splitedCPF[j] * i;
                    i--;
                }

                dig1 = dig1 * 10 % 11;
                dig2 = dig2 * 10 % 11;

                if (dig1 == 10) dig1 = 0;
                if (dig2 == 10) dig2 = 0;

                if (dig1 == splitedCPF[9] && dig2 == splitedCPF[10]) {
                    System.out.println("CPF Válido");
                } else {
                    System.out.println("CPF inválido");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ops... Acho que você digitou errado!");
            }

        }
    }
}