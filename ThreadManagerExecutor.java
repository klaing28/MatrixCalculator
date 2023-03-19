import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadManagerExecutor {

    public static void multiply(int[][] output, int matrix1[][], int matrix2[][], int concurentThreads) {
        ExecutorService executorService = Executors.newFixedThreadPool(concurentThreads);
        for (int i = 0; i < concurentThreads; i++) {
            executorService.execute(new MatrixMultiplicationRunnable(output,matrix1,matrix2,i));

        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
