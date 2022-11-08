
class ReverseVowelsOfString{
    public String reverseVowels(String s) {
        
        String vowels = "aeiouAEIOU";
        int l=0, r= s.length() - 1;
        
        char[] chars= s.toCharArray(); 
        
        while(l<r){
            if(vowels.contains(chars[l] + "") && vowels.contains(chars[r] + "")){
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
            else if(vowels.contains(chars[l] + "")){
                r--;
            }else{
                l++;
            }
        }
        
        return new String(chars);
    }
}