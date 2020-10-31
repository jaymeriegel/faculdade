package Classes;

import Interface.Stack;

public class MethodsExercicio {


    public Integer[] itemsExcept(int number, Stack<Integer> p){

        Integer[] arrayExept = new Integer[p.numElements()];
        Stack<Integer> pilha = new StaticStack<>(p.numElements());
        Integer aux = 0;
        Integer contador = 0;

        while (!p.isEmpty()){
            aux = p.pop();
            if (aux != number){
                arrayExept[contador] = aux;
                contador++;
            }
            pilha.push(aux);
        }

        while (!pilha.isEmpty()){
            p.push(pilha.pop());
        }

        return arrayExept;

    }
}
