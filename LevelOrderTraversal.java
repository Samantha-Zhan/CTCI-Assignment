import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
      Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            Node currNode = nodes.remove();
            System.out.print(currNode.data + " ");
            if(currNode.left!=null) {
                nodes.add(currNode.left);
            }
            if(currNode.right!=null) {
                nodes.add(currNode.right);
            }
        }
    }

	public static Node insert(Node root, int data) {
