package recursion;


import java.util.LinkedList;
import java.util.Queue;

class LinkNode{
    LinkNode left;
    LinkNode right;
    int data;
    LinkNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class Height_Of_A_Binary_Tree_Using_Recursion {
    static LinkNode BuildTree(String str){

        if(str.isEmpty() || str.charAt(0)=='N'){
            return null;
        }

        String input[] = str.split(" ");

        LinkNode root = new LinkNode(Integer.parseInt(input[0]));
        Queue<LinkNode> queue = new LinkedList<>();

        queue.add(root);
        int i=1;
        while(queue.size()>0 && i<input.length){

            //Get AND REMOVE FRONT OF THE QUEUE
            LinkNode currNode = queue.peek();
            queue.remove();

            //GET THE CURRENT NODE VALUE FROM THE STRING ARRAY
            String currValue = input[i];

            //IF LEFT CHILD IS NOT NULL
            if(!currValue.equals("N")){
                currNode.left = new LinkNode(Integer.parseInt(currValue));
                queue.add(currNode.left);
            }

            //FOR RIGHT CHILD
            i++;
            if(i>=input.length) break;

            currValue = input[i];
            //IF RIGHT CHILD IS NOT NULL
            if (!currValue.equals("N")){
                currNode.right = new LinkNode(Integer.parseInt(currValue));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    static void printInorder(LinkNode root){
        if(root==null) return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }


}
