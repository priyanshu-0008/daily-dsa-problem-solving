/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public void pre(Node root,ArrayList<Integer> arr){
        if(root==null) return;
        arr.add(root.data);
        pre(root.left,arr);
        pre(root.right,arr);
    }
    
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        ArrayList<Integer> arr=new ArrayList<>();
        pre(root,arr);
        return arr;
    }
}