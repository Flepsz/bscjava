package Fibonacci;

public class Main {
    public static void main(String[] args) {
        int[] fiboArr = new int[20];
        fiboArr[0] = 0;
        fiboArr[1] = 1;

        for (int i = 2; i < 20;i++) {
            fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2];
        }

        for (int i = 0; i <20; i++) {
            System.out.println(fiboArr[i] + " ");
        }
    }
}
