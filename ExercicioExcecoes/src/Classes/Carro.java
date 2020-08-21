package Classes;

import TanqueExceptions.TanqueInsuficienteException;
import TanqueExceptions.TanqueVazioException;

public class Carro {
    private double capacidadeMaxCombustivel;
    private double nivelDeCombustivel;
    private double quantQuilometrosPorLitros;

    public Carro(double capacidadeMaxCombustivel, double nivelDeCombustivel, double quantQuilometrosPorLitros) {
        this.capacidadeMaxCombustivel = capacidadeMaxCombustivel;
        this.nivelDeCombustivel = nivelDeCombustivel;
        this.quantQuilometrosPorLitros = quantQuilometrosPorLitros;
    }

    public void encherTanque(double quantidadeEnchida) throws TanqueInsuficienteException {
        if (capacidadeMaxCombustivel < (quantidadeEnchida + nivelDeCombustivel)) {
            throw new TanqueInsuficienteException();
        } else {
            System.out.println("O carro abasteceu!");
        }
    }

    public String combustivelGasto(double distanciaEmKm) {
        double combustivelCalculo = distanciaEmKm / quantQuilometrosPorLitros;
        return combustivelCalculo + " Litros";
    }

    public String distanciaPossivel() {
        double kmQuePodeAndar = nivelDeCombustivel / quantQuilometrosPorLitros;
        return kmQuePodeAndar + "km";
    }

    public void andar(double distancia) throws Exception {
        if ((capacidadeMaxCombustivel / quantQuilometrosPorLitros) < distancia) {
            throw new TanqueInsuficienteException();
        } else {
            if ((nivelDeCombustivel / quantQuilometrosPorLitros) < distancia) {
                throw new TanqueVazioException();
            } else {
                System.out.println("O carro percorreu o caminho com sucesso");
            }
        }
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
