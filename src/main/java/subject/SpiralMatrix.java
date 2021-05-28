package subject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: SpiralMatrix
 * @description: 螺旋打印矩阵
 * @author: jxx
 * @date: 2021/5/24 11:12 AM
 **/
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},{6,4,5},{9,8,0}
        };
        int[][] matrix1 = new int[][]{
                {1,2,3,9},{6,4,5,9},{9,8,0,9}
        };
        List<Integer> res = spiralOrder(matrix1);
        for (Integer re : res) {
            System.out.print(re + " ");
        }

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int count = 0, row = matrix.length, column = matrix[0].length;
        int total = row * column;
        int up = 0, down = row - 1, left = 0, right = column - 1;
        while(count < total){
            for(int i = left; i <= right && count < total; i++){
                res.add(matrix[up][i]);
                count++;
            }
            up++;
            for(int i = up; i <= down && count < total; i++){
                res.add(matrix[i][right]);
                count++;
            }
            right--;
            for(int i = right; i >= left && count < total; i--){
                res.add(matrix[down][i]);
                count++;
            }
            down--;
            for(int i = down; i >= up && count < total; i--){
                res.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return res;
    }

//    private static List<Integer> spiralOrder(int[][] matrix) {
//        LinkedList<Integer> result = new LinkedList<>();
//        if(matrix==null||matrix.length==0) return result;
//        int left = 0;
//        int right = matrix[0].length - 1;
//        int top = 0;
//        int bottom = matrix.length - 1;
//        int numEle = matrix.length * matrix[0].length;
//        while (numEle >= 1) {
//            for (int i = left; i <= right && numEle >= 1; i++) {
//                result.add(matrix[top][i]);
//                numEle--;
//            }
//            top++;
//            for (int i = top; i <= bottom && numEle >= 1; i++) {
//                result.add(matrix[i][right]);
//                numEle--;
//            }
//            right--;
//            for (int i = right; i >= left && numEle >= 1; i--) {
//                result.add(matrix[bottom][i]);
//                numEle--;
//            }
//            bottom--;
//            for (int i = bottom; i >= top && numEle >= 1; i--) {
//                result.add(matrix[i][left]);
//                numEle--;
//            }
//            left++;
//        }
//        return result;
//    }

    private static List<Integer> printSpiralMatrix(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;
        int left = 0;
        int up = 0;

        int n = 1;
        int nums = matrix.length * matrix[0].length;

        // 控制上下左右边界，控制层数

        while (n <= nums){
            for (int i = left;i <= right;i++) {
                res.add(matrix[up][i]);
                n++;
            }
            up++;
            for (int i = up;i <= down;i++) {
                res.add(matrix[i][right]);
                n++;
            }
            right--;
            for (int i = right;i >= left;i--) {
                res.add(matrix[down][i]);
                n++;
            }
            down--;
            for (int i = down;i >= up;i--) {
                res.add(matrix[i][left]);
                n++;
            }
            left++;
        }
        return res;
    }
}
