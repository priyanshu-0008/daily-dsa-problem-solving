class Solution {
    public int characterReplacement(String s, int k) {
        int ans=-1;
        int i=0;
        int n=s.length();
        int max_freq=0;  
        HashMap<Character,Integer>map=new HashMap<>();

        for(int j=0;j<n;j++){
            char right=s.charAt(j);
            if(map.containsKey(right)){
                map.put(right,map.get(right)+1);
            }
            else{
                map.put(right,1);
            }
            max_freq=Math.max(max_freq,map.get(right));
            while((j-i+1)-max_freq>k){
                char left=s.charAt(i); 
                if(map.containsKey(left)){
                    map.put(left,map.get(left)-1);
                }
                i++;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}