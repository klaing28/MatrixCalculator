public class MatrixMultiplicationRunnable implements Runnable
{
    // class implementing Runnable interface, a single thread is going to perform all dot
    // multiplications for the specified row from matrix1
    private final int[][] output; // output array
    private final int[][] matrix1; // matrix1 array
    private final int[][] matrix2; // matrix2 array
    private final int currentRow; // matrix1 row being calculated by this task

    public MatrixMultiplicationRunnable(int[][] output, int[][] matrix1, int[][] matrix2, int currentRow)  //constructor
    {
        this.currentRow = currentRow;
        this.matrix2 = matrix2;
        this.matrix1 = matrix1;
        this.output = output;
    }

    @Override
    public void run() { // performs dot multiplication of current matrix1 row (currentRow) and each matrix2 columns
        for(int m2Row = 0; m2Row< matrix2[0].length; m2Row++)
        {
            output[currentRow][m2Row] = 0;
            for(int m1Column = 0; m1Column < matrix1[currentRow].length; m1Column++) {
                output[currentRow][m2Row] += matrix1[currentRow][m1Column] * matrix2[m1Column][m2Row];
            }
        }
    }

}

