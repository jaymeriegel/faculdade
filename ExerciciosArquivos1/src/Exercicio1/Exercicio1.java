import java.io.*;
import java.util.Stack;

public class Exercicio1 {

    public static void inverteArquivo(File file)  {
        Stack<String> pilha = new Stack<>();
        FileReader fr = null;
        BufferedReader br  = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                pilha.push(line);
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("novoArquivoInvertido.java", true);
            bw = new BufferedWriter(fw);
            while (!pilha.isEmpty()){
                System.out.println(pilha.peek());
                bw.write(pilha.peek());
                bw.newLine();
                pilha.pop();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        inverteArquivo(new File("C:\\Users\\jayme\\Desktop\\Jayme\\Faculdade\\Programacao-SegundoSemestre\\ExerciciosArquivos1\\Exercicio.java"));
    }
}
