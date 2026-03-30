import java.util.*;

    public class Splay{
    // Splay Tree
    static class SplayTree
    {
         class Node {
            int key;
            Node left, right;

            Node(int key) {
                this.key = key;
            }
        }

        Node root;

        void insert(int key) {
            root = insertRec(root, key);
        }

        Node insertRec(Node root, int key) {
            if (root == null) return new Node(key);

            if (key < root.key)
                root.left = insertRec(root.left, key);
            else
                root.right = insertRec(root.right, key);

            return root;
        }

        boolean search(int key) {
            return searchRec(root, key);
        }

        boolean searchRec(Node root, int key) {
            if (root == null) return false;
            if (root.key == key) return true;
            if (key < root.key)
                return searchRec(root.left, key);
            else
                return searchRec(root.right, key);
        }
    }//end of a static method

public static void main(String[] args)
    {
    // Splay Tree Test
        SplayTree tree = new SplayTree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        System.out.println("Splay Tree Search (10 found): " + tree.search(10));
    }
}
