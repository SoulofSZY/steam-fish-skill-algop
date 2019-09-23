package com.szy.skill.geek.wz.list;

import java.util.Optional;

/**
 * 〈一句话功能简述〉<br>
 * 〈基于链表实现LRU缓存淘汰算法〉
 *
 * @author steamedfish
 * @create 2019/7/27
 * @since 1.0.0
 */
public class LRUList {

    static class Node<T> {
        T val;
        Node<T> next;

        Node() {
        }

        Node(T val, Node<T> next) {
            this.next = next;
            this.val = val;
        }
    }

    private static Node head;

    public static final <E> int store(E val) {
        Optional<Node> headOptional = Optional.ofNullable(LRUList.head);
        if (headOptional.isPresent()) {
            Node curr = head;
            Node prev = null;
            do {
                if (curr.val.equals(val)) {
                    prev.next = curr.next;
                    curr.next = head;
                    head = curr;
                    return 1;
                }
                prev = curr;
                curr = curr.next;
            } while (null != curr);

            curr = new Node(val, head);
            head = curr;

            return 1;
        } else {
            head = new Node(val, null);
            return 1;
        }
    }

    public static void printList() {
        Node curr = head;
        while (null != curr) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        store(1);
        printList();
        store(2);
        printList();
        store(1);
        printList();
        store(3);
        printList();

    }

}
