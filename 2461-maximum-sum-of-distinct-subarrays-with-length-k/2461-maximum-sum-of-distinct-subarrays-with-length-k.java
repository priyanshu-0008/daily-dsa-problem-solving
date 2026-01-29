class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> st=new HashSet<>();
        int i=0;
        long sum=0;
        long ans=0;
        for(int j=0;j<nums.length;j++){
            while(st.contains(nums[j])){
                st.remove(nums[i]);
                sum=sum-nums[i];
                i++;
            }
            st.add(nums[j]);
            sum+=nums[j];
            if(j-i+1==k){
                ans=Math.max(sum,ans);
                st.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
        }
        return ans;
    }
}