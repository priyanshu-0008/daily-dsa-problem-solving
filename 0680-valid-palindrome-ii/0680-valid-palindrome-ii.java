class Solution {
    public boolean validPalindrome(String s) {

        int n=s.length();
        int i=0;
        int j=n-1;

        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                return check(s,i+1,j)|| check(s,i,j-1);
            }
        }
        return true;
    }
    private boolean check(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
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