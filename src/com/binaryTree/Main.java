package com.binaryTree;

import com.binaryTree.BinaryTree.binaryTree;

import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {
	// Trees are hierarchical data structures. Can be used when you want to store information that naturally forms hierarchy
        // Moderate access for search, insertion and deletion.
        // A tree whose elements have at most 2 children is called binary tree.
        binaryTree tree = new binaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(6);
    }
}
