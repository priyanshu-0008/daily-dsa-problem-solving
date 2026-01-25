class Solution {
    public int minimumRefill(int[] nums, int capacityA, int capacityB) {
        int capA=capacityA;
        int capB=capacityB;

        int n=nums.length;
        int count=0;
        int i=0;
        int j=n-1;

        while(i<=j){
            if(i==j){
                if(Math.max(capA,capB)<nums[i]){
                    count++;
                }
                break;
            }
            if(capA<nums[i]){
                count++;
                capA=capacityA;
            }
            capA-=nums[i];
            i++;

            if(capB<nums[j]){
                count++;
                capB=capacityB;
            }
            capB-=nums[j];
            j--;
        }
            
        return count;

    }
}