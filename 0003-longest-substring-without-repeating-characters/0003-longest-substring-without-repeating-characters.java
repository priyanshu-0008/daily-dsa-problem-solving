class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0) retrun 0;
        int i=0;

        int ans=-1;
        HashMap<Character,Integer> map=new HashMap<>();

        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }

            while(map.get(ch)>1){
                char left=s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)-1); 
                }
                if(map.get(left)==0) map.remove(left);
                i++;
            }
            ans=Math.max(ans,r-i+1);
        }
        return ans;
    }
}