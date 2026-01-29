class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int max=Integer.MIN_VALUE;
        int i=0;
        int j=0;
        int sum=0;
        while(j<arr.length){
            sum+=arr[j];
            if(j-i+1==k){
                max=Math.max(max,sum);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return max;
    }
}