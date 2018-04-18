package linked;

/**
 * @Description TurnUpMatrixByk 在行列都排好序的矩阵中找数
 * @Author whmAdmin
 * @Date 2018/4/6 15:45 2018
 */
public class TurnUpMatrixByk {

//   给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一
//   列都是排好序的。实现一个函数，判断K是否在matrix中。 返回true或false
//   时间复杂度为O(N+M)，额外空间复杂度为O(1)。
//    思路：
//        1. 从右上或者左下开始找。从右上点开始，如果这个数比要找到K大，那么不用考虑左上点这一列的数，直接往左走。
//            如果左边的数比右上点这个数小，那么就往下走。
    public static boolean turnUpMatrixBykOne(int[][] matrix, int k){
        int row1 = 0;
        int col1 = matrix[0].length - 1;

        // 判断
        while (col1 > -1 && row1 < matrix.length) {
            System.out.println(matrix[row1][col1]);
            if(matrix[row1][col1] == k) {
                return true;
            }else if(matrix[row1][col1] < k) {
                row1++;
            }else if(matrix[row1][col1] > k) {
                col1--;
            }
        }
        return false;
    }

    //思路
    //  2.从左下角开始找，如果左下角位置元素比k大，往上走，如果比k小，往右走。
    public static boolean turnUpMatrixBykTwo(int[][] matrix, int k){
        int row1 = matrix.length -1;
        int col1 = 0;

        // 判断
        while (row1 > -1 && col1 < matrix[0].length) {
            System.out.println(matrix[row1][col1]);
            if(matrix[row1][col1] == k) {
                return true;
            }else if(matrix[row1][col1] > k){
                row1--;
            }else if(matrix[row1][col1] < k) {
                col1++;
            }
        }

        // 循环判断
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,5},{2,2,4,7},{3,4,4,8},{5,7,7,9}};
//        boolean help = turnUpMatrixBykOne(matrix,3);
        boolean help = turnUpMatrixBykTwo(matrix,6);
        System.out.println(help);
    }

}
