/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int height(Node root) {
        // code here
        if(root==null)return -1;
        int leftdepth=height(root.left);
        int rightdepth=height(root.right);

        return 1+Math.max(leftdepth,rightdepth);   
    }
}