class Solution {
    public boolean isPalindrome(String s) {
        String c=s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
        int i=0;
        int j=c.length()-1;

        while(i<j){
            if(c.charAt(i)==c.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}