class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans=0;
        int n=customers.length;

        for(int i=0;i<n;i++){
            if(grumpy[i]==0){
                ans+=customers[i];
            }
        }

        int maxExtra=0;

        for(int i=0;i<=n-minutes;i++){
            int extra=0;

            for(int r=i;r<i+minutes;r++){
                if(grumpy[r]==1){
                    extra+=customers[r];
                }
            }
            maxExtra=Math.max(maxExtra,extra);
        }
        return ans+maxExtra;
    }
}