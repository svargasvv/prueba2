package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
/******************************************************************************
 *  Compilation:  javac LinkedStack.java
 *  Execution:    java LinkedStack < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/13stacks/tobe.txt
 *
 *  A generic stack, implemented using a linked list. Each stack
 *  element is of type Item.
 *  
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java LinkedStack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/
public class Stack<T> implements IStack<T>, Iterable<T> {

	 private int n;          // size of the stack
	    private Node first;     // top of stack

	    // helper linked list class
	    private class Node {
	        private T T;
	        private Node next;
	    }

	    /**
	     * Initializes an empty stack.
	     */
	    public Stack() {
	        first = null;
	        n = 0;
	        assert check();
	    }

	    /**
	     * Is this stack empty?
	     * @return true if this stack is empty; false otherwise
	     */
	    public boolean isEmpty() {
	        return first == null;
	    }

	    /**
	     * Returns the number of Ts in the stack.
	     * @return the number of Ts in the stack
	     */
	    public int size() {
	        return n;
	    }

	    /**
	     * Adds the T to this stack.
	     * @param T the T to add
	     */
	    public void push(T T) {
	        Node oldfirst = first;
	        first = new Node();
	        first.T = T;
	        first.next = oldfirst;
	        n++;
	        assert check();
	    }

	    /**
	     * Removes and returns the T most recently added to this stack.
	     * @return the T most recently added
	     * @throws java.util.NoSuchElementException if this stack is empty
	     */
	    public T pop() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        T T = first.T;        // save T to return
	        first = first.next;            // delete first node
	        n--;
	        assert check();
	        return T;                   // return the saved T
	    }


	    /**
	     * Returns (but does not remove) the T most recently added to this stack.
	     * @return the T most recently added to this stack
	     * @throws java.util.NoSuchElementException if this stack is empty
	     */
	    public T peek() {
	        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
	        return first.T;
	    }

	    /**
	     * Returns a string representation of this stack.
	     * @return the sequence of Ts in the stack in LIFO order, separated by spaces
	     */
	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        for (T T : this)
	            s.append(T + " ");
	        return s.toString();
	    }
	       
	    /**
	     * Returns an iterator to this stack that iterates through the Ts in LIFO order.
	     * @return an iterator to this stack that iterates through the Ts in LIFO order.
	     */
	    public Iterator<T> iterator() {
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


	    // check internal invariants
	    private boolean check() {

	        // check a few properties of instance variable 'first'
	        if (n < 0) {
	            return false;
	        }
	        if (n == 0) {
	            if (first != null) return false;
	        }
	        else if (n == 1) {
	            if (first == null)      return false;
	            if (first.next != null) return false;
	        }
	        else {
	            if (first == null)      return false;
	            if (first.next == null) return false;
	        }

	        // check internal consistency of instance variable n
	        int numberOfNodes = 0;
	        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
	            numberOfNodes++;
	        }
	        if (numberOfNodes != n) return false;

	        return true;
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
