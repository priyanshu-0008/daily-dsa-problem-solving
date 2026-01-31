/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    int minDepth(Node root) {
        // code here
        if(root==null)return 0;
        int lh=minDepth(root.left);
        int rh=minDepth(root.right);

        if(lh==0) return rh+1;
        if(rh==0) return lh+1;

        return 1+Math.min(lh,rh);
    }
}