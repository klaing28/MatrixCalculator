import java.util.Date;

public class MatrixMultiplication {
    public static void main(String[] args)
    {
        // create matrices to multiply with random elements ( no checks for correct dimensions )
        int[][] matrix1 = MatrixGenerator.generateMatrix(2000,2000);
        int[][] matrix2 = MatrixGenerator.generateMatrix(2000,2000);

        // create matrix for result of Runnable multiplication
        int[][] result = new int[matrix1.length][matrix2[0].length];

        Date startRunnable = new Date(); // Start time measurement
        ThreadManager.multiply(result,matrix1,matrix2,4); // run multiplication using manual multithreading
        Date endRunnable = new Date(); // End time measurement
        System.out.println("Runnable time in ms : "+ (endRunnable.getTime()-startRunnable.getTime()));

        // create matrix for result of Executable multiplication
        int[][] result2  = new int[matrix1.length][matrix2[0].length];
        Date startExecutor = new Date(); // Start time measurement
        ThreadManagerExecutor.multiply(result2,matrix1,matrix2,matrix1.length); // run multiplication using executor
        Date endExecutor = new Date(); // End time measurement
        System.out.println("Executor time in ms : "+ (endExecutor.getTime()-startExecutor.getTime()));

        System.out.println(areSame(result,result2)); // check if results are the same
       // printMatrix(result);
       // printMatrix(result2);


    }
    private static void printMatrix(int[][] matrix){ // prints matrix elements
        for(int[] row: matrix){
            for(int element: row){
                System.out.print(element + " ");
            }
            System.out.print("\n");
        }
    }
    private static boolean areSame(int[][] matrix1, int[][] matrix2) { // checks if matrices are the same
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    if (matrix1[i][j] != matrix2[i][j]) return false;
                }
            }
            return true;
        }
        return false;
    }
}