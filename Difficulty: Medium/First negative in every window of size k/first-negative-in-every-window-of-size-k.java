class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int i=0;
        int j=0;
        while(j<arr.length){
            if(arr[j]<0){
                q.add(arr[j]);
            }
            if(j-i+1==k){
                if(q.isEmpty()){
                    ans.add(0);
                }
                else{
                    ans.add(q.peek());
                }
                if(!q.isEmpty() && q.peek()==arr[i]){
                    q.poll();
                }
                i++;
            }
            
            j++;
        }
        return ans;
    }
}