import java.util.ArrayList;
import java.util.List;
public class ThreadManager { // this class manually manages threads
    public static void multiply(int[][] output, int matrix1[][], int matrix2[][], int concurentThreads) {
        // multiply method for given matrices and number of threads running at the same time (concurentThreads)
        // runs concurentThreads number of threads and waits for them to finish before creating new threads
        List threads = new ArrayList<Thread>(); // list of running threads
        for (int row = 0; row < matrix1.length; row++) { // thread is created for each matrix1 row
            // a new task object is being created
            MatrixMultiplicationRunnable task = new MatrixMultiplicationRunnable(output, matrix1, matrix2, row);
            Thread thread = new Thread(task); // a Thread object is being created for the new task
            thread.start(); // new thread is being started
            threads.add(thread); // new thread is added to the thread list
            if (threads.size() % concurentThreads == 0) { // when number of concurent threads is
                // reached manager waits before creating new threads
                waitForThreads(threads);
            }
        }
    }
    private static void waitForThreads(List<Thread> threads){
        for (Thread thread : threads) { // for each running thread from the list method waits until thread is finished
            try {
                thread.join(); // join monitors thread and waits until it's finished or interrupted
            } catch (InterruptedException exception) { // if thread is interrupted exception is raised
                exception.printStackTrace();
            }
        }
        threads.clear(); // after all threads are finished active thread list is cleared
    }
}


