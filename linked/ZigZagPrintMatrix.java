package linked;

/**
 * @Description ZigZagPrintMatrix 之字形打印矩阵
 * @Author whmAdmin
 * @Date 2018/4/5 14:22 2018
 */
public class ZigZagPrintMatrix {

    // row1 col1往右走 走到头往下走
    // row2 col2往下走 走到头往右走
    // 始终处于一条斜线 打印斜线上的元素
    public static void printMatrixZigZag(int[][] matrix){
        // 都是从0,0 位置开始
        int row1 =0;
        int col1 = 0;
        int row2 = 0;
        int col2 = 0;
        // 记录行边界
        int endR = matrix.length-1;
        // 记录列边界
        int endC = matrix[0].length-1;
        // 判断打印方向
        boolean fromUp = false;
        // row1越界停止，或者col2越界停止
        while (row1 != endR+1) {
            printLevel(matrix, row1, col1, row2, col2, fromUp);
            // row1 开始不变，col1走的最后 开始增加 row1开始不变
            row1 = col1 == endC ? row1 + 1: row1;
            col1 = col1 == endC ? col1 : col1+ 1;
            // col2开始不变， row2开始增加， row2走到最后开始不变， col2开始增加
            row2 = row2 == endR ? row2 : row2 + 1 ;
            col2 = row2 == endR ? col2 + 1 : col2;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    /**
     * 斜线打印
     * @param matrix 矩阵数组
     * @param row1 左上左行数
     * @param col1 左上左列数
     * @param row2 左下行数
     * @param col2 左下列数
     * @param fromUp 判断打印方向
     */
    public static void printLevel(int[][] matrix, int row1, int col1, int row2,int col2, boolean fromUp){
        if(fromUp) {
            // 右上往坐下打印 一条斜线
            while (row1 <= row2){
                System.out.print(matrix[row1++][col1--] + "");
            }
        } else {
            // 左下往右上打印 一条斜线
            while (row2 <= row1) {
                System.out.print(matrix[row2--][col2++] + "");
            }
        }
    }


}
