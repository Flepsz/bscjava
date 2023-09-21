package CalculadoraGeometrica.Figuras.Espaciais;

public class Cubo {
    private double aresta;

    public Cubo(double aresta) {
        this.aresta = aresta;
    }

    public double volume() {
        return Math.pow(aresta, 3);
    }

    public double areaSup() {
        return 6 * Math.pow(aresta, 2);
    }
}
