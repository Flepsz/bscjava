package CalculadoraGeometrica.Figuras.Espaciais;

public class Cilindro {
    private double raio;
    private double altura;

    public Cilindro(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    public double volume() {
        return Math.PI * Math.pow(raio, 2) * altura;
    }

    public double areaSup() {
        return (2 * Math.PI * Math.pow(raio, 2)) + (2 * Math.PI * raio * altura);
    }
}
