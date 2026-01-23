class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n=nums.length;
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> keyPos = new ArrayList<>(); 
        int key1=0;
        int key2=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            if (nums[i] == key) {
                keyPos.add(i);
            }
        }
         for (int i = 0; i < n; i++) {
            for (int kp : keyPos) {
                if (Math.abs(i - kp) <= k) {
                    ans.add(i);
                    break; // avoid duplicates
                }
            }
        }
        return ans;
    }
}