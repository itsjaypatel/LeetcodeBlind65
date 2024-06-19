package matrix;

import java.util.Arrays;

public class Problem1 {

    //    Link: https://leetcode.com/problems/two-sum/description/

    public static void main(String[] args) {

        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
//        System.out.println(Arrays.toString(ans));
    }

    public static void setZeroes(int[][] matrix) {

        /*
            TC - O(N^2)
            SC - O(M + N)

            int m = matrix.length, n = matrix[0].length;

            boolean[] row = new boolean[m];
            boolean[] col = new boolean[n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
         */

//        TC - O(N^2)
//        SC - O(M + N)

        int m = matrix.length, n = matrix[0].length, col0 = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {

                    matrix[i][0] = 0;

                    if(j != 0) matrix[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0]  != 0 && matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

    }
}
