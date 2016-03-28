package com.leo.algorithm.btree;

class Root {
    public int data = -1;
    public Node[] children = new Node[2];
    public Root(int data) {
        this.data = data;
    }

}

class Node {
    public Node parent;
    public int[] datas = new int[2];
    public Node[] children = new Node[3];
}

public class BTree1 {

    private Root root = null;

    public BTree1(int[] nodes) {
        for (int data : nodes) {
            insertNode(data);
        }
    }

    public void insertNode(int data) {
        if (root == null) {
            root = new Root(data);
        } else {
            for (Node node : root.children) {
                insertNode(node, data);
            }
        }
    }

    public void insertNode(Node node, int data) {
        if (node != null) {
            if (node.datas[0] > data) {
                if (node.children[0] != null) {
                    insertNode(node.children[0], data);
                }
            } else if (node.datas[2] < data) {
                if (node.children[2] != null) {
                    insertNode(node.children[2], data);
                }
            } else {
                if (node.children[1] != null) {
                    insertNode(node.children[1], data);
                }
            }
        } else {
            node = new Node();
            node.datas[0] = data;
        }
    }


    public void printBTree() {
        if (root != null) {
            System.out.println("Root: " + root.data);
            for (Node n : root.children) {
                if (n != null) {
                    printBTree(n);
                }
            }
        }

    }

    public void printBTree(Node node) {
        if (node != null) {
            for (int i : node.datas) {
                System.out.print("Node: " + i + "\t");
            }
            System.out.println();
            for (Node n : node.children) {
                if (n != null) {
                    printBTree(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8};
        BTree1 bTree = new BTree1(arr);
        bTree.printBTree();
    }

}
