/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public void pre(Node root,ArrayList<Integer> arr){
        if(root==null) return;
        
        pre(root.left,arr);
        pre(root.right,arr);
        arr.add(root.data);
    }
    
    public ArrayList<Integer> postOrder(Node root) {
        //  code here
        ArrayList<Integer> arr=new ArrayList<>();
        pre(root,arr);
        return arr;
    }
}