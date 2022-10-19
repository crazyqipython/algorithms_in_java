package Array;
import java.util.*;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix){
        if(matrix == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<Integer>();

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix.length-1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            
            //left to right
            for(int j = colBegin; j <= colEnd; j++){
                int temp = matrix[rowBegin][j];
                res.add(temp);
            }
            rowBegin++;

            // up to down
            for(int j = rowBegin; j <= rowEnd; j++){
                int temp = matrix[j][colEnd];
                res.add(temp);
            }
            colEnd--;

            // right to left
            if(rowEnd < rowBegin){
                for(int j = colEnd; j >= colBegin; j--){
                    int temp = matrix[rowEnd][j];
                    res.add(temp);
                }
            }
            rowEnd--;

            // down to up
            if (colBegin <= colEnd){
                for(int j = rowEnd; j >= rowBegin; j--){
                    int temp = matrix[j][colBegin];
                    res.add(temp);
                }
            }
            colBegin++;
        }

        return res;
    }
    
}
