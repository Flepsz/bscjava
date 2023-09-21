package CalculadoraGeometrica.Figuras.Planas;

public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }

    public double perimetro() {
        return 2 * Math.PI * raio;
    }
}
