/* Given a Perfect Binary Tree reverse the odd levels of the Binary Tree... */
import java.util.*;
public class Reverse
{
    public class Node
    {
        public int data;
        public Node left;
        public Node right;
        public Node(int value)
        {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }
    public class Binary
    {
        public static int index = -1;
        public Node InsertNode(int nodes[])
        {
            index++;
            if(nodes[index] == -1)
                return null;
            Node n = new Node(nodes[index]);
            n.left = InsertNode(nodes);
            n.right = InsertNode(nodes);
            return n;
        }
        public void Print(Node root)
        {
            if(root == null)
                return;
            System.out.println("Node : "+root.data);
            if(root.left != null)
                System.out.println("\t"+root.data+" ---> "+root.left.data+"\t Left ( Occupied )");
            else
                System.out.println("\t"+root.data+"\t\t Left ( Empty )");
            if(root.right != null)
                System.out.println("\t"+root.data+" ---> "+root.right.data+"\t Right ( Occupied )");
            else
                System.out.println("\t"+root.data+"\t\t Right ( Empty )");
            Print(root.left);
            Print(root.right);
        }
        public Node ReverseOddLevels(Node root)
        {
            Traverse(root.left, root.right, 1);    // Calling reverse functions...
            return root;
        }
        public void Traverse(Node node1, Node node2, int level)
        {
            if(node1 == null || node2 == null)
                return;
            if(level % 2 == 1)
            {   // Reversing the Left and Right Child levels...
                int temp = node1.data;
                node1.data = node2.data;
                node2.data = temp;
            }
            Traverse(node1.left, node2.right, level+1);    // We pass the node left and right child...
            Traverse(node1.right, node2.left, level+1);    // Similarly we pass in reverse fashion...
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of nodes (including null nodes) : ");
        x = sc.nextInt();
        int nodes[] = new int[x];
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter the "+(i+1)+" th Node : ");
            nodes[i] = sc.nextInt();
        }
        Reverse reverse = new Reverse();          // Object creation...
        Binary binary = reverse.new Binary();     // Object creation...
        Node root = binary.InsertNode(nodes);
        binary.Print(root);
        binary.ReverseOddLevels(root);     // Calling function for Reversing the Odd levels...
        System.out.println("Nodes After Reversing Odd levels !!");
        binary.Print(root);
        sc.close();
    }
}

// Time Complexity  - O(log n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :-  
 * 1. We reverse the left and right child by passing the left and right child alternately in the Recursive call...
*/