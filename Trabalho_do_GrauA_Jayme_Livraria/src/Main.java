import Classes.*;
import Excecoes.IdNaoExistenteException;
import java.io.*;
import java.util.Scanner;

public class Main {

    static Livraria livraria = new Livraria();
    static Scanner sc = new Scanner(System.in);
    static Validacoes valida = new Validacoes();

    public static void menu() throws Exception {
        String selecao;

        while (true){

            System.out.println("--- Bem vindo ao gerenciamento da Loja Jayme ---");
            System.out.println("1 --> Cadastrar um novo produto");
            System.out.println("2 --> Remover um produto via ID");
            System.out.println("3 --> Listar os produtos cadastrados");
            System.out.println("4 --> Atualizar as informacoes de um produto");
            System.out.println("5 --> Orndenar o estoque pelo ID de forma crescente");
            System.out.println("Outro numero --> Sair");
            System.out.println();

            while (true){
                System.out.print("Selecione a opçao desejada: ");
                selecao = sc.nextLine();
                if (valida.validaValor(selecao)){
                    break;
                } else {
                    System.err.println("Selecionde um numero!");
                }
            }

            if (selecao.equalsIgnoreCase("1")){
                insereProduto();
            } else {
                if (selecao.equalsIgnoreCase("2")){
                    removeProdutoPorCodigo();
                } else {
                    if (selecao.equalsIgnoreCase("3")){
                        listaProdutosEmEstoque();
                    } else {
                        if (selecao.equalsIgnoreCase("4")){
                            moficaProduto();
                        } else {
                            if (selecao.equalsIgnoreCase("5")){
                                organizaProdutosPorId();
                            } else {
                                System.out.println("Ate a proxima!");
                                break;
                            }
                        }
                    }
                }
            }

        }


    }

    public static void insereProduto() {

        System.out.println("---> INSERINDO PRODUTO");

        String tipoProduto;
        String tituloProduto;
        String valor;
        String genero;
        String numeroDfases;
        String numeroDpaginas;

        while (true) {

            System.out.print("Tipo do produto: ");
            tipoProduto = sc.nextLine();

            if (valida.validaTipo(tipoProduto)) {
                break;
            } else {
                System.out.println("Erro tipo invalido, digite novamente");
            }
        }

        System.out.print("Digite o titulo do produto: ");
        tituloProduto = sc.nextLine();
        System.out.print("Digite o genero do produto: ");
        genero = sc.nextLine();

        while (true) {

            System.out.print("Digite o valor do produto: ");
            valor = sc.nextLine();
            if (valida.validaValor(valor)) {
                break;
            } else {
                System.err.println("Erro, coloque um valor valido!");
            }
        }


        if (tipoProduto.equalsIgnoreCase("filme")) {

            System.out.print("Digite o roteirista do filme: ");
            String roteirista = sc.nextLine();
            Filme filme = new Filme(tituloProduto, genero, Double.parseDouble(valor), roteirista);
            livraria.insercaoDeProduto(filme);


        } else {

            if (tipoProduto.equalsIgnoreCase("jogo")) {

                while (true) {

                    System.out.print("Digite o numero de fases do jogo: ");
                    numeroDfases = sc.nextLine();

                    if (valida.validaInt(numeroDfases)) {
                        break;
                    } else {
                        System.err.println("Erro, digite um valor valido!");
                    }

                }
                Jogo jogo = new Jogo(tituloProduto, genero, Double.parseDouble(valor), Integer.parseInt(numeroDfases));
                livraria.insercaoDeProduto(jogo);

            } else {
                while (true) {

                    System.out.print("Digite a quantidade de paginas do livro: ");
                    numeroDpaginas = sc.nextLine();

                    if (valida.validaInt(numeroDpaginas)) {
                        break;
                    } else {
                        System.err.println("Erro, digite um valor valido!");
                    }
                }

                Livro livro = new Livro(tituloProduto, genero, Double.parseDouble(valor), Integer.parseInt(numeroDpaginas));
                livraria.insercaoDeProduto(livro);

            }

        }
        System.out.println();

    }


    public static void listaProdutosEmEstoque(){
        System.out.println("---> ESTOQUE DE PRODUTOS");
        livraria.listaProdutosEmEstoque();
        System.out.println();
    }

    public static void removeProdutoPorCodigo() throws Exception{

        String codigoProdutoString;
        System.out.println("---> REMOVENDO PRODUTO POR CODIGO");

        while (true) {
            System.out.print("Digite o codigo do produto: ");
            codigoProdutoString = sc.nextLine();
            if (valida.validaInt(codigoProdutoString)){
                break;
            } else {
                System.err.println("Erro so podem conter numeros no codigo do produto!");
                System.out.println();
            }
        }

        if (livraria.removeProdutoPorId(Integer.parseInt(codigoProdutoString))){
            System.out.println("Produto removido com sucesso!");
        } else {
            throw new IdNaoExistenteException();
        }

        System.out.println();

    }

    public static void organizaProdutosPorId(){
        Produto[] produtosAtual = new Produto[contaItensEstoque()];
        int id, numeroDpaginas, numeroDfases;
        String titulo, genero, tipo, roteirista;
        double valor;

        try {
            FileWriter fw = new FileWriter("novo.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < contaItensEstoque(); i++){
                id = criaArrayProdutosOrganizados(contaItensEstoque())[i].getId();
                titulo = criaArrayProdutosOrganizados(contaItensEstoque())[i].getTituloProduto();
                genero = criaArrayProdutosOrganizados(contaItensEstoque())[i].getGenero();
                tipo = criaArrayProdutosOrganizados(contaItensEstoque())[i].getTipoProduto();
                valor = criaArrayProdutosOrganizados(contaItensEstoque())[i].getValor();

                if (tipo.equalsIgnoreCase("filme")){
                    roteirista = ((Filme)criaArrayProdutosOrganizados(contaItensEstoque())[i]).getRoteirista();
                    bw.write(id + "-" + tipo + "-" + titulo + "-" + genero + "-" + valor + "-" + roteirista);
                    bw.newLine();
                } else {
                    if (tipo.equalsIgnoreCase("jogo")){
                        numeroDfases = ((Jogo)criaArrayProdutosOrganizados(contaItensEstoque())[i]).getNumeroDeFases();
                        bw.write(id + "-" + tipo + "-" + titulo + "-" + genero + "-" + valor + "-" + numeroDfases);
                        bw.newLine();
                    } else {
                        numeroDpaginas = ((Livro)criaArrayProdutosOrganizados(contaItensEstoque())[i]).getNumeroDePaginas();
                        bw.write(id + "-" + tipo + "-" + titulo + "-" + genero + "-" + valor + "-" + numeroDpaginas);
                        bw.newLine();
                    }
                }
            }
            bw.flush();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        livraria.atualizaEstoque();
        System.out.println("Estoque Organizado!");

    }

    public static int contaItensEstoque(){
        int contagem = 0;

        FileReader fw = null;
        try {
            fw = new FileReader("Estoque.txt");
            BufferedReader br = new BufferedReader(fw);

            String line = br.readLine();
            while (line != null){
                line = br.readLine();
                contagem ++;
            }

            br.close();


        }catch (IOException e){
            e.printStackTrace();
        }

        return contagem;
    }

    public static Produto[] criaArrayProdutosOrganizados(int tamanhoArray){

        Produto[] produtos = new Produto[tamanhoArray];
        FileReader fw = null;
        String[] separado;
        int cont = 0;
        String line;
        try {
            fw = new FileReader("Estoque.txt");
            BufferedReader br = new BufferedReader(fw);
            line = br.readLine();


            while (cont < tamanhoArray){
                separado = line.split("-");


                if (separado[1].equalsIgnoreCase("filme")){
                    produtos[cont] = new Filme(separado[2], separado[3], Double.parseDouble(separado[4]),
                            separado[5], Integer.parseInt(separado[0]));
                } else {
                    if (separado[1].equalsIgnoreCase("jogo")){
                        produtos[cont] = new Jogo(separado[2], separado[3], Double.parseDouble(separado[4]),
                                Integer.parseInt(separado[5]), Integer.parseInt(separado[0]));
                    } else {
                        produtos[cont] = new Livro(separado[2], separado[3], Double.parseDouble(separado[4]),
                                Integer.parseInt(separado[5]), Integer.parseInt(separado[0]));
                    }
                }
                line = br.readLine();
                cont ++;
            }
            br.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        insertionSort(produtos);

        return produtos;
    }

    public static void insertionSort(Produto[] produtos) {

        Produto aux;

        for (int i = 1; i < produtos.length; i++) {

            if (produtos[i].getId() < produtos[i - 1].getId()) {
                for (int j = i; j > 0; j--) {
                    if (produtos[j].getId() < produtos[j - 1].getId()) {
                        aux = produtos[j - 1];
                        produtos[j - 1] = produtos[j];
                        produtos[j] = aux;
                    }
                }
            }
        }

    }

    public static void moficaProduto(){
        String codigoProdutoString;
        System.out.println("---> MODIFICANDO PRODUTO");
        String opcao;

        while (true) {
            System.out.print("Digite o codigo do produto: ");
            codigoProdutoString = sc.nextLine();
            if (valida.validaInt(codigoProdutoString)){
                break;
            } else {
                System.err.println("Erro so podem conter numeros no codigo do produto!");
                System.out.println();
            }
        }

        if (!livraria.achaProdutoPorId(Integer.parseInt(codigoProdutoString))){
            System.out.println("Erro produto nao encontrado!");
        } else {
            System.out.println("Opcoes disponiveis para mudanca");
            System.out.println("1--> Titulo do produto");
            System.out.println("2--> Genero do produto");
            System.out.println("3--> Valor do produto");
            System.out.println("Outro numero ---> Sair");

            while (true) {
                System.out.print("Digite a opcao desejada: ");
                opcao = sc.nextLine();
                if (valida.validaInt(opcao)) {
                    break;
                } else {
                    System.err.println("Erro, opcao invalida");
                    System.out.println();
                }
            }

            String novoTitulo;
            String novoGenero;
            String novoValor;

            if (opcao.equalsIgnoreCase("1")) {
                System.out.print("Digite o novo titulo do produto: ");
                novoTitulo = sc.nextLine();

                if (livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTipoProduto().equalsIgnoreCase("filme")) {
                    Filme f1 = new Filme(novoTitulo, livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getGenero(),
                            livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getValor(),
                            ((Filme) livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString))).getRoteirista(),
                            livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getId());
                    livraria.removeProdutoPorId(Integer.parseInt(codigoProdutoString));
                    livraria.insercaoDeProduto(f1);
                } else {
                    if (livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTipoProduto().equalsIgnoreCase("jogo")) {
                        Jogo j1 = new Jogo(novoTitulo, livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getGenero(),
                                livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getValor(),
                                ((Jogo) livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString))).getNumeroDeFases(),
                                livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getId());
                        livraria.removeProdutoPorId(Integer.parseInt(codigoProdutoString));
                        livraria.insercaoDeProduto(j1);
                    } else {
                        Livro l1 = new Livro(novoTitulo, livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getGenero(),
                                livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getValor(),
                                ((Livro) livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString))).getNumeroDePaginas(),
                                livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getId());
                        livraria.removeProdutoPorId(Integer.parseInt(codigoProdutoString));
                        livraria.insercaoDeProduto(l1);
                    }
                }

            } else {
                if (opcao.equalsIgnoreCase("2")) {
                    System.out.print("Digite o novo genero do produto: ");
                    novoGenero = sc.nextLine();

                    if (livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTipoProduto().equalsIgnoreCase("filme")) {
                        Filme f1 = new Filme(livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTituloProduto(), novoGenero,
                                livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getValor(),
                                ((Filme) livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString))).getRoteirista(),
                                livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getId());
                        livraria.removeProdutoPorId(Integer.parseInt(codigoProdutoString));
                        livraria.insercaoDeProduto(f1);
                    } else {
                        if (livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTipoProduto().equalsIgnoreCase("jogo")) {
                            Jogo j1 = new Jogo(livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTituloProduto(), novoGenero,
                                    livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getValor(),
                                    ((Jogo) livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString))).getNumeroDeFases(),
                                    livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getId());
                            livraria.removeProdutoPorId(Integer.parseInt(codigoProdutoString));
                            livraria.insercaoDeProduto(j1);
                        } else {
                            Livro l1 = new Livro(livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTituloProduto(), novoGenero,
                                    livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getValor(),
                                    ((Livro) livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString))).getNumeroDePaginas(),
                                    livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getId());
                            livraria.removeProdutoPorId(Integer.parseInt(codigoProdutoString));
                            livraria.insercaoDeProduto(l1);
                        }
                    }

                } else {
                    if (opcao.equalsIgnoreCase("3")) {
                        while (true){
                            System.out.print("Digite o novo valor do produto: ");
                            novoValor = sc.nextLine();
                            if (valida.validaValor(novoValor)){
                                break;
                            }else {
                                System.out.println("Erro coloque um valor valido!");
                            }
                        }


                        if (livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTipoProduto().equalsIgnoreCase("filme")) {
                            Filme f1 = new Filme(livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTituloProduto(), livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getGenero(),
                                    Double.parseDouble(novoValor),
                                    ((Filme) livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString))).getRoteirista(),
                                    livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getId());
                            livraria.removeProdutoPorId(Integer.parseInt(codigoProdutoString));
                            livraria.insercaoDeProduto(f1);
                        } else {
                            if (livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTipoProduto().equalsIgnoreCase("jogo")) {
                                Jogo j1 = new Jogo(livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTituloProduto(), livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getGenero(),
                                        Double.parseDouble(novoValor),
                                        ((Jogo) livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString))).getNumeroDeFases(),
                                        livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getId());
                                livraria.removeProdutoPorId(Integer.parseInt(codigoProdutoString));
                                livraria.insercaoDeProduto(j1);
                            } else {
                                Livro l1 = new Livro(livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getTituloProduto(), livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getGenero(),
                                        Double.parseDouble(novoValor),
                                        ((Livro) livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString))).getNumeroDePaginas(),
                                        livraria.devolveProdutoPorId(Integer.parseInt(codigoProdutoString)).getId());
                                livraria.removeProdutoPorId(Integer.parseInt(codigoProdutoString));
                                livraria.insercaoDeProduto(l1);
                            }
                        }

                    } else {
                        System.out.println("Retornar ao menu!");
                    }
                }

            }

        }

    }


    public static void main(String[] args) throws Exception {
        menu();

    }
}
