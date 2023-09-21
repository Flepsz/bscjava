package CalculadoraGeometrica.Figuras.Planas;

public class Quadrado {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double area() {
        return lado * lado;
    }

    public double perimetro() {
        return lado * 4;
    }
}
