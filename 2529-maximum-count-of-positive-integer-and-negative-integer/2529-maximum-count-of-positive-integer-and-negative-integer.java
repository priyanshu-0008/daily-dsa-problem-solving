class Solution {
    public int maximumCount(int[] nums) {
        int post=0;
        int neg=0;
        int n=nums.length;
        int ans=-1;

        for(int i=0;i<n;i++){
            if(nums[i]>0) post++;
            else if(nums[i]<0) neg++;
            ans=Math.max(post,neg);
        }
        return ans;
        
    }
}