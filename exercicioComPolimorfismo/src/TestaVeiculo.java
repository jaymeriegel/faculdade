import Classes.Carro;
import Classes.Onibus;
import Classes.Veiculo;

public class TestaVeiculo {
    public static void main(String[] args) {

        Veiculo v;
        v = new Carro(160.00, 120000, 1999);

        v.imprimeInfos();

        ((Carro)v).setAnoFabricacao(2000);

        System.out.println(((Carro)v).getAnoFabricacao());

        Veiculo v2;

        v2 = new Onibus(60, 500000, 50);

        v2.imprimeInfos();

        ((Onibus)v2).setCapacidadePassageiros(40);

        System.out.println(((Onibus)v2).getCapacidadePassageiros());



    }
}
