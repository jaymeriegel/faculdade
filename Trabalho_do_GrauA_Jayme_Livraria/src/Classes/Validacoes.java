package Classes;

public class Validacoes {


    public boolean validaTipo(String tipo){
        if (tipo.equalsIgnoreCase("filme") || tipo.equalsIgnoreCase("livro")
                ||tipo.equalsIgnoreCase("jogo")){
            return true;
        }
        return false;
    }

    public boolean validaValor(String valor){
        String numeros = "0123456789,.";
        boolean eNumero;

        for (int i = 0; i < valor.length(); i++){
            eNumero = false;
            for (int j = 0; j < numeros.length(); j++){
                if (valor.charAt(i) == numeros.charAt(j)){
                    eNumero = true;
                    break;

                }

            }

            if (!eNumero){
                return false;
            }
        }
        return true;
    }


    public boolean validaInt(String valor){
        String numeros = "0123456789";
        boolean eNumero;

        for (int i = 0; i < valor.length(); i++){
            eNumero = false;
            for (int j = 0; j < numeros.length(); j++){
                if (valor.charAt(i) == numeros.charAt(j)){
                    eNumero = true;
                    break;

                }

            }

            if (!eNumero){
                return false;
            }
        }
        return true;
    }


}
