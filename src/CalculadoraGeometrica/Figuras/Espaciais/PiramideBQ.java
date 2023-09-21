package CalculadoraGeometrica.Figuras.Espaciais;

public class PiramideBQ {
    private double arestaLado;
    private double arestaBase;
    private double altura;

    public PiramideBQ(double arestaLado, double arestaBase, double altura) {
        this.arestaLado = arestaLado;
        this.arestaBase = arestaBase;
        this.altura = altura;
    }

    public double volume() {
        return (1.0 / 3.0) * (Math.pow(arestaBase, 2)) * altura;
    }

    public double areaSup() {
        return Math.pow(arestaBase, 2) + 2 * arestaBase * arestaLado;
    }
}
