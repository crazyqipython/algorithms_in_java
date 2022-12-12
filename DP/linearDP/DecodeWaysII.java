import java.util.*;

public class DecodeWaysII {
    static Map<String, Integer> map = new HashMap<String, Integer>() {{
        put("**", 15); //11 to 19 and 21 to 26
        put("*0", 2); // 1 and 2
        put("*1", 2);
        put("*2", 2);
        put("*3", 2);
        put("*4", 2);
        put("*5", 2);
        put("*6", 2);   
        put("*7", 1);  //1
        put("*8", 1); 
        put("*9", 1); 
        put("1*", 9); //1 to 9
        put("2*", 6); //1 to 6       
    }};

    public int numDecodings(String s) {
        long[] mem = new long[s.length()];

        return (int)numDecodings(0, s, mem);
    }

    private long numDecodings(int p, String s, long[] mem){
        
        int n = s.length();
        if(p == n) return 1;
        
        if(s.charAt(p) == '0') return 0;

        if(mem[p] > 0) return mem[p];

        long num = (s.charAt(p) == '*'? 9: 1)*numDecodings(p+1, s, mem);

        if(p < n - 1){
            int mod=1000000007;
            String s2 = s.substring(p, p+2);
            if(s2.indexOf('*') > -1){
                num = (num + (map.getOrDefault(s2, 0))*numDecodings(p+2, s, mem)) % mod;
            }else if(s.charAt(p)=='1'||(s.charAt(p)=='2'&&s.charAt(p+1)<'7')){
                num = (num + numDecodings(p+2, s, mem)) % mod;
            }
        }
        return mem[p] = num;
    }
}
