package W15;

import java.util.*;
import java.io.*;
public class BinaryTree {

    static class Node {
        Node left, right;
        int value;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.value) {
                if (this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Node root = new Node(Integer.parseInt(br.readLine()));
            String input;
            while (true) {
                input = br.readLine();
                if (input == null || input.equals(""))
                    break;
                root.insert(Integer.parseInt(input));
            }

            postOrder(root);
        }

        static void postOrder(Node node) {
            if (node == null)
                return;

            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }
}
