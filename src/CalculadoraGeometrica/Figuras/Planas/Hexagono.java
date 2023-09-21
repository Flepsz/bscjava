package CalculadoraGeometrica.Figuras.Planas;

public class Hexagono {
    public double lado;

    public Hexagono(double lado) {
        this.lado = lado;
    }

    public double area() {
        return 6 * Math.pow(lado, 2) * Math.sqrt((3.0/4.0));
    }

    public double perimetro() {
        return 6 * lado;
    }
}
