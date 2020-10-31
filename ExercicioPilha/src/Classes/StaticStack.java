package Classes;

import Exceptions.OverflowException;
import Exceptions.UnderflowException;
import Interface.Stack;

public class StaticStack<E> implements Stack<E> {

    protected int top;
    protected E elements[];

    public StaticStack(int maxSize) {
        this.elements = (E[]) new Object[maxSize];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == elements.length - 1;
    }

    @Override
    public int numElements() {
        return top + 1;
    }

    @Override
    public void push(E element) throws OverflowException {

        if (isFull()){
            throw new OverflowException();
        }

        elements[++top] = element;

    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()){
            throw new UnderflowException();
        }

        E element = elements[top];
        elements[top] = null;
        top --;
        return element;

    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()){
            throw new UnderflowException();
        }

        return elements[top];
    }

    public String toString() {
        if (isEmpty())
            return "[Empty]";
        else {
            String s = "[";
            for (int i = numElements() - 1; i >= 0; i--) {
                s += "\n" + elements[i];
            }
            s += "\n]";
            return s;
        }
    }
}
