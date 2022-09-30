package DFA;

public class ValidNumber {
    public boolean isNumber(String s){
        boolean number = false;
        boolean exp = false;
        boolean decimal = false;
        boolean sign = false;
        
        int l = 0;
        int r = s.length();
        while(l == ' ') l++;
        while(r == ' ') r--;

        while(l < r){
            char c = s.charAt(l);
            l++;

            if(c == '-' || c == '+'){
                if(sign||number) return false;
                sign = true;
            }else if (c >= '0' && c <= '9'){
                number = true;
            }else if (c == '.'){
                if(decimal||exp) return false;
                decimal = true;
                sign = true;
            }else if (c == 'e' || c == 'E'){
                if(exp|| !number) return false;
                exp = true;
                number = false;
                sign = false;
            }else{
                return false;
            }
        }
        return number;
    }

    public static void main(String [] args){
        ValidNumber vnObj = new ValidNumber();
        boolean isNum = vnObj.isNumber("32.e-80123");
        System.out.println(isNum);
    }
}
