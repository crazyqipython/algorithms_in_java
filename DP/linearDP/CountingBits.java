public class CountingBits {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        
        int offset = 1;
        
        for(int i=1; i<n+1; i++){
            if(offset*2 == i)
                offset = offset*2;
            
            res[i] = res[i-offset] + 1;
        }
        
        return res;
    }
}

