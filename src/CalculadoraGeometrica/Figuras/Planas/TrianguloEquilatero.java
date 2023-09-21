package CalculadoraGeometrica.Figuras.Planas;

public class TrianguloEquilatero {
    private double lado;

    public TrianguloEquilatero(double lado) {
        this.lado = lado;
    }

    public double area() {
        return (Math.pow(lado, 2) * Math.sqrt(3)) / 4;
    }

    public double perimetro() {
        return lado * 3;
    }
}
