package model.data_structures;

import java.util.Iterator;

public class Stack<T> implements IStack<T>, Iterable<T> {

  private Node<T> peek;
  private int size;

  public Stack() {
    peek = null;
    size = 0;
  }

  public Iterator iterator() {
    // TODO Auto-generated method stub
    return new IteratorSQ<T>(peek);
  }

  @Override
  public boolean isEmpty() {

    return size == 0;
  }

  @Override
  public int size() {

    return size;
  }

  @Override
  public void push(T t) {
    if (t != null) {
      Node<T> nuevo = new Node<T>(t);
      if (size == 0) {
        peek = nuevo;
      } else {
        nuevo.cambiarSiguiente(peek);
        peek.cambiarAnterior(nuevo);
        peek = nuevo;
      }
      size++;
    }
  }

  @Override
  public T pop() {
    Node<T> retorno = new Node<T>(null);
    if (size != 0) {
      retorno = peek;

      peek = peek.darSiguiente();
      peek.cambiarAnterior(null);
      retorno.cambiarSiguiente(null);
      size--;
    }

    return retorno.darElement();
  }

}
