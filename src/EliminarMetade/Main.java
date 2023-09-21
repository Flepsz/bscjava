package EliminarMetade;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] listaPessoas = {"Felipe", "Alemão", "Vetores", "Beck", "Jholia", "Kethelyn", "Julia", "Byanka",
                "Pedrin", "João", "Fabin", "Prates", "Prijas", "Manu", "Keven", "Rafaela"};

        Random random = new Random();

        int arrSize = listaPessoas.length;
        int removeCnt;

        System.out.println("Array original:");
        System.out.println(Arrays.toString(listaPessoas));

        if (arrSize % 2 == 0) {
            removeCnt = arrSize / 2;
        } else {
            removeCnt = arrSize / 2 + 1;
        }

        while (removeCnt > 0) {
            int randomIndex = random.nextInt(listaPessoas.length);

            for (int i = randomIndex; i < listaPessoas.length - 1; i++) {
                listaPessoas[i] = listaPessoas[i + 1];
            }

            listaPessoas[listaPessoas.length - 1] = null;
            removeCnt--;

            listaPessoas = Arrays.copyOf(listaPessoas, listaPessoas.length - 1);
        }

        System.out.println("\nArray após a remoção:");
        System.out.println(Arrays.toString(listaPessoas));


    }
}
