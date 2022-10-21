import java.util.*;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for(int i=0; i<numRows; i++){
            List<Integer> temp = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                if(j==0||j==i){
                    temp.add(j, 1);
                }else{
                    temp.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
                }
            }
            res.add(temp);
        }

        return res;

    }
}
