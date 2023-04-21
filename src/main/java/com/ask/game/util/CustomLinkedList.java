package com.ask.game.util;

import com.ask.game.dto.LinkedList;

/**
 *
 * @author Daniel/DaniDaniel09
 * @param <R>
 */
public class CustomLinkedList<R extends LinkedList> {

    R head;
    R tail;
    R current;

    /**
     *
     * @param head
     */
    public CustomLinkedList(R head) {
        this.head = head;
        this.tail = head;
        this.current = head;
//        this.current.setNext(head);
    }

    /**
     *
     * @param node
     * @return
     */
    public R insert(R node) {
        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
        return node;
    }

    /**
     *
     */
    public void reset() {
        this.current = this.head;
    }

    /**
     *
     * @return
     */
    public boolean hasNext() {
        return this.current != null && this.current.getNext() != null;
    }

    /**
     *
     * @return
     */
    public R next() {
        R temp = (R) current.getNext();
        if (temp != null) {
            current = (R) temp;
        }
        return (R) temp;
    }

    /**
     *
     * @return
     */
    public R prev() {
        return (R) current.getPrev();
    }

    /**
     *
     * @return
     */
    public boolean hasPrev() {
        return this.current != null && this.current.getPrev() != null;
    }

    /**
     *
     * @return
     */
    public R getHead() {
        return this.head;
    }

    /**
     *
     * @return
     */
    public R getTail() {
        return this.tail;
    }

    /**
     *
     * @return
     */
    public R getCurrent() {
        return this.current;
    }

}
