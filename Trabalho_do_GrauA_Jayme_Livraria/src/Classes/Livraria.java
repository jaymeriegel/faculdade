package Classes;

import java.io.*;

public class Livraria {

    public void insercaoDeProduto(Produto produto) {

        FileWriter fw = null;
        try {
            fw = new FileWriter("estoque.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(produto.getId() + "-");
            bw.write(produto.getTipoProduto() + "-");
            bw.write(produto.getTituloProduto() + "-");
            bw.write(produto.getGenero() + "-");
            bw.write(produto.getValor() + "-");

            if (produto instanceof Filme) {
                bw.write(((Filme) produto).getRoteirista());
            } else {
                if (produto instanceof Jogo) {
                    String numeroDfases = Integer.toString(((Jogo) produto).getNumeroDeFases());
                    bw.write(numeroDfases);
                } else {
                    String numeroDpaginas = Integer.toString(((Livro) produto).getNumeroDePaginas());
                    bw.write(numeroDpaginas);
                }
            }

            bw.newLine();
            bw.flush();
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listaProdutosEmEstoque() {

        FileReader fr = null;
        try {
            fr = new FileReader("estoque.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void removeEorganiza(int id) {

        String[] separado;
        FileReader fr = null;
        try {
            FileWriter fw = new FileWriter("novo.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            fr = new FileReader("Estoque.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                separado = line.split("-");
                if (!separado[0].equalsIgnoreCase(Integer.toString(id))) {
                    bw.write(line);
                    bw.newLine();
                }
                line = br.readLine();
            }

            br.close();
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizaEstoque() {
        FileReader fr = null;

        try {
            FileWriter fw = new FileWriter("Estoque.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            fr = new FileReader("novo.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }

            br.close();
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean achaProdutoPorId(int id) {

        boolean achouId = false;
        String[] separado;
        FileReader fr = null;
        try {
            fr = new FileReader("estoque.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                separado = line.split("-");
                if (separado[0].equalsIgnoreCase(Integer.toString(id))) {
                    return true;
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    public Produto devolveProdutoPorId(int id) {

        boolean achouId = false;
        String[] separado;
        FileReader fr = null;
        try {
            fr = new FileReader("estoque.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                separado = line.split("-");
                if (separado[0].equalsIgnoreCase(Integer.toString(id))) {
                    if (separado[1].equalsIgnoreCase("filme")) {
                        return new Filme(separado[2], separado[3], Double.parseDouble(separado[4]), separado[5], Integer.parseInt(separado[0]));
                    } else {
                        if (separado[1].equalsIgnoreCase("jogo")) {
                            return new Jogo(separado[2], separado[3], Double.parseDouble(separado[4]), Integer.parseInt(separado[5]), Integer.parseInt(separado[0]));
                        } else {
                            return new Livro(separado[2], separado[3], Double.parseDouble(separado[4]), Integer.parseInt(separado[5]), Integer.parseInt(separado[0]));
                        }
                    }

                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean removeProdutoPorId(int idProduto) {

        boolean achouId = false;
        String[] separado;
        FileReader fr = null;
        try {
            fr = new FileReader("estoque.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                separado = line.split("-");
                if (separado[0].equalsIgnoreCase(Integer.toString(idProduto))) {
                    achouId = true;
                    removeEorganiza(idProduto);
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        atualizaEstoque();
        return achouId;

    }

}
