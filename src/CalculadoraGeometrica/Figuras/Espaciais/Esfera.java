package CalculadoraGeometrica.Figuras.Espaciais;

public class Esfera {
    private double raio;

    public Esfera(double raio) {
        this.raio = raio;
    }

    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(raio, 2);
    }

    public double areaSup() {
        return 4 * Math.PI * Math.pow(raio, 2);
    }
}
