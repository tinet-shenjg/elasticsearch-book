package com.shenjg.book;

import lombok.Data;

import java.util.LinkedList;

/**
 * 二叉树的前序、中序、后序、层次遍历
 *
 * @author shenjg
 * @date 2019/07/15
 */
@Data
public class TreeNode {

    /**
     * 数据
     */
    private Integer data;

    /**
     * 左孩子
     */
    private TreeNode leftChild;

    /**
     * 右孩子
     */
    private TreeNode rightChild;

    /**
     * 前序遍历
     *
     * @param node
     */
    private static void preOrder(TreeNode node) {
        System.out.println(node.getData());
        if (node.getLeftChild() != null) {
            preOrder(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            preOrder(node.getRightChild());
        }

    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private static void mediumOrder(TreeNode node) {

        if (node == null) {
            return;
        } else {
            mediumOrder(node.getLeftChild());
            System.out.println(node.getData());
            mediumOrder(node.getRightChild());
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    private static void postOrder(TreeNode node) {

        if (node == null) {
            return;
        } else {
            mediumOrder(node.getLeftChild());
            mediumOrder(node.getRightChild());
            System.out.println(node.getData());
        }
    }

    /**
     * 层次遍历
     *
     * @param node
     */
    private static void levelOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        LinkedList<TreeNode> nodeLinkedList = new LinkedList<>();
        nodeLinkedList.add(node);
        TreeNode treeNode;
        while (!nodeLinkedList.isEmpty()) {
            treeNode = nodeLinkedList.poll();
            System.out.println(treeNode.getData());
            if (treeNode.getLeftChild() != null) {
                nodeLinkedList.add(treeNode.getLeftChild());
            }
            if (treeNode.getRightChild() != null) {
                nodeLinkedList.add(treeNode.getRightChild());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode[] treeNodes = new TreeNode[11];
        for (int i = 0; i <= 10; i++) {
            TreeNode treeNode = new TreeNode();
            treeNode.setData(i + 1);
            treeNodes[i] = treeNode;
        }
        for (int i = 0; i < 5; i++) {

            treeNodes[i].setLeftChild(treeNodes[(i + 1) * 2 - 1]);
            treeNodes[i].setRightChild(treeNodes[(i + 1) * 2]);
        }

        System.out.println(treeNodes);
        System.out.println("先序遍历");
        preOrder(treeNodes[0]);
        System.out.println("中序遍历");
        mediumOrder(treeNodes[0]);
        System.out.println("后序遍历");
        postOrder(treeNodes[0]);
        System.out.println("层次遍历");
        levelOrder(treeNodes[0]);
    }
}
