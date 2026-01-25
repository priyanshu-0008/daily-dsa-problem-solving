class Solution {
    public boolean isPalindrome(String s) {
        String a=s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
        int l=0;
        int r=a.length()-1;
        while(l<r){
            if(a.charAt(l)==a.charAt(r)){
                l++;
                r--;
            }
            else{
                return false;
            }
        }
      return true;  
    }
}