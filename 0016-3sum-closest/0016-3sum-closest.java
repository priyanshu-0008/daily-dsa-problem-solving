class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int closest=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(closest-target)>Math.abs(sum-target)){
                    closest=sum;
                }
                if(sum==target){
                    return sum;
                }
                else if(sum>target){
                    k--;
                }
                else{
                    j++;
            
                }
            }
        }
       return closest; 
    }
}