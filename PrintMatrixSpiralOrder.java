package linked;

/**
 * @Description PrintMatrixSpiralOrder 转圈打印矩阵
 * @Author whmAdmin
 * @Date 2018/4/5 13:38 2018
 */
public class PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix){
        // 左上角行
        int row1 = 0;
        // 左上角列
        int col1 = 0;
        // 右下角行
        int row2 = matrix.length - 1;
        // 右下角列
        int col2 = matrix[0].length - 1;
        // 每循环一次节点坐标往内圈移动
        while (row1 <= row2 && col1 <= col2){
            printEdge(matrix, row1++, col1++, row2--, col2--);
        }
    }

    public static void printEdge(int[][] matrix, int row1, int col1, int row2, int col2) {
        // 如果打印的数组就一行
        if(row1 == row2) {
            for (int i = col1; i<=col2; i++) {
                System.out.println(matrix[row1][i] + ",");
            }
        // 如果只有一列
        }else if(col1 == col2){
            for (int i = row1; i<=row2;i++){
                System.out.println(matrix[i][col1] + ",");
            }
        // 多行多列
        }else{
            // 记录列号
            int curC = col1;
            // 记录行号
            int curR = row1;

            // 记录列号增加，不等于最大列号，打印这一列的最后一列前的所有元素
            while (curC != col2) {
                System.out.println(matrix[row1][curC] + ",");
                curC++;
            }
            // 记录行号增加，不等于最大行号，打印这一行的最后一行的所有元素
            while (curR != row2) {
                System.out.println(matrix[curR][col2] + ",");
                curR++;
            }
            // 记录行号开始从上次增加的多少开始减少，减少到最前一列前
            while (curC != col1) {
                System.out.println(matrix[row2][curC] + ",");
                curC--;
            }
            // 记录列号开始从上次增加的多少开始减少，减少到最前一行前
            while (curR != row1) {
                System.out.println(matrix[curR][col1] + ",");
                curR--;
            }
        }
    }

}
