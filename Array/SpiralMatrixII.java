import java.applet.*;

public class SpiralMatrixII {
    public int[][] SpiralMatrixII(int n){

        if (n == 0)
            return new int[n][n];

        int[][] matrix = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            // left to right
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = num;
                num++;
            }
            rowBegin++;

            // up -> down
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = num;
                num++;
            }
            colEnd--;

            // right->left
            if (rowEnd >= rowBegin) {
                for (int i = colEnd; i >= colBegin; i--) {
                    matrix[rowEnd][i] = num;
                    num++;
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    matrix[i][colBegin] = num;
                    num++;
                }
            }
            colBegin++;
        }

        return matrix;

    }

}
