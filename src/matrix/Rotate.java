package matrix;

import java.util.Random;

public class Rotate {
    //行列交换
    //123
    //456
    //789
    //每一行反转
    //147
    //258
    //369
    public void rotate(int[][] matrix) {
        //沿着对角线转换行列
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //反转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

}
