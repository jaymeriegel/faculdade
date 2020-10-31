import Classes.MethodsExercicio;
import Classes.StaticStack;
import Interface.Stack;

public class Main {

    static MethodsExercicio ex = new MethodsExercicio();
    public static void main(String[] args) {


        //exercicio1

        // p1 = {}
        // p2 = {}
        // p3 = {3 , 1, 4, 2}


        //exercicio2

//        p2.push(p1.pop());
//        p2.push(p1.pop());
//        p3.push(p1.pop());
//        p3.push(p1.pop());
//        p1.push(p2.pop());
//        p3.push(p2.pop());
//        p3.push(p1.pop());


        Stack<Integer> pilha1 = new StaticStack<>(20);

        for (int i = 0; i < 20; i++){
            pilha1.push(50 + i);
        }

        ex.itemsExcept(55, pilha1);

        for (int i = 0; i < ex.itemsExcept(55, pilha1).length; i++){
            System.out.println(ex.itemsExcept(55, pilha1)[i]);
        }





    }
}
