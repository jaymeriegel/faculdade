package Classes;

public class Carro {
    private double capacidadeMaxCombustivel;
    private double nivelDeCombustivel;
    private double quantQuilometrosPorLitros;

    public Carro(double capacidadeMaxCombustivel, double nivelDeCombustivel, double quantQuilometrosPorLitros) {
        this.capacidadeMaxCombustivel = capacidadeMaxCombustivel;
        this.nivelDeCombustivel = nivelDeCombustivel;
        this.quantQuilometrosPorLitros = quantQuilometrosPorLitros;
    }

    public double getCapacidadeMaxCombustivel() {
        return capacidadeMaxCombustivel;
    }

    public void setCapacidadeMaxCombustivel(double capacidadeMaxCombustivel) {
        this.capacidadeMaxCombustivel = capacidadeMaxCombustivel;
    }

    public double getNivelDeCombustivel() {
        return nivelDeCombustivel;
    }

    public void setNivelDeCombustivel(double nivelDeCombustivel) {
        this.nivelDeCombustivel = nivelDeCombustivel;
    }

    public double getQuantQuilometrosPorLitros() {
        return quantQuilometrosPorLitros;
    }

    public void setQuantQuilometrosPorLitros(double quantQuilometrosPorLitros) {
        this.quantQuilometrosPorLitros = quantQuilometrosPorLitros;
    }
}
