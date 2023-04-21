package com.ask.game.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author Daniel/DaniDaniel09
 * @param <T>
 */
@Data
//@Builder
@NoArgsConstructor
public class LinkedListNode<T> implements Serializable, LinkedList<LinkedListNode> {
    T data;
    LinkedListNode next;
    LinkedListNode prev;

}
