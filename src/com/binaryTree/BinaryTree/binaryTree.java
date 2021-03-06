package com.binaryTree.BinaryTree;

import com.binaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class binaryTree {
    public Node root;
    binaryTree(int data){
        root = new Node(data);
    }
    public binaryTree(){
        root = null;
    }

    public Node search(Node node, int key){
        if(node==null || node.getData()==key){
            return node;
        }
        if(node.getData() > key){
            return search(node.left, key);
        }
        return search(node.right, key);
    }
    public Node insert(Node node, int key){
        if(node == null){
            node = new Node(key);
        }
        if(key < node.getData()){
            node.left = insert(node.left, key);
        }
        else if(key > node.getData()){
            node.right = insert(node.right, key);
        }
        return node;
    }
    public Node delete(Node node, int key){

        if(node == null){
            return node;
        }
        if(key < node.getData()){
            node.left = delete(node.left, key);
        }
        else if(key > node.getData()){
            node.right = delete(node.right, key);
        }
        else{
            //node with only one child or no child
            if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }
            // node with two children
            //Get inorder successor
            // For deletion place minimum value in right tree
            node.setData(minimum_value(node.right));
            node.right = delete(node.right, node.getData());

        }
        return node;
    }
    int minimum_value(Node node){
        int min_val = node.getData();
        while(node.left != null){
            min_val = node.left.getData();
            node = node.left;
        }
        return min_val;
    }
   public int heightOfTree(Node node){

        if(node == null){
            return 0;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        int height = 0;
        while(1>0){
            int nodeCount = q.size();
            if(nodeCount == 0){
                return height;
            }
            height++;
            while(nodeCount > 0){
                Node newnode = q.peek();
                q.remove();
                if(newnode.left != null){
                    q.add(newnode.left);
                }
                if(newnode.right != null){
                    q.add(newnode.right);
                }
                nodeCount--;
            }
        }
    }
}

