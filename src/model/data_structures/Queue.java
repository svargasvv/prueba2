package model.data_structures;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>, IQueue<T> {

  private Node<T> head;
  private Node<T> last;
  private int size;


  public Queue() {
    head = null;
    last = null;
    size = 0;
  }

  public Iterator<T> iterator() {

    return new IteratorSQ<T>(head);
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return size == 0;
  }

  @Override
  public int size() {

    return size;
  }

  @Override
  public void enqueue(T t) {

    if (t != null) {
      Node<T> nuevo = new Node<T>(t);
      if (size == 0) {
        head = nuevo;
        last = nuevo;
        head.cambiarSiguiente(last);
        last.cambiarAnterior(head);
        size = 2;
      } else if (size == 2) {
        head = nuevo;
        head.cambiarSiguiente(last);
        last.cambiarAnterior(head);
        size++;
      } else {
        head.cambiarAnterior(nuevo);
        nuevo.cambiarSiguiente(head);
        head = nuevo;
        size++;
      }
    }

  }

  @Override
  public T dequeue() {
    Node<T> retorno = new Node<T>(null);
    if (size != 0) {

      if (size == 1) {
        retorno = head;
        head = null;
      } else if (size == 2) {
        retorno = last;
        size--;
        head.cambiarSiguiente(null);

      } else {

        retorno = last;
        last = last.darAnterior();
        last.cambiarSiguiente(null);
        size--;

      }

    }
    return retorno.darElement();
  }

}
