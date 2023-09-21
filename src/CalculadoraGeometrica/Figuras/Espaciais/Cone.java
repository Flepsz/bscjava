package CalculadoraGeometrica.Figuras.Espaciais;

public class Cone {
    private double raio;
    private double altura;

    public Cone(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    public double volume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(raio, 2) * altura;
    }

    public double areaSup() {
        double alturaInc = Math.sqrt((Math.pow(raio, 2) + Math.pow(altura, 2)));
        return Math.PI * Math.pow(raio, 2) + Math.PI * raio * alturaInc;
    }
}
