package com.ask.game.dto;

public interface LinkedList<R> {

    R getNext();

    void setNext(R r);

    R getPrev();

    void setPrev(R r);
}
