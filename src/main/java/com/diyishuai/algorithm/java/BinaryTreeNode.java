package com.diyishuai.algorithm.java;

/**
 * @author Bruce
 * @since 2019-04-10
 */
public class BinaryTreeNode {

    public BinaryTreeNode leftChild;

    public Long value;

    public BinaryTreeNode rightChild;



    public BinaryTreeNode(BinaryTreeNode leftChild, Long value, BinaryTreeNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = value;
    }

    public BinaryTreeNode() {
    }

    public static void preOrder(BinaryTreeNode treeNode){
        if (treeNode!=null){
            System.out.println(treeNode.value);
            preOrder(treeNode.leftChild);
            preOrder(treeNode.rightChild);
        }
    }

    public static void inOrder(BinaryTreeNode treeNode){
        if (treeNode!=null){
            inOrder(treeNode.leftChild);
            System.out.println(treeNode.value);
            inOrder(treeNode.rightChild);
        }
    }

    public static void postOrder(BinaryTreeNode treeNode){
        if (treeNode!=null){
            postOrder(treeNode.leftChild);
            postOrder(treeNode.rightChild);
            System.out.println(treeNode.value);
        }
    }


    public static void main(String[] args) {
        /**
         *               1
         *             2   3
         *            4   5 6
         */
        BinaryTreeNode root = new BinaryTreeNode(
                new BinaryTreeNode(
                        new BinaryTreeNode(null,4l,null),
                        2L,
                        null
                ),
                1L,
                new BinaryTreeNode(
                        new BinaryTreeNode(null,5l,null),
                        3L,
                        new BinaryTreeNode(null,6l,null)
                )
        );

        preOrder(root);
        System.out.println("======");
        inOrder(root);
        System.out.println("======");
        postOrder(root);
    }
}
