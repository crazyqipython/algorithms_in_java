package TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        
        s = s.toLowerCase();
        int i=0, j=s.length()-1;
        
        while(i<=j){
            char cHead = s.charAt(i);
            char cTail = s.charAt(j);
            if( Character.isLetterOrDigit(cHead) && Character.isLetterOrDigit(cTail)){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }else if(!Character.isLetterOrDigit(cHead)){
                i++;
            }else{
                j--;
            }
        }
        
        return true;
    }
}
