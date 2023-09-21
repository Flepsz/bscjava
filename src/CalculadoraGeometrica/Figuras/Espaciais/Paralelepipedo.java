package CalculadoraGeometrica.Figuras.Espaciais;

public class Paralelepipedo {
    private double largura;
    private double altura;
    private double comprimento;

    public Paralelepipedo(double largura, double altura, double comprimento) {
        this.largura = largura;
        this.altura = altura;
        this.comprimento = comprimento;
    }

    public double volume() {
        return largura * altura * comprimento;
    }

    public double areaSup() {
        return (2 * (largura * altura)) + (2 * (altura * comprimento)) + (2 * (largura * comprimento));
    }
}
