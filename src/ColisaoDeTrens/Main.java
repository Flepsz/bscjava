package ColisaoDeTrens;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // inputs


        System.out.println("Colisão de Trens");

        while (true) {
            double initPosA = -1;
            double initPosB = -1;
            double velA = -1;
            double velAbsB = -1;
            try {
                while (initPosA < 0 || initPosA > 10000) {
                    System.out.println("Digite a posição do trem A (0 a 10.000 KM): ");
                    initPosA = sc.nextDouble();

                    if (initPosA < 0 || initPosA > 10000) {
                        System.out.println("O número deve ser maior ou igual a zero e menor que 10000.\n");
                    }
                }

                while (velA < 0 || velA > 300) {
                    System.out.println("Digite a velocidade do trem A (Até 300 KM/h)");
                    velA = sc.nextDouble();

                    if (velA < 0 || velA > 300) {
                        System.out.println("O número deve ser maior ou igual a zero e menor que 300.");
                    }
                }

                while (initPosB < 0 || initPosB > 10000) {
                    System.out.println("Digite a posição do trem B (0 a 10.000 KM): ");
                    initPosB = sc.nextDouble();

                    if (initPosB < 0 || initPosB > 10000) {
                        System.out.println("O número deve ser maior ou igual a zero e menor que 10000.");
                    }
                }

                while (velAbsB < 0 || velAbsB > 300) {
                    System.out.println("Digite a velocidade do trem B (Até 300 KM/h)");
                    velAbsB = sc.nextDouble();

                    if (velAbsB < 0 || velAbsB > 300) {
                        System.out.println("O número deve ser maior ou igual a zero e menor que 300.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Ops.. Você digitou caracteres inválidos! Digite novamente.");
            }
            sc.nextLine();

            double velB = velAbsB * -1;

            double tempo = (initPosA - initPosB) / (velB - velA);
            double colisaoA = initPosA + velA * tempo;
            double tempoSec = tempo * 3600;
            int tempoInt = (int) tempoSec;
            int colisaoInt = (int) colisaoA;

            int horas = (int) (tempoSec / 3600);
            int minutos = (int) ((tempoSec % 3600) / 60);
            int segundos = (int) (tempoSec % 60);

            int horaInicial = 17;
            int minutoInicial = 0;
            int segundoInicial = 0;

            int horaFinal = horaInicial + horas;
            int minutoFinal = minutoInicial + minutos;
            int segundoFinal = segundoInicial + segundos;

            if (segundoFinal >= 60) {
                segundoFinal -= 60;
                minutoFinal++;
            }

            if (minutoFinal >= 60) {
                minutoFinal -= 60;
                horaFinal++;
            }

            if (initPosA == initPosB || (velA == 0 && velAbsB == 0)) {
                System.out.println("Os trens estão na mesma posição, eles não podem colidir!");
            } else {
                System.out.printf("\nA colisão dos trens acontecerá no KM %d e ocorrerá após %d:%d:%d hrs ou em %d segundos.", colisaoInt, horaFinal, minutoFinal, segundoFinal, tempoInt);
            }

            try {
                System.out.println("\n\nDeseja jogar novamente? (1 - Sim ou 2 - Não)?");
                int op = sc.nextInt();

                while (op != 1 && op != 2) {
                    System.out.println("Opção inválida, tente novamente!");
                    System.out.println("\n\nDeseja jogar novamente? (1 - Sim ou 2 - Não)?");
                    op = sc.nextInt();
                }
                if (op == 2) {
                    break;
                } else {
                    sc.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida, tente novamente!");
                sc.nextLine();
            }
        }
    }
}