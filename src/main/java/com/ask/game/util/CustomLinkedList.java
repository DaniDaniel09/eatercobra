package com.ask.game.util;

import com.ask.game.dto.LinkedList;

public class CustomLinkedList<R extends LinkedList> {

    R head;
    R tail;
    R current;

    public CustomLinkedList(R head) {
        this.head = head;
        this.tail = head;
        this.current = head;
//        this.current.setNext(head);
    }

    public R insert(R node) {
        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
        return node;
    }

    public void reset() {
        this.current = this.head;
    }

    public boolean hasNext() {
        return this.current != null && this.current.getNext() != null;
    }

    public R next() {
        R temp = (R) current.getNext();
        if (temp != null) {
            current = (R) temp;
        }
        return (R) temp;
    }


    public R prev() {
        return (R) current.getPrev();
    }

    public boolean hasPrev() {
        return this.current != null && this.current.getPrev() != null;
    }

    public R getHead() {
        return this.head;
    }

    public R getTail() {
        return this.tail;
    }

    public R getCurrent() {
        return this.current;
    }

}
