class Solution {
    public static int findSum(int n) {
        // code here
        int sum=0;
        if(n==0){
            return 0;
        }
        
        sum=sum+n;
        sum+=findSum(n-1);
        return sum;
    }
}
