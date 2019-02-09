package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *  The {@code LinkedQueue} class represents a first-in-first-out (FIFO)
 *  queue of generic items.
 *  It supports the usual <em>enqueue</em> and <em>dequeue</em>
 *  operations, along with methods for peeking at the first item,
 *  testing if the queue is empty, and iterating through
 *  the items in FIFO order.
 *  <p>
 *  This implementation uses a singly linked list with a non-static nested class 
 *  for linked-list nodes.  See {@link Queue} for a version that uses a static nested class.
 *  The <em>enqueue</em>, <em>dequeue</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Queue<T> implements Iterable<T>, IQueue<T> {

	 private int n;         // number of elements on queue
	    private Node first;    // beginning of queue
	    private Node last;     // end of queue

	    // helper linked list class
	    private class Node {
	        private T T;
	        private Node next;
	    }

	    /**
	     * Initializes an empty queue.
	     */
	    public Queue() {
	        first = null;
	        last  = null;
	        n = 0;
	      
	    }

	    /**
	     * Is this queue empty?
	     * @return true if this queue is empty; false otherwise
	     */
	    public boolean isEmpty() {
	        return first == null;
	    }

	    /**
	     * Returns the number of Ts in this queue.
	     * @return the number of Ts in this queue
	     */
	    public int size() {
	        return n;     
	    }

	    /**
	     * Returns the T least recently added to this queue.
	     * @return the T least recently added to this queue
	     * @throws java.util.NoSuchElementException if this queue is empty
	     */
	    public T peek() {
	        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	        return first.T;
	    }

	    /**
	     * Adds the T to this queue.
	     * @param T the T to add
	     */
	    public void enqueue(T T) {
	        Node oldlast = last;
	        last = new Node();
	        last.T = T;
	        last.next = null;
	        if (isEmpty()) first = last;
	        else           oldlast.next = last;
	        n++;
	        assert check();
	    }

	    /**
	     * Removes and returns the T on this queue that was least recently added.
	     * @return the T on this queue that was least recently added
	     * @throws java.util.NoSuchElementException if this queue is empty
	     */
	    public T dequeue() {
	        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	        T T = first.T;
	        first = first.next;
	        n--;
	        if (isEmpty()) last = null;   // to avoid loitering
	        assert check();
	        return T;
	    }

	    /**
	     * Returns a string representation of this queue.
	     * @return the sequence of Ts in FIFO order, separated by spaces
	     */
	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        for (T T : this)
	            s.append(T + " ");
	        return s.toString();
	    } 

	    // check internal invariants
	    private boolean check() {
	        if (n < 0) {
	            return false;
	        }
	        else if (n == 0) {
	            if (first != null) return false;
	            if (last  != null) return false;
	        }
	        else if (n == 1) {
	            if (first == null || last == null) return false;
	            if (first != last)                 return false;
	            if (first.next != null)            return false;
	        }
	        else {
	            if (first == null || last == null) return false;
	            if (first == last)      return false;
	            if (first.next == null) return false;
	            if (last.next  != null) return false;

	            // check internal consistency of instance variable n
	            int numberOfNodes = 0;
	            for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
	                numberOfNodes++;
	            }
	            if (numberOfNodes != n) return false;

	            // check internal consistency of instance variable last
	            Node lastNode = first;
	            while (lastNode.next != null) {
	                lastNode = lastNode.next;
	            }
	            if (last != lastNode) return false;
	        }

	        return true;
	    } 
	 

	    /**
	     * Returns an iterator that iterates over the Ts in this queue in FIFO order.
	     * @return an iterator that iterates over the Ts in this queue in FIFO order
	     */
	    public Iterator<T> iterator()  {
	        return new ListIterator();  
	    }

	    // an iterator, doesn't implement remove() since it's optional
	    private class ListIterator implements Iterator<T> {
	        private Node current = first;

	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public T next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            T T = current.T;
	            current = current.next; 
	            return T;
	        }
	    }


	  
	}

	/******************************************************************************
	 *  Copyright 2002-2018, Robert Sedgewick and Kevin Wayne.
	 *
	 *  This file is part of algs4.jar, which accompanies the textbook
	 *
	 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
	 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
	 *      http://algs4.cs.princeton.edu
	 *
	 *
	 *  algs4.jar is free software: you can redistribute it and/or modify
	 *  it under the terms of the GNU General Public License as published by
	 *  the Free Software Foundation, either version 3 of the License, or
	 *  (at your option) any later version.
	 *
	 *  algs4.jar is distributed in the hope that it will be useful,
	 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
	 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	 *  GNU General Public License for more details.
	 *
	 *  You should have received a copy of the GNU General Public License
	 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
	 ******************************************************************************/
