package com.szy.skill.geek.wz.tree;

/**
 * 〈一句话功能简述〉<br>
 * 〈二叉查找树〉
 *
 * @author steamedfish
 * @create 2019/9/8
 * @since 1.0.0
 */
public class BinarySearchTree {

    private Node tree;

    public Node find(int data) {
        Node p = tree;

        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }

        return null;
    }

    public void insert(int data) {
        if (null == tree) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (null != p) {
            if (data > p.data) {
                if (null == p.right) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (null == p.left) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 1. 删除节点无子节点：父节点调整
     * 2. 删除节点有一个子节点：子节点替代待删除节点
     * 3. 删除节点有两个子节点： 右子孙节点中最左节点替换删除节点 或者 左子节点中最右子节点替换删除节点
     *
     * @param data
     */
    public void delete(int data) {
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p == null) {
            return;
        }

        if ((p.left != null) && (p.right != null)) {
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }


    }


    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int val) {
            this.data = val;
        }

    }
}
