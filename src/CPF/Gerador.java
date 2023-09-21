package CPF;

import java.util.Random;

public class Gerador {
    public static void main(String[] args) {
        String cpf = gerarCPF();
        System.out.println("CPF com pontuação: " + formatarCPF(cpf));
        System.out.println("CPF sem pontuação: " + cpf);
    }

    public static String gerarCPF() {
        Random random = new Random();
        int[] numeros = new int[9];

        for (int i = 0; i < 9; i++) {
            numeros[i] = random.nextInt(9);
        }

        int[] digitos = calcularDigitosVerificadores(numeros);

        StringBuilder cpf = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            cpf.append(numeros[i]);
        }

        cpf.append(digitos[0]);
        cpf.append(digitos[1]);

        return cpf.toString();
    }

    public static int[] calcularDigitosVerificadores(int[] numeros) {
        int primeiroDigito = calcularDigitoVerificador(numeros, 10);
        int segundoDigito = calcularDigitoVerificador(numeros, 11);
        return new int[]{primeiroDigito, segundoDigito};
    }

    public static int calcularDigitoVerificador(int[] numeros, int pesoInicial) {
        int soma = 0;

        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i] * pesoInicial;
            pesoInicial--;
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }

    public static String formatarCPF(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }
}