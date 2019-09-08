package com.szy.skill.geek.wz.list;

/**
 * 〈一句话功能简述〉<br>
 * 〈如果字符串是通过单链表来存储的，那该如何来判断是一个回文串呢？〉
 *
 * @author steamedfish
 * @create 2019/7/27
 * @since 1.0.0
 */
public class PlalindromeString {

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

    private static Node String2NodeList(String str) {
        String[] charArr = str.split("");
        Node head = new Node(charArr[0], null);
        Node curr = head;
        for (int i = 1; i < charArr.length; i++) {
            Node node = new Node(charArr[i], null);
            curr.next = node;
            curr = node;
        }
        return head;
    }

    public static int plalindromeString(String str) {
        if (null == str || "".equals(str.trim())) {
            return -1;
        }
        Node strFirst = String2NodeList(str);
        Node currFast = strFirst.next.next;
        Node currSlow = strFirst.next;
        Node prevSlow = strFirst;
        prevSlow.next = null;
        while (currFast != null && currFast.next != null) {
            currFast = currFast.next.next;

            Node temp = currSlow.next;
            currSlow.next = prevSlow;
            prevSlow = currSlow;
            currSlow = temp;

        }

        Node currRight = currSlow;
        Node currLeft = prevSlow;
        while (currLeft != null || currRight != null) {
            if (null == currLeft && null != currRight) {
                return -1;
            }
            if (null != currLeft && null == currRight) {
                return -1;
            }
            if (!currLeft.val.equals(currRight.val)) {
                return -1;
            }
            currLeft = currLeft.next;
            currRight = currRight.next;
        }
        return 1;
    }


    public static void main(String[] args) {
        System.out.println("" + plalindromeString("abccba"));
    }
}
