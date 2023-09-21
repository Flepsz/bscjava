package CalculadoraGeometrica.Figuras;

import CalculadoraGeometrica.Figuras.Espaciais.*;
import CalculadoraGeometrica.Figuras.Planas.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("""
                        \n====== CALCULADORA GEOMÉTRICA ======
                        [1] - Figuras Planas
                        [2] - Figuras Espaciais
                        [3] - Sair
                        ====================================
                        """);
                System.out.println("Escolha uma opção: ");
                int opFig = sc.nextInt();

                switch (opFig) {
                    case 1:
                        System.out.println("""
                                \n====== FIGURAS PLANAS ======
                                [1] - Triângulo Equilátero
                                [2] - Quadrado
                                [3] - Retângulo
                                [4] - Círculo
                                [5] - Hexágono
                                [6] - Voltar
                                ============================
                                        """);
                        System.out.println("Escolha uma opção: ");
                        int opPln = sc.nextInt();
                            switch (opPln) {
                                case 1:
                                    System.out.print("Digite o lado do triângulo: ");
                                    double tLado = sc.nextDouble();

                                    TrianguloEquilatero te = new TrianguloEquilatero(tLado);
                                    System.out.printf("\nPerímetro: %.2f", te.perimetro());
                                    System.out.printf("\nÁrea: %.2f\n", te.area());
                                    continue;
                                case 2:
                                    System.out.print("Digite o lado do quadrado: ");
                                    double qLado = sc.nextDouble();

                                    Quadrado qua = new Quadrado(qLado);
                                    System.out.printf("\nPerímetro: %.2f", qua.perimetro());
                                    System.out.printf("\nÁrea: %.2f\n", qua.area());
                                    continue;
                                case 3:
                                    System.out.print("Digite o lado do retângulo: ");
                                    double reLado1 = sc.nextDouble();
                                    System.out.print("\nDigite o outro lado do retângulo: ");
                                    double reLado2 = sc.nextDouble();

                                    Retangulo ret = new Retangulo(reLado1, reLado2);
                                    System.out.printf("\nPerímetro: %.2f", ret.perimetro());
                                    System.out.printf("\nÁrea: %.2f\n", ret.area());
                                    continue;
                                case 4:
                                    System.out.print("Digite o raio do círculo: ");
                                    double cRaio = sc.nextDouble();

                                    Circulo cir = new Circulo(cRaio);
                                    System.out.printf("\nPerímetro: %.2f", cir.perimetro());
                                    System.out.printf("\nÁrea: %.2f\n", cir.area());
                                    continue;
                                case 5:
                                    System.out.print("Digite o lado do hexágono: ");
                                    double hexLado = sc.nextDouble();

                                    Hexagono hex = new Hexagono(hexLado);
                                    System.out.printf("\nPerímetro: %.2f", hex.perimetro());
                                    System.out.printf("\nÁrea: %.2f\n", hex.area());
                                    continue;
                                case 6:
                                    break;
                                default:
                                    System.out.println("Opção Inválida, tente novamente\n");
                            }
                        break;
                    case 2:
                        System.out.println("""
                                \n====== FIGURAS ESPACIAIS ==========
                                [1] - Cubo
                                [2] - Paralelepípedo
                                [3] - Esfera
                                [4] - Pirâmide de Base Quadrada
                                [5] - Cilindro
                                [6] - Cone
                                [7] - Voltar
                                ===================================
                                        """);
                        System.out.println("Escolha uma opção: ");
                        int opEsp = sc.nextInt();
                        switch (opEsp) {
                            case 1:
                                System.out.print("Digite a aresta do cubo: ");
                                double arrCubo = sc.nextDouble();

                                Cubo cubo = new Cubo(arrCubo);
                                System.out.printf("\nVolume: %.2f", cubo.volume());
                                System.out.printf("\nÁrea Superficial: %.2f\n", cubo.areaSup());
                                continue;
                            case 2:
                                System.out.print("Digite a largura do paralelepipedo: ");
                                double parLar = sc.nextDouble();
                                System.out.print("\nDigite a altura do paralelepipedo: ");
                                double parAlt = sc.nextDouble();
                                System.out.print("\nDigite o comprimento do paralelepipedo: ");
                                double parCom = sc.nextDouble();

                                Paralelepipedo par = new Paralelepipedo(parLar, parAlt, parCom);
                                System.out.printf("\nVolume: %.2f", par.volume());
                                System.out.printf("\nÁrea Superficial: %.2f\n", par.areaSup());
                                continue;
                            case 3:
                                System.out.print("Digite o raio da esfera: ");
                                double esRaio = sc.nextDouble();

                                Esfera esf = new Esfera(esRaio);
                                System.out.printf("\nVolume: %.2f", esf.volume());
                                System.out.printf("\nÁrea Superficial: %.2f\n", esf.areaSup());
                                continue;
                            case 4:
                                System.out.print("Digite o lado da pirâmide: ");
                                double pirLad = sc.nextDouble();
                                System.out.print("\nDigite a base da pirâmide: ");
                                double pirBas = sc.nextDouble();
                                System.out.print("\nDigite a altura da pirâmide: ");
                                double pirAlt = sc.nextDouble();

                                PiramideBQ pirBQ = new PiramideBQ(pirLad, pirBas, pirAlt);
                                System.out.printf("\nVolume: %.2f", pirBQ.volume());
                                System.out.printf("\nÁrea Superficial: %.2f\n", pirBQ.areaSup());
                                continue;
                            case 5:
                                System.out.print("Digite o raio do cilindro: ");
                                double cilRaio = sc.nextDouble();
                                System.out.print("\nDigite a altura do cilindro: ");
                                double cilAlt = sc.nextDouble();

                                Cilindro cil = new Cilindro(cilRaio, cilAlt);
                                System.out.printf("\nVolume: %.2f", cil.volume());
                                System.out.printf("\nÁrea Superficial: %.2f\n", cil.areaSup());
                                continue;
                            case 6:
                                System.out.print("Digite o raio do cone: ");
                                double conRaio = sc.nextDouble();
                                System.out.print("\nDigite a altura do cone: ");
                                double conAlt = sc.nextDouble();

                                Cone con = new Cone(conRaio, conAlt);
                                System.out.printf("\nVolume: %.2f", con.volume());
                                System.out.printf("\nÁrea Superficial: %.2f\n", con.areaSup());
                                continue;
                            case 7:
                                break;
                            default:
                                System.out.println("Opção Inválida, tente novamente!\n");
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opção Inválida, tente novamente!\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção Inválida, tente novamente!\n");
            }
            sc.nextLine();
        }
    }
}
