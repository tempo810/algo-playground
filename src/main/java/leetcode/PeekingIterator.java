package leetcode;

import java.util.Iterator;

/**
 * @author Tempo
 */
public class PeekingIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;

    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        next = getNext();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = next;
        next = getNext();
        return temp;
    }

    private Integer getNext() {
        return iterator.hasNext() ? iterator.next() : null;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
